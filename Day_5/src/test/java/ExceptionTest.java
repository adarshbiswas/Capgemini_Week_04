import static org.junit.jupiter.api.Assertions.*;

import basic_junit_testing.Calculator;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}