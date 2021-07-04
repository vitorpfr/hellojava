package isograms;

public class isogram {

    public static final int MAX_CHARS = 256;

    public static boolean isIsogram(String str) {

        // initializes a boolean[] to mark if a char was already observed
        boolean[] charWasSeen = new boolean[MAX_CHARS];

        // converts string to char[], storing to variable 'array'
        char[] array = str.toLowerCase().toCharArray();

        // for each char in array, set its position on charWasSeen to true.
        // but first, if that char was already found, we already know that word is not a isogram
        for (char c : array) {
            if (charWasSeen[(int) c]) {
                return false;
            }

            charWasSeen[(int) c] = true;
        }

        // if for loop exits, it means that there are no repeated chars. return that word is isogram
        return true;
    }

    // better solution
    public static boolean betterIsIsogram(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }

}
