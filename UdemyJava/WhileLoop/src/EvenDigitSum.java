public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        // Exits if invalid input
        if (number < 0) {
            return -1;
        }

        // Starts sum and copies original loop
        int sum = 0;
        int originalNumber = number;

        // Take the last digit of the number, one by one, and add to sum if it is even, until there are no digits anymore
        while (originalNumber > 0) {
            int currentDigit = originalNumber % 10;

            if (currentDigit % 2 == 0) {
                sum += currentDigit;
            }

            originalNumber /= 10;
        }

        // Return the sum of the even digits
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }
}
