package strings.isanagram;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {
    // this problem is not on hackerrank, but it is a basic version of makinganagrams

    // problem: create a function that returns true if strings s1 and s2 are anagrams, false otherwise

    // brute force method: ???
    // if s1.length = s2.length
        // boolean anagram = true;
        // for char in s1:
            //
    // else
        // return false

    // memory-optimized method: sort strings and compare
    // runtime: at least O(n log n) (O(n) to convert to char and to compare arrays, but sort is the bottleneck)
    public static boolean memIsAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }


    // runtime-optimized method: use hashmap
    // runtime: O(n), n being the sum of array sizes
    public static boolean runIsAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1DataStore = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            int newCount = (s1DataStore.get(currentChar) == null) ? 1 : (s1DataStore.get(currentChar) + 1);
            s1DataStore.put(currentChar, newCount);
        }

        for (int i = 0; i < s2.length(); i++) {
            char currentChar = s2.charAt(i);
            s1DataStore.put(currentChar, (s1DataStore.get(currentChar) - 1));
        }

        for (char c : s1DataStore.keySet()) {
            if (s1DataStore.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagramsStack(String one, String two) {
        if (one.length() == two.length()) {
            String s0 = one.toLowerCase();
            String s1 = two.toLowerCase();
            HashMap<Character, Integer> chars = new HashMap<Character, Integer>(one.length());
            Integer count;
            for (char c : s0.toCharArray()) {
                count = chars.get(c);
                count = count != null ? count + 1 : 1;
                chars.put(c, count);
            }
            for (char c : s1.toCharArray()) {
                count = chars.get(c);
                if (count == null) {
                    return false;
                } else {
                    count--;
                    chars.put(c, count);
                }
            }
            for (Integer i : chars.values()) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

//    static int NO_OF_CHARS = 256;

    // function to check if two strings
    // are anagrams of each other
//    static boolean areAnagramGeeks(String str1a, String str2a)
//    {
//        char[] str1 = str1a.toCharArray();
//        char[] str2 = str2a.toCharArray();
//
//        // Create a count array and initialize
//        // all values as 0
//        int[] count = new int[NO_OF_CHARS];
//        int i;
//
//        // For each character in input strings,
//        // increment count in the corresponding
//        // count array
//        for(i = 0; i < str1.length; i++)
//        {
//            count[str1[i] - 'a']++;
//            count[str2[i] - 'a']--;
//        }
//
//        // If both strings are of different
//        // length. Removing this condition
//        // will make the program fail for
//        // strings like "aaca" and "aca"
//        if (str1.length != str2.length)
//            return false;
//
//        // See if there is any non-zero
//        // value in count array
//        for(i = 0; i < NO_OF_CHARS; i++)
//            if (count[i] != 0)
//            {
//                return false;
//            }
//        return true;
//    }

    // faster version!
    public static boolean areAnagrams(String s1, String s2) {
        // if lengths are different, return false already (not an anagram)
        if (s1.length() != s2.length()) {
            return false;
        }

        // initialize dataStore int[] to store counting data ('a' is 0, 'z' is 25)
        int[] dataStore = new int[26];

        int i;
        // loop through s1, adding 1 to the index of the respective char
        for (i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            dataStore[currentChar - 'a'] += 1;
        }

        // loop through s2, subtracting 1 to the index of the respective char
        for (i = 0; i < s2.length(); i++) {
            char currentChar = s2.charAt(i);
            dataStore[currentChar - 'a'] -= 1;
        }

        // loop through dataStore; if any element is different from 0, return false
        for (i = 0; i < dataStore.length; i++) {
            if (dataStore[i] != 0) {
                return false;
            }
        }

        // return true (all elements are zero, meaning that they match
        return true;
    }
}
