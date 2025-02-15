package extraction_problems2;

import java.util.regex.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info."; // Example input
        String regex = "https?://[\\w.-]+\\.[a-zA-Z]{2,}"; // Regex pattern for links

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each link found
        }
    }
}