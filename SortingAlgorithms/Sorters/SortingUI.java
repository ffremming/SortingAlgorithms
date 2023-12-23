package SortingAlgorithms.Sorters;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import SortingAlgorithms.Sorters.*;
import SortingAlgorithms.Sorters.sorters.*;


public class SortingUI extends JFrame{

    Timer timer ;
    Content content;
    ArrayList<Thread> threads;
    int size = 50;
    

    public SortingUI(String name){
        JFrame frame;
        
        setLayout(new BorderLayout());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        threads = new ArrayList<>();
        content = new Content();
        Header header = new Header();
        add(header,BorderLayout.NORTH);
        add(new OptionPanel(),BorderLayout.WEST);
        add(content,BorderLayout.CENTER);
        
        
        // Make the JFrame visible
        setVisible(true);
        


        // Create a Timer with a 10-millisecond delay
        timer = new Timer(5, new ActionListener() {
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
                    if (threads.size()>0){
                        for (Thread threads:threads){
                        threads.interrupt();
                        }
                    }
                    

                    Thread bubble = new Thread( new BubbleSort((Sorting)content.getComponents()[0]));
                    Thread bucket = new Thread( new CountingSort((Sorting)content.getComponents()[1]));
                    Thread selection = new Thread (new SelectionSort((Sorting)content.getComponents()[2]));
                    Thread insertion = new Thread (new InsertionSort((Sorting)content.getComponents()[3]));
                    threads.clear();
                    threads.add(selection);
                    threads.add(bubble);
                    threads.add(bucket);
                    threads.add(insertion);


                    for (Thread threads:threads){
                        
                        threads.start();
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
            list = generateRandomList(size);


            Sorting sorting1 = new Sorting("Bubble sort");
            Sorting sorting2 = new Sorting("Counting sort");
            Sorting sorting3 = new Sorting("sorting 3");
            Sorting sorting4 = new Sorting("sorting 4");

            sorting1.addValuesToList(list);sorting2.addValuesToList(list);
            sorting3.addValuesToList(list);sorting4.addValuesToList(list);
            // Add the JPanel to the JFrame

            setLayout(new GridLayout(2,2));

            add(sorting1);
            add(sorting2);
            add(sorting3);
            add(sorting4);

            
            

            
        }

        public void shuffleLists(){
            for (Component panel :content.getComponents()){
                        ((Sorting)panel).list = generateRandomList(size);
            }
            revalidate();
            repaint();
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

    public class OptionPanel extends JPanel{

        public OptionPanel(){
            
            setLayout(new GridLayout(6,1));
            addSlider();
            addShuffleButton();
            addSizeSlider();
            
        }

        private void addSlider(){
            add(new JLabel("speed"));
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 30, 10);
            //slider.setMinorTickSpacing();
            //slider.setMajorTickSpacing();
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            

            // Add a change listener to the slider
            slider.addChangeListener((ChangeListener) new ChangeListener() {
                
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider) e.getSource();
                    double value = ((double)source.getValue());

                    int nanoVal = (int) Math.pow(2,value)-1;

                    for (Component panel :content.getComponents()){
                        if (nanoVal>999999){
                            int millisVal = nanoVal -999999;
                            //getting milisecond
                            ((Sorting)panel).millis = millisVal/1000000;
                            ((Sorting)panel).nanos = 999999;

                        } else{
                             ((Sorting)panel).nanos = nanoVal;
                        }
                       
                        

                        
                    }
                }
            });
            add(slider);
        }   

        private void addShuffleButton(){
            
            add(new JLabel("shuffle"));


            JButton shuffleButton = new JButton();
            shuffleButton.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    content.shuffleLists();
                }
            });
            add(shuffleButton);
        }
        

        private void addSizeSlider(){
            add(new JLabel("size"));
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 400, 50);
            slider.setMinorTickSpacing(25);
            slider.setMajorTickSpacing(100);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);

            // Add a change listener to the slider
            slider.addChangeListener((ChangeListener) new ChangeListener() {
                
                @Override
                public void stateChanged(ChangeEvent e) {
                    for (Thread thread:threads){
                        thread.stop();
                    }



                    JSlider source = (JSlider) e.getSource();
                    int value = source.getValue();
                    size = value;
                    content.shuffleLists();

                }
            });
            add(slider);
        }
        
    }

    
}
