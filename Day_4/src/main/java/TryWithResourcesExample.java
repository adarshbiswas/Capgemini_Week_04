import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Using try-with-resources to read file
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            System.out.println("First line: " + br.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
