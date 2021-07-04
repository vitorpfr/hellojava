package reversewords;

import java.util.Arrays;

// Reverse words kata

public class Kata {

    public static String reverseString(String st) {
        return new StringBuilder(st).reverse().toString();
    }

    public static String reverseWords(final String original) {
        // return same string if empty or whitespaces only
        if (original.matches("\\s*")) {
            return original;
        }

        // transform received String to a String[]
        String[] wordsList = original.split(" ");

        // initialize a String[] to receive the result
        String[] reversedWordsList = new String[wordsList.length];

        // loop through first list, saving result to second list
        for (int i = 0; i < wordsList.length; i++) {
            reversedWordsList[i] = reverseString(wordsList[i]);
        }

        // return second list concatenated back as a single string
        return String.join(" ", reversedWordsList);

    }

    public static void main(String[] args) {

        System.out.println(reverseWords("testing    this    string"));
    }
}
