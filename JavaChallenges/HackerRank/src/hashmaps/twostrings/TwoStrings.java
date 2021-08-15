package hashmaps.twostrings;

import java.util.HashMap;

public class TwoStrings {
    // https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

    public static String twoStrings(String s1, String s2) {
        // initialize HashMap<Character, Boolean> to store char presence data
        HashMap<Character, Boolean> dataStore = new HashMap<>();

        // loop through s1 and store char counts
        for (int i = 0; i < s1.length(); i++) {
            dataStore.put(s1.charAt(i), true);
        }

        // loop through s2
        for (int j = 0; j < s2.length(); j++) {
            // if current char exists in the map, return true
            if (dataStore.get(s2.charAt(j)) != null) {
                return "YES";

            }
        }

        // return false
        return "NO";

    }

    // possible optimization:
    // substitute char storage from hashmap to new boolean[26], with index representing chars ('a' is 0, etc)
}
