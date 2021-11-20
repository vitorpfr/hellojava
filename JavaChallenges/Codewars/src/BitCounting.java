public class BitCounting {

    // my solution
    public static int countBits(int n) {
        String binary = Integer.toBinaryString(n);
        int counter = 0;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                counter++;
            }
        }

        return counter;
    }

    // good solutions submitted in Codewards by other users
    public static int countBits2(int n) {
        return Integer.bitCount(n);
    }

    public static int countBits3(int n) {
        int ret = n % 2;
        while ((n /= 2) > 0) ret += n % 2;
        return ret;
    }

    public static int countBits4(int n) {
        return (int) Integer.toBinaryString(n)
                .chars()
                .filter(c -> c == '1')
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countBits(15)); // should return 4 (binary is 1111)
        System.out.println(countBits(16)); // should return 1 (binary is 10000)
    }
}
