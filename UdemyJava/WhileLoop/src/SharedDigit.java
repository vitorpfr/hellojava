public class SharedDigit {

    // constraint: the input needs to be between 10 and 99, and arrays were not taught yet in the course
    // so this solution will assume that the input always have 2 digits (kind of a "brute force" solution)
    public static boolean hasSharedDigit(int par1, int par2) {
        boolean validFirstParameter = (par1 >= 10) && (par1 <= 99);
        boolean validSecondParameter = (par2 >= 10) && (par2 <= 99);

        if (!validFirstParameter || !validSecondParameter) {
            return false;
        }

        int par1FirstDigit = par1 % 10;
        int par1SecondDigit = (par1 / 10) % 10;

        int par2FirstDigit = par2 % 10;
        int par2SecondDigit = (par2 / 10) % 10;

        return ((par1FirstDigit == par2FirstDigit) ||
                (par1FirstDigit == par2SecondDigit) ||
                (par1SecondDigit == par2FirstDigit) ||
                (par1SecondDigit == par2SecondDigit));
    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
    }
}
