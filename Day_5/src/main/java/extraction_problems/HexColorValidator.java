package extraction_problems;

import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        String hexColor = "#FFA500"; // Example input
        String regex = "^#[0-9A-Fa-f]{6}$"; // Regex pattern
        // ^# ensures the string starts with #
        // [0-9A-Fa-f]{6} ensures the next six characters are hexadecimal digits

        boolean isValid = Pattern.matches(regex, hexColor);
        System.out.println(hexColor + " is " + (isValid ? "Valid" : "Invalid"));
    }
}
