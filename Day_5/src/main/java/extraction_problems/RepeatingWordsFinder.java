package extraction_problems;

import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test."; // Example input
        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b"; // Regex pattern for repeating words
        // \\b(\\w+)\\b captures a word
        // \\s+ matches one or more spaces
        // \\b\\1\\b matches the same word again

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1)); // Print each repeating word found
        }
    }
}