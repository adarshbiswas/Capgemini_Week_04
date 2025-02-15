import static org.junit.jupiter.api.Assertions.*;

import basic_junit_testing.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("cba", utils.reverse("abc"));
    }

    @Test
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    public void testToUpperCase() {
        StringUtils utils = new StringUtils();
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}