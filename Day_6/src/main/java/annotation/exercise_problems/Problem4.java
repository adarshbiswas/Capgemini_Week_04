package annotation.exercise_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority() default "MEDIUM";

    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "John")
    void completeTask() {
        System.out.println("Task completed");
    }
}

public class Problem4 {
    public static void main(String[] args) throws NoSuchMethodException {
        TaskInfo info = TaskManager.class.getMethod("completeTask").getAnnotation(TaskInfo.class);
        System.out.println("Priority: " + info.priority()); // Output: Priority: HIGH
        System.out.println("Assigned To: " + info.assignedTo()); // Output: Assigned To: John
    }
}