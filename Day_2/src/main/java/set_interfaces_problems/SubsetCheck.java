package set_interfaces_problems;

import java.util.*;

public class SubsetCheck {
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Check if set1 is a subset of set2
        boolean isSubset = set2.containsAll(set1);

        // Print the result
        System.out.println(isSubset); // Output: true
    }
}
