package queue_interfaces_problems;

import java.util.*;

public class ReverseQueueRecursive {
    // Generic method to reverse any queue using recursion
    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) {
            return; // Base case: Stop when the queue is empty
        }

        // Step 1: Remove the front element
        T front = queue.remove();

        // Step 2: Recursively reverse the remaining queue
        reverseQueue(queue);

        // Step 3: Add the removed element back to the queue (at the rear)
        queue.add(front);
    }

    public static void main(String[] args) {
        // Example with Integers
        Queue<Integer> intQueue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Integer Queue: " + intQueue);
        reverseQueue(intQueue);
        System.out.println("Reversed Integer Queue: " + intQueue);

        // Example with Strings
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList("A", "B", "C"));
        System.out.println("\nOriginal String Queue: " + stringQueue);
        reverseQueue(stringQueue);
        System.out.println("Reversed String Queue: " + stringQueue);
    }
}
