package javaniobinaryfiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class JavaNioBinaryFilesMain {
    public static void main(String[] args) {
        // steps to write binary data to a file using java.nio:
        // 1: create FileOutputStream (link to file)
        // 2: create FileChannel (channel to manipulate file)

        // obs: when opening stream and channel with try with resources, there's no need to close them manually
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            System.out.println("------------------------------------------");
            System.out.println("WRITE/READ DATA USING MULTIPLE BUFFERS");

            // 3: to write string, create a ByteBuffer using .wrap, passing to it the string in bytes, and pass this buffer to chnanels .write
//            ByteBuffer buffer = ByteBuffer.wrap(outputBytes); // one option: pass array, resets buffer position to zero
            byte[] outputBytes = "Hello world!".getBytes(StandardCharsets.UTF_8);
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length); // other option: passes length to allocate, needs to flip after put
            buffer.put(outputBytes);
            buffer.flip(); // needs to flip here because put moved the current buffer position
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            // 4: to write int, create another ByteBuffer with .allocate (allocating 4 bytes, which is size of integer)
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES); // sets buffer position to zero
            intBuffer.putInt(245); // moves buffer position 4 bytes
            intBuffer.flip(); // resets buffer position to 0
            numBytes = binChannel.write(intBuffer); // starts to read on current buffer position (zero)
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip(); // reset buffer position to 0 (to avoid BufferOverflowException)
            intBuffer.putInt(-98765); // writes buffer and moves position to 4 bytes
            intBuffer.flip(); // reset buffer position to 0 again
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            // reading hello world content with java.io
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            byte[] b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));
            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1 + " and " + int2);

            // reading hello world content with java.nio instead
            RandomAccessFile raf = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = raf.getChannel();
            outputBytes[0] = 'a'; // this is overridden, just showing that the read works
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
            }
            // reading using relative read: do not pass the buffer position (uses current), so it needs to reset every time
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

            // reading using absolute read: pass buffer position
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0)); // absolute read: this works because we specified the index
            System.out.println(intBuffer.getInt()); // relative read: this also works because getInt(0) does not move buffer position

            // closing because we opened without 'try with resources'
            channel.close();
            ra.close();
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------------");
        System.out.println("WRITE/READ DATA SEQUENTIALLY IN A SINGLE BUFFER");

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // 5: create a single big buffer to write both string and ints (code becomes cleaner)
            ByteBuffer bigBuffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello world!".getBytes(StandardCharsets.UTF_8);
            byte[] outputBytes2 = "Nice to meet you".getBytes(StandardCharsets.UTF_8);

            // chained version of put (possible because .put returns the buffer)
//            bigBuffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
//            bigBuffer.flip();
//            binChannel.write(bigBuffer);

//            // unchained version of put (normal)
//            bigBuffer.put(outputBytes);
//            bigBuffer.putInt(245);
//            bigBuffer.putInt(-98765);
//            bigBuffer.put(outputBytes2);
//            bigBuffer.putInt(1000);
//            bigBuffer.flip();
//            binChannel.write(bigBuffer);

            // unchained version of put (modified to keep track of start position of each int)
            bigBuffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            bigBuffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            bigBuffer.putInt(-98765);
            bigBuffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            bigBuffer.putInt(1000);
            bigBuffer.flip();

            binChannel.write(bigBuffer);

            // reading all file contents in one shot using a new big buffer
            RandomAccessFile ra2 = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel2 = ra2.getChannel();
            ByteBuffer readBuffer2 = ByteBuffer.allocate(100);
            channel2.read(readBuffer2);
            readBuffer2.flip(); // switching from get the content from file to buffer, to actually read it (reset pointer)
            byte[] inputString = new byte[outputBytes.length];
            readBuffer2.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer2.getInt());
            System.out.println("int2 = " + readBuffer2.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer2.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer2.getInt());


            // copy data from file a to file b
            // file a
            RandomAccessFile file = new RandomAccessFile("data.dat", "rw");
            FileChannel channel = file.getChannel();
            // file b
            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
//            channel.position(0); // not needed because it is already on position zero
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size()); // specify number of bytes to copy: from 0 to channel size
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel); // another option
            System.out.println("Num transferred = " + numTransferred);

            file.close();
            channel.close();
            copyFile.close();
            copyChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
