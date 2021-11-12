import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an integer:\r");
        return scanner.nextInt();
    }

    private static int[] readElements(int size) {
        Scanner scanner = new Scanner(System.in);

        int[] values = new int[size];
        System.out.println("Please input " + size + " integers to compose the array:");
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        scanner.close();
        return values;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int size = readInteger();
        int[] array = readElements(size);

        System.out.println(Arrays.toString(array));
        System.out.println("Minimum element: " + findMin(array));
    }
}
