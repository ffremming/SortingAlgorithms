package SortingAlgorithms.Sorters.sorters;

import SortingAlgorithms.Sorters.Sorting;
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

        for (int i = 0;i<size-1;i++){
            value = Collections.min(list.subList(i,size));
            index = list.indexOf(value);
           // firstValue = list.get(i);


            //list.set(i,value);
            //list.set(index,firstValue);
            if (i!=index){
                Collections.swap(list,i,index);
            }
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                
                System.out.println("the thread is sleeping");
            }
        }
        System.out.println(list);
        System.out.println("selection sort completed");
    }
    
}
