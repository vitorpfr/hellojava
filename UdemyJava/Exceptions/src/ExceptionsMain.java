import java.util.InputMismatchException;
import java.util.Scanner;

// exception: an event that disrupts the normal flow of program execution
// Exception is a class from java.lang, everything else are sub-classes of those exception (e.g. RuntimeException)

// two types of exception: checked and unchecked
// checked exceptions cannot be ignored (example: IOException, if the program can throw it, the user needs to do something)

public class ExceptionsMain {
    public static void main(String[] args) {
        int a = 98;
        int b = 0;
        System.out.println(divideLBYL(a, b));
        System.out.println(divideEAFP(a, b));
//        System.out.println(divide(a, b)); // crashes, throwing exception

        System.out.println("-------------------------");
        // input validation
        // the following throws an exception if the user inputs a letter
//        int x = getInt();
//        System.out.println("x is " + x);

        // the following returns zero if the user inputs a letter
//        int x = getIntLBYL();
//        System.out.println("x is " + x);

        // the following also returns zero if the user inputs a letter
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        var s = new Scanner(System.in);
        return s.nextInt();
    }

    // a lot of code just to validate that the input is a integer
    private static int getIntLBYL() {
        var s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }

        if(isValid) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }

    // preferred option, a lot less code and more readable
    private static int getIntEAFP() {
        var s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try {
            return s.nextInt();
        } catch(InputMismatchException e) {
            return 0;
        }
    }

    // look before you leave method: test if conditions are valid before making operation
    private static int divideLBYL(int x, int y) {
        if(y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    // easier to ask for forgiveness than permission: just tries operation, then deals with exception
    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
