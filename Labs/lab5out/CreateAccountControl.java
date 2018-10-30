package lab5out;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CreateAccountControl implements ActionListener
{
	  // Private data fields for the container and chat client.
	  private JPanel container;
	  private ChatServer chatserver;
	  
	  
	  // Constructor for the login controller.
	  public CreateAccountControl(JPanel container, ChatServer chatserver)
	  {
	    this.container = container;
	   this.chatserver = chatserver;
	  }
	  
	  // Handle button clicks.
	  public void actionPerformed(ActionEvent ae)
	  {
		   // Get the name of the button clicked.
		    String command = ae.getActionCommand();
		    
		    // The Login button takes the user to the login panel.
		    if (command.equals("Submit"))
		    {
		    	 // Get the username and password the user entered.
		     
		        
		    	CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
		    	String username = createAccountPanel.getUsername();
		    	String pass = createAccountPanel.getPassword();
		    	String re_pass = createAccountPanel.getRe_Password();
		    	CreateAccountData data = new CreateAccountData();
		    	data.setNewAccount(username);
		    	data.setNewPass(pass);
		    	data.setRe_newPass(re_pass);
		        
		        // Check the validity of the information locally first.
		        if (data.getNewAccount().equals("") || data.getNewPass().equals("")|| data.getRe_newPass().equals(""))
		        {
		        	displayError("Enter new account, password and verify your password.");
		        }
		        boolean result_user = chatserver.getDatabase().validateUsername(username);
		        if(result_user) {
		        	displayError("Account exists, Choose another account.");
		        }
		        else if(!pass.equals(re_pass)) {
		        	displayError("Verify Password is not correct.");
		        }
		        else if(pass.length()<6) {
		        	displayError("Password has to be at least 6 characters");
		        }
		        else {
		        	createSuccess(username,pass);
		        }

		     
		    }

		    
		    // The Create button takes the user to the create account panel.
		    else if (command.equals("Cancel"))
		    {
		      //Handle CreatAccount Here
		    	 CardLayout cardLayout = (CardLayout)container.getLayout();
		         cardLayout.show(container, "1");
		    }
	  }
	  public void createSuccess(String username, String password)
	  {
	    System.out.println("create succeses");
	    int id = chatserver.getDatabase().generateID(username);
	    
	    chatserver.getUser().setId(id);
	    chatserver.getAccountData().setNewAccount(username);
	    chatserver.getAccountData().setNewPass(password);
	    
	    CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "1");
	    
	  }

	  // Method that displays a message in the error - could be invoked by ChatClient or by this class (see above)
	  public void displayError(String error)
	  {
	    	CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
	    	createAccountPanel.setError(error);
	    
	  }
}
