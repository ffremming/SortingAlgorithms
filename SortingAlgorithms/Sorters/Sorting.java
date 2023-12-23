package SortingAlgorithms.Sorters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Sorting extends JPanel{
    public ArrayList<Integer> list;
    

    public int millis = 0;
    public int nanos = 50;
    
    String name;
    public Sorting(String name){
        setSize(150,100);
        this.name = name;
        add(new JLabel(name));
        list = new ArrayList<Integer>();
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        setBorder(blackline);
    }

    public void addValuesToList(ArrayList<Integer> additionalList){
        list.addAll( additionalList);
    }

    
    private ArrayList<Integer> getCopyOfList(){
    return  new ArrayList<Integer>(list);
    }

    @Override
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);

       
        int pos = 0;
        ArrayList<Integer> copy = getCopyOfList();
        int width = getWidth()/(copy.size()+0);
        for (Integer value :copy){

            double yValue = 0;
            double minValue = 0.0;
            double maxValue = 100.0;
            try{
                yValue =  (value*(getHeight()*2/3)/ Collections.max(copy)*100)/100;
            }
            catch (ArithmeticException e){
                
            }
            

            
            
            double colValue = yValue *2.55;
            Color color = mapValueToColor(yValue);

            Color color2=  Color.getHSBColor(50,(int)colValue,50);
           
            g.setColor(color);
            g.fillRect(pos, (int)(getHeight()-yValue), width, (int)yValue);
            pos += width;
            
        }
    }
    public Color mapValueToColor(double value) {
        // Ensure the value is within the valid range
        value = Math.max(0.0, Math.min(100.0, value));

        // Map the value to a hue in the range [0.0, 1.0]
        float hue = (float) (value / 750.0);

        // Use the hue to create a color with full saturation and brightness
        return Color.getHSBColor(hue, 1, 1);
    }
    

    

    @Override
    public String toString(){
        return "Sorting";
    }
}
