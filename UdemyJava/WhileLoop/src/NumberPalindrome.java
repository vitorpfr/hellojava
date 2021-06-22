public class NumberPalindrome {
//    public static int reverse(int number) {
//        int originalNumber = number;
//        int reversedNumber = 0;
//
//        while (originalNumber > 0) {
//            int lastDigit = originalNumber % 10;
//            reversedNumber *= 10;
//            reversedNumber += lastDigit;
//            originalNumber /= 10;
//        }
//
//        return reversedNumber;
//    }
//
//    public static boolean isPalindrome(int number) {
//        int absoluteNumber = (number >= 0) ? number : -number;
//        return (absoluteNumber == reverse(absoluteNumber));
//    }

    // re-doing because the solution needs to be on a single method
    public static boolean isPalindrome(int number) {
        int absoluteNumber = (number >= 0) ? number : -number;
        int originalNumber = absoluteNumber;
        int reversedNumber = 0;

        while (originalNumber > 0) {
            int lastDigit = originalNumber % 10;
            reversedNumber *= 10;
            reversedNumber += lastDigit;
            originalNumber /= 10;
        }

        return (reversedNumber == absoluteNumber);
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }
}
