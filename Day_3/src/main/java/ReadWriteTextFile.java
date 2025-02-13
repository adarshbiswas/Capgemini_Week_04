import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteTextFile {

    public static void main(String[] args) {

        String sourceFilePath = "Day_3/src/main/resources/ReadWriteTextFile/input.txt";
        String destinationFilePath = "Day_3/src/main/resources/ReadWriteTextFile/output.txt";

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath);) {
            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.print("File copied successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

    }
}
