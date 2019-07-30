// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270

package gui;
import java.awt.*;
import javax.swing.*;
import commands.*;
public class DisplayAllPassengerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	
	private JScrollPane myPane(String words)
	{
		JTextArea myTextArea = new JTextArea(words);
		myTextArea.setEditable(false);
		JScrollPane myPane = new JScrollPane(myTextArea);
		return myPane;
	}

	

	
	private void createPanel()
	{
		DisplayPassengersCommand passenger = new DisplayPassengersCommand();
		JPanel addPanel = new JPanel();
		addPanel.add(myPane(passenger.getPassengersString()));
		addPanel.setLayout(new GridLayout(0,1));
		add(addPanel,BorderLayout.CENTER);
	}
	
	public DisplayAllPassengerFrame()
	{
		createPanel();
		setSize(600,600);
		setTitle("DISPLAY PASSENGER");
		setVisible(true);
	}
	
	

}
