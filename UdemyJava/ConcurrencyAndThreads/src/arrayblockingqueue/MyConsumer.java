package arrayblockingqueue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import static synchronizedcommand.ProducerConsumerMain.EOF;

public class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            // still needs to use synchronized because although buffer is thread-safe, thread may be suspended between if calls
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take()); // .take() gets elements following FIFO
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
