package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskManager {
    @ImportantMethod(level = "CRITICAL")
    void criticalTask() {
        System.out.println("Critical task executed");
    }

    @ImportantMethod
    void highPriorityTask() {
        System.out.println("High priority task executed");
    }
}

public class Problem1 {
    public static void main(String[] args) throws NoSuchMethodException {
        ImportantMethod critical = TaskManager.class.getMethod("criticalTask").getAnnotation(ImportantMethod.class);
        ImportantMethod high = TaskManager.class.getMethod("highPriorityTask").getAnnotation(ImportantMethod.class);
        System.out.println("Critical Task Level: " + critical.level()); // Output: Critical Task Level: CRITICAL
        System.out.println("High Priority Task Level: " + high.level()); // Output: High Priority Task Level: HIGH
    }
}