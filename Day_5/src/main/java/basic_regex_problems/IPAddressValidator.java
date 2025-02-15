package basic_regex_problems;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1"; // Example input
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"; // Regex pattern for IPv4
        // Each group matches numbers from 0 to 255

        boolean isValid = Pattern.matches(regex, ipAddress);
        System.out.println(ipAddress + " is " + (isValid ? "Valid" : "Invalid"));
    }
}