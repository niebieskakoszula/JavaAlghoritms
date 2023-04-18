package PRIME_T;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PRIME_TTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 181, 1000081})
    void CheckForPrimeNumber_ReturnTrue(int num) {
        assertTrue(PRIME_T.CheckForPrimeNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 180, 1000080})
    void CheckForPrimeNumber_ReturnFalse(int num) {
        assertFalse(PRIME_T.CheckForPrimeNumber(num));
    }
}