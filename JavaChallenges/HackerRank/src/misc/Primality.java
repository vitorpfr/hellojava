package misc;

public class Primality {
    public static String primality(int n) {
        // brute force solution:
        // loop i from 2 to i < n
            // if n % i == 0, return false (there is a divisor other than 1 and n)
        // return true
        // time complexity: O(n)

        // optimized solution: loop until sqrt(n), because n = A*B, A > B, A and B are ints
        // loop i from 2 to i <= sqrt(n); rest is equal
        // time complexity: O(sqrt n)
        if (n == 1) return "Not prime";

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return "Not prime";
            }
        }

        return "Prime";
    }

    public static void main(String[] args) {
        // 2: loops from 2 to sqrt(2)

        System.out.println(primality(2));
        System.out.println(primality(4));
        System.out.println(primality(7));
    }
}
