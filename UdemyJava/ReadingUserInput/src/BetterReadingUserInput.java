import java.util.Scanner;

public class BetterReadingUserInput {
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    // current year hard-coded is bad, but this is just an example
    public static int getAge(int year) {
        return 2021 - year;
    }

    public static boolean isOutOfYearRange(String str) {
        if (isNumeric(str)) {
            int number =  Integer.parseInt(str);
            return ((getAge(number) >= 0) && (getAge(number) <= 100));
        }

        return false;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your year of birth: ");
        String yearOfBirth = scanner.nextLine();
        while (!isNumeric(yearOfBirth) || !isOutOfYearRange(yearOfBirth)) {
            System.out.println("Invalid input. Please enter a valid year: ");
            yearOfBirth = scanner.nextLine();
        }

        int year = Integer.parseInt(yearOfBirth);
        System.out.println("Your name is " + name + " and you are " + getAge(year) + " years old");

        scanner.close();
    }
}
