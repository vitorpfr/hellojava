public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        // Input validation
        if (number < 1) {
            return false;
        }

        // Initializes a sum
        int sum = 0;

        // Loop all numbers from 1 to the number (could be more efficent, if performance was a constraint)
        // If i is a factor of number and different from number, add to sum
        for (int i = 1; i <= number; i++) {
            if ((number % i == 0) && (i != number)) {
                sum += i;
            }
        }

        // Returns true if the sum of factors (excluding the number) is equal to the number itself
        return (number == sum);
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }
}
