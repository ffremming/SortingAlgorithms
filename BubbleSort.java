public class BubbleSort extends Sorting{

    public BubbleSort(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    void sort() {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j+1)) {
                    // Swap arr[j] and arr[j+1]
                    int temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(temp,list.get(j + 1));

                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
}
