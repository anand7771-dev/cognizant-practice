package junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {

    Calculator c = new Calculator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void testNumbers(int num) {
        assertEquals(num, c.add(num, 0));
    }

    @ParameterizedTest
    @CsvSource({
        "10,5,15",
        "20,10,30",
        "5,5,10"
    })
    void testAdd(int a, int b, int result) {
        assertEquals(result, c.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "10,5,5",
        "20,10,10",
        "8,3,5"
    })
    void testSubtract(int a, int b, int result) {
        assertEquals(result, c.subtract(a, b));
    }
}