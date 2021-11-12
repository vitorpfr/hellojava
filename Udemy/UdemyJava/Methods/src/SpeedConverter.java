public class SpeedConverter {
    public final static double ONE_KPH_OVER_MPH = 1.609;

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }

        double milesPerHour = (kilometersPerHour / SpeedConverter.ONE_KPH_OVER_MPH);
        return Math.round(milesPerHour);
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + "mi/h");
        }
    }
}
