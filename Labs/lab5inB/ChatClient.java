package lab5inB;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
  private String msg_from_server ="";
  public ChatClient()
  {
    super("localhost",8300);
  }

  @Override
  public void handleMessageFromServer(Object arg0)
  {
    System.out.println("Server Message sent to Client " + (String)arg0);
    
    msg_from_server = (String)arg0;
  }
  public String msg_from_server() {
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