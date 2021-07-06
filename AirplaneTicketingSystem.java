import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;

public class AirplaneTicketingSystem implements ActionListener
{
	private JComboBox<String> airlineBox, tripTypeBox, scheduleBox, flightTypeBox, originBox, 
    destinationBox, classTypeBox, passengerTypeBox, paymentBox;
	
	private JLabel airlineBoxLabel, tripTypeBoxLabel, scheduleBoxLabel, flightTypeBoxLabel, originBoxLabel, 
    destinationBoxLabel, classTypeBoxLabel, numberOfPassengersLabel, passengerTypeBoxLabel, paymentBoxLabel
    ,bankAccountNameLabel, bankAccountNumberLabel, bankAccountCellNumberLabel;
	
	private JButton submitButton, backButton;
	
	private JTextArea rightTextArea, bankAccountName, bankAccountNumber, bankAccountCellNumber;
	
	//private String chosenAirline;
	
	JPanel firstPanel, rightPanel, leftPanel, bankPanel, secondPanel;
	
	String[] localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"};
    String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "ANA Airlines", 
    		"Japan Airlines", "Greater Bay Airlines", "Hongkong Airlines", "Air Busan", "Jeju Air", "Jetstar Asia Airways", 
    		"Singapore Airlines", "Indonesia Air Asia", "Lion Air"};
	
	public AirplaneTicketingSystem()
	{   
		//Create right and left panel to split main panel
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		
		//JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, right, left);
        
		//Creates the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(rightPanel, BorderLayout.CENTER);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        
        
        //Creates the first panel to the left
//        JPanel firstPanel = new JPanel(new BorderLayout());
        //firstPanel.setBounds(0, 0, -20, -20);
        firstPanel = new JPanel(new BorderLayout());
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
        leftPanel.add(firstPanel, BorderLayout.NORTH);
        //firstPanel.setVisible(true);
        
        //Creates the second panel to the right
        secondPanel = new JPanel(new BorderLayout());
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
        rightPanel.add(secondPanel, BorderLayout.CENTER);
        
        rightTextArea = new JTextArea();
        addComponent(rightTextArea, secondPanel, true, null, false);
        
        submitButton = new JButton("Submit");
        rightPanel.add(submitButton, BorderLayout.SOUTH);
        
        
        bankPanel = new JPanel(new BorderLayout());
        bankPanel.setLayout(new BoxLayout(bankPanel, BoxLayout.Y_AXIS));
        //leftPanel.add(bankPanel, BorderLayout.NORTH);
        //bankPanel.setVisible(false);
        
        //Creates the first panel components
        
        JTextArea numberOfPassengers = new JTextArea();
        
        String[] flightTypeChoices = {"International", "Local"};
        flightTypeBox = new JComboBox<String>(flightTypeChoices);
		flightTypeBox.addActionListener(this);
		flightTypeBoxLabel = new JLabel("Choose Flight Type");
		flightTypeBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstPanel.add(flightTypeBoxLabel, BorderLayout.WEST);
		firstPanel.add(flightTypeBox, BorderLayout.WEST);
        
//        String[] localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"};
//        String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "ANA Airlines", 
//        		"Japan Airlines", "Greater Bay Airlines", "Hongkong Airlines", "Air Busan", "Jeju Air", "Jetstar Asia Airways", 
//        		"Singapore Airlines", "Indonesia Air Asia", "Lion Air"};
        airlineBox = new JComboBox<String>(internationalAirlineChoices);
        airlineBoxLabel = new JLabel("Choose Airline");
        airlineBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(airlineBoxLabel, BorderLayout.WEST);
        firstPanel.add(airlineBox, BorderLayout.WEST);
      
//        if (chosenAirline == "Local")
//        {
//        	airlineBox = new JComboBox<String>(localAirlineChoices);
//            addComponent(airlineBox, "Choose Airline", firstPanel);
//        }
//        
//        if (chosenAirline == "International")
//        {
//        	airlineBox = new JComboBox<String>(internationalAirlineChoices);
//            addComponent(airlineBox,"Choose Airline", firstPanel);
//        }
        
        
        String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
        tripTypeBox = new JComboBox<String>(tripTypeChoices);
        tripTypeBoxLabel = new JLabel("Choose Trip Type");
        tripTypeBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(tripTypeBoxLabel, BorderLayout.WEST);
        firstPanel.add(tripTypeBox, BorderLayout.WEST);
      
        String[] originChoices = {"EMPTY"};
        originBox = new JComboBox<String>(originChoices);
        originBoxLabel = new JLabel("Set Origin");
        originBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(originBoxLabel, BorderLayout.WEST);
        firstPanel.add(originBox, BorderLayout.WEST);
        
        String[] destinationChoices = {"EMPTY"};
        destinationBox = new JComboBox<String>(destinationChoices);
        destinationBoxLabel = new JLabel("Set Destination");
        destinationBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(destinationBoxLabel, BorderLayout.WEST);
        firstPanel.add(destinationBox, BorderLayout.WEST);
        
        String[] scheduleChoices = {"EMPTY"};
        scheduleBox = new JComboBox<String>(scheduleChoices);
        scheduleBoxLabel = new JLabel("Set Schedule");
        scheduleBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(scheduleBoxLabel, BorderLayout.WEST);
        firstPanel.add(scheduleBox, BorderLayout.WEST);
        
        String[] classTypeChoices = {"Business", "Economy", "Premium"};
        classTypeBox = new JComboBox<String>(classTypeChoices);
        classTypeBoxLabel = new JLabel("Choose Class Type");
        classTypeBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(classTypeBoxLabel, BorderLayout.WEST);
        firstPanel.add(classTypeBox, BorderLayout.WEST);
        
        numberOfPassengersLabel = new JLabel("Number Of Passengers");
        numberOfPassengersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(numberOfPassengersLabel, BorderLayout.WEST);
        addComponent(numberOfPassengers, firstPanel, true, "Input number of passengers", true);
        
        String[] passengerType = {"Adult","Infant", "Senior Citizen"};
        passengerTypeBox = new JComboBox<String>(passengerType);
        passengerTypeBoxLabel = new JLabel("Passenger Type");
        passengerTypeBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(passengerTypeBoxLabel, BorderLayout.WEST);
        firstPanel.add(passengerTypeBox, BorderLayout.WEST);
        
        String[] modeOfPayment = {"Credit","Debit", "GCash"};
        paymentBox = new JComboBox<String>(modeOfPayment);
        paymentBoxLabel = new JLabel("Mode of Payment");
        paymentBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPanel.add(paymentBoxLabel, BorderLayout.WEST);
        firstPanel.add(paymentBox, BorderLayout.WEST);
        //TODO: Bank details, Change flight, Cancel flight, UI
        
        bankAccountNameLabel = new JLabel("Account Name");
        bankAccountNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankAccountName = new JTextArea();
        bankPanel.add(bankAccountNameLabel, BorderLayout.WEST);
        addComponent(bankAccountName, bankPanel, true, "Input Name", true);
        
        bankAccountNumberLabel = new JLabel("Account Number");
        bankAccountNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankAccountNumber = new JTextArea();
        bankPanel.add(bankAccountNumberLabel, BorderLayout.WEST);
        addComponent(bankAccountNumber, bankPanel, true, "Input Account Number", true);
        
        bankAccountCellNumberLabel = new JLabel("Cellphone Number");
        bankAccountCellNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankAccountCellNumber = new JTextArea();
        bankPanel.add(bankAccountCellNumberLabel, BorderLayout.WEST);
        addComponent(bankAccountCellNumber, bankPanel, true, "Input Cellphone Number", true);
       
        
        backButton = new JButton("Back");
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
            
        	//firstPanel.setVisible(false);
        	switchFirstPanel(bankPanel, BorderLayout.WEST);
        	rightTextArea.setText(details);  
        	leftPanel.add(bankPanel, BorderLayout.CENTER);
            leftPanel.add(backButton, BorderLayout.SOUTH);
        });
        
        backButton.addActionListener((e) -> {
        	switchFirstPanel(firstPanel, BorderLayout.NORTH);
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
	
	private void addComponent(JComboBox<String> box, JLabel label, Container container, int index)
	{
		container.add(box, index);
		container.add(label, index);
		
	}
	private void addComponent(JTextArea textArea, Container container, Boolean needsInput, String placeholder, Boolean editable)
	{
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
			
	        textArea.setLineWrap(false);
	        textArea.setWrapStyleWord(true);
	        textArea.setBackground(new Color(241,241,241));
	        textArea.setBorder(blackline);
	        textArea.setEditable(editable);
	        textArea.setMargin(new Insets(5, 5, 5, 5));
	        container.add(textArea, BorderLayout.NORTH);
		}
	}

//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>)e.getSource();
        String r = (String)cb.getSelectedItem();
        if (r == "Local")
        {
        	//leftTextArea.setText(r);
        	firstPanel.remove(airlineBox);
        	firstPanel.remove(airlineBoxLabel);
        	firstPanel.updateUI();
        	airlineBox = new JComboBox<String>(localAirlineChoices);	
        	
//        	firstPanel.add(airlineBox,2);
        	
            addComponent(airlineBox, airlineBoxLabel , firstPanel,2);
        }
        if (r == "International")
        {
        	//leftTextArea.setText(r);
        	firstPanel.remove(airlineBox);
        	firstPanel.remove(airlineBoxLabel);
        	firstPanel.updateUI();
        	airlineBox = new JComboBox<String>(internationalAirlineChoices);
            addComponent(airlineBox,airlineBoxLabel, firstPanel, 2);
        }
        
	}
	private void switchFirstPanel(JPanel panel, String layout)
	{
		leftPanel.removeAll();
		leftPanel.add(panel, layout);
		leftPanel.repaint();
		leftPanel.revalidate();
	}
	
}
