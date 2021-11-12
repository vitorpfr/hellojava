public class NumberOfDaysInMonth {
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

    public static int getDaysInMonth(int month, int year) {
        boolean isValidMonth = (month >= 1) && (month <= 12);
        boolean isValidYear = (year >= 1) && (year <= 9999);

        if (!isValidMonth || !isValidYear) {
            return -1;
        }

        switch(month) {
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }

            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;

            default:
                return 30;
        }

    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));

        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }
}
