package warmup.countingvalleys;

public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int valleys = 0;
        int altitude = 0;

        char[] pathList = path.toCharArray();

        for (char c : pathList) {
            // translate letter (U, D) to altitude modifier (1, -1) - could be a separate fn
            int altitudeModifier;
            if (c == 'U') {
                altitudeModifier = 1;
            } else if (c == 'D') {
                altitudeModifier = -1;
            } else {
                altitudeModifier = 0;
            }

            // check if valley finished
            int newAltitude = altitude + altitudeModifier;
            if ((newAltitude == 0) && (altitude == -1)) {
                valleys++;
            }

            // update altitude
            altitude = newAltitude;
        }

        return valleys;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU")); // returns 1
    }
}
