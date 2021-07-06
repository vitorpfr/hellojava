package strings.permutationswithin;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsWithinTest {

    @Test
    public void testPermutationsWithin() {
        String s = "xacxzaa";
        String b = "fxaazxacaaxzoecazxaxaz";

        assertEquals(5, PermutationsWithinMain.findPermutations(s, b).size());
    }

}
