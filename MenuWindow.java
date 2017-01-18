/********************************************************************
Class:     CSCI 470-1
Program:   Assignment 4
Author:    Soukya Lokula
Z-number:  z1776873
Date Due:  11/16/2016

Purpose:   GUI for microwave

*********************************************************************/
package hw4;
//import statements required
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
/**
 *
 * @author Soukya
 */
public class MenuWindow
{
    
    //declaring the components
    private final JMenuBar menuBar;
    private final JMenuItem microwaveItem1;
    private final JMenuItem microwaveItem2;
    private final JMenuItem microwaveItem3;
    private final JMenuItem microwaveItem4;
    private final JMenuItem resetAllItem;
    private final JMenuItem authorItem;
    private final JMenu createMenu;
    private final JMenu resetAllMenu;
    private final JMenu aboutUsMenu;
    protected static final int COUNT_TOTAL=2;         //Max clocks for each kind.
    protected final ArrayList<Microwave> microwaveArray;

    
    /*****
     * default constructor
     */
    public MenuWindow()
    {
        //creating the menuFrame
        JFrame menuFrame = new JFrame();
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BorderLayout());
        
        //creating an arraylist to store the microwave objects
        microwaveArray = new ArrayList<>();
        
        menuBar = new JMenuBar();           //creating the menubar
        
        //creating the menus options
        createMenu = new JMenu("Create");
        createMenu.setMnemonic('C');
        resetAllMenu = new JMenu("Reset All");
        resetAllMenu.setMnemonic('R');
        aboutUsMenu = new JMenu("About Us");
        aboutUsMenu.setMnemonic('A');
        
        //crating the menu items
        microwaveItem1 = new JMenuItem("Microwave with text fields");
        microwaveItem1.setMnemonic('1');
        
        microwaveItem2 = new JMenuItem("Microwave with combo box");
        microwaveItem2.setMnemonic('2');
        microwaveItem3 = new JMenuItem("Microwave with radio buttons/buttons");
        microwaveItem3.setMnemonic('3');
        microwaveItem4 = new JMenuItem("Microwave with radio buttons and +/- buttons");
        microwaveItem4.setMnemonic('4');
        
        resetAllItem = new JMenuItem("Reset All the Microwaves");
        authorItem = new JMenuItem("Soukya Lokula");
        
        //adding the menu items to the menu options
        createMenu.add(microwaveItem1);
        createMenu.add(microwaveItem2);
        createMenu.add(microwaveItem3);
        createMenu.add(microwaveItem4);
        
        resetAllMenu.add(resetAllItem);
        aboutUsMenu.add(authorItem);
        
        //adding the menu options to the menubar
        menuBar.add(createMenu);
        menuBar.add(resetAllMenu);
        menuBar.add(aboutUsMenu);
        
        
        JLabel Title = new JLabel("WELCOME",SwingConstants.CENTER);
        Title.setFont(new Font("Serif", Font.BOLD, 60));
        
        //adding the menubar to the frame
        menuFrame.setJMenuBar(menuBar);
        menuFrame.add(Title, BorderLayout.CENTER);
        menuFrame.pack();
        menuFrame.setSize(600,320);
        menuFrame.setVisible(true);
        
        
        //listener to catch the action events
        MenuItemHandler handler = new MenuItemHandler();
        microwaveItem1.addActionListener(handler);
        microwaveItem2.addActionListener(handler);
        microwaveItem3.addActionListener(handler);
        microwaveItem4.addActionListener(handler);
        resetAllItem.addActionListener(handler);
        aboutUsMenu.addActionListener(handler);
        
    }
    
    /*********
     * MenuItemHandler class for the menu items
     * It overrides the actionPerformed method
     */
    private class MenuItemHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == microwaveItem1){   
                if(Microwave1.microwaveCount1 == COUNT_TOTAL){
                    JOptionPane.showMessageDialog(null,"Cannot create any more Microwaves of type 1","Error Message",JOptionPane.PLAIN_MESSAGE);        //displays a modal dialog
                }
                else
                {
                    Microwave1 m1= new Microwave1();
                    microwaveArray.add(m1);    //adding to the arraylist
                }
            }
            
            else if(event.getSource() == microwaveItem2){   
                if(Microwave2.microwaveCount2 == COUNT_TOTAL){
                    JOptionPane.showMessageDialog(null,"Cannot create any more Microwaves of type 2","Error Message",JOptionPane.PLAIN_MESSAGE);        //modal dialog
                }
                else
                {
                    Microwave2 m2= new Microwave2();
                    microwaveArray.add(m2);         //adding to the arraylist
                }
            }
            if(event.getSource() == microwaveItem3){   //Get the source and implement the appropriate action.
                if(Microwave3.microwaveCount3 == COUNT_TOTAL){
                    JOptionPane.showMessageDialog(null,"Cannot create any more Microwaves of type 3","Error Message",JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    Microwave3 m3= new Microwave3();
                    microwaveArray.add(m3);    
                }
            }
            if(event.getSource() == microwaveItem4){   //Get the source and implement the appropriate action.
                if(Microwave4.microwaveCount4 == COUNT_TOTAL){
                    JOptionPane.showMessageDialog(null,"Cannot create any more Microwaves of type 4","Error Message",JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    Microwave4 m4= new Microwave4();
                    microwaveArray.add(m4);    
                }
            }
            if(event.getSource() == resetAllItem)
            {
              //for loop to go through each microwave object
                for(Microwave mv: microwaveArray)
                {
                    
                    //calling the respective reset method.
                    if(mv instanceof Microwave1)
                    {
                        Microwave1 mv1 = (Microwave1)mv;
                        mv1.reset();
                    }
                    else if(mv instanceof Microwave2)
                    {
                        Microwave2 mv1 = (Microwave2)mv;
                        mv1.reset();
                    }
                    else if(mv instanceof Microwave3)
                    {
                        Microwave3 mv1 = (Microwave3)mv;
                        mv1.reset();
                    }
                    else if(mv instanceof Microwave4)
                    {
                        Microwave4 mv1 = (Microwave4)mv;
                        mv1.reset();
                    }
                }
                
            }
            
        }
        
    }
    
}
