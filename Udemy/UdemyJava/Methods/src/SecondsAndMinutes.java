public class SecondsAndMinutes {

    public final static int MINUTES_IN_ONE_HOUR = 60;
    public final static int SECONDS_IN_ONE_MINUTE = 60;

    public static String getDurationString(int minutes, int seconds) {
        boolean validMinutes = minutes >= 0;
        boolean validSeconds = (seconds >= 0) && (seconds <= 59);

        if (!validMinutes || !validSeconds) {
            return "Invalid value";
        }

        int hours = minutes / MINUTES_IN_ONE_HOUR;
        int remainingMinutes = minutes % MINUTES_IN_ONE_HOUR;

        return hours + "h " + remainingMinutes + "m " + seconds + "s";
    }

    public static String getDurationString(int seconds) {
        int minutes = seconds / SECONDS_IN_ONE_MINUTE;
        int remainingSeconds = seconds % SECONDS_IN_ONE_MINUTE;

        return getDurationString(minutes, remainingSeconds);
    }

    public static void main(String[] args) {
        System.out.println(getDurationString(125, 1));
        System.out.println(getDurationString(14470));
    }
}
