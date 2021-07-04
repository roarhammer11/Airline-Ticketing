import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.Border;

public class AirplaneTicketingSystem 
{
	public AirplaneTicketingSystem()
	{   
		//Create right and left panel to split main panel
		JPanel splitToRight = new JPanel();
		splitToRight.setLayout(new BorderLayout());
		JPanel splitToLeft = new JPanel();
		splitToLeft.setLayout(new BorderLayout());
		
		//JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, right, left);
        
		//Creates the main panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(splitToRight, BorderLayout.EAST);
        panel.add(splitToLeft, BorderLayout.WEST);
        
        //Creates the left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        splitToLeft.add(leftPanel, BorderLayout.NORTH);
        
        //Creates the components
        String[] airlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"};
        addComponent("Choose Airline", leftPanel, airlineChoices);
        String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
        addComponent("Choose Trip Type", leftPanel, tripTypeChoices);
        String[] scheduleChoices = {"EMPTY"};
        addComponent("Set Schedule", leftPanel, scheduleChoices);
        String[] flightTypeChoices = {"International", "Local"};
        addComponent("Choose Flight Type", leftPanel, flightTypeChoices);
        String[] originChoices = {"EMPTY"};
        addComponent("Set Origin", leftPanel, originChoices);
        String[] destinationChoices = {"EMPTY"};
        addComponent("Set Destination", leftPanel, destinationChoices);
        String[] classTypeChoices = {"Business", "Economy", "Premium"};
        addComponent("Choose Class Type", leftPanel, classTypeChoices);
        addComponent("Number Of Passengers", leftPanel, true, "Input number of passengers");
        String[] passengerType = {"Adult","Infant", "Senior Citizen"};
        addComponent("Passenger Type", leftPanel, passengerType);
        String[] modeOfPayment = {"Credit","Debit", "Cash"};
        addComponent("Mode of Payment", leftPanel, modeOfPayment);
        //TODO: Bank details, Change flight, Cancel flight, UI
        
        //Creates the shell
		JFrame frame = new JFrame();
		frame.setTitle("Airplane Ticketing System");
		frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(new Dimension(800, 650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.pack();
        frame.setVisible(true);
        
	}
	private void addComponent(String description, Container container, String[] list)
	{
		JLabel label = new JLabel(description);
		container.add(label, BorderLayout.WEST);
		JComboBox<String> box = new JComboBox<String>(list);
		container.add(box, BorderLayout.WEST);
	}
	private void addComponent(String description, Container container, Boolean needsInput, String placeholder)
	{
		JLabel label = new JLabel(description);
		container.add(label, BorderLayout.WEST);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		if (needsInput)
		{
			JTextArea textArea = new JTextArea();
			textArea.setText(placeholder);
			textArea.addFocusListener(new FocusListener()
					{

						@Override
						public void focusGained(FocusEvent e) {
							// TODO Auto-generated method stub
							if (textArea.getText().equals(placeholder))
							{
								textArea.setText("");
							}
						}

						@Override
						public void focusLost(FocusEvent e) {
							// TODO Auto-generated method stub
							if (textArea.getText().isEmpty())
							{
								textArea.setText(placeholder);
							}
						}
				
					});
			
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setBackground(new Color(241,241,241));
	        textArea.setBorder(blackline);
	        textArea.setEditable(true);
	        textArea.setMargin(new Insets(5, 5, 5, 5));
	        container.add(textArea, BorderLayout.WEST);
		}
	}
}
