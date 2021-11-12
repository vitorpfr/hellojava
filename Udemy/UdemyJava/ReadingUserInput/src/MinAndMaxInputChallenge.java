import java.util.Scanner;

public class MinAndMaxInputChallenge {
    public static void main(String[] args) {

        // Set initial vars
        var scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        boolean first = true;

        // Infinite loop
        while (true) {
            System.out.println("Enter number: ");

            // If input is valid, do stuff. Otherwise, break loop and
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (first) {
                    min = input;
                    max = input;
                    first = false;
                    continue;
                }

                if (input > max) {
                    max = input;
                }

                if (input < min) {
                    min = input;
                }

            } else {
                if (first) {
                    System.out.println("No numbers were given...");
                } else {
                    System.out.println("Min: " + min);
                    System.out.println("Max: " + max);
                }
                break;
            }
        }

        scanner.close();
    }
}
