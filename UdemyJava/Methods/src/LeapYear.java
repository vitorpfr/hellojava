public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }

        boolean isEvenlyDivisibleBy4 = (year % 4) == 0;
        boolean isEvenlyDivisibleBy100 = (year % 100) == 0;
        boolean isEvenlyDivisibleBy400 = (year % 400) == 0;

        if (isEvenlyDivisibleBy4) {
            if (isEvenlyDivisibleBy100) {
                return isEvenlyDivisibleBy400;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1924));
    }
}
