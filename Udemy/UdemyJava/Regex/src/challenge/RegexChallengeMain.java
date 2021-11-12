package challenge;

import java.util.regex.Matcher;
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

        // Challenge 8: Modify the regular expression in challenge 7 to use a group, so that we can print all the
        // digits that occur in a string that contains multiple occurrences of the pattern. Write all the code required
        // to accomplish this (create a pattern, matcher, etc).
        String challenge8 = "abcd.135uvqz.7tzik.999";

        // this regex will be narrow to match a specific group (as opposed to being broad to match the whole string)
        String challenge8Regex = "\\.(\\d+)[A-Za-z]*"; // my attempt
        String challenge8RegexSolution = "[A-Za-z]+\\.(\\d+)"; // solution from lesson
        // explanation: dot (\\.), followed by 1 or more numbers (group), followed by zero or more letters

        Pattern challenge8Pattern = Pattern.compile(challenge8Regex);
        Matcher challenge8Matcher = challenge8Pattern.matcher(challenge8);

        while (challenge8Matcher.find()) {
            System.out.println("Occurrence: " + challenge8Matcher.group(1));
        } // prints 135, then 7, then 999

        // Challenge 9: Let's suppose we're reading strings that match the patterns we used in challenges 7 and 8
        // from a file. Tabs are used to separate the matches, with one exception. The last match is followed by a newline.
        // Our revised challenge 8 string would look like this:
        System.out.println("----- Challenge 9 ------");

        String challenge9 = "abcd.135\tuqvz.7\ttzik.999\n";
        String challenge9Regex = "\\.(\\d+)[\t|\n]"; // my attempt (not perfect, but it's honest work)
        String challenge9RegexSolution = "[A-Za-z]+\\.(\\d+)\\s"; // solution (uses \\s instead of specifying [\t|\n]

        var challenge9Matcher = Pattern.compile(challenge9Regex).matcher(challenge9);
        while (challenge9Matcher.find()) {
            System.out.println("Occurrence: " + challenge9Matcher.group(1));
        } // prints 135, then 7, then 999

        // Challenge 10: Instead of printing the numbers themselves, print out their start and end indices. Make those
        // indices inclusive. Start index for 135 should be 5, and end index should be 7.

        // start and end methods specify the group of the pattern (1 in this case)
        // end is subtracted 1 because we want indices inclusive
        System.out.println("----- Challenge 10 ------");
        challenge9Matcher.reset();
        while (challenge9Matcher.find()) {
            System.out.println("Occurrence: from " + challenge9Matcher.start(1) + " to " + (challenge9Matcher.end(1) - 1));
        }

        // Challenge 11: Suppose we have the following string containing points on a graph within curly braces.
        // Extract what's in the curly braces.
        System.out.println("----- Challenge 11 ------");

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String challenge11Regex = "\\{(\\d+, \\d+)\\}"; // my attempt (more specific)
        String challenge11RegexSolution = "\\{(.+?)\\}"; // solution (more generic, gets any character pattern inside the curly braces, lazily)
        Pattern challenge11Pattern = Pattern.compile(challenge11Regex);
        Matcher challenge11Matcher = challenge11Pattern.matcher(challenge11);

        while (challenge11Matcher.find()) {
            System.out.println("Occurrence: " + challenge11Matcher.group(1));
        }

        // Challenge 12: Write a regular expression that will match a 5-digit US zip code. Use "11111" as your test string.
        System.out.println("----- Challenge 12 ------");
        String challenge12 = "11111";
        String challenge12Regex = "^\\d{5}$"; // start, digit 5 times, end
        System.out.println(challenge12.matches(challenge12Regex)); // true

        // Challenge 13: US zip codes can be followed by a dash and another four numbers. Write a regular expression
        // that will match those zip codes. Use "11111-1111" as your test string.
        System.out.println("----- Challenge 13 ------");
        String challenge13 = "11111-1111";
        String challenge13Regex = "^\\d{5}-\\d{4}$"; // start, 5 digits, -, 4 digits, end
        System.out.println(challenge13.matches(challenge13Regex)); // true

        // Challenge 14: Write a regex that matches both US zip code formats
        System.out.println("----- Challenge 14 ------");
        // surrounded the optional part within a group and inserted a ? in the end, which means there can be 0 or more occurrences of group
        String challenge14Regex = "^\\d{5}(-\\d{4})?$"; // start, 5 digits, then maybe - and 4 digits, end
        System.out.println(challenge12.matches(challenge14Regex)); // true
        System.out.println(challenge13.matches(challenge14Regex)); // true




    }
}
