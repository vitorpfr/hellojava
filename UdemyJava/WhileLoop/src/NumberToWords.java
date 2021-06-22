public class NumberToWords {
    public static int getDigitCount(int number) {
        // Special cases
        if (number < 0) {
            return -1;
        } else if (number == 0) {
            return 1;
        }

        // Divide number by 10 and add to counter until there are no digits anymore
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }

        // Return the counter
        return count;
    }

    public static int reverse(int number) {
        // store if number is negative
        boolean isNegative = (number < 0);

        // get absolute number and initialize reversed number
        int absoluteNumber = (number < 0) ? -number : number;
        int reversedNumber = 0;

        // take the last digit of the absolute number, one by one, until there's no more
        // multiply reversed by 10, add the digit and remove it from the original number
        while(absoluteNumber > 0) {
            int lastDigit = absoluteNumber % 10;

            reversedNumber *= 10;
            reversedNumber += lastDigit;

            absoluteNumber /= 10;
        }

        // if negative, restore the minus signal in the reversed, otherwise just return the reversed
        return (isNegative ? -reversedNumber : reversedNumber);
    }

    // Ideally the number-to-word switch would be in a separate method, but the exercise do not accept additional methods
    // Ideally we'd also use StringBuilder to build the string, but it wasn't taught yet at this point
    public static void numberToWords(int number) {
        // Input validation
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            // Start inputs to loop
            String output = "";
            int reversedNumber = reverse(number);
            int counter = 0;

            // Get each digit from the reversed number, convert to word and append to output string
            while (reversedNumber > 0) {
                // Consider last digit from number
                int lastDigit = reversedNumber % 10;

                // Convert it to word and add to output
                switch (lastDigit) {
                    case 0:
                        output += "Zero";
                        break;
                    case 1:
                        output += "One";
                        break;
                    case 2:
                        output += "Two";
                        break;
                    case 3:
                        output += "Three";
                        break;
                    case 4:
                        output += "Four";
                        break;
                    case 5:
                        output += "Five";
                        break;
                    case 6:
                        output += "Six";
                        break;
                    case 7:
                        output += "Seven";
                        break;
                    case 8:
                        output += "Eight";
                        break;
                    case 9:
                        output += "Nine";
                        break;

                }
                // Remove last digit from number and add to counter
                reversedNumber /= 10;
                counter += 1;

                // Add a white space if we know the loop will execute one more time
                if (reversedNumber > 0) {
                    output += " ";
                }
            }

            // Add leading zeros to output, if any (they were removed by the reverse method)
            int leadingZeros = getDigitCount(number) - counter;
            if (leadingZeros > 0) {
                for (int i = 0; i < leadingZeros; i++) {
                    output = output + " Zero";
                }
            }

            // Print output that was built
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        System.out.println("getDigitCount validation:");
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));

        System.out.println("reverse validation:");
        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));

        System.out.println("numberToWords validation:");
        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);
    }
}
