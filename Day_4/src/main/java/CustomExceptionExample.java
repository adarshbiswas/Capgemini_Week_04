import java.util.Scanner;

// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
