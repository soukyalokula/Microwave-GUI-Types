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

//import static hw4.Microwave1.timerCount1;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;


/**
 *
 * @author Soukya
 */
public class Microwave2 extends Microwave implements ActionListener,SwingConstants,CookingFunctions
{
        //declaring the components
        private final JFrame frame2;
        private final JPanel resetPanel;
        private final JPanel powerPanel;
        private final JLabel timerLabel;
        private final JLabel powerLabel;
        JComboBox<Integer> minsCB;
        JComboBox<Integer> secondsCB;
        JComboBox<String> powerCB;
        protected static int microwaveCount2=0;         //variable to count the microwave2 instances
        
        
        /***
         * default constructor
         */
        public Microwave2()
        {
            frame2 = new JFrame();              //creating the frame object        
            frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame2.setLayout(new BorderLayout());
            microwaveCount2++;
            
            //creating the panels
            resetPanel = new JPanel();
            //timerPanel = new JPanel();
            powerPanel = new JPanel();
            //label1 = new JPanel();
            
            //setting the panel layout
            resetPanel.setLayout(new GridLayout(1,1));
            
            powerPanel.setLayout(new GridLayout(1,1));
            
            timerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));       //setting the border
            
            Integer[] numberList = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,
                                                  42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59};
            minsCB = new JComboBox<>(numberList);
            secondsCB = new JComboBox<>(numberList);
            minsCB.setMaximumRowCount(6);
            secondsCB.setMaximumRowCount(6);
            
            String[] powerValues = new String[] {"0%","10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"};
            powerCB = new JComboBox<>(powerValues);
            
            timerLabel = new JLabel("Timer (MM:SS)",SwingConstants.CENTER);
            timerLabel.setFont(new Font("Serif", Font.BOLD, 15));
            powerLabel = new JLabel("Power (%)",SwingConstants.RIGHT);
            powerLabel.setFont(new Font("Serif", Font.BOLD, 15));
           
            
            //adding the components to the panels
            resetPanel.add(resetButton);
            timerPanel.add(minsCB);
            timerPanel.add(colon);
            timerPanel.add(secondsCB);
            powerPanel.add(powerCB);
            label1.add(new JLabel());
            label1.add(timerLabel);
            label1.add(powerLabel);
            
            
            //adding the panels to the frame
            frame2.add(resetPanel, BorderLayout.WEST);
            frame2.add(timerPanel, BorderLayout.CENTER); 
            frame2.add(powerPanel, BorderLayout.EAST);
            frame2.add(label1, BorderLayout.NORTH);
            frame2.setTitle("Microwave Type 2");
            resetButton.addActionListener(this);
            
            WindowActions windowHandler = new WindowActions();   //handler for window action events.
            frame2.addWindowListener(windowHandler);
            
            
            
            //listeners for the combo boxes
            minsCB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    JComboBox cb = (JComboBox)event.getSource();
                    Integer selectedMin = (Integer)cb.getSelectedItem();
                }
            });
            
            
            
            secondsCB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    JComboBox cb = (JComboBox)event.getSource();
                    Integer selectedSec = (Integer)cb.getSelectedItem();
                }
            });
            powerCB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    JComboBox cb = (JComboBox)event.getSource();
                    String selectedPower = (String)cb.getSelectedItem();
                }
            });
            
            frame2.pack();
            frame2.setSize(500,120);
            frame2.setVisible(true);
            
        }
            
            /*****
             * Overriding the actionPerformed method
             * for the reset button
             *  
             */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource() == resetButton)
                reset();
            }
            
            
            /*****
             * Overriding the reset method of CookingFunctions
             * Purpose-To set the fields back to default values
             */
            @Override
            public void reset()
            {
                minsCB.setSelectedItem(0);
                secondsCB.setSelectedItem(0);
                powerCB.setSelectedItem("100%");
                
            }
            
            private class WindowActions extends WindowAdapter{
                @Override
                public void windowClosing(WindowEvent e) {
                microwaveCount2--;          //If a microwave is closed, decrement the count.
                }
            }
        
}
