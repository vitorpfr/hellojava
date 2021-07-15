package strings.sherlockandthevalidstring;

import java.lang.reflect.Array;
import java.util.*;

public class ValidString {

    // me trying to do it, didn't work
//    public static String isValid(String s) {
//        String valid = "YES";
//        String notValid = "NO";
//
//        // initialize int[] dataStore with 26 spaces (a is 0, z is 25)
//        int[] dataStore = new int[26];
//
//        // loop through s chars and update to the respective index for each char occurrence
//        for (int i = 0; i < s.length(); i++) {
//            int charIndex = s.charAt(i) - 'a';
//            int newValue = dataStore[charIndex] + 1;
//            dataStore[charIndex] = newValue;
//        }
//
//        // loop through dataStore printing - remove after
//        for (int i = 0; i < dataStore.length; i++) {
//            System.out.println(((char) (i + 'a')) + " " +  dataStore[i]);
//        }
//
//        // get distinct frequencies in datastore array (except zero) and save to a hashmap
//        int minFrequency = Integer.MAX_VALUE;
//        int maxFrequency = Integer.MIN_VALUE;
//        HashMap<Integer, Integer> letterCountFrequencies = new HashMap<>();
////        List<Integer> distinctFrequencies = new ArrayList<>();
//        for (int i = 0; i < dataStore.length; i++) {
//
//            // if element is not in the new list, add it and update min/max values
//            int currentElement = dataStore[i];
//            if (currentElement != 0)  {
//                int currentValue = (letterCountFrequencies.get(currentElement) == null) ? 0 : letterCountFrequencies.get(currentElement);
//                int newValue = currentValue + 1;
//                letterCountFrequencies.put(currentElement, newValue);
//
//                if (currentElement > maxFrequency) {
//                    maxFrequency = currentElement;
//                }
//
//                if (currentElement < minFrequency) {
//                    minFrequency = currentElement;
//                }
//            }
//        }
//
//        System.out.println(letterCountFrequencies);
//        System.out.println(minFrequency);
//        System.out.println(maxFrequency);
//
//
//        // set conditions for number to be valid or not
//        boolean validOneFrequencyString = (letterCountFrequencies.size() == 1);
//        boolean validTwoFrequenciesString = (letterCountFrequencies.size() == 2) &&
//                ((maxFrequency - minFrequency) == 1);
//
////        // return string based on conditions
//        if (validOneFrequencyString || validTwoFrequenciesString) {
//            return valid;
//        } else {
//            return notValid;
//        }
//
//    }

    public static String isValid(String s) {
        String valid = "YES";
        String notValid = "NO";

        // returning result for obvious cases (empty string or small strings)
        if (s.isEmpty()) {
            return notValid;
        }
        if (s.length() <= 2) {
            return valid;
        }

        // initialize array to store letter frequencies
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)- 'a']++;
        }

        // sort letter frequency array and set index past zero elements
        Arrays.sort(letters);
        int i = 0;
        while (letters[i] == 0) {
            i++;
        }

        // setting smallest and largest frequency of letters
        int min = letters[i];
        int max = letters[25];

        // conditions for being a valid string:
        // 1. all letters have same frequency
        // 2. there's a diff of 1 between max and min frequency, and there's only one letter with max frequency
        // 3. min frequency is 1 and there's only one letter with min frequency
        boolean isValidString = (min == max) ||
                ((max - min == 1) && (max > letters[24])) ||
                ((min == 1) && (letters[i+1] == max));

        // return result based on boolean check
        if (isValidString) {
            return valid;
        } else {
            return notValid;
        }

    }

    public static void main(String[] args) {
        System.out.println(isValid("aabcd"));
        System.out.println(isValid("aaabcd"));

        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("aabbccddeefghi"));


    }
}
