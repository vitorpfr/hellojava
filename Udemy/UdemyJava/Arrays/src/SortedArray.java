import java.util.Scanner;

public class SortedArray {
    // challenge: create a method that sorts array in descending order

    // gets n inputs from user and returns an int array with the elements
    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);

        int[] values = new int[size];
        System.out.println("Enter " + size + " integer values");
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        scanner.close();
        return values;
    }

    // prints an int array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }


    // returns a new array sorted in descending order
    // certainly not an optimal way to sort (it goes through the array multiple times)
    public static int[] sortIntegers(int[] array) {

        // duplicate array into sorted array
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        // starts looping through the sorted array (minus the last element)
        for (int i = 0; i < (sortedArray.length - 1); i++) {

            // if current element is not last and is smaller than the next one
            if (sortedArray[i] < sortedArray[i+1]) {

                // swap current element with next element
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[i+1];
                sortedArray[i+1] = temp;

                // re-start loop (i=-1  combined with i++ makes next loop start with i=0)
                i = -1;
            }
        }

        // Return sorted array
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] myArray = getIntegers(4);
        printArray(myArray);
        System.out.println("now sorting");
        int[] sortedArray = sortIntegers(myArray);
        printArray(sortedArray);

    }
}
