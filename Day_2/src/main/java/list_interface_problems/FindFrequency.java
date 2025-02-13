package list_interface_problems;
import java.util.*;

public class FindFrequency {

        // Method to count the frequency of elements in a list
        public static Map<String, Integer> countFrequency(List<String> list) {
            Map<String, Integer> frequencyMap = new HashMap<>();
            for (String item : list) {
                // Increment count for each occurrence
                frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
            }
            return frequencyMap;
        }

        public static void main(String[] args) {
            // Sample input list
            List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");

            // Get frequency count
            Map<String, Integer> result = countFrequency(inputList);

            // Print the result
            System.out.println(result);
        }
    }


