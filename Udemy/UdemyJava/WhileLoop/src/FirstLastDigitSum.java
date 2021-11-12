public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int originalNumber = number;
        int firstDigit;
        int lastDigit = number % 10;


        while (true) {
            if (originalNumber < 10) {
                firstDigit = originalNumber;
                break;
            }

            originalNumber /= 10;
        }

        return firstDigit + lastDigit;
    }

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));
    }

}
