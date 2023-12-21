import java.util.Collections;
import java.util.HashMap;

public class CountingSort extends Sorter {

    public CountingSort(Sorting motherPanel) {
        super(motherPanel);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        int size = list.size();
        int highest = Collections.max(list);
        int lowest = Collections.min(list);
        int[]amounts = new int[highest-lowest];

        

        for (int num : list) {
            //increment
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            amounts[num]++;
        }
        int index = 0;
        for (int value:amounts){
            list.set(index,value);
            index ++;
        }
    }
    
}
