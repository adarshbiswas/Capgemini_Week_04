package extraction_problems;

import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        String licensePlate = "AB1234"; // Example input
        String regex = "^[A-Z]{2}\\d{4}$"; // Regex pattern
        // ^[A-Z]{2} ensures the first two characters are uppercase letters
        // \\d{4} ensures the next four characters are digits

        boolean isValid = Pattern.matches(regex, licensePlate);
        System.out.println(licensePlate + " is " + (isValid ? "Valid" : "Invalid"));
    }
}