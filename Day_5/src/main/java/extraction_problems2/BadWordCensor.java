package extraction_problems2;

import java.util.regex.*;

public class BadWordCensor {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words."; // Example input
        String[] badWords = {"damn", "stupid"}; // List of bad words
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****"); // Replace bad words with ****
        }
        System.out.println(text);
    }
}