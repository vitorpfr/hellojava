import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class LoopThroughStrings {

    // not part of the udemy course
    // https://www.techiedelight.com/iterate-over-characters-string-java/

    public static void main(String[] args) {
        // 1. Naive solution
        // effective for strings of smaller length
        String s1 = "Vitor";
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i));
        }

        System.out.println("--------------------------");

        // 2. Using String.toCharArray()
        String s2 = "Vitor";
        char[] chars = s2.toCharArray();

        for (char ch: chars) {
            System.out.println(ch);
        }

        System.out.println("--------------------------");

        // 3. Using StringCharacterIterator (bidirectional iteration)
        // ops: for loop is preferred
        String s3 = "Vitor";
        CharacterIterator it = new StringCharacterIterator(s3);
        while (it.current() != CharacterIterator.DONE) {
            System.out.println(it.current());
            it.next();
        }

        // Performance considerations (which is fastest?)
        // prefer using for loop and s1.charAt(i)
    }
}
