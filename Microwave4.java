/********************************************************************
Class:     CSCI 470-1
Program:   Assignment 4
Author:    Soukya Lokula
Z-number:  z1776873
Date Due:  11/16/2016

Purpose:   GUI for microwave

*********************************************************************/
package hw4;

//import statements
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import java.awt.Color;

/**
 *
 * @author Soukya
 */
public class Microwave4 extends Microwave3
{
    private final JButton decrementTimer;
    private final JButton incrementPower;
    protected static int microwaveCount4 = 0;             //variable to count the microwave4 instances
    
    /*****
     * default constructor
     */
    public Microwave4()
    {
        microwaveCount4++;
        //creating two new buttons
        incrementPower= new JButton("+");
        decrementTimer = new JButton("-");
        
        //adding to the panels
        buttonPanel.add(checkMins);
        buttonPanel.add(increment);
        buttonPanel.add(decrementTimer);
        buttonPanel.add(checkSecs);
        
        buttonPanel.setBackground(Color.ORANGE);
        southLeftPanel.add(incrementPower);
        southLeftPanel.add(decrement);
        
        
        Button4Action handler2 = new Button4Action();       //listener class 
        decrementTimer.addActionListener(handler2);         //catching the events
        incrementPower.addActionListener(handler2);
        
        WindowActions windowHandler = new WindowActions();   //handler for window action events.
        frame3.addWindowListener(windowHandler);
            
        //adding the panels to the frame
        frame3.add(centerPanel, BorderLayout.CENTER); 
        frame3.add(label1, BorderLayout.NORTH);
        frame3.add(southPanel,BorderLayout.SOUTH);
        frame3.setTitle("Microwave Type 4");
       
        
            
        frame3.pack();
        frame3.setVisible(true);
            
    }
    private class Button4Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
                if(event.getSource() == decrementTimer)         //button to decrement the timer
                {
                    int minsInt = 0, secsInt = 0;
                    String minutes = minsLabel.getText();           //stores the value in string
                    String seconds = secsLabel.getText();
                    
                    minsInt = Integer.parseInt(minutes);
                    if(minsSelected)                        //checks which radio is selected
                    {
                        if(minsInt>0)
                            minsInt-=1;
                        else if(minsInt==0)
                            minsInt=59;
                    }
                    secsInt=Integer.parseInt(seconds);
                    if(secsSelected)
                    {
                        if(secsInt>0)
                            secsInt-=1;
                        else if(secsInt == 0)
                            secsInt=59;
                    }    
                    minutes = String.valueOf(minsInt);
                    if(minutes.length() > 1) minsLabel.setText(minutes); 
                    else minsLabel.setText("0"+minutes);
                    seconds = String.valueOf(secsInt);
                    if(seconds.length() > 1) secsLabel.setText(seconds);
                    else secsLabel.setText("0"+seconds);
                }
                
                else if(event.getSource() == incrementPower)            //button to increment power
                {
                    int powerInt = 0;
                    String power = powerLabel.getText();
                    
                    powerInt = Integer.parseInt(power);
                    
                    
                        powerInt+=10;
                        
                        if(powerInt <100)
                            powerInt %= 100;
                        else if(powerInt == 110)
                            powerInt=0;
                    
                    power = String.valueOf(powerInt);
                    powerLabel.setText(power);          //setting the value to the label
                    
                }
            }
    }
    
    private class WindowActions extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            microwaveCount4--;           //If a microwave is closed, decrement the count.
        }
    }
}
