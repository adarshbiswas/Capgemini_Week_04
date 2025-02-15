import static org.junit.jupiter.api.Assertions.*;

import advanced_junit_problems.PasswordValidator;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    public void testInvalidPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("password"));
    }
}