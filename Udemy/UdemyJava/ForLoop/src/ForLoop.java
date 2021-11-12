public class ForLoop {
    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // too repetitive
        System.out.println("10k at 2% interest is " + calculateInterest(10000.0, 2.0));
        System.out.println("10k at 3% interest is " + calculateInterest(10000.0, 3.0));
        System.out.println("10k at 4% interest is " + calculateInterest(10000.0, 4.0));

        System.out.println("This is very repetitive!");

        // better to use a for statement
        for (int i = 2; i < 7; i++) {
            System.out.println("10k at " + (i + 1) + "% interest is " + String.format("%.2f", calculateInterest(10000, i + 1)));
        }

        // going backwards
        System.out.println("now going backwards");
        for (int i = 8; i > 2; i--) {
            System.out.println("10k at " + i + "% interest is " + String.format("%.2f", calculateInterest(10000, i)));
        }

        // doing a loop that increments a counter for every prime number, until 3 are found
        int counter = 0;
        int loopLimit = 3;
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime, added one to counter!");
                counter++;
            }

            if (counter >= loopLimit) {
                System.out.println(loopLimit + " prime numbers were already found, exiting loop");
                break;

            }
        }
    }
}
