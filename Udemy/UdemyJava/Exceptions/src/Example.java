import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    // this code can throw InputMismatchException and ArithmeticException (divide by zero)
    // solution: change getInt() method so it continually asks for input if not provided, until something valid is provided
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }

    }

    // issue: two try/catch blocks
//    private static int divide() {
//        int x, y;
//        try {
//            x = getInt();
//            y = getInt();
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("no suitable input");
//        }
//        System.out.println("x is " + x + ", y is " + y);
//
//        try {
//            return x / y;
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("attempt to divide by zero");
//        }
//    }

    // better version: combine two try/catch blocks - much more readable
    // even better version: perform operation normally here and delegate try/catch to main method
    private static int divide() {
        int x, y;
//        try {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
//        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException("no suitable input");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("attempt to divide by zero");
//        }
    }

    private static int getInt() {
        var s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while (true) {
            try {
                return s.nextInt();
            } catch(InputMismatchException e) {
                // go round again, reading past end of line in the input first
                s.nextLine();
                System.out.println("Please enter a number using only digits 0 to 9");
            }
        }
    }
}
