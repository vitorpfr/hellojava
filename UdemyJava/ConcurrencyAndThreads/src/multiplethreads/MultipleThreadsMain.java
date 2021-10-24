package multiplethreads;

public class MultipleThreadsMain {
    public static void main(String[] args) {
        // equivalent to defining a bank account object
        Countdown countdown = new Countdown();

        // equivalent of having two threads changing the same resource at once (bank account)
        CountdownThread t1 = new CountdownThread(countdown, "Thread 1");
        CountdownThread t2 = new CountdownThread(countdown, "Thread 2");

        t1.start();
        t2.start();

        // ways to avoid race condition:
        // 1. synchronize an entire method that's being called by both threads using synchronize keyword
        // 2. synchronize a block of code using lock
        // only synchronize the bare minimum necessary! synchronizing more than necessary slows down the application
    }

}

class Countdown {
    // since this data is stored in the heap, multiple threads can access/modify it
    // causing a race condition between threads
    private int i;

    // synchronized keyword guarantees that only one thread can call this method at each time (no race condition)
//    public synchronized void doCountdown() {
    public void doCountdown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        // as it is, i is shared between threads
        // if it was a local variable, each one would have its own 'i' in the thread stack
        // synchronize avoids this (this object used to synchronize, each thread can use it at a time)

        // this is a critical section (a part of code shared between threads)
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown, String name) {
        threadCountdown = countdown;
        this.setName(name);
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}
