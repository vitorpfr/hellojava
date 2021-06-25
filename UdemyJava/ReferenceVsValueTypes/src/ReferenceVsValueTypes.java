import java.util.Arrays;

public class ReferenceVsValueTypes {
    public static void main(String[] args) {

        // VALUE TYPES (primitive types and string)
        // when we create a primitive type, a single space in memory is allocated for the variable, and it directly holds the value
        // if you assign it to another variable, the value is copied to it, and both variables work independently in different memory spaces
        // int example
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println(myIntValue + " and " + anotherIntValue); // 10 and 10

        anotherIntValue++;
        System.out.println(myIntValue + " and " + anotherIntValue); // 10 and 11

        // string example
        String myString = "ab";
        String myOtherString = myString;
        System.out.println(myString + " and " + myOtherString); // ab and ab

        myOtherString += "cde";
        System.out.println(myString + " and " + myOtherString); // ab and abcde

        // REFERENCE TYPES (arrays, classes, etc - the ones you need to use new to instantiate)
        // the variables holds a reference (address) to the object, but not the object itself
        // if you assign the variable to another, you're just copying the address and the data is the same
        int[] myIntArray = new int[5];
        int[] anotherIntArray = myIntArray;

        System.out.println(myIntArray.toString() + " and " + anotherIntArray.toString()); // they have the same address
        System.out.println(Arrays.toString(myIntArray) + " and " + Arrays.toString(anotherIntArray)); // and the same content

        anotherIntArray[0] = 1;
        System.out.println(Arrays.toString(myIntArray) + " and " + Arrays.toString(anotherIntArray)); // same content again

        modifyArray(myIntArray);
        System.out.println(myIntArray.toString() + " and " + anotherIntArray.toString()); // they have the same address
        System.out.println(Arrays.toString(myIntArray) + " and " + Arrays.toString(anotherIntArray)); // same content again
    }

    private static void modifyArray(int[] array) {
        array[0] = 2;

        // define a new array doesn't change the original one because array is just a reference received, myIntArray continues pointing to the old address
//        array = new int[] {1, 2, 3, 4, 5};
//        System.out.println("----");
//        System.out.println(array.toString());
//        System.out.println(Arrays.toString(array));
//        System.out.println("----");
    }
}
