package queue_interfaces_problems;

import java.util.*;

public class BinaryNumbersGenerator {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Initialize queue with "1"

        for (int i = 0; i < N; i++) {
            String front = queue.poll(); // Dequeue front element
            result.add(front); // Add it to result list

            queue.add(front + "0"); // Enqueue next binary numbers
            queue.add(front + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(generateBinaryNumbers(N)); // Output: [1, 10, 11, 100, 101]
    }
}
