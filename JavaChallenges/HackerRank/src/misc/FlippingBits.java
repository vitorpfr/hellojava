package misc;

public class FlippingBits {

    public static long flippingBits(long n) {
        // convert long to binary (string)
        String binary = Long.toBinaryString(n);

        // insert lead 1s until (32 - size)
        StringBuilder flippedBinary = new StringBuilder(32);
        for (int i = 0; i < (32 - binary.length()); i++) {
            flippedBinary.append("1");
        }

        // add string to end, flipping each char (0 to 1 and vice-versa)
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                flippedBinary.append("1");
            } else{
                flippedBinary.append("0");
            }
        }

//        System.out.println(flippedBinary);
//        System.out.println(flippedBinary.length());

        // convert binary back to long
        return Long.parseLong(flippedBinary.toString(), 2);

    }

    public static long simpleFlippingBits(long n) {

        // this is 32 bits of 1s
        long maxValue = (long) Math.pow(2, 32) - 1;

        // XOR with 1 bits always return the opposite
        return n ^ maxValue;


    }




    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(2));
//        System.out.println(~9);
//
//        System.out.println(Integer.parseUnsignedInt("2"));

        System.out.println(flippingBits(9)); // 4294967286
        System.out.println(simpleFlippingBits(9));
    }
}
