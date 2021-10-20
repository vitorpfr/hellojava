public class ThreadsMain {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");

        // how to create a second thread
        // 1: create an instance of the Thread class
        // 2: create a sub-class of the Thread class, override the run() method, and create an instance of it
        // we'll be doing the second option, using the AnotherThread class
        // order of executions is not guaranteed (because threads have variable times to be scheduled/run)

        Thread anotherThread = new AnotherThread();
        anotherThread.start(); // prints "Hello from another thread"

        // another option is to create an anonymous class, but it has to start the thread instantly
        new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");

//        anotherThread.start(); // this throws an exception because anotherThread is already started (you can't start the same instance of thread twice)
    }
}
