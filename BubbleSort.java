public class BubbleSort extends Sorter{

    public BubbleSort(Sorting motherPanel) {
        super(motherPanel);
        //TODO Auto-generated constructor stub
    }

    @Override
    public synchronized void run() {
        System.out.println(list);
        int n = list.size();
        
        
        int temp = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < (n -i-1); j++) {
               
                    
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (list.get(j) > list.get(j+1)) {
                    temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set((j+1), temp);
                }
            }
        }
        System.out.println("completed sorting");
        
        System.out.println(list);
    }
    
}
