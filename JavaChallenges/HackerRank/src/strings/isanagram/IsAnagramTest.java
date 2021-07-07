package strings.isanagram;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsAnagramTest {

    @Test
    public void testIsAnagram() {
        assertTrue(IsAnagram.memIsAnagram("abc", "cba"));
        assertTrue(IsAnagram.memIsAnagram("abcdefghaa", "aabcdehgaf"));
        assertFalse(IsAnagram.memIsAnagram("abc", "abcd"));

        assertTrue(IsAnagram.runIsAnagram("abc", "cba"));
        assertTrue(IsAnagram.runIsAnagram("abcdefghaa", "aabcdehgaf"));
        assertFalse(IsAnagram.runIsAnagram("abc", "abcd"));

    }
}
