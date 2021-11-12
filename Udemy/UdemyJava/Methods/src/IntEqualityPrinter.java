public class IntEqualityPrinter {
    public static void printEqual(int par1, int par2, int par3) {
        if (par1 < 0 || par2 < 0 || par3 < 0) {
            System.out.println("Invalid Value");;
        } else {
            boolean allNumbersEqual = (par1 == par2) && (par2 == par3);
            boolean allNumbersDifferent = (par1 != par2) && (par2 != par3) && (par3 != par1);

            if (allNumbersEqual) {
                System.out.println("All numbers are equal");
            } else if (allNumbersDifferent) {
                System.out.println("All numbers are different");
            } else {
                System.out.println("Neither all are equal or different");
            }
        }
    }

    public static void main(String[] args) {
        printEqual(1, 1, 1);
        printEqual(1, 1, 2);
        printEqual(-1, -1, -1);
        printEqual(1, 2, 3);
    }
}
