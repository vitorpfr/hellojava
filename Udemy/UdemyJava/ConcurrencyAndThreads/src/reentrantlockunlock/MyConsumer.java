package reentrantlockunlock;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static synchronizedcommand.ProducerConsumerMain.EOF;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    // it is bad to have to call unlock in so many places to guarantee it is unlocked -> code becomes unmantainable...
    // however, this is not the recommended way to use the lock
    // recommended way: use try...finally block!
    @Override
    public void run() {
        while (true) {
            // option 1: tries to get lock, if lock is not available thread is suspended until lock is available (keep trying)
            bufferLock.lock(); // gets the lock
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock(); // releases the lock
            }

            // option 2: tries to get lock, if lock is not available do something else
//            if(bufferLock.tryLock()) {
//                // critical-code-block
//            } else {
//                // something-else
//            }
        }
    }
}
