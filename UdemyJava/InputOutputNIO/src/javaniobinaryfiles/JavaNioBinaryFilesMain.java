package javaniobinaryfiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class JavaNioBinaryFilesMain {
    public static void main(String[] args) {
        try {
            FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel();
            byte[] outputBytes = "Hello world!".getBytes(StandardCharsets.UTF_8);
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
