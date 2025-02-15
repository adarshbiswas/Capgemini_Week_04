package basic_regex_problems;

import java.util.regex.*;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."; // Example input
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b"; // Regex pattern for dates in dd/mm/yyyy format
        // \\d{2} ensures two digits for day and month
        // \\d{4} ensures four digits for year

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each date found
        }
    }
}