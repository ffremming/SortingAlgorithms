package SortingAlgorithms.Sorters.sorters;

import java.util.Collection;
import java.util.Collections;

import SortingAlgorithms.Sorters.Sorting;

public class InsertionSort extends Sorter {

    public InsertionSort(Sorting motherPanel) {
        super(motherPanel);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        for (int i = 0;i<list.size();i++ ){
            int value = list.get(i);
            
            //if there is next value
            if (i+1<(list.size())){

                int nextValue = list.get(i+1);

                //if next value is greater than value
                if (value<nextValue){
                    //do nothing..? cahnge if so
                }
                //if value is larger, i dont care about alike.
                else if (value>nextValue){
                    swap(i);
                }
            }
        }
        System.out.println("insertion done, "+list);
    }
    

    private void swap(int index){
        sleep();
        Collections.swap(list,index,index+1);
        if (index != 0 &&list.get(index-1)>list.get(index)){
            swap(index-1);
        }
    
    }
}
