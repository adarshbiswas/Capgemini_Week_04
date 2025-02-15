package extraction_problems2;

import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org"; // Example input
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"; // Regex pattern for email

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each email found
        }
    }
}