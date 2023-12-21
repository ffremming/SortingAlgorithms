import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Sorting extends JPanel implements Runnable{
    ArrayList<Integer> list;
    
    String name;
    public Sorting(String name){
        setSize(150,100);
        this.name = name;
        add(new JLabel(name));
        list = new ArrayList<Integer>();
        
    }
    public void addValuesToList(ArrayList<Integer> additionalList){
        list.addAll( additionalList);
    }

    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pos = 10;
        int width = getWidth()/list.size();
        for (Integer value :list){

            double minValue = 0.0;
            double maxValue = 100.0;
            double yValue =  (value*(getHeight()*2/3)/ Collections.max(list)*100)/100;

            // -(value*100/ Collections.max(list)*100)/40
            
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
        float hue = (float) (value / 125.0);

        // Use the hue to create a color with full saturation and brightness
        return Color.getHSBColor(hue/6, 1.0f, 1.0f);
    }
    @Override
    public void run() {
        sort();
    }

    abstract void sort();

    @Override
    public String toString(){
        return "Sorting";
    }
}
