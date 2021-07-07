package strings.makinganagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakingAnagramsTest {
    @Test
    public void test() {
        assertEquals(4, MakingAnagrams.makeAnagram("cde", "abc"));
        assertEquals(0, MakingAnagrams.makeAnagram("abcdef", "abcdef"));
        assertEquals(3, MakingAnagrams.makeAnagram("abcdefghii", "abcdefgji"));
    }
}
