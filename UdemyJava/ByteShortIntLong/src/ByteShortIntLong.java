public class ByteShortIntLong {
    public static void main(String[] args) {

        //// int primitive type; 32 bit signed (value from -2^31 to to 2^31 - 1)
        // occupies 32 bits in memory
        int myValue = 10000;

        // int is the primitive data type
        // Integer is a wrapper class in the int primitive data type (which can perform operations on int)
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integers from " + myMinIntValue + " to " + myMaxIntValue); // Integers from -2147483648 to 2147483647

        System.out.println("Busted max value = " + (myMaxIntValue + 1)); // overflows to the min value
        System.out.println("Busted min value = " + (myMinIntValue - 1)); // underflows to the max value

        int myMaxIntTest = 2147483647;
        int myMaxIntTestTwo = 2_147_483_647;

        //// byte primitive type: 8 bit signed (value from -2^7 to to 2^7 - 1)
        // occupies 8 bits in memory
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Bytes from " + myMinByteValue + " to " + myMaxByteValue); // Bytes from -128 to 127

        //// short primitive type: 16 bit signed (value from -2^15 to to 2^15 - 1)
        // occupies 16 bits in memory
        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Shorts from " + myMinShortValue + " to " + myMaxShortValue); // Shorts from -32768 to 32767

        // byte and short are useful to save memory! (when an int size is not needed)

        //// long primitive type: occupies 64 bits
        // signed: from -2^63 to 2^63 - 1
        // unsigned: from 0 to 2^64 - 1
        long myLongValue = 100L;
        long myMinlongValue = Long.MIN_VALUE;
        long myMaxlongValue = Long.MAX_VALUE;
        System.out.println("longs from " + myMinlongValue + " to " + myMaxlongValue); // longs from -9223372036854775808 to 9223372036854775807
        long bigLongLiteralValue = 2147483649L;
        System.out.println(bigLongLiteralValue);

        short bigShortLiteralValue = 32767;

        // this works
        int myTotal = (myMinIntValue / 2);

        // this doesn't work because things inside parenthesis () are treated as int by the computer
//        byte myNewByteValue = (myMinByteValue / 2);
        // we can use casting here to force the result into the byte data type (because we know it fits!
        byte myNewByteValue = (byte) (myMinByteValue / 2);
        short myNewShortValue = (short) (myMinShortValue / 2);

        // challenge
        byte byte1 = 5;
        short short1 = 400;
        int int1 = 50000;

        long finalLong = 50000L + 10L * (byte1 + short1 + int1);
        System.out.println(finalLong);

        short finalShort = (short) (20 + 10 * (byte1 + short1 + int1));
        System.out.println(finalShort);

    }
}
