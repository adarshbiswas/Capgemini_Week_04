import java.io.*;

public class ConvertCase {
    public static void main(String[] args) {
        String inputFile = "Day_3/src/main/resources/ConvertCase/input.txt";
        String outputFile = "Day_3/src/main/resources/ConvertCase/output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase() + "\n"); // Convert to lowercase
            }
            System.out.println("File converted and saved.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}