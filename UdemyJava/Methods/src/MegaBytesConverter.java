public class MegaBytesConverter {

    public final static int ONE_KB_OVER_MB = 1024;

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaBytes = kiloBytes / ONE_KB_OVER_MB;
            int remainingKiloBytes = kiloBytes % ONE_KB_OVER_MB;
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
        }
    }
}
