package SortingAlgorithms.Sorters.sorters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

import SortingAlgorithms.Sorters.Sorting;

public abstract class Sorter implements Runnable{
    ArrayList<Integer> list;
    Sorting panel;
    

    
    /**
     * base sorter, all sorters should inherit from this and implement own sorting alg
     */
    public Sorter(Sorting motherPanel){
        this.panel = motherPanel;
        this.list = motherPanel.list;
    }

    protected int getSortingSpeedNanos(){
        return panel.nanos;
    }
    protected int getSortingSpeedMillis(){
        return panel.millis;
    }
    protected void sleep(){
        try {
            
            Thread.sleep(getSortingSpeedMillis(),getSortingSpeedNanos());
        } catch (InterruptedException e) {
            
            System.out.println("the thread is sleeping");
        }
    }

}
