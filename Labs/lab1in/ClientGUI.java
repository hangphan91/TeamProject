package lab1in;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

public class ClientGUI extends JFrame
{
  private JLabel status;
  private JButton connect;
  private JButton submit;
  private JButton stop;
  
  public ClientGUI(String title)
  {
    int i = 0;
    
    this.setTitle(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
//    Create a JLabel containing “Not Connected”. Set the color of the text to Red.
//    Store the JLabel in a JPanel named “north” that implements FlowLayout as the Layout Manager
//    Create 3 JButtons.
//    Store the JButtons in a JPanel named “south” that implements FlowLayout as the Layout Manager.
    JPanel north = new JPanel();
    JPanel south = new JPanel();
    north.setLayout(new FlowLayout());
    south.setLayout(new FlowLayout());

    
    
    status = new JLabel("Status:");
    JLabel notConnect = new JLabel("Not Connected");
    notConnect.setForeground(Color.red);
    north.add(status);
    north.add(notConnect);
    
    getContentPane().add(north,BorderLayout.NORTH);
    
    connect = new JButton("Connect");
    submit = new JButton("Submit");
    stop = new JButton("Stop");
    

    
    south.add(connect);
    south.add(submit);
    south.add(stop);
    
    getContentPane().add(south,BorderLayout.SOUTH );
    
//    Create a class named EventHandler whose responsibility is 
//   to process the ActionEvent generated from pressing any of the 3 JButtons –
//    Connect, Submit, Stop. You can make this class an inner class if you like. 
//    For now, just display the following messages to the console dependent upon 
//    the pressing of a given JButton:
//
//    	When pressing Connect display “Connect Button Pressed”
//    	When pressing Submit  display “Submit Button Pressed”
//    	When pressing Stop display “Stop Button Pressed”

    connect.addActionListener(new EventHandler());
    submit.addActionListener(new EventHandler());
    stop.addActionListener(new EventHandler());
//Create action event with GUI builder
    
//    connect.addActionListener(new ActionListener() {
//    	public void actionPerformed(ActionEvent e) {
//    		System.out.println("Connect Button Pressed");
//    		
//    	}
//    });
//    
//    submit.addActionListener(new ActionListener() {
//    	public void actionPerformed(ActionEvent e) {
//    		System.out.println("Submit Button Pressed");
//    		
//    	}
//    });
//   
//    stop.addActionListener(new ActionListener() {
//    	public void actionPerformed(ActionEvent e) {
//      		System.out.println("Stop Button Pressed");
//    	}
//    });
    
    
    
    
   
    setSize(300,300);
    //this.pack(); //Set window to preferred size 
    setVisible(true);
    
  }
  
  public static void main(String[] args)
  {
    new ClientGUI(args[0]); //args[0] represents the title of the GUI
  }
  //class to implements EventHandler
  class EventHandler implements ActionListener
  {
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if (command.equals("Connect"))
		{
    		System.out.println("Connect Button Pressed");
		}
		
		if (command.equals("Submit"))
		{
    		System.out.println("Submit Button Pressed");
		}
		if (command.equals("Stop"))
		{
    		System.out.println("Stop Button Pressed");
		}
		
	}
	
  }
  
  
}