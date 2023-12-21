import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class SortingUI{

    

    public static void main(String[]args){

        // Create a JPanel
        JFrame frame;
        frame = new JFrame("sorting");

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        ArrayList<Integer> list =  new ArrayList<Integer>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));


        Sorting sorting1 = new Sorting();
        Sorting sorting2 = new Sorting();

        sorting1.addValuesToList(list);sorting2.addValuesToList(list);

        // Add the JPanel to the JFrame
        frame.getContentPane().add(sorting1);
        frame.getContentPane().add(sorting2);
        // Make the JFrame visible
        frame.setVisible(true);



    }



    

}
