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
    int duration = 100;

    
    /**
     * base sorter, all sorters should inherit from this and implement own sorting alg
     */
    public Sorter(Sorting motherPanel){
        this.panel = motherPanel;
        this.list = motherPanel.list;
    }
}
