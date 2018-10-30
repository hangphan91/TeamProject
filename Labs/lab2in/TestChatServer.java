package lab2in;

import java.io.IOException;

public class TestChatServer
{

	private ChatServer server;
	
	public TestChatServer(int port, int timeout) {
		//Initiate the Chat Server
		server =new ChatServer();
		server.setPort(port);
		//set port time out
		server.setTimeout(timeout);
		
		//start listening
		try
		{
			server.listen();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		
		// TODO Auto-generated method stub
	// Handle arg validation
		new TestChatServer(Integer.parseInt(args[0]),Integer.parseInt(args[1]) );
	}

}
