package basic_junit_testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestExample {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    public void testIsEven(int number) {
        assertTrue(number % 2 == 0);
    }
}