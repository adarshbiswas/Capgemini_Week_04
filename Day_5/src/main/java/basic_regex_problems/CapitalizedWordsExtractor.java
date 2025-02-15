package basic_regex_problems;

import java.util.regex.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York."; // Example input
        String regex = "\\b[A-Z][a-z]*\\b"; // Regex pattern for capitalized words
        // \\b[A-Z] ensures the word starts with a capital letter
        // [a-z]* ensures the rest of the word is lowercase letters

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each capitalized word found
        }
    }
}