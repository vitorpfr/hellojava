public class FeetAndInchesToCentimeters {

    public final static double ONE_INCH_IN_CENTIMETERS = 2.54;
    public final static int ONE_FOOT_IN_INCHES = 12;

    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        boolean validFeet = (feet >= 0);
        boolean validInches = (inches >= 0) && (inches <= 12);

        if (!validFeet || !validInches) {
            return -1;
        }

        int totalInInches = (feet * ONE_FOOT_IN_INCHES) + inches;
        return (totalInInches * ONE_INCH_IN_CENTIMETERS);
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        boolean validInches = (inches >= 0);

        if (!validInches) {
            return -1;
        }

        int feetInInches = inches / ONE_FOOT_IN_INCHES;
        int remainingInches = inches % ONE_FOOT_IN_INCHES;

        return calcFeetAndInchesToCentimeters(feetInInches, remainingInches);
    }

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(6, 0));
        System.out.println(calcFeetAndInchesToCentimeters(6, 5));
        System.out.println(calcFeetAndInchesToCentimeters(72));
        System.out.println(calcFeetAndInchesToCentimeters(77));
    }
}
