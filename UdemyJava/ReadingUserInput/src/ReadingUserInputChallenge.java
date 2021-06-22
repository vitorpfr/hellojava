import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int counter = 0;
        int sum = 0;
        while (counter < 10) {
            System.out.println("Enter number #" + (counter + 1));

            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                counter++;
            } else {
                System.out.println("Invalid number. Please input a valid number!");
            }

            scanner.nextLine(); // handle end of line (enter key)
        }

        System.out.println("Thanks for inputting 10 valid numbers! Their sum is: " + sum);

        scanner.close();
    }
}
