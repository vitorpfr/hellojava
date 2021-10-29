package shortestword;

// Simple, given a string of words, return the length of the shortest word(s).
//
// String will never be empty, and you do not need to account for different data types.

import java.util.Arrays;

public class ShortestWord {
    public static int findShort(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(String::length)
                .min()
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps"));
        System.out.println(findShort("turns out random test cases are easier than writing out basic ones"));
        System.out.println(findShort("Let's travel abroad shall we"));
    }
}
