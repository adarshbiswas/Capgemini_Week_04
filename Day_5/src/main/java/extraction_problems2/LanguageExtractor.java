package extraction_problems2;

import java.util.regex.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet."; // Example input
        String regex = "\\b(Java|Python|JavaScript|Go)\\b"; // Regex pattern for programming languages
        // \\b ensures word boundaries
        // (Java|Python|JavaScript|Go) matches any of the specified languages

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each language found
        }
    }
}
