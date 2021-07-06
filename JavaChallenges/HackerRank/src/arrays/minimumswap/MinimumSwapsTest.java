package arrays.minimumswap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSwapsTest {

    // to run tests in java:
    // 1) create a class BlablaTest
    // 2) create a method public void testBlabla()
    // insert the @Test annotation above it and import junit5
    // start writing assertEquals, etc, and import them
    @Test
    public void testMinimumSwaps() {
        assertEquals(5, MinimumSwaps.minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));
        assertEquals(3, MinimumSwaps.minimumSwaps(new int[]{2, 3, 4, 1, 5}));
    }
}
