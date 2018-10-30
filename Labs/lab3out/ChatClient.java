package lab3out;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
	private JLabel status;
	private JTextArea serverMsg;
	private JTextField clientID;

	public ChatClient() {
		super("localhost",8311);
	}
	
	
	public void setStatus(JLabel status) {
		this.status= status; 
	}
	public void setServerMsg(JTextArea serverMsg) {
		this.serverMsg = serverMsg;
	}
	public void setClientID(JTextField clientID) {
		this.clientID = clientID;
	}
	public void connectionEstablished() {
		status.setText("Connected");
		status.setForeground(Color.green);
	}
	@Override
	protected void handleMessageFromServer(Object msg)
	{
		// TODO Auto-generated method stub
		serverMsg.append("Server: "+(String)msg+"\n");
		//somemore codes here
			}
	public void connectionClosed() {
		status.setText("Not Connected");
		status.setForeground(Color.red);
	}

}
