// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainFrame extends JFrame{
	
	/**
	 * This frame is the main frame that contains all operations for this assignments
	 * It contains adding flight button, adding passenger button
	 * It contains display all passengers and flight buttons
	 * it contains terminate button and text field that handle flight
	 */
	private static final long serialVersionUID = -5417265551757179600L;

	
	
	
	/**
	 * The adding flight button
	 * @param nothing
	 * @return the button that can open a new window that can add Flight
	 * Linked the ActionListener that can open new window
	 * */
	private JButton addFlightButton()
	{
		JButton button = new JButton("ADDING FLIGHT");
		Font f = new Font("Courier", Font.PLAIN,18);
		button.setFont(f);
		button.addActionListener(new AddFlightListener(button));
		return button;
	}
	
	
	
	/**
	 * The internal class that for add flight button
	 * A new window will be opened caused by the adding flight button
	 * */
	class AddFlightListener implements ActionListener
	{
		/*
		 * The actionPerformed will execute open new window operation
		 * */
		public void actionPerformed(ActionEvent event)
		{
			new AddNewFlightFrame();
		}
		public AddFlightListener(JButton aButton){
		}
	}
	
	
	/**
	 * The adding passenger button
	 * @param nothing
	 * @return the button that can open a new window that can add passenger
	 * Linked a ActionListener that can open a new window
	 * */
	private JButton addPassengerButton()
	{
		JButton button = new JButton("ADDING PASSENGER");
		Font f = new Font("Courier", Font.PLAIN,18);
		button.setFont(f);
		button.addActionListener(new AddPassengerListener(button));
		return button;
	}
	
	/**
	 * The internal class that for add passenger button
	 * A new window will be opened caused by the adding passenger button
	 * */
	class AddPassengerListener implements ActionListener
	{
		/*
		 * The actionPerformed will execute open new window operation
		 * */
		public void actionPerformed(ActionEvent event)
		{
			new AddPassengerFrame();
		}
		public AddPassengerListener(JButton aButton)
		{
		}
	}
	

	
	/**
	 *The displaying passenger button
	 *@param nothing
	 *@return a new button that can open a new window that can add passenger */
	private JButton displayPassenger()
	{
		JButton button = new JButton("DISPLAY PASSENGER");
		Font f = new Font("Courier", Font.PLAIN,18);
		button.setFont(f);
		button.addActionListener(new DisplayPassengerListener(button));
		return button;
	}
	
	/**
	 * The internal class can when displaying passenger button pressed, a new window will be opened
	 * */
	class DisplayPassengerListener implements ActionListener
	{
		/*
		 * The actionPerformed will execute open a new window operation
		 * */
		public void actionPerformed(ActionEvent event)
		{
			new DisplayAllPassengerFrame();
		}
		public DisplayPassengerListener(JButton aButton)
		{
		}
	}
	
	/**
	 * 	 *The displaying passenger button
	 *@param nothing
	 *@return a new button that can open a new window that can display all flight info*/
	private JButton displayFlight()
	{
		JButton button = new JButton("DISPLAY FLIGHT");
		Font f = new Font("Courier", Font.PLAIN,18);
		button.setFont(f);
		button.addActionListener(new DisplayFlightListener(button));
		return button;
	}
	
	/**
	 * The internal class can execute when displaying flight button pressed, a new window will be opened*/
	class DisplayFlightListener implements ActionListener
	{
		
		
		/*
		 * the actionPerformed will execute open a new window operation*/
		public void actionPerformed(ActionEvent event)
		{
			new DisplayAllFlightFrame();
		}
		public DisplayFlightListener(JButton aButton)
		{
		}
		
	}
	
	
	/**
	 * The button that can terminate the project
	 * @param nothing
	 * @return nothing
	 * need close the main window
	 * */
	private JButton quitOut()
	{
		JButton quitOut = new JButton("QUIT");
		Font f = new Font("Courier", Font.PLAIN,18);
		quitOut.setFont(f);
		quitOut.addActionListener(new QuitOutListener(quitOut));
		return quitOut;
	}
	
	/**
	 * The internal class can execute when quit button pressed, close the main window
	 * */
	class QuitOutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
		public QuitOutListener(JButton button)
		{
		}
	}
	
	
	
	/**
	 * A text field that user can have a space for input
	 * @param nothing
	 * @return nothing
	 * need to open a new window when it pressed 
	 * */
	private JTextField display()
	{
		JTextField display = new JTextField();
		display.addActionListener(new DisplayListener(display));
		display.setEditable(true);
		display.setVisible(true);
		return display;
	}
	
	/**
	 * The internal class can execute when user input some thing in the space, to open a new window
	 * Get user's input number to link HandleFlightFrame.java
	 * */
	class DisplayListener implements ActionListener
	{
		private JTextField display;
		/*
		 * When the input is in the field and press enter key
		 * a new window will be opened named INFORMATION */
		public void actionPerformed(ActionEvent evnet)
		{
			int flight = Integer.parseInt(display.getText());
			HandleFlightFrame a = new HandleFlightFrame(flight);
			a.setTitle("INFORMATION");
			a.setVisible(true);
		}
		public DisplayListener(JTextField display)
		{
			this.display=display;
		}
		
	}
	
	/**
	 * Create a new panel can organize text field and a new label "Please enter flight number:
	 * @param nothing
	 * @return nothing*/
	private JPanel text()
	{
		JPanel text = new JPanel();
		text.setLayout(new BoxLayout(text, BoxLayout.X_AXIS));
		text.add(new Label("FLIGHT NO."));
		text.add(display());
		Font f = new Font("Courier", Font.PLAIN,18);
		text.setFont(f);
		return text;
	}
	
	
	/**	 
	 * Arrange all buttons and the text field in a panel by grid layout
	 * and add the panel to the Main frame by border layout
	 * @param nothing
	 * @return nothing
	 * */
	private void createButtonPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,1));
		buttonPanel.add(addFlightButton());
		buttonPanel.add(addPassengerButton());
		buttonPanel.add(displayFlight());
		buttonPanel.add(displayPassenger());
		buttonPanel.add(quitOut());
		buttonPanel.add(text());
		add(buttonPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * The constructor for the main frame 
	 * @param nothing
	 * @return nothing*/
	public MainFrame()
	{
		setTitle("FLIGHT RESERVATION SYS");
		setVisible(true);
		createButtonPanel();
		setSize(600,600);
		
	}
	


	
}
