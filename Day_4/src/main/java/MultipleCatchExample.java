import java.util.Scanner;

public class MultipleCatchExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // User input for array size and index
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            System.out.print("Enter index to retrieve value: ");
            int index = scanner.nextInt();

            // Retrieving value at given index
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
