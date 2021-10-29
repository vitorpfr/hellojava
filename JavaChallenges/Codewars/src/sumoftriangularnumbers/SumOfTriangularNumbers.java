package sumoftriangularnumbers;

//Your task is to return the sum of Triangular Numbers up-to-and-including the nth Triangular Number.
//
//Triangular Number: "any of the series of numbers (1, 3, 6, 10, 15, etc.) obtained by continued summation of the natural numbers 1, 2, 3, 4, 5, etc."

//e.g. If 4 is given: 1 + 3 + 6 + 10 = 20.
//
//Triangular Numbers cannot be negative so return 0 if a negative number is given.

public class SumOfTriangularNumbers {
    public static int sumTriangularNumbers(int n) {
        if (n <= 0) {
            return 0;
        }

        int currentTriangularNumber = 0;
        int increment = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            currentTriangularNumber += increment;
            sum += currentTriangularNumber;
            increment++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumTriangularNumbers(4));
        System.out.println(sumTriangularNumbers(6));
        System.out.println(sumTriangularNumbers(34));
        System.out.println(sumTriangularNumbers(-291));
        System.out.println(sumTriangularNumbers(943));
        System.out.println(sumTriangularNumbers(-971));
    }
}
