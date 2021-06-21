public class TeenNumberChecker {
    public static boolean hasTeen(int par1, int par2, int par3) {
        return isTeen(par1) || isTeen(par2) || isTeen(par3);
    }

    public static boolean isTeen(int par) {
        return (par >= 13 && par <= 19);
    }

    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19));
        System.out.println(hasTeen(23, 15, 42));
        System.out.println(hasTeen(22, 23, 24));
    }
}
