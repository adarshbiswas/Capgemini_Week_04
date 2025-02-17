package reflection.Basic.InvokePrivateMethod;

import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokeMethod {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();

        // Access the private method 'multiply' using reflection
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true); // Set accessible to true to invoke private method

        // Invoke the private method and display the result
        int result = (int) method.invoke(calculator, 5, 10);
        System.out.println("Multiplication Result: " + result);
    }
}

