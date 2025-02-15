package extraction_problems2;

import java.util.regex.*;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."; // Example input
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b"; // Regex pattern for dates in dd/mm/yyyy format

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each date found
        }
    }
}