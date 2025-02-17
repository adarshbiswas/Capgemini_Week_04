package reflection.Basic.AccessPrivateField;

import java.lang.reflect.*;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class PrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person(25);

        // Access the private field 'age' using reflection
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true); // Set accessible to true to access private field

        // Retrieve the current value of 'age'
        int ageValue = (int) field.get(person);
        System.out.println("Initial Age: " + ageValue);

        // Modify the value of 'age'
        field.set(person, 30);
        ageValue = (int) field.get(person);
        System.out.println("Updated Age: " + ageValue);
    }
}
