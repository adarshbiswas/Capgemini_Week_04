package map_interfaces_problems;

import java.util.*;

public class MapMerger {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1); // Start with map1

        // Iterate through map2 and merge values
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // If key exists, sum the values; otherwise, add new key-value pair
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        // Initialize first map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Initialize second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge maps and print result
        Map<String, Integer> result = mergeMaps(map1, map2);
        System.out.println(result); // Output: {A=1, B=5, C=4}
    }
}
