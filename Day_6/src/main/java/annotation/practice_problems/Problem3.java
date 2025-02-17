package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

class TaskManager {
    @LogExecutionTime
    void performTask() {
        try {
            Thread.sleep(1000); // Simulate task execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Problem3 {
    public static void main(String[] args) throws NoSuchMethodException {
        TaskManager manager = new TaskManager();
        long startTime = System.nanoTime();
        manager.performTask();
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}