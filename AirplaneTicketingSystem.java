import java.awt.*;

import javax.swing.*;
//import javax.swing.border.Border;


public class AirplaneTicketingSystem 
{
	public AirplaneTicketingSystem()
	{   
		JPanel right = new JPanel();
		right.setLayout(new BorderLayout());
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		
		//JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, right, left);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(right, BorderLayout.EAST);
        panel.add(left, BorderLayout.WEST);
        
    
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        left.add(leftPanel, BorderLayout.NORTH);
        
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
        addComponent("Number Of Passengers", leftPanel, true);
        String[] passengerType = {"Adult","Infant", "Senior Citizen"};
        addComponent("Passenger Type", leftPanel, passengerType);
        String[] modeOfPayment = {"Credit","Debit", "Cash"};
        addComponent("Mode of Payment", leftPanel, modeOfPayment);
        //TODO: Bank details, Change flight, Cancel flight, UI
        
       
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
	private void addComponent(String description, Container container, Boolean needsInput)
	{
		JLabel label = new JLabel(description);
		container.add(label, BorderLayout.WEST);
		
		if (needsInput)
		{
			JTextArea infoTextArea = new JTextArea();
	        infoTextArea.setLineWrap(true);
	        infoTextArea.setWrapStyleWord(true);
	        infoTextArea.setBackground(new Color(241,241,241));
	        infoTextArea.setEditable(true);
	        infoTextArea.setMargin(new Insets(5, 5, 5, 5));
	        container.add(infoTextArea, BorderLayout.WEST);
		}
	}
}
