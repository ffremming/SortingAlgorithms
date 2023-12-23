package SortingAlgorithms.Sorters.sorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import SortingAlgorithms.Sorters.Sorting;

public class CountingSort extends Sorter {
    
    public CountingSort(Sorting motherPanel) {
        super(motherPanel);
        
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        int size = list.size();

        // Find the highest and lowest values in the list
        int highest = Collections.max(list);
        int lowest = Collections.min(list);

        // Adjust the range if there are negative numbers
        int range = highest - lowest + 1;

        ArrayList<Integer> newList = new ArrayList<>();
        int[] amounts = new int[range];

        for (int num : list) {
            // Increment, considering the offset for negative numbers
            
            sleep();
            
            amounts[num - lowest]++;
        }

        for (int i = 0; i < range; i++) {
            for (int j = 0; j < amounts[i]; j++) {
                // Reconstruct the sorted list
                newList.add(i + lowest);
            }
        }

        panel.list = newList;
        System.out.println(panel.list);
    }
    
}
