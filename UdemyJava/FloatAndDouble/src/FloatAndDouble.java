public class FloatAndDouble {

    // final because it won't change (constant)
    // static because it can be accessed directly from the class, without instantiating a FloatAndDouble object
    public final static double ONE_POUND_TO_KG = 0.45359237;

    public static void main(String[] args) {
        // two primitive types to deal with floating point numbers:

        // float: single precision number, occupies 32 bits -----------------------> 4 bytes
        // double: double precision number, occupies 64 bits ----------------------> 8 bytes
        // (precision is the format and amount of space occupied by the type)

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float from " + myMinFloatValue + " to " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double from " + myMinDoubleValue + " to " + myMaxDoubleValue);

        int myIntValue = 5;
        float myFloatValue = 5.25f; // needs the F here because double is the assumed default floating number
        float anotherFloatValue = (float) 5.25; // other solution to cast double to float, less used
        double myDoubleValue = 5.25d; // doesn't need the D for the same reason above

        // starting again
        int int1 = 5 / 3;
        float float1 = 5f / 3f;
//        double double1 = 5d / 3d;
        double double1 = 5.0 / 3.0; // default floating point is double, so no need of d
        System.out.println("int is " + int1);
        System.out.println("float is " + float1);
        System.out.println("double is " + double1);

        // double is highly recommended! it can be faster (even though uses more space), and java libraries usually deal with double

        // challenge: pound to kg

        double weightInPound = 200;
        double weightInKg = weightInPound * FloatAndDouble.ONE_POUND_TO_KG;
        System.out.println(weightInKg);

        // float and double are not recommended for precise calculations (e.g. dealing with money/currency)
        // BigDecimal should be used
    }
}
