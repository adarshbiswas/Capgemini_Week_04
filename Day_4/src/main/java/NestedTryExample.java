import java.util.Scanner;

public class NestedTryExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[] arr = {10, 20, 30};

            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            try {
                int value = arr[index] / divisor;
                System.out.println("Result: " + value);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
