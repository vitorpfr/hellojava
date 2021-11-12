public class DiagonalStar {
    public static void printSquareStar(int number) {
        // Input validation
        if (number < 5) {
            System.out.println("Invalid value");
        }

        else {
            // Loop through line i
            for (int i = 1; i <= number; i++) {

                // Loop through column j
                for (int j = 1; j <= number; j++) {
                    // If stars condition are met, print star. Otherwise, print empty space
                    if ((i == 1) || (i == number) || (j == 1) || (j == number) || (i == j) || (j == (number - i + 1))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                // Add a new line before moving to next i or when finished
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printSquareStar(5);
        System.out.println("-----------------");
        printSquareStar(8);
    }
}
