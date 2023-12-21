import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.awt.*;

import javax.swing.JPanel;

public class Sorting extends JPanel{
    ArrayList<Integer> list;
    Sorter sorter;
    public Sorting(){
        
        list = new ArrayList<Integer>();
        setSize(150,100);
    }
    public void addValuesToList(ArrayList<Integer> additionalList){
        list.addAll( additionalList);
    }

    public void addSorter(Sorter sorter){
        this.sorter = sorter;
    }
    public void sort(){
        //TODO
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pos = 10;
        for (Integer value :list){

            double minValue = 0.0;
            double maxValue = 100.0;
            double yValue =  (value*100/ Collections.max(list)*100)/100;

            // -(value*100/ Collections.max(list)*100)/40
            
            double colValue = yValue *2.55;
            Color color = mapValueToColor(yValue);

            Color color2=  Color.getHSBColor(50,(int)colValue,50);
            System.out.println(colValue);
            g.setColor(color);
            g.fillRect(pos, (int)(getHeight()-yValue), 5, (int)yValue);
            pos += 5;
        }
    }
    public Color mapValueToColor(double value) {
        // Ensure the value is within the valid range
        value = Math.max(0.0, Math.min(100.0, value));

        // Map the value to a hue in the range [0.0, 1.0]
        float hue = (float) (value / 100.0);

        // Use the hue to create a color with full saturation and brightness
        return Color.getHSBColor(hue, 1.0f, 1.0f);
    }

    


}
