// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270
package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import commands.*;
public class AddPassengerFrame extends JFrame {
	/**
	 * This class is the new window when user pressed add new passenger button in last frame
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The text field that user can input the passenger name
	 * */
	private JTextField displayName;
	
	/**
	 * The text field that user can input the passenger telephone number
	 * */
	private JTextField displayTele;
	
	/**
	 * The label that can display greeting message and error message
	 * */
	private JLabel greeting;
	
	/**
	 * The main panel in the frame the window
	 * */
	private JPanel mainPanel;
	

	/**
	 * The panel that include the greeting message
	 * @param nothing
	 * @return the greeting message panel
	 * */
	private JPanel topMessage()
	{
		JPanel topMessage = new JPanel();
		greeting = new JLabel("*******Welcome*******");
		topMessage.add(greeting);
		return topMessage;
	}
	
	/**
	 * The panel that include the text fields and information labels
	 * Also include a actionlistener that when user pressed enter key, it will execute
	 * @param nothing
	 * @return this panel*/
	private JPanel field()
	{
		displayName = new JTextField();
		displayTele = new JTextField();
		JPanel addFlightPanel = new JPanel();
		addFlightPanel.setLayout(new GridLayout(0,1));
		addFlightPanel.add(new JLabel("Please enter the Passenger's Name"));
		addFlightPanel.add(displayName);
		addFlightPanel.add(new JLabel("Please enter the Passenger's telephone Number"));
		addFlightPanel.add(displayTele);
		/**
		 * The internal class that when user have input the text file and press the enter key*/
		class ReturnListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				String name = null;
				String teleNum = null;
				
				try{
					name = displayName.getText();
					teleNum = displayTele.getText();
				}
				catch (Exception e)
				{
				}
				AddPassengerCommand a= new AddPassengerCommand();
				a.addPassenger(name, teleNum);
				if(a.wasSuccessful())
				{
					dispose();
				}
				else
				{
					/*
					 * set up the red color for the error message*/
					greeting.setText("***Error Message*** "+ a.getErrorMessage());
					greeting.setForeground(Color.RED);
				}

			}
		}
		displayTele.addActionListener(new ReturnListener());
		return addFlightPanel;
	}
	
	/**
	 * The panel that set up main panel, import every panel above and set up them
	 * @param nothing
	 * @return the mainPanel
	 * */
	private JPanel mainPanel()
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(field(),BorderLayout.CENTER);
		mainPanel.add(topMessage(), BorderLayout.PAGE_START);
		return mainPanel;
	}
	
	/**
	 * constructor
	 * put the main panel into this frame set up size and name
	 * @param nothing
	 * @return nothing
	 * */
	public AddPassengerFrame()
	{
		add(mainPanel(),BorderLayout.CENTER);
		setSize(600,600);
		setTitle("ADD PASSENGER");
		setVisible(true);
	}

}
