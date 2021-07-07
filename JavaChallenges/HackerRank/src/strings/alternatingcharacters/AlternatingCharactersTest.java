package strings.alternatingcharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlternatingCharactersTest {
    @Test
    public void test() {
        assertEquals(0, AlternatingCharacters.alternatingCharacters("A"));
        assertEquals(1, AlternatingCharacters.alternatingCharacters("AA"));
        assertEquals(3, AlternatingCharacters.alternatingCharacters("AAAA"));
        assertEquals(4, AlternatingCharacters.alternatingCharacters("BBBBB"));
        assertEquals(0, AlternatingCharacters.alternatingCharacters("ABABABAB"));
        assertEquals(0, AlternatingCharacters.alternatingCharacters("BABABA"));
        assertEquals(4, AlternatingCharacters.alternatingCharacters("AAABBB"));

        assertEquals(0, AlternatingCharacters.altAlternatingCharacters("A"));
        assertEquals(1, AlternatingCharacters.altAlternatingCharacters("AA"));
        assertEquals(3, AlternatingCharacters.altAlternatingCharacters("AAAA"));
        assertEquals(4, AlternatingCharacters.altAlternatingCharacters("BBBBB"));
        assertEquals(0, AlternatingCharacters.altAlternatingCharacters("ABABABAB"));
        assertEquals(0, AlternatingCharacters.altAlternatingCharacters("BABABA"));
        assertEquals(4, AlternatingCharacters.altAlternatingCharacters("AAABBB"));

        assertEquals(0, AlternatingCharacters.alt2AlternatingCharacters("A"));
        assertEquals(1, AlternatingCharacters.alt2AlternatingCharacters("AA"));
        assertEquals(3, AlternatingCharacters.alt2AlternatingCharacters("AAAA"));
        assertEquals(4, AlternatingCharacters.alt2AlternatingCharacters("BBBBB"));
        assertEquals(0, AlternatingCharacters.alt2AlternatingCharacters("ABABABAB"));
        assertEquals(0, AlternatingCharacters.alt2AlternatingCharacters("BABABA"));
        assertEquals(4, AlternatingCharacters.alt2AlternatingCharacters("AAABBB"));
    }
}
