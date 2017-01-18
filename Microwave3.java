/********************************************************************
Class:     CSCI 470-1
Program:   Assignment 4
Author:    Soukya Lokula
Z-number:  z1776873
Date Due:  11/16/2016

Purpose:   GUI for microwave

*********************************************************************/
package hw4;

import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;
/**
 *
 * @author Soukya
 */
public class Microwave3 extends Microwave implements ActionListener,SwingConstants
{
        
        protected JFrame frame3;
        protected JPanel buttonPanel;
        protected JPanel southPanel;
        protected JPanel southLeftPanel;
        protected JPanel centerPanel;
        protected JLabel powerLabel;
        protected JLabel minsLabel;
        protected JLabel secsLabel;
        protected final JLabel timerLbl;
        protected final JLabel powerLbl;
        protected final JRadioButton checkMins;
        protected final JRadioButton checkSecs;
        protected final ButtonGroup radioButton;
        protected final JButton increment;
        protected final JButton decrement;
        protected boolean minsSelected;
        protected boolean secsSelected;
        protected static int microwaveCount3 = 0;         //variable to count the microwave3 instances
        public Microwave3()
        {
            frame3 = new JFrame();           //creating the frame object
            frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame3.setLayout(new BorderLayout());
            microwaveCount3++;
            //creating the panels
            
            buttonPanel = new JPanel();
            southPanel = new JPanel();
            southLeftPanel = new JPanel();
            centerPanel = new JPanel();
            
            //setting the panel layout
            buttonPanel.setLayout(new FlowLayout());
            southPanel.setLayout(new GridLayout(1,3));
            southLeftPanel.setLayout(new FlowLayout());
            centerPanel.setLayout(new GridLayout(1,3));
            
            timerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));       //setting the border
            
            //creating the radio buttons
            checkMins = new JRadioButton("Minutes");
            checkSecs = new JRadioButton("Seconds");
            radioButton = new ButtonGroup();        //grouping the two radio buttons
            
            //adding them to the group
            radioButton.add(checkMins);
            radioButton.add(checkSecs);
            
            //creating the JButtons
            increment= new JButton("+");
            decrement = new JButton("-");
            
            //creating the labels
            minsLabel = new JLabel("00",SwingConstants.LEFT);
            secsLabel = new JLabel("00",SwingConstants.RIGHT);
            powerLabel = new JLabel("100",SwingConstants.CENTER);
            powerLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)); 
            timerLbl = new JLabel("Timer(MM:SS)",SwingConstants.CENTER);
            powerLbl = new JLabel("Power(%)",SwingConstants.CENTER);
            
            //adding the components to the panels
            label1.add(new JLabel());
            label1.add(timerLbl);
            label1.add(powerLbl);
            
            centerPanel.add(resetButton);
            timerPanel.add(minsLabel);
            timerPanel.add(colon);
            timerPanel.add(secsLabel);
            
            timerPanel.setBackground(Color.LIGHT_GRAY);
            centerPanel.add(timerPanel);
            centerPanel.add(powerLabel);
            
            buttonPanel.add(checkMins);
            buttonPanel.add(increment);
            buttonPanel.add(checkSecs);
            southPanel.add(new JLabel());
            southPanel.add(buttonPanel);
            southLeftPanel.add(decrement);
            southPanel.add(southLeftPanel);
            
            
            //adding panels to the frame
            frame3.add(centerPanel, BorderLayout.CENTER); 
            frame3.add(label1, BorderLayout.NORTH);
            frame3.add(southPanel,BorderLayout.SOUTH);
            frame3.setTitle("Microwave Type 3");
            
            //action listener for the radio buttons
            TimerRadioButtonListener handler = new TimerRadioButtonListener();
            
            //catching the radio events
            checkMins.addItemListener(handler); 
            checkSecs.addItemListener(handler);
            
            //catching the button events
            increment.addActionListener(this);
            decrement.addActionListener(this);
            resetButton.addActionListener(this);
            
            WindowActions windowHandler = new WindowActions();   //Create an object to handler window action events.
            frame3.addWindowListener(windowHandler);
            
            frame3.pack();
            
            
            frame3.setVisible(true);
            
            
        }
        
        
        /*****
         * TimerRadioButtonListener for catching the item events
         * Overrides the method itemStateChanged
         */
        
        private class TimerRadioButtonListener implements ItemListener
        { //To catch the events from radio buttons.
        
            @Override
            public void itemStateChanged(ItemEvent event){
                minsSelected = checkMins.isSelected();
                secsSelected = checkSecs.isSelected();
            }
        }
        
        
        
            /*****
             * Overriding the reset method of CookingFunctions
             * Purpose-To set the fields back to default values
             */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource() == increment)
                {
                    int minsInt = 0, secsInt = 0;
                    //storing the value in strings
                    String minutes = minsLabel.getText();
                    String seconds = secsLabel.getText();
                    
                    //converting to int
                    minsInt = Integer.parseInt(minutes);
                    if(minsSelected)        //condition to check which radio is selected
                    {
                        minsInt+=1; 
                        minsInt%=60;
                    }
                    secsInt=Integer.parseInt(seconds);
                    if(secsSelected)
                    {
                        secsInt+=1; 
                        secsInt%=60;
                    }    
                    minutes = String.valueOf(minsInt);
                    if(minutes.length() > 1) minsLabel.setText(minutes); 
                    else minsLabel.setText("0"+minutes);
                    seconds = String.valueOf(secsInt);
                    if(seconds.length() > 1) secsLabel.setText(seconds);
                    else secsLabel.setText("0"+seconds);
                }
                
                else if(event.getSource() == decrement)
                {
                    int powerInt = 0;
                    String power = powerLabel.getText();
                    
                    powerInt = Integer.parseInt(power);
                    
                    if(powerInt>0)
                        powerInt-=10;
                    else if(powerInt==0)
                        powerInt = 100;
                    
                    power = String.valueOf(powerInt);
                    powerLabel.setText(power);
                    
                }
                else if(event.getSource() == resetButton)
                {
                    reset();
                }
            }
            
            
            /*****
             * Overriding the reset method of CookingFunctions
             * Purpose-To set the fields back to default values
             */
            @Override
            public void reset()
            {
                //setting to initial values
                minsLabel.setText("00");
                secsLabel.setText("00");
                powerLabel.setText("100");
                
            }
            
            private class WindowActions extends WindowAdapter{
                @Override
                public void windowClosing(WindowEvent e) {
                microwaveCount3--;          //If a microwave is closed, decrement the count.
                }
            }
}
    

