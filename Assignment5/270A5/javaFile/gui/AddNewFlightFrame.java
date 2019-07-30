// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270
package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import commands.AddFlightCommand;
public class AddNewFlightFrame extends JFrame {
	/**
	 * This class is the new window when user pressed the add flight button
	 * */
	private static final long serialVersionUID = 1L;
	
	/*
	 * the text field that user can input flight number in
	 * */
	private JTextField flightNum;
	
	
	/*
	 *the text field that user can input flight capacity in
	 * */
	private JTextField flightCap;
	
	/*
	 * the text field that user can input flight width in
	 *  */
	private JTextField flightWidth;
	
	/*
	 * the main panel in the frame of the window
	 * */
	private JPanel  mainPanel;
	
	/*
	 * the greeting label that output the welcome message and error message
	 * */
	private JLabel greeting;
	
	/**
	 * The constructor that add the main panel to this frame
	 * @param nothing
	 * @return nothing
	 * */
    
    
    
    
	public AddNewFlightFrame()
	{

		add(mainPanel());
		setSize(600,600);
		setTitle("ADD FLIGHT");
		setVisible(true);
		
	}
	
	
	/**
	 * Using the panel to store mainPanel and organize the main mainPanel
	 * @param nothing
	 * @return the mainPanel
	 * */
	private JPanel mainPanel()
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());;
		mainPanel.add(topMessage(),BorderLayout.PAGE_START);;
		mainPanel.add(operationFiled(),BorderLayout.CENTER);
		return mainPanel;
	}
	
	/**
	 * Using the panel to store greeting message
	 * the original message should be "welcome"
	 * @param nothing
	 * @return the greeting
	 * */
	private JPanel topMessage()
	{
		JPanel topMessage = new JPanel();
		greeting = new JLabel("********Welcome********");
		topMessage.add(greeting);
		return topMessage;
		
	}
	
	/**
	 * The operation panel can can store every operation that the panel need
	 * The label can show every message and the text field can store the user input
	 * @param nothing
	 * @return the operation panel*/
	private JPanel operationFiled()
	{
		flightCap = new JTextField();
		flightNum = new JTextField();
		flightWidth = new JTextField();
		JPanel field = new JPanel();
		field.setLayout(new GridLayout(0,1));
		field.add(new Label("Please enter the flight number"));
		field.add(flightNum);
		field.add(new Label("Please enter the flight capacity"));
		field.add(flightCap);
		field.add(new Label("Please enter the flight width"));
		field.add(flightWidth);
		field.add(button());
		return field;
	}
	
	/**
	 * The button that named submit, and when it is pressed store the data that user input 
	 * or output an error message to instead the greeting
	 * @param nothing
	 * @return the button
	 * */
	private JButton button(){
		JButton button = new JButton("Submit");
		/**
		 * the internal class that can judge if the user input is correct or not 
		 * */
		class ButtonListener implements ActionListener
		{
			/*
			 * if it is correct, store the data and add the flight
			 * otherwise output the error message*/
			public void actionPerformed (ActionEvent event)
			{
				int num =0;
				int cap =0;
				int width=0;
				try
				{
					num = Integer.parseInt(flightNum.getText());
					cap = Integer.parseInt(flightCap.getText());
					width = Integer.parseInt(flightWidth.getText());
				}
				catch(NumberFormatException e)
				{
				}
				AddFlightCommand a = new AddFlightCommand();
				a.addFlight(num, width, cap);
				if(a.wasSuccessful())
				{
					dispose();
				}
				else
				{
					/*
					 * change the greeting to error message and change the color to the red*/
					greeting.setText("***Error Message***"+a.getErrorMessage());
					greeting.setForeground(Color.RED);;
				}
			}
		}
		button.addActionListener(new ButtonListener());
		return button;
	}
	
}
