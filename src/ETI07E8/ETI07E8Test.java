package ETI07E8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ETI07E8Test {

    @Test
    void solve() {
        String test = "aaa";
        String test2 = "aac";
        assertEquals(-1, test.compareTo(test2));
    }
}