public class LargestPrime {
    public static int getLargestPrime(int number) {
        // Input validation
        if (number <= 1) {
            return -1;
        }

        // Start on 2 and loop until number
        for (int i = 2; i < number; i++) {
            // If the current i value is a factor of number it will be the minimum factor A
            // So dividing the number by i will set number to the maximum factor of the previous value, B (given number = A*B, A is the minimum, B is maximum)
            // i-- effectively re-starts the cycle with the same i (because i-- then i++ will compensate each other)
            // but with a reduced number, re-doing the same process for the maximum factor, which generates a new maximum factor, etc.
            // eventually number will be a prime number (that can only be divided by 1 or itself), so it exits the loop (since i never reaches number)
            if ((number % i) == 0) {
                number /= i;
                i--;
            }
        }

        // Obtained number is returned
        return number;
    }

    public static void main(String[] args) {
        System.out.println(getLargestPrime(21)); // 7
        System.out.println(getLargestPrime(217)); // 31
        System.out.println(getLargestPrime(0)); // -1
        System.out.println(getLargestPrime(45)); // 5
        System.out.println(getLargestPrime(-1)); // -1
        System.out.println(getLargestPrime(23)); // 23
    }
}
