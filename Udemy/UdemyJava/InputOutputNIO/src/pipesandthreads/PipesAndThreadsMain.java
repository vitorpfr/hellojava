package pipesandthreads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

// java.nio Pipe: a way to send data from one thread to another

public class PipesAndThreadsMain {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            // prepare writer thread
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes(StandardCharsets.UTF_8));
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }

                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // prepare reader thread
            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // starting both threads
            new Thread(writer).start();
            new Thread(reader).start();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
