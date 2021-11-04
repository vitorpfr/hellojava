package challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// reference: https://www.baeldung.com/parameterized-tests-junit-5
public class UtilitiesTestParameterized {
    private static final Utilities util = new Utilities();

    // Here we're literally returning a stream of arguments, but it's not a strict requirement. For example, we can return any other collection-like interfaces like List.
    private static Stream<Arguments> provideStringsForRemovePairs() {
        return Stream.of(
                Arguments.of("ABCDEFF", "ABCDEF"),
                Arguments.of("AB88EFFG", "AB8EFG"),
                Arguments.of("112233445566", "123456"),
                Arguments.of("ZYZQQB", "ZYZQB"),
                Arguments.of("A", "A")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForRemovePairs")
    void removePairs(String input, String expected) {
        assertEquals(expected, util.removePairs(input));
    }
}
