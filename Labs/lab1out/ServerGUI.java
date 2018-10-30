package lab1out;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

	public JPanel  panel1 = new JPanel ();
	public JPanel panel2 = new JPanel(new BorderLayout());
	public JPanel panel3 = new JPanel(new BorderLayout());
	public JPanel panel4 = new JPanel(new BorderLayout());
	public JPanel  panel5 = new JPanel ();

	public ServerGUI(String title) {
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
				System.out.println("Listen Button Pressed");
			}

			if (command.equals("Close"))
			{
				System.out.println("Close Button Pressed");
			}
			if (command.equals("Stop"))
			{
				System.out.println("Stop Button Pressed");
			}
			if (command.equals("Quit"))
			{
				System.exit(0);
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
		log=new JTextArea("",5,40);
		
		//log.setPreferredSize(new Dimension(400,100) );
		JScrollPane jp1= new JScrollPane(log);

		panel3.add(j3,BorderLayout.NORTH );
		panel3.add(jp1, BorderLayout.SOUTH);
		//panel3.setPreferredSize(new Dimension(420,120));



	}
	public void Panel4() {

		JButton listen = new JButton("Listen");
		JButton close = new JButton("Close");
		JButton stop = new JButton("Stop");
		JButton quit = new JButton("Quit");

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
