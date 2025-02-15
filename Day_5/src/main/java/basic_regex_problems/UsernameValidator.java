package basic_regex_problems;

import java.util.regex.*;

public class UsernameValidator {
    public static void main(String[] args) {
        String username = "user_123"; // Example input
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$"; // Regex pattern
        // ^[a-zA-Z] ensures the username starts with a letter
        // [a-zA-Z0-9_]{4,14} ensures the rest are letters, numbers, or underscores, and total length is 5-15

        boolean isValid = Pattern.matches(regex, username);
        System.out.println(username + " is " + (isValid ? "Valid" : "Invalid"));
    }
}