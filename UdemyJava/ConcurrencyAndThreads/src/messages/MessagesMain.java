package messages;

import java.util.Random;

// to avoid deadlock between threads: use wait for one thread to release the lock to the other, and notifyAll in the other to notify others when it can proceed processing

public class MessagesMain {
    public static void main(String[] args) {
        Message message = new Message(); // message object to be shared between reader and writer threads
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        // loop until there is a message to read (empty = false, will exit loop)
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // set that there's no message to read anymore and return the message
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        // loop until there is no message to read (empty = true, will exit loop)
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // set that there's message to read and register the message
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);

            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}