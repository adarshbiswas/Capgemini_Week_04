import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pos.connect(pis); // Connect the streams

        Thread writerThread = new Thread(() -> {
            try (PipedOutputStream p = pos) {
                p.write("Hello from writer thread!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            try (PipedInputStream p = pis) {
                int data;
                while ((data = p.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writerThread.start();
        readerThread.start();
    }
}