package challenge;

import java.util.regex.Pattern;

public class RegexChallengeMain {
    public static void main(String[] args) {
        // Challenge 1: Write the string literal regular expression that will match the following String. Use the
        // String.matches() method to verify your answer
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike.")); // true

        // Challenge 2: Write a regular expression that matches "I want a bike." and "I wnat a ball." Verify your
        // answer using the matches() method
        String challenge2 = "I want a ball.";
//        String challenge2Pattern = "^I want a [A-Za-z]{4}.$"; // my first attempt, better version is below
//        String challenge2Pattern = "^I want a (bike|ball).$"; // another version, better version is below
        String challenge2Regex = "^I want a \\w+.$"; // \\w means word characters

        System.out.println(challenge1.matches(challenge2Regex)); // true
        System.out.println(challenge2.matches(challenge2Regex)); // true

        // Challenge 3:
        // Use the Matcher.matches() method to check for matches, instead of String.matches()
        String challenge3Regex = "^I want a \\w+.$";
        Pattern challenge3Pattern = Pattern.compile(challenge3Regex);
        System.out.println(challenge3Pattern.matcher(challenge1).matches());
        System.out.println(challenge3Pattern.matcher(challenge2).matches());

        // Challenge 4: Replace all occurrences of blank with an underscore for the following string.
        // Print out the resulting string.
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_")); // replaces only spaces
        System.out.println(challenge4.replaceAll("\\s", "_")); // replaces every whitespace (incl. \n and \t)

        // Challenge 5: Write a regular expression that will match the following string in its entirety. Use the String.matches()
        // method to verify your answer.
        String challenge5 = "aaabccccccccdddefffg";
//        String challenge5Regex = "[abcdefg]+"; // possible solution
        String challenge5Regex = "[a-g]+"; // best solution
        System.out.println(challenge5.matches(challenge5Regex));

        // Challenge 6: Write a regular expression that only match the challenge 5 string in its entirety.
        String challenge6Regex = "^a{3}bc{8}d{3}ef{3}g$"; // no need to use {1} if only letter is there
        System.out.println(challenge5.matches(challenge6Regex));

        // Challenge 7: Write a regex that will match a string that starts with a series of letters. The letters
        // must be followed by a period. After the period, there must be a series of digits. The string "kjisl.22"
        // would match. The string "f5.12a" would not.
        String challenge7 = "abcd.135";
        String challenge7Regex = "^[A-Za-z]+\\.\\d+$";
        System.out.println(challenge7.matches(challenge7Regex));


    }
}
