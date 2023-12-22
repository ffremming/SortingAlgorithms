package SortingAlgorithms.Sorters;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    
    public static void main(String []args){

        ArrayList<Integer> list = generateRandomList(15);
        System.out.println(sort(list));

    }
    private static  ArrayList<Integer> sort(ArrayList<Integer> list){
        System.out.println(list);
        int n = list.size();
        int temp = 0;
        for (int i = 0; i < n-i; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                if (list.get(j) > list.get(j+1)) {
                    temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set((j+1), temp);
                }
            }
        }
        return list;
    }



    static ArrayList<Integer> generateRandomList(int size) {
        ArrayList<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(100); // Generates a random integer
            randomList.add(randomNumber);
        }

        return randomList;
    }
}
