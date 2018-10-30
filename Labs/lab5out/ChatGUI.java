package lab5out;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatGUI extends JFrame
{
	private ChatClient chatclient = new ChatClient ();
	private ChatServer chatserver = new ChatServer ();
	JPanel container;
	public ChatGUI() {
	 
	    
	 // Set the title and default close operation.
	    this.setTitle("Chat Client");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    // Create the card layout container.
	    CardLayout cardLayout = new CardLayout();
	     container = new JPanel(cardLayout);
	    
	    //Create the Controllers next
	    //Next, create the Controllers
	    InitialControl ic = new InitialControl(container); 
	    LoginControl lc = new LoginControl(container, chatclient); //Probably will want to pass in ChatClient here
	    CreateAccountControl cap = new CreateAccountControl(container,chatserver);
	    
	    
	    
	    // Create the four views. (need the controller to register with the Panels
	    JPanel view1 = new InitialPanel(ic);
	    JPanel view2 = new LoginPanel(lc);
	    JPanel view3 = new CreateAccountPanel(cap);
	    JPanel view4 = new ContactPanel();
	    
	    
	    // Add the views to the card layout container.
	    container.add(view1, "1");
	    container.add(view2, "2");
	    container.add(view3, "3");
	    container.add(view4, "4");
	   
	    
	    // Show the initial view in the card layout.
	    cardLayout.show(container, "1");
	    
	    // Add the card layout container to the JFrame.
	    this.add(container, BorderLayout.CENTER);

	    // Show the JFrame.
	    this.setSize(550, 350);
	    this.setVisible(true);
	    // oepn connection for the socket
	    try
	   	{
	   		chatclient.openConnection();
	   	} catch (IOException e1)
	   	{
	   		// TODO Auto-generated catch block
	   		e1.printStackTrace();
	   	}
	    
	  }

	  // Main function that creates the client GUI when the program is started.
	  public static void main(String[] args)
	  {
	    new ChatGUI();
	  }
	
}
