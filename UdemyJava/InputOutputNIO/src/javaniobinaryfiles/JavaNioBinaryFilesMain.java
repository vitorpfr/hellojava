package javaniobinaryfiles;

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

            System.out.println("------------------------------------------");
            System.out.println("WRITE/READ DATA SEQUENTIALLY IN A SINGLE BUFFER");

            // 5: create a single big buffer to write both string and ints (code becomes cleaner)
            ByteBuffer bigBuffer = ByteBuffer.allocate(100);
            outputBytes = "Hello world!".getBytes(StandardCharsets.UTF_8);
            bigBuffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes(StandardCharsets.UTF_8);
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            // closing because we opened without 'try with resources'
            channel.close();
            ra.close();
            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
