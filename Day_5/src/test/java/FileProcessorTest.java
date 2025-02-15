import static org.junit.jupiter.api.Assertions.*;

import basic_junit_testing.FileProcessor;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class FileProcessorTest {

    @Test
    public void testWriteAndReadFile() throws IOException {
        FileProcessor processor = new FileProcessor();
        String filename = "test.txt";
        String content = "Hello, World!";

        processor.writeToFile(filename, content);
        assertEquals(content, processor.readFromFile(filename));
    }

    @Test
    public void testFileNotFound() {
        FileProcessor processor = new FileProcessor();
        Exception exception = assertThrows(IOException.class, () -> {
            processor.readFromFile("nonexistent.txt");
        });
        assertEquals("nonexistent.txt (No such file or directory)", exception.getMessage());
    }
}