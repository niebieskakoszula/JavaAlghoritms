import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BFN1Test {

    @ParameterizedTest
    @MethodSource("numbersToSolve")
    void Solve(int input, int expectedResult, int expectedAmount) {
        var result = BFN1.Solve(input);
        assertEquals(result[0], expectedResult);
    }
    private static Stream<Arguments> numbersToSolve() {
        return Stream.of(
                arguments(28, 121, 2),
                arguments(68, 1111, 3),
                arguments(5, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("numberToAddReversed")
    void ReverseInteger(int input, int expected) {
        var result = BFN1.ReverseInteger(input);
        assertEquals(result, expected);
    }
    private static Stream<Arguments> numberToAddReversed() {
        return Stream.of(
                arguments(28, 82),
                arguments(1111, 1111),
                arguments(5, 5),
                arguments(121, 121),
                arguments(123, 321)
        );
    }

    @ParameterizedTest
    @MethodSource("stringToPalindromeCheck")
    void CheckForPalindrome(int input, boolean expected) {
        var result = BFN1.CheckForPalindrome(input);
        assertEquals(result, expected);
    }
    private static Stream<Arguments> stringToPalindromeCheck() {
        return Stream.of(
                arguments(28, false),
                arguments(110, false),
                arguments(0, true),
                arguments(1, true),
                arguments(44, true),
                arguments(121, true),
                arguments(1111, true)
        );
    }
}