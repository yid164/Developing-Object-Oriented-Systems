// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270
package gui;
import java.awt.*;
import javax.swing.*;
import commands.*;
public class DisplayAllFlightFrame extends JFrame {

	/**
	 * This class is a new frame when user pressed display all flight button in last page
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * a scroll pane set up the text area can not be editable 
	 * @param a set of string 
	 * @return the scroll pane
	 * */
	private JScrollPane myPane(String words)
	{
		JTextArea myTextArea = new JTextArea(words);
		myTextArea.setEditable(false);
		JScrollPane myPane = new JScrollPane(myTextArea);
		return myPane;
	}
	
	

	/**
	 * The void function that can create the panel
	 * add the flight information to myPane and 
	 * set up myPane into the panel
	 * add the panel to the main frame
	 * @param nothing
	 * @return nothing
	 * */
	private void createPanel()
	{
		DisplayFlightsCommand flight = new DisplayFlightsCommand();
		JPanel addPanel = new JPanel();
		addPanel.add(myPane(flight.getFlightsString()));
		addPanel.setLayout(new GridLayout(0,1));
		add(addPanel,BorderLayout.CENTER);
	}
	
	/**
	 * The constructor that make the new frame 
	 * import the panel that created before
	 * set size and title
	 * @param nothing
	 * @return nothing
	 * */
	public DisplayAllFlightFrame()
	{
		createPanel();
		setSize(600,600);
		setTitle("DISPLAY FLIGHT");
		setVisible(true);
	}
}
