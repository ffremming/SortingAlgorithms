import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;

public class SortingUI extends JFrame{

    Timer timer ;
    Content content;

    public SortingUI(String name){
        JFrame frame;
        
        setLayout(new BorderLayout());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        content = new Content();
        Header header = new Header();
        add(header,BorderLayout.NORTH);
        add(content,BorderLayout.CENTER);
        
        // Make the JFrame visible
        setVisible(true);


        // Create a Timer with a 10-millisecond delay
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed every 10 milliseconds
                // You can put your drawing or update logic here

                
                // Repaint the JFrame
                revalidate();
                repaint();
            }
        });

        // Start the Timer
        

    }

    public static void main(String[]args){
        SortingUI frame = new SortingUI("sorting");
    }

    public class Header extends JPanel{

        public Header(){
            setSize(getWidth(),50);
           JButton activateButton = new JButton("start sorting");

            activateButton.addActionListener(new ActionListener() {
                

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Component sortingPanel:content.getRootPane().getComponents()){
                        System.out.println((sortingPanel.toString()) );
                        if (sortingPanel instanceof Sorting){
                            ((Sorting) sortingPanel).run();
                        }

                        if (sortingPanel instanceof Sorting) {
                            ((Sorting) sortingPanel).run();
                        }

                        System.out.println(sortingPanel);
                        
                        
                        
                    }
                    timer.start();

                }
            });
            add(activateButton);

        }
    }

    public class Content extends JPanel{
        public Content(){
            ArrayList<Integer> list =  new ArrayList<Integer>();
            list = generateRandomList(100);


            Sorting sorting1 = new BubbleSort("sorting 1");
            Sorting sorting2 = new BubbleSort("sorting 2");
            Sorting sorting3 = new BubbleSort("sorting 3");
            Sorting sorting4 = new BubbleSort("sorting 4");

            sorting1.addValuesToList(list);sorting2.addValuesToList(list);
            sorting3.addValuesToList(list);sorting4.addValuesToList(list);
            // Add the JPanel to the JFrame

            setLayout(new GridLayout(2,2));

            add(sorting1);
            add(sorting2);
            add(sorting3);
            add(sorting4);

            
        }
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
