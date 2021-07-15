public class BinaryReview {
    // Introduction to binary:
    // 00001010 = 10, because it is 2^1 + 2^3
    // a number with 8 bits for example can go max until 255 (11111111)
    // java ints are 32 bits, but they are signed (representing negative numbers as well: more on that below)

    // How to represent negative numbers in binary?
        // form 1: Sign and magnitude (not used)
        // first bit is sign (0 pos, 1 neg), rest is the number
            // e.g. 1000 1001 is -9 (first 1 indicates it is negative, 000 1001 is 9)
            // this method can represent from -127 to 127 in 8 bits
        // form 2: Two's complement (more used)
            // first bit (at far left; or most significant bit, or MSG) represent sign (0 pos, 1 neg)
            // positive numbers are normal and always start with 0
            // e.g. 0001 = 1, up to 0111 = 7
            // negative numbers always start with 1, and the smallest negative number is the largest binary value (it is inversed)
            // e.g. 1111 = -1, 1110 = -2, 1101 = -3, down to 1000 which is -8

    // how to convert negative number to its two's complement? (ex. -4)
    // 1. find the positive binary value of the negative number (4 =  100)
    // 2. add 0 to the front (0100)
    // 3. invert all bits (1011)
    // 4. add 1 (1100)

    // why using two's complement for negative? because it makes addition faster for PCs

    // e.g. -7 + 5
    // 5 is 0101
    // -7 is (0111 -> 1000 -> 1001) = 1001

    // those two can be sum directly, which gives: 1110 (which is -2)


}
