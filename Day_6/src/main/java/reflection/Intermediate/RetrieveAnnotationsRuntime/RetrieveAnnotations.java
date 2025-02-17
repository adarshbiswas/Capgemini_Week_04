package reflection.Intermediate.RetrieveAnnotationsRuntime;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
    public void printDetails() {
        System.out.println("This is a book class.");
    }
}

public class RetrieveAnnotations {
    public static void main(String[] args) throws Exception {
        // Get the Book class
        Class<?> clazz = Book.class;

        // Check if the Author annotation is present on the class
        if (clazz.isAnnotationPresent(Author.class)) {
            // Retrieve the Author annotation
            Author authorAnnotation = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No Author annotation found.");
        }
    }
}









