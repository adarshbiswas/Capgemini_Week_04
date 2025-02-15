package advanced_junit_problems;

public class PasswordValidator {
    public boolean isValid(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isDigit);
    }
}
