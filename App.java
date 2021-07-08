import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class App extends JFrame 
{
	//Instance Variables
	private JPanel mainPanel, firstPanel, secondPanel;
	String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "ANA Airlines", 
    		"Japan Airlines", "Greater Bay Airlines", "Hongkong Airlines", "Air Busan", "Jeju Air", "Jetstar Asia Airways", 
    		"Singapore Airlines", "Indonesia Air Asia", "Lion Air"};
	String[] localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"};
	private JLayeredPane layeredPane;
	private JLabel setFlightTypeBoxLabel, setAirlineBoxLabel, setTripTypeBoxLabel, setOriginBoxLabel, setDestinationLabel, setScheduleBoxLabel, setClassTypeBoxLabel, setBankAccountNameLabel,
				   setNumberOfPassengerBoxLabel, setNumberOfAdultsLabel, setNumberOfInfantsLabel, setNumberOfSeniorCitizenLabel, setModeOfPaymentBoxLabel;
	private JComboBox<String> setFlightTypeBox, setAirlineBox, setTripTypeBox, setOriginBox, setDestinationBox, setScheduleBox, setClassTypeBox, setModeOfPaymentBox;
	private JTextField setBankAccountName, setNumberOfPassengersTextField, setNumberOfInfantsTextField, setNumberOfAdultsTextField, setNumberOfSeniorCitizensTextField;
	private JButton backButton, nextButton;
	private int numberOfPassengers, numberOfInfants, numberOfAdults, numberOfSeniorCitizens;
	private JTextArea rightTextArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					App frame = new App();
					frame.setSize(new Dimension(800, 650));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() 
	{
		initializeComponent();
		createEvents();
	}
	
	public void switchPanels(JPanel panel, JLayeredPane pane)
	{
		pane.removeAll();
		pane.add(panel);
		pane.repaint();
		pane.revalidate();
		
	}

	private void initializeComponent() 
	{
		// TODO Auto-generated method stub
		setTitle("Airplane Ticketing System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/resources/213569889_535845414403206_7341132822717748611_n.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		
		//Panels
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 280, 594);
		layeredPane.setLayout(new CardLayout(0, 0));
		mainPanel.add(layeredPane);
		
		firstPanel = new JPanel();
		layeredPane.add(firstPanel, "name_45847991791500");
		
		secondPanel = new JPanel();
		layeredPane.add(secondPanel, "name_45848002587000");
		secondPanel.setLayout(null);
		
		
		//Labels
		setClassTypeBoxLabel = new JLabel("Class Type");
		setClassTypeBoxLabel.setLabelFor(setClassTypeBox);
		setClassTypeBoxLabel.setBounds(12, 203, 62, 16);
		
		setFlightTypeBoxLabel = new JLabel("Flight Type  ");
		setFlightTypeBoxLabel.setBounds(12, 16, 66, 16);
		
		setAirlineBoxLabel = new JLabel("Airlines");
		setAirlineBoxLabel.setBounds(12, 47, 43, 16);
		
		setTripTypeBoxLabel = new JLabel("Trip Type");
		setTripTypeBoxLabel.setBounds(12, 78, 52, 16);
		
		setOriginBoxLabel = new JLabel("Origin");
		setOriginBoxLabel.setBounds(12, 109, 34, 16);
		
		setDestinationLabel = new JLabel("Destination");
		setDestinationLabel.setBounds(12, 140, 64, 16);
		
		setScheduleBoxLabel = new JLabel("Schedule");
		setScheduleBoxLabel.setBounds(12, 172, 53, 16);
		
		setNumberOfPassengerBoxLabel = new JLabel("Number Of Passengers");
		setNumberOfPassengerBoxLabel.setLabelFor(setNumberOfPassengersTextField);
		setNumberOfPassengerBoxLabel.setBounds(12, 231, 133, 16);
		firstPanel.add(setNumberOfPassengerBoxLabel);
		
		setNumberOfAdultsLabel = new JLabel("Adults");
		setNumberOfAdultsLabel.setBounds(108, 259, 55, 16);
		firstPanel.add(setNumberOfAdultsLabel);
		
		setNumberOfInfantsLabel = new JLabel("Infants");
		setNumberOfInfantsLabel.setBounds(23, 259, 55, 16);
		firstPanel.add(setNumberOfInfantsLabel);
		
		setNumberOfSeniorCitizenLabel = new JLabel("Senior Citizen");
		setNumberOfSeniorCitizenLabel.setBounds(180, 259, 83, 16);
		firstPanel.add(setNumberOfSeniorCitizenLabel);
		
		setModeOfPaymentBoxLabel = new JLabel("Mode of Payment");
		setModeOfPaymentBoxLabel.setBounds(12, 325, 105, 16);
		firstPanel.add(setModeOfPaymentBoxLabel);
		
		setBankAccountNameLabel = new JLabel("Account Name");
		setBankAccountNameLabel.setBounds(12, 12, 92, 16);
		secondPanel.add(setBankAccountNameLabel);
		
		
		
		
		//Box
		setClassTypeBox = new JComboBox<String>();
		String[] classTypeChoices = {"Business", "Economy", "Premium"};
		setClassTypeBox.setModel(new DefaultComboBoxModel<String>(classTypeChoices));
		setClassTypeBox.setBounds(82, 199, 81, 25);
		
		setDestinationBox = new JComboBox<String>();
		setDestinationLabel.setLabelFor(setDestinationBox);
		String[] destinationChoices = {"EMPTY"};
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(destinationChoices));
		setDestinationBox.setBounds(82, 136, 67, 25);
		
		setOriginBox = new JComboBox<String>();
		setOriginBoxLabel.setLabelFor(setOriginBox);
		String[] originChoices = {"EMPTY"};
		setOriginBox.setModel(new DefaultComboBoxModel<String>(originChoices));
		setOriginBox.setBounds(82, 105, 67, 25);
		
		setFlightTypeBox = new JComboBox<String>();
		setFlightTypeBoxLabel.setLabelFor(setFlightTypeBox);
		String[] flightTypeChoices = {"International", "Local"};
		setFlightTypeBox.setModel(new DefaultComboBoxModel<String>(flightTypeChoices));
		setFlightTypeBox.setBounds(82, 12, 99, 25);
		
		setAirlineBox = new JComboBox<String>();
		setAirlineBoxLabel.setLabelFor(setAirlineBox);
		setAirlineBox.setModel(new DefaultComboBoxModel<String>(internationalAirlineChoices));
		setAirlineBox.setBounds(82, 43, 146, 25);
		
		setTripTypeBox = new JComboBox<String>();
		setTripTypeBoxLabel.setLabelFor(setTripTypeBox);
		String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
		setTripTypeBox.setBounds(82, 74, 105, 25);
		
		setScheduleBox = new JComboBox<String>();
		setScheduleBoxLabel.setLabelFor(setScheduleBox);
		String[] scheduleChoices = {"EMPTY"};
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(scheduleChoices));
		setScheduleBox.setBounds(82, 168, 67, 25);
		
		setModeOfPaymentBox = new JComboBox<String>();
		setModeOfPaymentBoxLabel.setLabelFor(setModeOfPaymentBox);
		String[] modeOfPayment = {"Credit","Debit", "GCash"};
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(modeOfPayment));
		setModeOfPaymentBox.setBounds(118, 321, 69, 25);
		firstPanel.add(setModeOfPaymentBox);
		
		firstPanel.setLayout(null);
		firstPanel.add(setFlightTypeBoxLabel);
		firstPanel.add(setFlightTypeBox);
		firstPanel.add(setAirlineBoxLabel);
		firstPanel.add(setAirlineBox);
		firstPanel.add(setTripTypeBoxLabel);
		firstPanel.add(setTripTypeBox);
		firstPanel.add(setOriginBoxLabel);
		firstPanel.add(setOriginBox);
		firstPanel.add(setDestinationLabel);
		firstPanel.add(setDestinationBox);
		firstPanel.add(setScheduleBoxLabel);
		firstPanel.add(setScheduleBox);
		firstPanel.add(setClassTypeBoxLabel);
		firstPanel.add(setClassTypeBox);
		
		
		//Text Fields
		setNumberOfPassengersTextField = new JTextField();
		
		setNumberOfPassengersTextField.setBounds(154, 229, 114, 20);
		
		firstPanel.add(setNumberOfPassengersTextField);	
		setNumberOfPassengersTextField.setColumns(10);
	
		setNumberOfInfantsTextField = new JTextField();
		setNumberOfInfantsLabel.setLabelFor(setNumberOfInfantsTextField);
		setNumberOfInfantsTextField.setBounds(12, 284, 66, 20);
		firstPanel.add(setNumberOfInfantsTextField);
		setNumberOfInfantsTextField.setColumns(10);
		
		setNumberOfAdultsTextField = new JTextField();
		setNumberOfAdultsLabel.setLabelFor(setNumberOfAdultsTextField);
		setNumberOfAdultsTextField.setColumns(10);
		setNumberOfAdultsTextField.setBounds(97, 284, 66, 20);
		firstPanel.add(setNumberOfAdultsTextField);
		
		setNumberOfSeniorCitizensTextField = new JTextField();
		setNumberOfSeniorCitizenLabel.setLabelFor(setNumberOfSeniorCitizensTextField);
		setNumberOfSeniorCitizensTextField.setColumns(10);
		setNumberOfSeniorCitizensTextField.setBounds(185, 284, 66, 20);
		firstPanel.add(setNumberOfSeniorCitizensTextField);
		setBankAccountName = new JTextField();
		setBankAccountName.setBounds(122, 10, 114, 20);
		secondPanel.add(setBankAccountName);
		setBankAccountName.setColumns(10);
		
		
		
		
		
		
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		rightTextArea = new JTextArea();
		rightTextArea.setEditable(false);
		rightTextArea.setLineWrap(false);
		rightTextArea.setBackground(new Color(241,241,241));
		rightTextArea.setWrapStyleWord(true);
		rightTextArea.setBorder(blackline);
		rightTextArea.setBounds(297, 5, 475, 542);
		mainPanel.add(rightTextArea);
		
		//Buttons
		backButton = new JButton("Back");
		backButton.setBounds(47, 556, 98, 26);
		secondPanel.add(backButton);
		
		nextButton = new JButton("Next");
		
		nextButton.setBounds(627, 559, 98, 26);
		mainPanel.add(nextButton);
	}
	
	private void createEvents()
	{
		nextButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(firstPanel.getParent() == layeredPane)
				{
					try
					{
						numberOfPassengers = Integer.parseInt(setNumberOfPassengersTextField.getText());
						numberOfInfants = Integer.parseInt(setNumberOfInfantsTextField.getText());
						numberOfAdults = Integer.parseInt(setNumberOfAdultsTextField.getText());
						numberOfSeniorCitizens = Integer.parseInt(setNumberOfSeniorCitizensTextField.getText());
						
						int totalPassengers =  numberOfInfants + numberOfAdults + numberOfSeniorCitizens;
					
						if(numberOfPassengers > 200)
						{
							JOptionPane.showMessageDialog(null,"Number of Passengers should not exceed 200");
						}
						else if (numberOfPassengers < 0)
						{
							JOptionPane.showMessageDialog(null,"Number of Passengers should not be less than 0");
						}
						else if (numberOfPassengers == 0)
						{
							JOptionPane.showMessageDialog(null,"Number of Passengers should not be set to 0");
							
						}
						else if (totalPassengers != numberOfPassengers)
						{
							JOptionPane.showMessageDialog(null,"Total passengers error");
						}
						else 
						{
							rightTextArea.setText("Flight Type: "+ setFlightTypeBox.getSelectedItem() + "\n"+ "Airlines: " + setAirlineBox.getSelectedItem() + "\n" + "Trip Type: " + 
						    setTripTypeBox.getSelectedItem() + "\n" + "Origin: " + setOriginBox.getSelectedItem() + "\n" + "Destination: " + setDestinationBox.getSelectedItem() + "\n" +
							"Schedule: " + setScheduleBox.getSelectedItem() + "\n" + "Class Type: " + setClassTypeBox.getSelectedItem() + "\n" + "Number Of Passengers: " + 
						    setNumberOfPassengersTextField.getText() + "\n" + "Infants: " + numberOfInfants + "\n" + "Adults: " + numberOfAdults + "\n" + "Senior Citizen: " + 
							numberOfSeniorCitizens + "\n" + "Mode of Payment: " + setModeOfPaymentBox.getSelectedItem() + "\n"
							);
							numberOfInfants = 0;
							numberOfAdults = 0;
							numberOfSeniorCitizens = 0;
							
							switchPanels(secondPanel, layeredPane);
						}
						
					}
					catch(Exception NumberFormatException)
					{
	
						if (NumberFormatException != null && checkStringForLetters(setNumberOfPassengersTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Passengers must only contain numbers");
						}
						else if(NumberFormatException != null  && numberOfPassengers == 0)
						{
							JOptionPane.showMessageDialog(null, "Number of Passengers should not be empty");
						}
						else if (NumberFormatException != null && checkStringForLetters(setNumberOfInfantsTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Infants must only contain numbers");
						}
						else if (NumberFormatException != null  && numberOfInfants == 0 && setNumberOfInfantsTextField.getText() != "0")
						{
							JOptionPane.showMessageDialog(null, "Number of Infants should not be empty");
						}
						else if (NumberFormatException != null && checkStringForLetters(setNumberOfAdultsTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Adults must only contain numbers");
						}
						else if (NumberFormatException != null  && numberOfAdults == 0 && setNumberOfAdultsTextField.getText() != "0")
						{
							JOptionPane.showMessageDialog(null, "Number of Adults should not be empty");
						}
						else if (NumberFormatException != null && checkStringForLetters(setNumberOfSeniorCitizensTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Senior Citizens must only contain numbers");
						}
						else if (NumberFormatException != null  && numberOfSeniorCitizens == 0 && setNumberOfSeniorCitizensTextField.getText() != "0")
						{
							JOptionPane.showMessageDialog(null, "Number of Senior Citizen should not be empty");
						}
//						else if(NumberFormatException != null && Pattern.matches("[a-zA-Z0-9]{1,}", setNumberOfInfantsTextField.getText()) == true)
//						{
//							JOptionPane.showMessageDialog(null, "Number of Infants must only contain numbers");
//						}
//						else if(NumberFormatException != null && Pattern.matches("[a-zA-Z0-9]{1,}", setNumberOfSeniorCitizensTextField.getText()) == true)
//						{
//							JOptionPane.showMessageDialog(null, "Number of Senior Citizens must only contain numbers");
//						}
//							
					}
						
					
					//JOptionPane.showMessageDialog(null,textField.getText());
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Could Not Switch Pane");
				}
					
			}
		});
		
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(firstPanel, layeredPane);
			}
		});
		
		setFlightTypeBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (setFlightTypeBox.getSelectedItem() == "International")
				{
					setAirlineBox.setModel(new DefaultComboBoxModel<String>(internationalAirlineChoices));
				}
				if (setFlightTypeBox.getSelectedItem() == "Local")
				{
					setAirlineBox.setModel(new DefaultComboBoxModel<String>(localAirlineChoices));
				}
			}
		});
	}
	boolean checkStringForLetters(String s) 
	{
	    if (s == null)
	    {
	    	return false;
	    }
	    int len = s.length();
	    for (int i = 0; i < len; i++) 
	    {
	    	if ((Character.isLetter(s.charAt(i)) == true)) 
	        {
	            return true;
	        }
	    }
	    return false;
	}
}