import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String fileName = "Day_3/src/main/resources/LargeFileReader/largeFile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line); // Print lines containing "error"
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}