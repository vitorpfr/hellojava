package challenge1;

public class Challenge1 {
    public static void main(String[] args) {
        // Challenge 1: Write the following anonymous class as a lambda expression
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        // doing it
        Runnable newRunnable = () -> {
            String myString = "Let's split this up into an array too";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        // testing
        new Thread(runnable).start();
        new Thread(newRunnable).start();
    }
}
