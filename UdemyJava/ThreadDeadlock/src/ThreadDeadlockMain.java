public class ThreadDeadlockMain {
    // deadlock: situation where two threads are blocked, holding a lock, and each one is waiting for the lock that the
    // other one is holding - this situation doesn't have a way out

    // solutions for deadlock:
    // 1: change the code to use a single object/single lock: not practical for many applications
    // 2: require that all threads try to obtain the locks in the same order, making a deadlock impossible
    // 3: use a lock object instead of synchronized blocks

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Has lock1 and lock2");
                }
                System.out.println("Thread 1: Released lock2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2: has lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread 2: Has lock2 and lock1");
                }
                System.out.println("Thread 2: Released lock1");
            }
            System.out.println("Thread 2: Released lock2. Exiting...");
        }
    }
}


