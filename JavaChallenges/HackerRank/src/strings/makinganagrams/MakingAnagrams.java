package strings.makinganagrams;

public class MakingAnagrams {
    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int LOWERCASE_LETTERS = 26;

    public static int makeAnagram(String a, String b) {
        // since a and b contain lowercase English letters (a-z), we can use an int array of size 26
        // to store the count of each letter on the strings (e.g. 'a' is index 0, 'z' is index 25)
        int[] dataStore = new int[LOWERCASE_LETTERS];

        // loop through string a and register the frequency of each character (subtracting 'a' so it maps from 0 to 25)
        for (int i = 0; i < a.length(); i++) {
            char currentChar = a.charAt(i);
            dataStore[currentChar - 'a'] += 1;
        }

        // loop through string b and subtract the frequency of each character from a
        for (int i = 0; i < b.length(); i++) {
            char currentChar = b.charAt(i);
            dataStore[currentChar - 'a'] -= 1;
        }

        // any index with value different from zero in the data store represent a char that needs to be deleted
        // to achieve an anagram
        // loop through datastore and add the values from it
        int sum = 0;
        for (int value : dataStore) {
            sum += Math.abs(value);
        }

        return sum;
    }
}
