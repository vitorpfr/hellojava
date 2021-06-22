public class DigitSum {
    public static int sumDigits(int number) {

        if (number < 10) {
            return -1;
        }

        int copyNumber = number;
        int sum = 0;

        while (copyNumber > 0) {
            sum += (copyNumber % 10);
            copyNumber = copyNumber / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("sum: " + sumDigits(128));
        System.out.println("sum: " + sumDigits(15));
        System.out.println("sum: " + sumDigits(1));
    }
}
