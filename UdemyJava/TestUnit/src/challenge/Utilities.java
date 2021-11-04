package challenge;

public class Utilities {
    // Returns a char array containing every nth char. When sourceArray.length < n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n; // 5/2 equals to 2
        char[] result = new char[returnedLength]; // char[2]
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) { // i is 1, then 3
            result[index++] = sourceArray[i]; // result[0] = sourceArray[0]
        }

        return result;
    }

    // Remove pairs of the same character that are next to each other, by removing on e occurrence of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (the two B's aren't next to each other, so they aren't removed)
    public String removePairs(String source) {
        // If length is less than two, there won't be any pairs
        if (source == null || (source.length() < 2)) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        // Loop all characters and add unique ones to stringbuilder, returning it later
        for (int i = 0; i < string.length; i++) {
            boolean isLastCharacter = (i == (string.length - 1));

            if (isLastCharacter || (string[i] != string[i + 1])) {
                sb.append(string[i]);
            }
        }

        return sb.toString();
    }

    // perform a conversion based on some internal business rule
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }

        return null;
    }
}
