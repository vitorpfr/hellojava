public class SumOddRange {
    public static boolean isOdd(int number) {
        if (number <= 0) {
            return false;
        }

        return !(number % 2 == 0);
    }

    public static int sumOdd(int start, int end) {
        boolean validRange = (start > 0) && (end > 0) && (end >= start);
        if (!validRange) {
            return -1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if(isOdd(i)) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(5));
        System.out.println(isOdd(2));

        System.out.println("now testing the sum fn:");
        System.out.println(sumOdd(1, 100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));
        System.out.println(sumOdd(100, -100));
        System.out.println(sumOdd(100, 1000));
    }
}
