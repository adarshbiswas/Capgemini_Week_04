package extraction_problems2;

import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50."; // Example input
        String regex = "\\$?\\d+(\\.\\d+)?"; // Regex pattern for currency values
        // \\$? matches optional dollar sign
        // \\d+ matches one or more digits
        // (\\.\\d+)? matches optional decimal part

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each currency value found
        }
    }
}