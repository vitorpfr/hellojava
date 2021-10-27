package challenge2to5;

import java.util.function.Function;

// Challenge 2: Write the following method as a lambda expression. Don't worry about assigning it to anything:

// Challenge 3: Write the code that will execute the function with an argument of "1234567890"

// Challenge 4: Write a method called "everySecondCharacter" that accepts the function as a parameter and executes
// it with the argument "1234567890"

// Challenge 5: Call the method from challenge 4 and the string "1234567890" and print the result

public class Challenge2to5 {
    public static void main(String[] args) {
        System.out.println(everySecondChar("testings")); // prints "etns"

        // challenge 2 result
        Function<String, String> everySecondCharFun = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // challenge 2 test run
        System.out.println(everySecondCharFun.apply("testings")); // prints "etns"

        // challenge 3
        System.out.println(everySecondCharFun.apply("1234567890"));

        // challenge 5
        System.out.println(everySecondCharacter(everySecondCharFun, "1234567890"));
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

    // challenge 4 result
    public static String everySecondCharacter(Function<String, String> fn, String input) {
        return fn.apply(input);
    }
}
