import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import lombok.Getter;

@Getter
public class FlightDetails 
{
	
	private	 JLabel setFlightDetailsLabel, setFlightTypeBoxLabel, setAirlineBoxLabel, setTripTypeBoxLabel, setOriginBoxLabel, setDestinationBoxLabel, setScheduleBoxLabel, setClassTypeBoxLabel, 
				   setNumberOfPassengersTextFieldLabel, setNumberOfInfantsTextFieldLabel, setNumberOfAdultsTextFieldLabel, setNumberOfSeniorCitizensTextFieldLabel, setModeOfPaymentBoxLabel;
	
	private  JTextField setNumberOfPassengersTextField, setNumberOfInfantsTextField, setNumberOfAdultsTextField, setNumberOfSeniorCitizensTextField;
	
	private  JComboBox<String> setFlightTypeBox, setAirlineBox, setTripTypeBox, setOriginBox, setDestinationBox, setScheduleBox, setClassTypeBox, setModeOfPaymentBox;
	
	private  JButton setNextButton, setCheckPricesButton, setBackButton, minimizeButton, exitButton;
	
	private  String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "Kansai Intl. Airport", 
    				 "Hiroshima Airport", "Dunhuang Airport", "Beijing Capital Intl. Airport", "Taipei Songshan Airport", "Tainan Airport", "Daegu Int'l. Airport", 
    				 "Jeju Int'l. Airport", "Banyuwangi Int'l Airport", "Hang Nadim Int'l Airport"},
					  localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"},
					  classTypeChoices = {"Economy", "Premium", "Business"},
					  flightTypeChoices = { "Local", "International"},
					  tripTypeChoices = {"One-Way Trip", "Round Trip"},
					  modeOfPaymentChoices = {"Credit","Debit", "GCash"};
	
	private	int numberOfPassengers, numberOfInfants, numberOfAdults, numberOfSeniorCitizens;
	
	//Constructor
	public FlightDetails()
	{
		setFlightTypeBox = new JComboBox<String>();
		setOriginBox = new JComboBox<String>();
		setDestinationBox = new JComboBox<String>();
		setTripTypeBox = new JComboBox<String>();
		setAirlineBox = new JComboBox<String>();
		setScheduleBox = new JComboBox<String>();
		setClassTypeBox = new JComboBox<String>();
		setModeOfPaymentBox = new JComboBox<String>();
		
		setFlightDetailsLabel = new JLabel("Flight Details");
		setFlightTypeBoxLabel = new JLabel("Flight Type");
		setOriginBoxLabel = new JLabel("Origin");
		setDestinationBoxLabel = new JLabel("Destination");
		setTripTypeBoxLabel = new JLabel("Trip Type");
		setAirlineBoxLabel = new JLabel("Airlines");
		setScheduleBoxLabel = new JLabel("Schedule");
		setClassTypeBoxLabel = new JLabel("Class Type");
		setNumberOfPassengersTextFieldLabel = new JLabel("Number Of Passengers");
		setNumberOfInfantsTextFieldLabel = new JLabel("Infants");
		setNumberOfAdultsTextFieldLabel = new JLabel("Adults");
		setNumberOfSeniorCitizensTextFieldLabel = new JLabel("Senior Citizen");
		setModeOfPaymentBoxLabel = new JLabel("Mode of Payment");
		
		setNumberOfPassengersTextField = new JTextField();
		setNumberOfInfantsTextField = new JTextField();
		setNumberOfAdultsTextField = new JTextField();
		setNumberOfSeniorCitizensTextField = new JTextField();
		
		setNextButton = new JButton("Next");
		setCheckPricesButton = new JButton("Check Prices");
		setBackButton = new JButton("Back");
		exitButton = new JButton();
		minimizeButton = new JButton();	
	}
	
	// Initialization
	public void setFlightDetails(Component component)
	{
		setFlightDetailsLabel.setLabelFor(component);
		setFlightDetailsLabel.setBounds(304, 28, 174, 35);
		setFlightDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 27));	
	}
	
	public void setFlightTypeBox()
	{
		setFlightTypeBox.setFocusable(false);
		setFlightTypeBox.setBounds(432, 111, 225, 30);		
		setFlightTypeBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setFlightTypeBox.setModel(new DefaultComboBoxModel<String>(flightTypeChoices));
		
		setFlightTypeBoxLabel.setLabelFor(setFlightTypeBox);
		setFlightTypeBoxLabel.setBounds(130, 114, 120, 25);
		setFlightTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setOriginBox()
	{
		String[] originChoices = {"EMPTY"};
		
		setOriginBox.setFocusable(false);
		setOriginBox.setBounds(432, 141, 225, 30);
		setOriginBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setOriginBox.setModel(new DefaultComboBoxModel<String>(originChoices));
		
		setOriginBoxLabel.setLabelFor(setOriginBox);
		setOriginBoxLabel.setBounds(130, 144, 120, 25);
		setOriginBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setDestinationBox()
	{
		String[] destinationChoices = {"EMPTY"};
		
		setDestinationBox.setFocusable(false);
		setDestinationBox.setBounds(432, 171, 225, 30);
		setDestinationBox.setFont(new Font("Dialog", Font.BOLD, 21));	
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(destinationChoices));
		
		setDestinationBoxLabel.setLabelFor(setDestinationBox);
		setDestinationBoxLabel.setBounds(130, 174, 120, 25);
		setDestinationBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setTripTypeBox()
	{	
		setTripTypeBox.setFocusable(false);
		setTripTypeBox.setBounds(432, 201, 225, 30);
		setTripTypeBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
		
		setTripTypeBoxLabel.setLabelFor(setTripTypeBox);
		setTripTypeBoxLabel.setBounds(130, 204, 120, 25);
		setTripTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setAirlineBox()
	{
		setAirlineBox.setFocusable(false);
		setAirlineBox.setBounds(432, 231, 225, 30);
		setAirlineBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setAirlineBox.setModel(new DefaultComboBoxModel<String>(localAirlineChoices));
		
		setAirlineBoxLabel.setLabelFor(setAirlineBox);
		setAirlineBoxLabel.setBounds(130, 234, 120, 25);
		setAirlineBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setScheduleBox()
	{
		String[] scheduleChoices = {"EMPTY"};
		
		setScheduleBox.setFocusable(false);
		setScheduleBox.setBounds(432, 261, 225, 30);
		setScheduleBox.setFont(new Font("Dialog", Font.BOLD, 21));		
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(scheduleChoices));
		
		setScheduleBoxLabel.setLabelFor(setScheduleBox);
		setScheduleBoxLabel.setBounds(130, 264, 120, 25);
		setScheduleBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setClassTypeBox()
	{
		setClassTypeBox.setFocusable(false);
		setClassTypeBox.setBounds(432, 291, 225, 30);
		setClassTypeBox.setFont(new Font("Dialog", Font.BOLD, 21));	
		setClassTypeBox.setModel(new DefaultComboBoxModel<String>(classTypeChoices));
		
		setClassTypeBoxLabel.setLabelFor(setClassTypeBox);
		setClassTypeBoxLabel.setBounds(130, 294, 120, 25);
		setClassTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setNumberOfPassengersTextField()
	{	
		setNumberOfPassengersTextField.setBounds(432, 321, 225, 30);
		setNumberOfPassengersTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		setNumberOfPassengersTextField.setColumns(10);
		
		setNumberOfPassengersTextFieldLabel.setLabelFor(setNumberOfPassengersTextField);
		setNumberOfPassengersTextFieldLabel.setBounds(130, 324, 243, 25);
		setNumberOfPassengersTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setNumberOfInfantsTextField()
	{
		setNumberOfInfantsTextField.setBounds(161, 388, 101, 30);
		setNumberOfInfantsTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		setNumberOfInfantsTextField.setColumns(10);
		
		setNumberOfInfantsTextFieldLabel.setLabelFor(setNumberOfInfantsTextField);
		setNumberOfInfantsTextFieldLabel.setBounds(173, 351, 77, 24);
		setNumberOfInfantsTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setNumberOfAdultsTextField()
	{
		setNumberOfAdultsTextField.setBounds(304, 388, 97, 30);
		setNumberOfAdultsTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		setNumberOfAdultsTextField.setColumns(10);
		
		setNumberOfAdultsTextFieldLabel.setLabelFor(setNumberOfAdultsTextField);
		setNumberOfAdultsTextFieldLabel.setBounds(321, 352, 65, 24);
		setNumberOfAdultsTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setNumberOfSeniorCitizenTextField()
	{
		setNumberOfSeniorCitizensTextField.setBounds(452, 388, 110, 30);
		setNumberOfSeniorCitizensTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		setNumberOfSeniorCitizensTextField.setColumns(10);
		
		setNumberOfSeniorCitizensTextFieldLabel.setLabelFor(setNumberOfSeniorCitizensTextField);
		setNumberOfSeniorCitizensTextFieldLabel.setBounds(442, 351, 151, 24);
		setNumberOfSeniorCitizensTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setModeOfPaymentBox()
	{
		setModeOfPaymentBox.setFocusable(false);
		setModeOfPaymentBox.setBounds(432, 433, 225, 30);
		setModeOfPaymentBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(modeOfPaymentChoices));
		
		setModeOfPaymentBoxLabel.setLabelFor(setModeOfPaymentBox);
		setModeOfPaymentBoxLabel.setBounds(130, 433, 183, 25);
		setModeOfPaymentBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setNextButton()
	{
		setNextButton.setFocusPainted(false);
		setNextButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setNextButton.setBounds(619, 550, 108, 26);
	}
	
	public void setCheckPricesButton()
	{
		setCheckPricesButton.setFocusPainted(false);
		setCheckPricesButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setCheckPricesButton.setBounds(280, 550, 200, 26);
	}
	
	public void setBackButton()
	{
		setBackButton.setFocusPainted(false);
		setBackButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setBackButton.setBounds(58, 550, 98, 28);
	}
	
	public void setMinimizeButton()
	{
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBounds(719, 0, 40, 35);
		minimizeButton.setOpaque(true);
		minimizeButton.setContentAreaFilled(true);
		minimizeButton.setBackground(Color.WHITE);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/-.png")));	
	}
	
	public void setExitButton()
	{
		exitButton.setFocusable(false);
		exitButton.setFocusPainted(false);
		exitButton.setBounds(760, 0, 40, 35);
		exitButton.setOpaque(true);
		exitButton.setContentAreaFilled(true);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorderPainted(false);
		exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/x.png")));	
	}
	
	public void setNumberOfPassengers(int numberOfPassengers)
	{
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public void setNumberOfInfants(int numberOfInfants)
	{
		this.numberOfInfants = numberOfInfants;
	}
	
	public void setNumberOfAdults(int numberOfAdults)
	{
		this.numberOfAdults = numberOfAdults;
	}
	
	public void setNumberOfSeniorCitizens(int numberOfSeniorCitizens)
	{
		this.numberOfSeniorCitizens = numberOfSeniorCitizens;
	}
	
	// Other methods
	public int parseNumberOfPassengersToInt()
	{
		try
		{
			numberOfPassengers = Integer.parseInt(setNumberOfPassengersTextField.getText());	
		}
		catch(Exception NumberFormatException)
		{	
			if (NumberFormatException != null && setNumberOfPassengersTextField.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Number of Passengers is empty");
			}
		}
		return numberOfPassengers;
	}
	
	public void parseNumberOfInfantsToInt()
	{
		numberOfInfants = Integer.parseInt(setNumberOfInfantsTextField.getText());		
	}
	
	public void parseNumberOfAdultsToInt()
	{		
		numberOfAdults = Integer.parseInt(setNumberOfAdultsTextField.getText());				
	}
	
	public void parseNumberOfSeniorCitizensToInt()
	{		
		numberOfSeniorCitizens = Integer.parseInt(setNumberOfSeniorCitizensTextField.getText());				
	}
	
	protected boolean checkStringForLetters(String s) 
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