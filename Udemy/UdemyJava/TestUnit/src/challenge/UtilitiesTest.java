package challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    // not needed because Utilities class doesn't have internal state that needs to be reset
    // so it is better to instantiate a static field as done below
//    private Utilities util;
//    @BeforeEach
//    void setup() {
//        util = new Utilities();
//    }

    private static final Utilities util = new Utilities();

    @Test
    void everyNthChar() {
        assertArrayEquals(new char[] {'e', 'l'}, util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2));
        assertArrayEquals(new char[] {'h', 'i'}, util.everyNthChar(new char[] {'h', 'i'}, 3));
    }

    @Test
    void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
        assertNull(util.removePairs(null));
    }

    @Test
    void converter() {
        assertEquals(300, util.converter(10, 5));
        assertThrows(ArithmeticException.class, () -> util.converter(10, 0));
    }

    @Test
    void nullIfOddLength() {
        assertNull(util.nullIfOddLength("abc"));
        assertNotNull(util.nullIfOddLength("ab"));
    }
}