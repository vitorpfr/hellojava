package arrays.findelementsincommon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindElementsInCommonTest {

    @Test
    public void findElementsInCommonTest() {
        assertEquals(3, FindElementsInCommon.numberOfElementsInCommon(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
        assertEquals(3, FindElementsInCommon.numberOfElementsInCommon(Arrays.asList(1, 5, 15, 20, 30, 37), Arrays.asList(2, 5, 13, 30, 32, 35, 37, 42)));
        assertEquals(3, FindElementsInCommon.numberOfElementsInCommon(Arrays.asList(1, 2, 8), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));
    }
}
