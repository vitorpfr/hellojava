import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;

        while (scanner.hasNextInt()) {
            count++;
            sum += scanner.nextInt();
            scanner.nextLine();
        }

        long average = (count == 0) ? 0 : Math.round((double) sum / (double) count);
        System.out.println("SUM = " + sum + " AVG = " + average);
        scanner.close();
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
