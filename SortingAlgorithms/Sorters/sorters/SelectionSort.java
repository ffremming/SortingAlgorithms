package SortingAlgorithms.Sorters.sorters;

import SortingAlgorithms.Sorters.Sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort extends Sorter{

    public SelectionSort(Sorting motherPanel) {
        super(motherPanel);
        //TODO Auto-generated constructor stub
    }

    @Override
    public synchronized void run() {
        int value,index,firstValue,size;

        size = list.size();

        //selection phase
        for (int i = 0;i<size-1;i++){
            List<Integer> sublist = list.subList(i,size);
            int lowVal = 1000;int lowIndex = -1;
            for (index = 0;index<sublist.size();index++){
                sleep();
                if (sublist.get(index)< lowVal){
                    lowVal = sublist.get(index);
                    lowIndex = index;
                }
            }
            
            //swap phase
            Collections.swap(list,i,lowIndex+list.size()-sublist.size());
           
            
            //sleeping
            
            
        }
        System.out.println(list);
        System.out.println("selection sort completed");
    }
    
}
