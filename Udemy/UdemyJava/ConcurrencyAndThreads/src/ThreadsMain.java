public class ThreadsMain {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");

        // how to create a second thread
        // 1: create an instance of the Thread class
        // 2: create a sub-class of the Thread class, override the run() method, and create an instance of it
        // we'll be doing the second option, using the AnotherThread class
        // order of executions is not guaranteed (because threads have variable times to be scheduled/run)
        // important: overrides .run() method, calls .start() method, in this order

        // option 1: create instance of thread class
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        // option 2: create an anonymous class (it has to start the thread instantly)
        new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        // this command is also running from main thread because it is called directly
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");

        // this throws an exception because
        // anotherThread is already started (you can't start the same instance of thread twice)
//        anotherThread.start();

        // interrupt a thread: needs to have a reference to the thread object
//        anotherThread.interrupt();

        // option 3: instantiate a class that implements Runnable, and pass to a new Thread instance
        // this also has max priority
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.setPriority(Thread.MAX_PRIORITY);
        myRunnableThread.start();

        // option 4: instantiate an anonymous class that implements Runnable, and pass it to a new Thread instance
        // join thread: this thread will run only after the other thread is interrupted
        Thread myOtherRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_CYAN + "Hello from the anonymous class implementation of run()");
                try {
                    anotherThread.join(2000); // parameter is the timeout that it will wait for the other thread
                    System.out.println(ThreadColor.ANSI_CYAN + "AnotherThread terminated or timed out, so I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_CYAN + "I couldn't wait after all. I was interrupted");
                }
            }
        });
        myOtherRunnableThread.start();


    }
}
