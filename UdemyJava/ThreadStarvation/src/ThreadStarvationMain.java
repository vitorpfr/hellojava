import java.util.concurrent.locks.ReentrantLock;

public class ThreadStarvationMain {
    // thread starvation happens when a low-priority thread keeps suspended when trying to access a synchronized resource
    // because higher priority threads keep getting the lock (lock is shared between all threads)

    // how to prevent starvation: use a fair lock (tries to be FIFO on getting the lock)
    // it doesn't guarantee fairness because some thread may still take a long time
    // important: using a fair lock impacts performance, because of the extra layer to process which thread gets the lock

    // when running this, each thread will count to 1, then 2, then 3, etc... (instead of a high priority queue using the lock to count to 100 sequentially before the others)
    // however, performance is lower, so you may decide that starvation is the lesser of two evils
    private static ReentrantLock lock = new ReentrantLock(true); // true means it is a fair lock

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        t1.setPriority(10);
        t1.start();
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        t2.setPriority(8);
        t2.start();
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        t3.setPriority(6);
        t3.start();
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        t4.setPriority(4);
        t4.start();
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");
        t5.setPriority(2);
        t5.start();


    }

    // inner class - worker
    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // executing critical section of code
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
