package threadpools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

// ExecutorService interface: allows the creation of an executor service, which can manage a fixed pool of threads
public class ThreadPoolsMain {
    public static String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        // this creates a object that manages a fixed thread pool for us
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        // this block of code involves using a future to run a thread that returns a result (object) to this future (async comp)
        Future<String> future = executorService.submit(new Callable<>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_CYAN + "I'm being printed from the callable class");
                return "This is the callable result";
            }
        });

        // future.get() blocks this thread (main) until the result is available, so we wouldn't use this in a UI application
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown(); // needs to shutdown the executor service for the program to terminate
//        executorService.shutdownNow() // non-graceful shutdown (if necessary)
    }
}
