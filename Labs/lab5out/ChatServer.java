package lab5out;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChatServer extends AbstractServer
{
  private JTextArea log;
  private JLabel status;
  private DatabaseFile database = new DatabaseFile();
  private User user = new User();
  private LoginData loginData = new LoginData();
  private CreateAccountData accountData = new CreateAccountData();
  
  
  public ChatServer()
  {
    super(12345);
  }
  
  public ChatServer(int port)
  {
    super(port);
  }
  
  public void setLog(JTextArea log)
  {
    this.log = log;
  }
  
  public JTextArea getLog()
  {
    return log;
  }
  
  public void setStatus(JLabel status)
  {
    this.status = status;
  }
  
  public JLabel getStatus()
  {
    return status;
  }
  
  
  
  public CreateAccountData getAccountData()
{
	return accountData;
}

public void setAccountData(CreateAccountData accountData)
{
	this.accountData = accountData;
}

public User getUser()
{
	return user;
}

public void setUser(User user)
{
	this.user = user;
}

public DatabaseFile getDatabase()
{
	return database;
}

public void setDatabase(DatabaseFile database)
{
	this.database = database;
}

@Override
  protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
  {
    // TODO Auto-generated method stub
   // System.out.println("Message from Client" + arg0.toString() + arg1.toString());
    //log.append("Message from Client" + arg0.toString() + arg1.toString() + "\n");
    if (arg0 instanceof LoginData)
    {
       loginData = (LoginData)arg0;
       String username = loginData.getUsername();
       String password = loginData.getPassword();
       System.out.println("Username/Password: " + loginData.getUsername() + " " + loginData.getPassword());
       boolean result = database.validateAccount(username, password);
    
    	   try
		{
    		   
			arg1.sendToClient(result);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
      
    }

    
    
  }
  
  protected void listeningException(Throwable exception) 
  {
    //Display info about the exception
    System.out.println("Listening Exception:" + exception);
    exception.printStackTrace();
    System.out.println(exception.getMessage());
    
    /*if (this.isListening())
    {
      log.append("Server not Listening\n");
      status.setText("Not Connected");
      status.setForeground(Color.RED);
    }*/
    
  }
  
  protected void serverStarted() 
  {
    System.out.println("Server Started");
    //log.append("Server Started\n");
  }
  
  protected void serverStopped() 
  {
    System.out.println("Server Stopped");
    //log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
  }
  
  protected void serverClosed() 
  {
    System.out.println("Server and all current clients are closed - Press Listen to Restart");
    //log.append("Server and all current clients are closed - Press Listen to Restart\n");
  }

  
  protected void clientConnected(ConnectionToClient client) 
  {
    System.out.println("Client Connected");
    //log.append("Client Connected\n");
  }
  
  
  


}
