package lab3in;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{

	public ChatClient() {
		super("localhost",8300);
	}
	
	@Override
	protected void handleMessageFromServer(Object msg)
	{
		// TODO Auto-generated method stub
		System.out.println("Server Message sent to Client "+ (String)msg);
	}
	
	public void connectionException (Throwable exception) {
		System.out.println("Connection Exception Occurred");
		System.out.println("Message: "+exception.getMessage());
		exception.printStackTrace();

		
	}
	public void connectionEstablished() {
		System.out.println("Client Connected");
	}

}
