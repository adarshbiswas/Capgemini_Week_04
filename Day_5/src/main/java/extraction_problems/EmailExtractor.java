package extraction_problems;

import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org"; // Example input
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"; // Regex pattern for email
        // \\b ensures word boundaries
        // [A-Za-z0-9._%+-]+ matches the local part of the email
        // @ matches the @ symbol
        // [A-Za-z0-9.-]+ matches the domain name
        // \\.[A-Z|a-z]{2,} matches the top-level domain (e.g., .com, .org)

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each email found
        }
    }
}