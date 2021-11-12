public class Strings {
    public static void main(String[] args) {
        // reminder = 8 bits equal to 1 byte

        // most used primitive types:
        // int (32 bit)
        // double (64 bit)
        // boolean (represents 1 bit of info, but size not precisely defined)

        // sometimes used primitive types:
        // long (64 bit)
        // char (16 bit)


        // almost never used:
        // byte (8 bit)
        // short (16 bit)
        // float (32 bit)


        // String is not a primitive type (it is a class), but it is widely used as a common data type
        // it is a sequence of characters

        String myString = "This is a string";
        System.out.println("myString is equal to: " + myString);
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to: " + myString);
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to: " + myString);

        String numberString = "250.55";
        System.out.println(numberString + "30");  // concats strings

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt; // myInt is converted to a string here by Java, so the addition is possible
        System.out.println("LastString is equal to: " + lastString);

        double doubleNumber = 120.47;
        lastString = lastString + doubleNumber;
        System.out.println("LastString is equal to: " + lastString);

        // strings in java are immutable
        // so, when I append an int value to lastString, it converts int to string, and creates a new string with the concatenation
    }
}
