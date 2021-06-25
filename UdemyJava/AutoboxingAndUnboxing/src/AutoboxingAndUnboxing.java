import java.util.ArrayList;

class IntClass {
    private int value;

    public IntClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("Vitor");

        // can't do this because a primitive type is not a class
//        ArrayList<int> intArrayList = new ArrayList<int>();

        // if I create my own wrapper class for the int type, I can use it
        ArrayList<IntClass> intArrayList = new ArrayList<>();
        intArrayList.add(new IntClass(54));

        // but this is messy, needs to create a class just for this, etc.
        // solution: autoboxing

        // java already has the Integer class for that, which can be used with an array list (same for all primitive types)
        // showing the 'long' way, which actually instantiates Integer object, calls object method to get value, etc
        Integer integer = new Integer(54);
        ArrayList<Integer> intArrayList2 = new ArrayList<>();

        // autoboxing: "box" a primitive int in an object of class Integer
        for (int i = 0; i <= 10; i++) {
            intArrayList2.add(Integer.valueOf(i));
        }

        // unboxing: from an Integer object, retrieving the primitive int value that's inside it
        for (int i = 0; i <= 10; i++) {
            // .intValue() converts Integer object back to primitive int type (by extracting object field)
            System.out.println(i + " ---> " + intArrayList2.get(i).intValue());
        }

        // showing the 'short' way
        Integer myIntValue = 56;    // works because java converts this to Integer.valueOf(56); at compiling time
        int myInt = myIntValue;     // works because java converts this to myIntValue.intValue(); at compiling time

        //// DOUBLE
        // example with double primitive type and wrapper class Double
        // autoboxing: converting double value 'dbl' to Double object (using Double.valueOf) is already done at compile itme
        ArrayList<Double> myDoubleValues = new ArrayList<>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(dbl);
        }

        // unboxing: converting Double object to double value (using .doubleValue) is already done at compile time
        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i);
            System.out.println(i + " ---> " + value);
        }


        // summary: Java already does autoboxing and unboxing for you,
        // so you can basically use the wrapper classes as if they were primitive types
        // this code just shows that there's work being done behind the scenes, and you're actually defining an object!


    }
}
