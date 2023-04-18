package FR_16_03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FR_16_03Test {

    @ParameterizedTest
    @MethodSource("provideStringsForSolve")
    void SolveShouldChangeOnlySnakeToCamelCase(String input, String expected) {
        assertEquals(expected, FR_16_03.Solve(input));
    }
    private static Stream<Arguments> provideStringsForSolve() {
        return Stream.of(
                Arguments.of("liczba_zestawow_danych", "liczbaZestawowDanych"),
                Arguments.of("imie", "imie"),
                Arguments.of("camelCase", "camelCase"),
                Arguments.of("kebab-case", "kebab-case")
        );
    }
}