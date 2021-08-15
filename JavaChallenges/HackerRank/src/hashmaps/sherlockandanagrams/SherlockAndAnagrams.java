package hashmaps.sherlockandanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndAnagrams {

    // https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

    public static List<String> getSubstrings(String s, int size) {
        if ((size <= 0) || (size > s.length())) {
            return null;
        }

        List<String> substringsList = new ArrayList<>();

        for (int i = 0; i <= (s.length() - size); i++) {
            substringsList.add(s.substring(i, i + size));
        }

        return substringsList;
    }

    // could be more efficient: storing s1 letters in array, checking if s2 letters are in array
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] sorteds1 = s1.toCharArray();
        Arrays.sort(sorteds1);
        char[] sorteds2 = s2.toCharArray();
        Arrays.sort(sorteds2);

        return Arrays.equals(sorteds1, sorteds2);

    }

    public static int sherlockAndAnagrams(String s) {
        // start anagramPairs int to increment every time an anagram is found
        int anagramPairs = 0;

        // loop i from 1 to s.length() - 1 (1 to 3)
        for (int i = 1; i < s.length(); i++) {

            // get all word substrings of size i and store in array
            List<String> substrings = getSubstrings(s, i);

            for (int j = 0; j < substrings.size(); j++) {
                String x = substrings.get(j);
                for (int k = 0; k < substrings.size(); k++) {
                    String y = substrings.get(k);
                    if ((j != k) && (x.length() == y.length()) && areAnagrams(x, y)) {
//                        System.out.println(x + " and " + y + " are anagrams");
                        anagramPairs++;
                    }
                }
            }
        }

        // return anagramPairs / 2 (because every pair was counted twice)
        return (anagramPairs / 2);
    }

    public static void main(String[] args) {
        System.out.println(getSubstrings("abba", 0)); // null
        System.out.println(getSubstrings("abba", 1)); // a, b, b, a
        System.out.println(getSubstrings("abba", 2)); // ab, bb, ba
        System.out.println(getSubstrings("abba", 3)); // abb, bba
        System.out.println(getSubstrings("abba", 4)); // abba
        System.out.println(getSubstrings("abba", 5)); // null

        System.out.println("-------------------");

        System.out.println(areAnagrams("abb", "bba")); // true
        System.out.println(areAnagrams("abb", "bbc")); // false
        System.out.println(areAnagrams("acbd", "cdba")); // true

        System.out.println("-------------------");
        System.out.println(sherlockAndAnagrams("abba")); // 4
        System.out.println(sherlockAndAnagrams("abcd")); // 0
        System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // 166650
    }
}
