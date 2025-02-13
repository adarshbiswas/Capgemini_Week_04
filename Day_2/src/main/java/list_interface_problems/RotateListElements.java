package list_interface_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateListElements {
    public static void rotate(List<Integer> list ,int index){
        if (list == null || list.isEmpty() || index % list.size() == 0) {
            return; // No rotation needed
        }
        index = index % list.size();
        for (int i = 0; i < index; i++) {
            int temp = list.remove(0);
            list.add(temp);
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,2,6,7,3,3));
        rotate(list,2);
        System.out.println(list);


    }
}
