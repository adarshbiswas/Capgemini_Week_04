package CustomObjectManager;

import java.lang.reflect.*;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class CustomObject {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(instance, fieldValue);
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found: " + fieldName);
            }
        }

        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = Map.of(
                "name", "John",
                "age", 30
        );

        Person person = toObject(Person.class, properties);
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
    }
}

