public class EqualSumChecker {
    public static boolean hasEqualSum(int par1, int par2, int par3) {
        return (par1 + par2) == par3;
    }

    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, -1, 0));
    }
}
