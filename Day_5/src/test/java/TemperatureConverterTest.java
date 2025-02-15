import static org.junit.jupiter.api.Assertions.*;

import advanced_junit_problems.TemperatureConverter;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    @Test
    public void testCelsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(32, converter.celsiusToFahrenheit(0));
    }

    @Test
    public void testFahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(0, converter.fahrenheitToCelsius(32));
    }
}