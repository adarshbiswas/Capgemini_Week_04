import static org.junit.jupiter.api.Assertions.*;

import advanced_junit_problems.UserRegistration;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    @Test
    public void testValidRegistration() {
        UserRegistration registration = new UserRegistration();
        assertDoesNotThrow(() -> registration.registerUser("user", "user@example.com", "password123"));
    }

    @Test
    public void testInvalidUsername() {
        UserRegistration registration = new UserRegistration();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "user@example.com", "password123");
        });
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        UserRegistration registration = new UserRegistration();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("user", "invalid-email", "password123");
        });
        assertEquals("Invalid email.", exception.getMessage());
    }

    @Test
    public void testInvalidPassword() {
        UserRegistration registration = new UserRegistration();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("user", "user@example.com", "pass");
        });
        assertEquals("Password must be at least 8 characters long.", exception.getMessage());
    }
}