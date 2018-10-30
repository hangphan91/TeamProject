package lab2out;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer
{

	private JTextArea log; //Corresponds to JTextArea of ServerGUI
	private JLabel status; //Corresponds to the JLabel of ServerGUI

	public ChatServer()
	{
		super(12345);
		this.setTimeout(500);
		// TODO Auto-generated constructor stub
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
		System.out.println("Message from Client Received");
	}
	
	public void listeningException(Throwable exception) {
		log.append("\nListen Exception:"+ exception.getMessage() +"\n");
		log.append("Press Listen to Restart Server");
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.red);
	}
	public void serverStarted() {
		log.setText("Server Started");
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
	public void clientConnected(ConnectionToClient client) {
		log.append("Client connected");
	}

}
