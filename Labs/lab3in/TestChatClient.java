package lab3in;

import java.io.IOException;

public class TestChatClient
{
	private ChatClient client;
	
	public TestChatClient(String host, int port) {
		client = new ChatClient();
		client.setHost(host);
		client.setPort(port);
		try
		{
			client.openConnection();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			client.sendToServer("Hello Server ");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int port = Integer.parseInt(args[1]);
		new TestChatClient(args[0],port);

	}

}
