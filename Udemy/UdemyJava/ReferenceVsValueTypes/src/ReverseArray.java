import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array) {
        // copy array to a temp array
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        // invert elements using temp as a reference
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[array.length - i - 1];
        }

        System.out.println("Array = " + Arrays.toString(temp));
        System.out.println("Reversed array = " + Arrays.toString(array));
    }

    private static void betterReverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));

        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }

        System.out.println("Reversed array = " + Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));

        System.out.println("----------------------");
        int[] otherArray = new int[] {1, 2, 3, 4};
        betterReverse(otherArray);
    }
}
