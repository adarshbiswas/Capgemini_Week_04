package basic_regex_problems;

import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String ssn = "123-45-6789"; // Example input
        String regex = "^\\d{3}-\\d{2}-\\d{4}$"; // Regex pattern for SSN
        // \\d{3} matches three digits for the first part
        // \\d{2} matches two digits for the second part
        // \\d{4} matches four digits for the third part

        boolean isValid = Pattern.matches(regex, ssn);
        System.out.println(ssn + " is " + (isValid ? "Valid" : "Invalid"));
    }
}