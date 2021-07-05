package warmup.repeatedstrings;

public class RepeatedStrings {
    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {

        // get number of 'a's in a full string
        long countOfAInFullString = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countOfAInFullString++;
            }
        }

        // given that we want n first characters, we get the number of full strings repeated
        // and the number of remaining chars
        long fullStringOccurrences = n / s.length();
        long remainingChars = n % s.length();

        long countOfAInRemainingChars = 0L;
        for (int i = 0; i < remainingChars; i++) {
            if (s.charAt(i) == 'a') {
                countOfAInRemainingChars++;
            }
        }

        // return the sum of 'a's
        return ((fullStringOccurrences * countOfAInFullString) + countOfAInRemainingChars);
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("abcac", 10));
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
    }
}
