package lab5out;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
  private boolean msg_from_server = false;
  public ChatClient()
  {
    super("localhost",8300);
  }

  @Override
  public void handleMessageFromServer(Object arg0)
  {
    System.out.println("Server Message sent to Client " + (boolean)arg0);
    
    msg_from_server = (boolean)arg0;
  }
  public boolean msg_from_server() {
	  return msg_from_server;
  }
  
  public void connectionException (Throwable exception) 
  {
    //Add your code here
	  System.out.println(" throwed exception");

  }
  public void connectionEstablished()
  {
    //Add your code here
	  System.out.println("Connection established");
  }
  

}