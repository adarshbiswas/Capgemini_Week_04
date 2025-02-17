package reflection.Basic.DynamicallyCreateObjects;

import java.lang.reflect.*;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicallyObjects {
    public static void main(String[] args) throws Exception {
        // Create an instance of the Student class dynamically using reflection
        Class<?> clazz = Class.forName("Student");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Object student = constructor.newInstance("John Doe");

        // Call the display method to show the name
        Method displayMethod = clazz.getMethod("display");
        displayMethod.invoke(student);
    }
}














