package lab5out;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ContactPanel extends JPanel
{
	public ContactPanel() {
		
		
		//create panel for label
		JPanel myPanel = new JPanel();
	 	JPanel labelPanel = new JPanel(new FlowLayout());
	 	
	    
	    JLabel instructionLabel = new JLabel("Contacts");
	    labelPanel.add(instructionLabel);
	 // create panel for text field
	    JTextArea usernameField = new JTextArea("",10,20);
	    usernameField.setText(" Person One\n Person Two\n Person Three\n Person Four");
	    JPanel textPanel = new JPanel(new FlowLayout());
	    textPanel.add(usernameField);

	    // Create a panel for the buttons.
	    JPanel buttonPanel = new JPanel();
	    JButton deleteButton = new JButton("Delete Contact");
	    JButton addButton = new JButton("Add Contact");
	    JButton logoutButton = new JButton("Log Out");
	   
	    buttonPanel.add(deleteButton);
	    buttonPanel.add(addButton);
	    buttonPanel.add(logoutButton);
	    
	    
	    JPanel grid = new JPanel(new BorderLayout());
	    grid.add(labelPanel,BorderLayout.NORTH );
	    grid.add(textPanel, BorderLayout.CENTER);
	    grid.add(buttonPanel,BorderLayout.SOUTH);
	    myPanel.add(grid);
	    this.add(myPanel);
}
}
