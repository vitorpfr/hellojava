public class Arrays {
    public static void main(String[] args) {
//        int[] myIntArray;
//        myIntArray = new int[10];

        // or directly (array size is mandatory)
        int[] myIntArray = new int[10];
        myIntArray[0] = 1; // first element
        myIntArray[5] = 50; // sixth element

        double[] myDoubleArray = new double[10];

        // retrieve elements
        System.out.println(myIntArray[5]);

        // shortcut to store data in the array when initializing
        int[] myArray2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(myArray2[0]);
        System.out.println(myArray2[6]);
        System.out.println(myArray2[8]);

        // third way to initialize array
        int[] myArray3 = new int[10];
        for (int i = 0; i < myArray3.length; i++) {
            myArray3[i] = i*10;
        }
        System.out.println(myArray3[3]);

        printArray(myArray3);

        // error if I try to access an element out of bounds
//        System.out.println(myArray3[20]);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("element " + i + ", value is " + array[i]);
        }
    }
}
