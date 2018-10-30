package lab3out;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ServerGUI extends JFrame
{

	private JLabel status; //Initialized to “Not Connected”
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea log;
	JLabel notConnect;
	Boolean listen_pressed = false;
	Boolean close_pressed = false;
	Boolean stop_pressed = false;
	
	
	JButton listen = new JButton("Listen");
	JButton close = new JButton("Close");
	JButton stop = new JButton("Stop");
	JButton quit = new JButton("Quit");
	
	private ChatServer server;

	public JPanel  panel1 = new JPanel ();
	public JPanel panel2 = new JPanel(new BorderLayout());
	public JPanel panel3 = new JPanel(new BorderLayout());
	public JPanel panel4 = new JPanel(new BorderLayout());
	public JPanel  panel5 = new JPanel ();

	
	public ServerGUI(String title) {
		server = new ChatServer();
		server.setLog(log);
		server.setStatus(status);
		
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel thisPanel = new JPanel();
		JPanel middle = new JPanel(new BorderLayout());

		this.setLayout(new BorderLayout());
		Panel1();
		Panel2();
		Panel3();
		Panel4();


		this.add(panel1,BorderLayout.NORTH);
		middle.add(panel2,BorderLayout.NORTH);
		middle.add(panel3, BorderLayout.SOUTH);
		thisPanel.add(middle, BorderLayout.CENTER);
		this.add(panel4, BorderLayout.SOUTH);

		//thisPanel.setPreferredSize(new Dimension(500,500));
		this.add(thisPanel);

		//setSize(500,300);
		this.pack();
		setVisible(true);


	}
	public static void main(String[] args)
	{
		//new ServerGUI();
		new ServerGUI(args[0]);
		
	}


	class EventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();
			// if the command is connect/submit/stop, ]
			//print the command in the console

			if (command.equals("Listen"))
			{
				listen_pressed = true;


				if(textFields[0].getText().equals("") || textFields[1].getText().equals("") ) {
					log.setText("Port Number/timeout not entered before pressing Listen\n");
				}
				else{
					log.setText("");
					int port = Integer.parseInt(textFields[0].getText());
					int timeout = Integer.parseInt(textFields[1].getText());
					server.setPort(port);
					//set port time out
					server.setTimeout(timeout);
					server.setLog(log);
					server.setStatus(notConnect);
					try
					{
						server.listen();
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			if (command.equals("Close"))
			{


				if (!listen_pressed) {
					log.setText("Server not currently started\n");
				}
				else {
					try
					{
						server.close();
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//server.serverClosed();
					listen_pressed = false;

				}
			}
			 if (command.equals("Stop"))
			{
			


				if (!listen_pressed) {
					log.setText("Server not currently started\n");
				}
				else{
					server.serverStopped();
					//server.stopListening();
					listen_pressed = false;

				}
			}
			 if (command.equals("Quit"))
			{
				System.exit(0);
			}
		}

	}
	public void Panel1() {
		status = new JLabel("Status:",JLabel.CENTER );
		notConnect = new JLabel("Not Connected", JLabel.CENTER );
		notConnect.setForeground(Color.red);
		panel1.add(status);
		panel1.add(notConnect);
		//panel1.setPreferredSize(new Dimension(1200,20));
	}
	public void Panel2() {
		JPanel labelPanel = new JPanel(new GridLayout(labels.length, 2));
		//JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
		panel2.add(labelPanel, BorderLayout.CENTER);
		//panel2.add(fieldPanel, BorderLayout.EAST);

		for (int i = 0; i < labels.length; i++)
		{

			JLabel j2 = new JLabel(labels[i],JLabel.CENTER);


			if(i==1) {
				textFields[i] = new JTextField(5);
			}
			else
			{textFields[i] = new JTextField(15);}

			JPanel temp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			temp1.add(j2);
			JPanel temp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			temp2.add(textFields[i]);


			labelPanel.add(temp1);
			labelPanel.add(temp2);
		}
	//	panel2.setPreferredSize(new Dimension(50,80));

	}
	public void Panel3() {

		JLabel j3 = new JLabel("Server Log Below" ,JLabel.CENTER);
		log=new JTextArea("",10,40);
		
		//log.setPreferredSize(new Dimension(400,100) );
		JScrollPane jp1= new JScrollPane(log);

		panel3.add(j3,BorderLayout.NORTH );
		panel3.add(jp1, BorderLayout.SOUTH);
		//panel3.setPreferredSize(new Dimension(420,120));



	}
	public void Panel4() {



		//JPanel south = new JPanel();

		panel4.setLayout(new FlowLayout());

		panel4.add(listen);
		panel4.add(close);
		panel4.add(stop);
		panel4.add(quit);
		

		
		

		listen.addActionListener(new EventHandler());
		close.addActionListener(new EventHandler());
		stop.addActionListener(new EventHandler());
		quit.addActionListener(new EventHandler());
	//	panel4.setPreferredSize(new Dimension(1200,40));


	}

}
