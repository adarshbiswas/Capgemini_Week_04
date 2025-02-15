import static org.junit.jupiter.api.Assertions.*;

import advanced_junit_problems.DateFormatter;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    @Test
    public void testFormatDate() {
        DateFormatter formatter = new DateFormatter();
        assertEquals("12-05-2023", formatter.formatDate("2023-05-12"));
    }
}