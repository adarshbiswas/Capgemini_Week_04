package extraction_problems;

public class SpaceReplacer {
    public static void main(String[] args) {
        String text = "This is an example with multiple    spaces."; // Example input
        String result = text.replaceAll("\\s+", " "); // Replace multiple spaces with a single space
        // \\s+ matches one or more whitespace characters
        System.out.println(result);
    }
}