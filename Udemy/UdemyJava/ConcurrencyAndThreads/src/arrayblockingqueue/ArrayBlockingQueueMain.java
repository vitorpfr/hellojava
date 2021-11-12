package arrayblockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueueMain {
    public static String EOF = "EOF";

    public static void main(String[] args) {
        // using a data structure that already manages concurrency, such as ArrayBlockingQueue,
        // allows us to stop using synchronized or locks
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

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
