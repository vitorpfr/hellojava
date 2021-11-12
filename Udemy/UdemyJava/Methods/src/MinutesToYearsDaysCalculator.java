public class MinutesToYearsDaysCalculator {
    public final static int ONE_YEAR_IN_DAYS = 365;
    public final static int ONE_DAY_IN_HOURS = 24;
    public final static int ONE_HOUR_IN_MINUTES = 60;

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long days = (minutes / ONE_HOUR_IN_MINUTES) / ONE_DAY_IN_HOURS;
            long years = days / ONE_YEAR_IN_DAYS;
            long remainingDays = days % ONE_YEAR_IN_DAYS;

            System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
        }


    }

    public static void main(String[] args) {
        printYearsAndDays(-50);
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }
}
