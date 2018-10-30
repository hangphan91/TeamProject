package lab3out;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer
{
	private JTextArea log; //Corresponds to JTextArea of ServerGUI
	private JLabel status; //Corresponds to the JLabel of ServerGUI
	//int  client_id;
	
	public ChatServer() {
		super(12345);
		this.setTimeout(500);
	}
	public void setLog(JTextArea log) {
		this.log=log;
	}
	public void setStatus(JLabel status) {
		this.status= status;
	}

	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		// TODO Auto-generated method stub
		int client_id =    (int)arg1.getId();
		String message_from_client = (String)arg0;
		log.append("Client "+ client_id +" "+ message_from_client +"\n");
		try
		{
			arg1.sendToClient(message_from_client);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void clientConnected(ConnectionToClient client) {
		try
		{
			
			client.sendToClient("username:Client-" + client.getId());
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.append("Client " + client.getId() + " Connected \n" );
		
	}
	
	public void listeningException(Throwable exception) {
		log.append("\nListen Exception:"+ exception.getMessage() +"\n");
		log.append("Press Listen to Restart Server");
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.red);
	}
	public void serverStarted() {
		log.setText("Server Started\n");
		status.setText("Listening");
		status.setForeground(Color.green);
	}
	public void serverStopped() {
		log.append("\nServer Stopped Accepting New Clients - Press Listen to Start Accepting New Clients");
		status.setText("Stopped");
		status.setForeground(Color.red);
	}
	public void serverClosed() {
		log.append("\nServer and all current clients are closed - Press Listen to Restart");
		status.setText("Close");
		status.setForeground(Color.red);
	}
	
	

}
