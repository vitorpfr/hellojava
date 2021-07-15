package arraysandstrings;

public class OneAway {

    //    There are three types of edits that can be performed on strings: insert a character,
    //    remove a character, or replace a character. Given two strings, write a function to check if they are
    //    one edit (or zero edits) away

    // checks:
    // 1. str1 is str2 with one additional character
    // 2. str1 is str2 with one removed character
    // 3. str1 is str2 with one character shifted

    // calculate length diff
    // if length diff is greater than 1, return false

    // if length diff is equal to 1
        // initialize offset = 0
        // initialize counter = 0
        // loop through larger string and compare str1[i + offset] with str2[i]
            // if current char is different in both strings, counter++ and offset++
            // if counter > 1, return false

    // if length diff is equal to 0
        // initialize counter as 0
        // loop through index i, 0 to length
            // if char i is different in both strings, counter++
            // if counter > 1, return false
        // return true

    public static boolean oneAwayOneCharacterDiff(String largeString, String shortString) {
        int offset = 0;
        for (int i = 0; i < largeString.length(); i++) {
            // if offset is 1 and current character is last, exit loop and return true
            if (i == largeString.length() - 1) {
                break;
            }

            // if current char is different and offset is zero, increment offset
            if ((largeString.charAt(i) != shortString.charAt(i)) && offset == 0) {
                offset++;
            }

            // if current char is different (considering offset), returns false
            if (largeString.charAt(i + offset) != shortString.charAt(i) && offset == 1) {
                return false;
            }
        }

        return true;
    }


    public static boolean oneAwayEqualCharacterCount(String str1, String str2) {
        int counter = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                counter++;
            }
            if (counter > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean oneAway(String str1, String str2) {
        int lengthAbsDifference = Math.abs(str1.length() - str2.length());

        // if size difference is equal to 1, it is a candidate to be oneAway
        if (lengthAbsDifference == 1) {
            if (str1.length() > str2.length()) {
                return oneAwayOneCharacterDiff(str1, str2);
            } else {
                return oneAwayOneCharacterDiff(str2, str1);
            }
        }

        // if size difference is equal to 0, it is a candidate to be oneAway
        if (lengthAbsDifference == 0) {
            return oneAwayEqualCharacterCount(str1, str2);
        }

        // if size difference of strings is more than 1, return false
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple")); // true
        System.out.println(oneAway("pales", "pale")); // true
        System.out.println(oneAway("pale", "bale")); // true
        System.out.println(oneAway("pale", "bake")); // false
        System.out.println(oneAway("pale", "bakeee")); // false
    }
}