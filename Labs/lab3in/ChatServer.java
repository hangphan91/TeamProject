package lab3in;

import java.io.IOException;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer
{

	public ChatServer() {
		super(12345);
		this.setTimeout(500);
		
	
	}
	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		// TODO Auto-generated method stub
		String a = (String) arg0;
		int b = (int) arg1.getId();
		System.out.println("Client " + " "+b +" "+ a );
		try {
			arg1.sendToClient("Hello Client");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void listeningException(Throwable exception) {
		System.out.println("Listening Exception Occurred");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
		
	}
	public void serverStarted() {
		System.out.println("Server Started");
	}
	

}
