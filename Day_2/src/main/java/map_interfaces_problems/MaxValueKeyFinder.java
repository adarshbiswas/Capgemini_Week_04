package map_interfaces_problems;

import java.util.*;

public class MaxValueKeyFinder {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty())
            return null; // Handle empty map case

        // Find the entry with the maximum value and return its key
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String maxKey = findMaxKey(map); // Find key with the highest value
        System.out.println(maxKey); // Output: B
    }
}
