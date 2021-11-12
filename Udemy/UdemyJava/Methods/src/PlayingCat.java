public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        int lowerTemperatureLimit = 25;
        int upperTemperatureLimit = summer ? 45 : 35;

        return ((temperature >= lowerTemperatureLimit) && (temperature <= upperTemperatureLimit));
    }

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
    }
}
