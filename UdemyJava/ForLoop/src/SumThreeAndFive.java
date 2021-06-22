public class SumThreeAndFive {
    public static boolean isDivisibleBy3And5(int n) {
        return ((n % 3 == 0) && (n % 5 == 0));
    }

    public static void main(String[] args) {
        int counter = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if (isDivisibleBy3And5(i)) {
                System.out.println(i + " meets the condition!");
                counter++;
                sum += i;
            }

            if (counter >= 5) {
                System.out.println("Five numbers were found! Interrupting loop...");
                System.out.println("Sum of numbers: " + sum);
                break;
            }
        }
    }
}
