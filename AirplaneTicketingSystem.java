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
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		
		//JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, right, left);
        
		//Creates the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(rightPanel, BorderLayout.CENTER);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        
        
        //Creates the first panel to the left
        JPanel firstPanel = new JPanel(new BorderLayout());
        //firstPanel.setBounds(0, 0, -20, -20);
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
        leftPanel.add(firstPanel, BorderLayout.NORTH);
        
        //Creates the second panel to the right
        JPanel secondPanel = new JPanel(new BorderLayout());
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
        rightPanel.add(secondPanel, BorderLayout.CENTER);
        
        JTextArea leftTextArea = new JTextArea();
        
        addComponent(leftTextArea, null,secondPanel, true, null, false);
        
        JButton submitButton = new JButton("Submit");
        rightPanel.add(submitButton, BorderLayout.SOUTH);
        
        
        //Creates the first panel components
        JComboBox<String> airlineBox, tripTypeBox, scheduleBox, flightTypeBox, originBox, 
        destinationBox, classTypeBox, passengerTypeBox, paymentBox;
        JTextArea numberOfPassengers = new JTextArea();
        
        String[] flightTypeChoices = {"International", "Local"};
        flightTypeBox = new JComboBox<String>(flightTypeChoices);
        addComponent(flightTypeBox,"Choose Flight Type", firstPanel);
        
        String[] airlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"};
        airlineBox = new JComboBox<String>(airlineChoices);
        addComponent(airlineBox,"Choose Airline", firstPanel);
        
        String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
        tripTypeBox = new JComboBox<String>(tripTypeChoices);
        addComponent(tripTypeBox,"Choose Trip Type", firstPanel);
        
        String[] originChoices = {"EMPTY"};
        originBox = new JComboBox<String>(originChoices);
        addComponent(originBox,"Set Origin", firstPanel);
        
        String[] destinationChoices = {"EMPTY"};
        destinationBox = new JComboBox<String>(destinationChoices);
        addComponent(destinationBox,"Set Destination", firstPanel);
        
        String[] scheduleChoices = {"EMPTY"};
        scheduleBox = new JComboBox<String>(scheduleChoices);
        addComponent(scheduleBox,"Set Schedule", firstPanel);
        
        String[] classTypeChoices = {"Business", "Economy", "Premium"};
        classTypeBox = new JComboBox<String>(classTypeChoices);
        addComponent(classTypeBox,"Choose Class Type", firstPanel);
        
        addComponent(numberOfPassengers,"Number Of Passengers", firstPanel, true, "Input number of passengers", true);
        
        String[] passengerType = {"Adult","Infant", "Senior Citizen"};
        passengerTypeBox = new JComboBox<String>(passengerType);
        addComponent(passengerTypeBox,"Passenger Type", firstPanel);
        
        String[] modeOfPayment = {"Credit","Debit", "GCash"};
        paymentBox = new JComboBox<String>(modeOfPayment);
        addComponent(paymentBox,"Mode of Payment", firstPanel);
        //TODO: Bank details, Change flight, Cancel flight, UI
        
        submitButton.addActionListener((e) -> {
        	String details  = flightTypeBox.getItemAt(flightTypeBox.getSelectedIndex()) + System.lineSeparator() + 
        	airlineBox.getItemAt(airlineBox.getSelectedIndex()) + System.lineSeparator() + 
        	tripTypeBox.getItemAt(tripTypeBox.getSelectedIndex()) +System.lineSeparator()+
        	originBox.getItemAt(originBox.getSelectedIndex()) + System.lineSeparator() + 
        	destinationBox.getItemAt(destinationBox.getSelectedIndex()) + System.lineSeparator() +  
        	scheduleBox.getItemAt(scheduleBox.getSelectedIndex()) + System.lineSeparator() +  
        	classTypeBox.getItemAt(classTypeBox.getSelectedIndex()) + System.lineSeparator() + numberOfPassengers.getText() 
        	+ System.lineSeparator() + passengerTypeBox.getItemAt(passengerTypeBox.getSelectedIndex()) + 
        	System.lineSeparator() + paymentBox.getItemAt(paymentBox.getSelectedIndex());
            
        	leftTextArea.setText(details);  
        });
        
        
        //Creates the shell
		JFrame frame = new JFrame();
		frame.setTitle("Airplane Ticketing System");
		frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(new Dimension(800, 650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.pack();
        frame.setVisible(true);
        
	}
	
	private void addComponent(JComboBox<String> box, String description, Container container)
	{
		JLabel label = new JLabel(description);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(label, BorderLayout.WEST);
		container.add(box, BorderLayout.WEST);
	}
	private void addComponent(JTextArea textArea, String description, Container container, Boolean needsInput, String placeholder, Boolean editable)
	{
		JLabel label = new JLabel(description);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(label, BorderLayout.WEST);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		if (needsInput)
		{
			//textArea = new JTextArea(1,1);
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
	        textArea.setEditable(editable);
	        textArea.setMargin(new Insets(5, 5, 5, 5));
	        container.add(textArea, BorderLayout.CENTER);
		}
	}
}
