package arraysandstrings;

public class StringCompression {

    // String Compression: Implement a method to perform basic string compression using the counts
    //of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    //"compressed" string would not become smaller than the original string, your method should return
    //the original string. You can assume the string has only uppercase and lowercase letters (a - z).

    public static String compress(String str) {

        // initialize mappingString to false
        // initialize stringRepetitionCount to 0
        // initialize stringbuilder sb

        // loop through string characters (i = 0 to i < str.length())
            // counter++

            // if (character is the last one or (next character is different from this and mappingString is true)
                // append to sb: current character + counter (e.g. a2)
                // set mappingString to false
                // set counter to 0

            // if (next character is equal to this) and (mappingString is true)
                // do nothing (continue)

            // if mappingString is false
                // set mappingString to true

        // "aaaab"
        // 0: counter = 1, mappingstring = true
        // 1: counter = 2
        // 2: counter = 3
        // 3: counter = 4, append "a4", mappingstring = false, counter = 0
        // 4: counter = 1, append b1

        int repetitionCounter = 0;
        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            repetitionCounter++;

            if ((i == str.length() - 1) || (str.charAt(i) != str.charAt(i + 1))) {
                compressed.append(str.charAt(i));
                compressed.append(repetitionCounter);
                repetitionCounter = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        System.out.println(compress("aaaabb"));
    }
}
