public class BitwiseOperators {
    // content not on udemy java course
    // https://www.geeksforgeeks.org/bitwise-operators-in-java/

    public static void main(String[] args) {




        // Bitwise operators are used to performing manipulation of individual bits of a number.
        // They can be used with any of the integral types (char, short, int, etc).

        // Bitwise OR - |
        int a = 5; // 0101
        int b = 7; // 0111

        System.out.println("OR");
        System.out.println("5 | 7 = " + (a | b)); // a or b = 0111 = 7 (in decimal)

        System.out.println("AND");
        System.out.println("5 & 7 = " + (a & b)); // a and b = 0101 = 5 (in decimal)

        System.out.println("XOR");
        System.out.println("5 ˆ 7 = " + (a ^ b)); // a xor b = 0010 = 2 (in decimal)

        System.out.println("NOT (complement)");
        System.out.println("~5 = "  + ~a); // complement of a = 1010 = 10 (in decimal), but compilers give -6
        // obs: Note – Compiler will give 2’s complement of that number, i.e., 2’s complement of 10 will be -6.
        // https://en.wikipedia.org/wiki/Two%27s_complement

        // Shift Operators: These operators are used to shift the bits of a number left or right
        // thereby multiplying or dividing the number by two respectively.

        // RIGHT SHIFT
        // signed right shift (>>): shift the bits to the right and fill the voids with the sign bit (1 neg, 0 pos)
        // performs division by a power of 2
        int c = 10;
        System.out.println("SIGNED RIGHT SHIFT");
        System.out.println("10 >> 1 = " + (c >> 1)); // 10 >> 1 is 5 (effectively divides by 2)

        System.out.println("40 >> 2 = " + (40 >> 2)); // 40 >> 2 is 5 (effectively divides by 2*2)

        System.out.println("-10 >> 1 = " + (-10 >> 1)); // -5 (-10 divided by 2)

        // unsigned right shift (>>>): same as >>, but it will always fill void with 0 (instead of sign bit)
        System.out.println("UNSIGNED RIGHT SHIFT");
        System.out.println("10 >>> 1 = " + (10 >>> 1));
        System.out.println("-10 >>> 1 = " + (-10 >>> 1)); // 2147483643 (does not preserve the sign bit)

        // LEFT SHIFT
        // left shift (<<): Shifts the bits of the number to the left and fills 0 on voids left as a result.
        // performs multiplication by a power of 2
        System.out.println("LEFT SHIFT");
        System.out.println("5 << 1 = " + (5 << 1));// 10 (multiplies 5 by 2)
        System.out.println("5 << 2 = " + (5 << 2));// 20 (multiplies 5 by 2*2)
    }
}
