package extraction_problems2;

public class SpaceReplacer {
    public static void main(String[] args) {
        String text = "This is an example with multiple    spaces."; // Example input
        String result = text.replaceAll("\\s+", " "); // Replace multiple spaces with a single space
        System.out.println(result);
    }
}
