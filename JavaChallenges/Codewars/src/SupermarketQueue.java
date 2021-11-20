import java.util.Arrays;

public class SupermarketQueue {

    //There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total time required for all the customers to check out!
    //input
    //
    //    customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
    //    n: a positive integer, the number of checkout tills.
    //
    //output
    //
    //The function should return an integer, the total time required.

    // my solution
    public static int solveSuperMarketQueue(int[] customers, int n) {

        if (customers.length == 0) return 0;
        if (n == 1) return Arrays.stream(customers).sum();
        if (n >= customers.length) return Arrays.stream(customers).max().getAsInt();

        int[] beingServed = Arrays.copyOfRange(customers, 0, n);
        int[] remainingQueue = Arrays.copyOfRange(customers, n, customers.length);

        for (int i : remainingQueue) {
            int indexOfSmallestElement = getIndexOfSmallestElement(beingServed);

            beingServed[indexOfSmallestElement] = beingServed[indexOfSmallestElement] + i;
        }

        return Arrays.stream(beingServed).max().getAsInt();
    }

    private static int getIndexOfSmallestElement(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(getIndexOfSmallestElement(new int[] {0, 5, 10})); // 0
        System.out.println(getIndexOfSmallestElement(new int[] {5, 0, 10})); // 1
        System.out.println(getIndexOfSmallestElement(new int[] {5, 10, 4})); // 2

        System.out.println(solveSuperMarketQueue(new int[] {5, 3, 4}, 1)); // 12
        System.out.println(solveSuperMarketQueue(new int[] {10, 2, 3, 3}, 2)); // 10
        System.out.println(solveSuperMarketQueue(new int[] {2, 3, 10}, 2)); // 12
    }
}
