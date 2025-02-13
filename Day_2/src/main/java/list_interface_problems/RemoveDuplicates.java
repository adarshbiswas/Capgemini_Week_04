package list_interface_problems;
import java.util.*;


    public class RemoveDuplicates {
        // Method to remove duplicates while preserving order
        public static <T> List<T> removeDuplicates(List<T> list) {
            Set<T> seen = new HashSet<>();
            List<T> result = new ArrayList<>();

            for (T item : list) {
                if (seen.add(item)) { // Only add if it's not already in the set
                    result.add(item);
                }
            }
            return result;
        }

        public static void main(String[] args) {
            List<Integer> inputList = Arrays.asList(3, 1, 2, 2, 3, 4);
            List<Integer> outputList = removeDuplicates(inputList);
            System.out.println(outputList); // Output: [3, 1, 2, 4]
        }
    }
