package reflection.Intermediate.DynamicMeethodInvocation;

import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethod {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperations = new MathOperations();

        // Get method name from user
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Get the method dynamically using Reflection
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

        // Invoke the method and display the result
        int result = (int) method.invoke(mathOperations, num1, num2);
        System.out.println("Result: " + result);
    }
}


