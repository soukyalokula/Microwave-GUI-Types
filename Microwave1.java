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
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Container;
/**
 *
 * @author Soukya
 */
public class Microwave1 extends Microwave implements ActionListener,SwingConstants,CookingFunctions
{
    //declaring the components
    private JFrame frame1;
    private JTextField timerMin;
    private JTextField timerSec;
    private JTextField power;
    private JPanel resetPanel;
    private JPanel powerPanel;
    private JLabel timerLabel;
    private JLabel powerLabel;
    protected static int microwaveCount1=0;     //variable to count the microwave1 instances
        
    
    /*
    default constructor
    */
    public Microwave1()     //constructor
        {
            //creating the frame and setting the default operations
            frame1 = new JFrame();
            frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame1.setLayout(new BorderLayout());
            microwaveCount1++;      //to keep track of number of objects
            
            //creating the panels
            resetPanel = new JPanel();
            powerPanel = new JPanel();
            
            
            //setting the panel layout
            resetPanel.setLayout(new GridLayout(1,1));
            powerPanel.setLayout(new GridLayout(1,1));
            
            timerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));       //setting the border
            //creating the textfields
            timerMin = new JTextField("00",5);
            timerSec = new JTextField("00",5);
            power = new JTextField("100",5);
            
            //creating the labels
            timerLabel = new JLabel("Timer (MM:SS)",SwingConstants.CENTER);
            powerLabel = new JLabel("Power (%)",SwingConstants.RIGHT);
           
        
            //adding the components to the panels
            resetPanel.add(resetButton);
            timerPanel.add(timerMin);
            timerPanel.add(colon);
            timerPanel.add(timerSec);
            timerPanel.add(timerLabel);
            powerPanel.add(power);
            label1.add(new JLabel());
            label1.add(timerLabel);
            label1.add(powerLabel);
            label1.setBackground(Color.LIGHT_GRAY);
            
            
            //adding the panels to the frame
            frame1.add(resetPanel, BorderLayout.WEST);
            frame1.add(timerPanel, BorderLayout.CENTER); 
            frame1.add(powerPanel, BorderLayout.EAST);
            frame1.add(label1, BorderLayout.SOUTH);
            frame1.setTitle("Microwave Type 1");
            
            //event listener for catching the events
            timerMin.addActionListener(this);
            timerSec.addActionListener(this);
            power.addActionListener(this);
            resetButton.addActionListener(this);
            
            WindowActions windowHandler = new WindowActions();   //handler for window action events.
            frame1.addWindowListener(windowHandler);
            
            
            frame1.pack();
            frame1.setSize(500,120);
            frame1.setVisible(true);
            
        }
            
    
    /****************
     * Overriding the actionPerformed method
     * for the textFields to perform validation
     *  
     */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String string = "";
                int temp;
                
                if(event.getSource() == timerMin)
                {
                    string = event.getActionCommand();      //to get the text from the textfield
                    temp = Integer.parseInt(string);        //converting it to an integer
                    if(temp<0 || temp>60)
                    {
                        JOptionPane.showMessageDialog(null,"Minutes cannot be "+temp,"Error",JOptionPane.PLAIN_MESSAGE);        //displays the error message
                        timerMin.setText("");
                    }
              
                }
                else if(event.getSource() == timerSec)
                {
                    string = event.getActionCommand();          //to get the text from the textfield
                    temp = Integer.parseInt(string);            //converting it to an integer
                    if(temp<0 || temp>60)
                    {
                        JOptionPane.showMessageDialog(null,"Seconds cannot be "+temp,"Error",JOptionPane.PLAIN_MESSAGE);        //displays the error message
                        timerSec.setText("");
                    }
                }
                else if(event.getSource() == power)
                {
                    string = event.getActionCommand();          //to get the text from the textfield
                    temp = Integer.parseInt(string);            //converting it to an integer
                    if(temp%10 !=0 || temp>100)
                    {
                        JOptionPane.showMessageDialog(null,"Power cannot be "+temp,"Error",JOptionPane.PLAIN_MESSAGE);          //displays the error message
                        power.setText("");
                    }
                }
                else if(event.getSource() == resetButton)
                {
                    reset();            //calls the reset method
                }
                
                    
            }
            
            
            /*****
             * Overriding the reset method of CookingFunctions
             * Purpose-To set the text field back to default values
             */
            @Override
            public void reset()
            {
                timerMin.setText("00");
                timerSec.setText("00");
                power.setText("100");
                
            }
            
            private class WindowActions extends WindowAdapter{
                @Override
                public void windowClosing(WindowEvent e) {
                microwaveCount1--;           //If a microwave is closed, decrement the count.
                }
            }
}
