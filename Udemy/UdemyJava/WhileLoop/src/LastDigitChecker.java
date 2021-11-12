public class LastDigitChecker {

    public static boolean isValid(int number) {
        return (number >= 10) && (number <= 1000);
    }

    public static boolean hasSameLastDigit(int par1, int par2, int par3) {

        // Input validation
        if (!isValid(par1) || !isValid(par2) || !isValid(par3)) {
            return false;
        }

        // Get last digit of each input
        int firstLastDigit = par1 % 10;
        int secondLastDigit = par2 % 10;
        int thirdLastDigit = par3 % 10;

        // Return true if there's any pair of equal last digits
        return ((firstLastDigit == secondLastDigit) || (firstLastDigit == thirdLastDigit) || (secondLastDigit == thirdLastDigit));
    }

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
    }
}
