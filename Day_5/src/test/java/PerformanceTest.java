import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTest {

    @Test
    @Timeout(2)
    public void testLongRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulate a long-running task
    }
}