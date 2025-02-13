package set_interfaces_problems;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Creating a HashSet with unsorted elements
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert to a List
        List<Integer> sortedList = new ArrayList<>(set);

        // Sort the List in ascending order
        Collections.sort(sortedList);

        // Print the sorted list
        System.out.println(sortedList); // Output: [1, 3, 5, 9]
    }
}
