/********************************************************************
Class:     CSCI 470-1
Program:   Assignment 4
Author:    Soukya Lokula
Z-number:  z1776873
Date Due:  11/16/2016

Purpose:   GUI for microwave

*********************************************************************/
package hw4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Soukya
 */
public abstract class Microwave implements CookingFunctions {
    
    //declaring the components
    protected JFrame frame;
    protected final JButton resetButton;
    protected final JLabel colon;
    protected JPanel timerPanel;
    protected JPanel label1;
    
    
    /************
     * Default constructor
     ************/
    public Microwave()
    {
        resetButton = new JButton("RESET");     //creating a reset button
        resetButton.setForeground(Color.RED);
        frame = new JFrame();       
        
        //creating the panels
        timerPanel = new JPanel();
        label1 = new JPanel();
        //setting the layouts for the panel
        timerPanel.setLayout(new FlowLayout());
        label1.setLayout(new GridLayout(1,3));
        
        colon = new JLabel(":"); 
    }
    
    
    
}
