package synchronizedcommand;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {
    public static String EOF = "EOF";

    public static void main(String[] args) {
        // ArrayList class is not synchronized/thread-safe

        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

        // this doesn't work as it is now due to thread interference (both consumers throw IndexOutOfBounds exception)
        // solution: add synchronize to the methods/code blocks that access this arraylist (buffer)
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}
