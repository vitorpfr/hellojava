package strings.alternatingcharacters;

public class AlternatingCharacters {

    // brute force / non-optimal:
    // initialize index i = 0 (first letter) and loop until i < s.length() (last letter)
    // while next letter is different, delete it (stringbuilder?)

    // other proposal that considers that String is immutable (avoid using Stringbuilder/mutable things):
    // initialize deletionCounter = 0
    // initialize index i = 0 (first letter) and loop until i < s.length() (last letter)
    // while letter on i + 1 is different from i, add 1 to i and 1 to deletionCounter ("fake" deletion)

    public static boolean isLastElementOfString(int index, String s) {
        return (index == s.length() - 1);
    }

    public static boolean isNextIndexWithinBounds(int currentIndex, int charJump, String s) {
        int nextIndex = currentIndex + charJump;
        return ((nextIndex > 0) && (nextIndex < s.length()));
    }

    public static boolean isCurrentCharEqualToNext(int currentIndex, int charJump, String s) {
        return (s.charAt(currentIndex) == s.charAt(currentIndex + charJump));
    }

    public static boolean nextCharNeedsToBeDeleted(int currentIndex, int charJump, String s) {
        return (isNextIndexWithinBounds(currentIndex, charJump, s)) && (isCurrentCharEqualToNext(currentIndex, charJump, s));
    }


    // my solution
    public static int alternatingCharacters(String s) {
        int charsToBeDeleted = 0;
        int charJump;
        for (int i = 0; i < s.length(); i += charJump) {

            charJump = 1;

            while (nextCharNeedsToBeDeleted(i, charJump, s)) {
                charJump++;
                charsToBeDeleted++;
            }
        }

        return charsToBeDeleted;
    }


    // solution from hackerrank discussions
    public static int altAlternatingCharacters(String s) {
        int count = 0;
        char lastItem = 0;

        for(char item: s.toCharArray()){
            if(lastItem == item){
                count++;
            }
            lastItem = item;
        }
        return count;
    }

    // another solution from hackerrank discussions
    // catch: loop until the 'penultimo' element (excluding the last one)
    public static int alt2AlternatingCharacters(String s) {
        int count = 0;
        for(int i = 0; i < s.length() - 1; i++){ // A
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}
