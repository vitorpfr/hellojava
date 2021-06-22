public class GreatestCommonDivisor {

    // No arrays will be used since it hasn't been taught yet
    // So, using brute force here again
    public static int getGreatestCommonDivisor(int first, int second) {
        // input validation
        if ((first < 10) || (second < 10)) {
            return -1;
        }

        // loop from the lowest number to 1, trying to divide both inputs
        // if both divisions have remainder 0, return this divisor
        int lowestNumber = Math.min(first, second);
        for (int i = lowestNumber; i > 0 ; i--) {
            if ((first % i == 0) && (second % i == 0)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(9, 18));
        System.out.println(getGreatestCommonDivisor(81, 153));
    }
}
