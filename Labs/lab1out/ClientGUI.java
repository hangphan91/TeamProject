package lab1out;

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.*;

public class ClientGUI extends JFrame
{
	private JLabel status;
	private JButton connect;
	private JButton submit;
	private JButton stop;

	private String[] labels = {"Client ID", "Server URL", "Server Port"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea clientArea;
	private JTextArea serverArea;

	public JPanel  panel1 = new JPanel ();
	public JPanel panel2 = new JPanel(new BorderLayout());
	public JPanel panel3 = new JPanel(new BorderLayout());
	public JPanel panel4 = new JPanel(new BorderLayout());
	public JPanel  panel5 = new JPanel ();

	public ClientGUI(String title)
	{
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel thisPanel = new JPanel();
		JPanel middle = new JPanel(new GridLayout(3,1,0,0));

		this.setLayout(new BorderLayout());
		Panel1();
		Panel2();
		Panel3();
		Panel4();
		Panel5();

		this.add(panel1,BorderLayout.NORTH);
		middle.add(panel2);
		middle.add(panel3);
		middle.add(panel4);
		thisPanel.add(middle, BorderLayout.CENTER);
		this.add(thisPanel, BorderLayout.CENTER);
		
		this.add(panel5, BorderLayout.SOUTH);

//		thisPanel.setPreferredSize(new Dimension(400,400));
		//this.add(thisPanel);


		//setSize(500,500);
		this.pack();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new ClientGUI(args[0]); //args[0] represents the title of the GUI
	}
	//class to implements EventHandler
	class EventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();
			// if the command is connect/submit/stop,
			//print the command in the console

			if (command.equals("Connect"))
			{
				System.out.println("Connect Button Pressed");
			}

			if (command.equals("Submit"))
			{
				System.out.println("Client Data: " + clientArea.getText() );
			}
			if (command.equals("Stop"))
			{
				System.out.println("Stop Button Pressed");
			}

		}

	}
	public void Panel1() {
		status = new JLabel("Status:",JLabel.CENTER );
		JLabel notConnect = new JLabel("Not Connected", JLabel.CENTER );
		notConnect.setForeground(Color.red);
		panel1.add(status);
		panel1.add(notConnect);
		//panel1.setPreferredSize(new Dimension(1200,20));
	}
	public void Panel2() {
		JPanel temp0 = new JPanel();
		JPanel labelPanel = new JPanel(new GridLayout(labels.length, 2));
		temp0.add(labelPanel, BorderLayout.CENTER);
		for (int i = 0; i < labels.length; i++)
		{
			
			JLabel j2 = new JLabel(labels[i]);
			if(i==2) {
				textFields[i] = new JTextField(7);
			}
			else
			{textFields[i] = new JTextField(10);}

			if(i==0) {
				textFields[i].setEditable(false);
			}
			JPanel temp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			temp1.add(j2);
			JPanel temp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			temp2.add(textFields[i]);


			labelPanel.add(temp1);
			labelPanel.add(temp2);
			

		}
		panel2.add(temp0);
	}
	public void Panel3() {

		JLabel j3 = new JLabel("Enter Client Data Below" ,JLabel.CENTER);
		clientArea=new JTextArea("",5,40);
		//clientArea.setPreferredSize(new Dimension(100,50) );

		JScrollPane jp1= new JScrollPane(clientArea);
		panel3.add(j3, BorderLayout.NORTH);
		panel3.add(jp1,BorderLayout.SOUTH);
		//panel3.setPreferredSize(new Dimension(320,120));



	}
	public void Panel4() {

		JLabel j3 = new JLabel("Enter Client Data Below" ,JLabel.CENTER);
		serverArea=new JTextArea("",5,40);
		//serverArea.setPreferredSize(new Dimension(100,50) );
		serverArea.setEditable(false);
		JScrollPane jp1= new JScrollPane(serverArea);
		panel4.add(j3, BorderLayout.NORTH);
		panel4.add(jp1,BorderLayout.SOUTH);
		//panel4.setPreferredSize(new Dimension(320,120));


	}


	public void Panel5() {
		connect = new JButton("Connect");
		submit = new JButton("Submit");
		stop = new JButton("Stop");

		panel5.setLayout(new FlowLayout());

		panel5.add(connect);
		panel5.add(submit);
		panel5.add(stop);
		connect.addActionListener(new EventHandler());
		submit.addActionListener(new EventHandler());
		stop.addActionListener(new EventHandler());
		//panel5.setPreferredSize(new Dimension(1200,30));
	}
}