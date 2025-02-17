package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    void loginFeature() {
        System.out.println("Login feature in progress");
    }

    @Todo(task = "Fix UI alignment", assignedTo = "Bob")
    void fixUI() {
        System.out.println("Fixing UI alignment");
    }
}

public class Problem2 {
    public static void main(String[] args) throws NoSuchMethodException {
        Todo loginTodo = Project.class.getMethod("loginFeature").getAnnotation(Todo.class);
        Todo uiTodo = Project.class.getMethod("fixUI").getAnnotation(Todo.class);
        System.out.println("Task: " + loginTodo.task() + ", Assigned To: " + loginTodo.assignedTo() + ", Priority: " + loginTodo.priority());
        System.out.println("Task: " + uiTodo.task() + ", Assigned To: " + uiTodo.assignedTo() + ", Priority: " + uiTodo.priority());
    }
}