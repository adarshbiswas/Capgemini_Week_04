package list_interface_problems;
import java.util.*;


public class FindElementInLinkedList {

        // Method to find the Nth element from the end
        public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
            Iterator<T> first = list.iterator();
            Iterator<T> second = list.iterator();

            // Move first pointer n steps ahead
            for (int i = 0; i < n; i++) {
                if (!first.hasNext()) {
                    throw new IllegalArgumentException("N is greater than the size of the list");
                }
                first.next();
            }

            // Move both pointers until first reaches the end
            while (first.hasNext()) {
                first.next();
                second.next();
            }

            return second.next();
        }

        public static void main(String[] args) {
            LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
            int n = 2;
            System.out.println("Nth element from end: " + findNthFromEnd(list, n)); // Output: D
        }
    }
