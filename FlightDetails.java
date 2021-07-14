import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FlightDetails 
{
	
	private JLabel setFlightDetailsLabel, setFlightTypeBoxLabel, setAirlineBoxLabel, setTripTypeBoxLabel, setOriginBoxLabel, setDestinationBoxLabel, setScheduleBoxLabel, setClassTypeBoxLabel, 
				   setNumberOfPassengersTextFieldLabel, setNumberOfInfantsTextFieldLabel, setNumberOfAdultsTextFieldLabel, setNumberOfSeniorCitizensTextFieldLabel, setModeOfPaymentBoxLabel;
	
	private JTextField setNumberOfPassengersTextField, setNumberOfInfantsTextField, setNumberOfAdultsTextField, setNumberOfSeniorCitizensTextField;
	
	private JComboBox<String> setFlightTypeBox, setAirlineBox, setTripTypeBox, setOriginBox, setDestinationBox, setScheduleBox, setClassTypeBox, setModeOfPaymentBox;
	
	private JButton setNextButton, setCheckPricesButton, setBackButton;
	
	private String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "Kansai Intl. Airport", 
    				 "Hiroshima Airport", "Dunhuang Airport", "Beijing Capital Intl. Airport", "Taipei Songshan Airport", "Tainan Airport", "Daegu Int'l. Airport", 
    				 "Jeju Int'l. Airport", "Banyuwangi Int'l Airport", "Hang Nadim Int'l Airport"},
					  localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"},
					  classTypeChoices = {"Business", "Economy", "Premium"},
					  flightTypeChoices = { "Local", "International"},
					  tripTypeChoices = {"One-Way Trip", "Round Trip"},
					  modeOfPaymentChoices = {"Credit","Debit", "GCash"};
	
	private int numberOfPassengers, numberOfInfants, numberOfAdults, numberOfSeniorCitizens;
	
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
		
		setDestinationBox.setBounds(432, 171, 225, 30);
		setDestinationBox.setFont(new Font("Dialog", Font.BOLD, 21));	
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(destinationChoices));
		
		setDestinationBoxLabel.setLabelFor(setDestinationBox);
		setDestinationBoxLabel.setBounds(130, 174, 120, 25);
		setDestinationBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setTripTypeBox()
	{
		
		setTripTypeBox.setBounds(432, 201, 225, 30);
		setTripTypeBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
		
		setTripTypeBoxLabel.setLabelFor(setTripTypeBox);
		setTripTypeBoxLabel.setBounds(130, 204, 120, 25);
		setTripTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setAirlineBox()
	{
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
		
		setScheduleBox.setBounds(432, 261, 225, 30);
		setScheduleBox.setFont(new Font("Dialog", Font.BOLD, 21));		
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(scheduleChoices));
		
		setScheduleBoxLabel.setLabelFor(setScheduleBox);
		setScheduleBoxLabel.setBounds(130, 264, 120, 25);
		setScheduleBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setClassTypeBox()
	{
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
		setModeOfPaymentBox.setBounds(432, 433, 225, 30);
		setModeOfPaymentBox.setFont(new Font("Dialog", Font.BOLD, 21));
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(modeOfPaymentChoices));
		
		setModeOfPaymentBoxLabel.setLabelFor(setModeOfPaymentBox);
		setModeOfPaymentBoxLabel.setBounds(130, 433, 183, 25);
		setModeOfPaymentBoxLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setNextButton()
	{
		setNextButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setNextButton.setBounds(619, 550, 108, 26);
	}
	
	public void setCheckPricesButton()
	{
		setCheckPricesButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setCheckPricesButton.setBounds(280, 550, 200, 26);
	}
	
	public void setBackButton()
	{
		setBackButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setBackButton.setBounds(58, 550, 98, 28);
	}
	
	// Get Generic String Boxes
	public JComboBox<String> getSetFlightTypeBox()
	{
		return setFlightTypeBox;
	}
	
	public JComboBox<String> getSetAirlineBox()
	{
		return setAirlineBox;
	}
	
	public JComboBox<String> getSetTripTypeBox()
	{
		return setTripTypeBox;
	}
	
	public JComboBox<String> getSetOriginBox()
	{
		return setOriginBox;
	}
	
	public JComboBox<String> getSetDestinationBox()
	{
		return setDestinationBox;
	}
	
	public JComboBox<String> getSetScheduleBox()
	{
		return setScheduleBox;
	}
	
	public JComboBox<String> getSetClassTypeBox()
	{
		return setClassTypeBox;
	}
	
	public JComboBox<String> getSetModeOfPaymentBox()
	{
		return setModeOfPaymentBox;
	}
	
	// Get TextFields
	public JTextField getSetNumberOfPassengersTextField()
	{
		return setNumberOfPassengersTextField;
	}
	
	public JTextField getSetNumberOfInfantsTextField()
	{
		return setNumberOfInfantsTextField;
	}
	
	public JTextField getSetNumberOfAdultsTextField()
	{
		return setNumberOfAdultsTextField;
	}
	
	public JTextField getSetNumberOfSeniorCitizensTextField()
	{
		return setNumberOfSeniorCitizensTextField;
	}
	
	// Get Labels
	public JLabel getFlightDetailsLabel()
	{
		return setFlightDetailsLabel;
	}
	
	public JLabel getSetFlightTypeBoxLabel()
	{
		return setFlightTypeBoxLabel;
	}
	
	public JLabel getSetAirlineBoxLabel()
	{
		return setAirlineBoxLabel;
	}
	
	public JLabel getSetTripTypeBoxLabel()
	{
		return setTripTypeBoxLabel;
	}
	public JLabel getSetOriginBoxLabel()
	{
		return setOriginBoxLabel;
	}
	
	public JLabel getSetDestinationBoxLabel()
	{
		return setDestinationBoxLabel;
	}
	
	public JLabel getSetScheduleBoxLabel()
	{
		return setScheduleBoxLabel;
	}
	
	public JLabel getSetClassTypeBoxLabel()
	{
		return setClassTypeBoxLabel;
	}
	
	public JLabel getSetNumberOfPassengersTextFieldLabel()
	{
		return setNumberOfPassengersTextFieldLabel;
	}
	
	public JLabel getSetNumberOfInfantsTextFieldLabel()
	{
		return setNumberOfInfantsTextFieldLabel;
	}
	
	public JLabel getSetNumberOfAdultsTextFieldLabel()
	{
		return setNumberOfAdultsTextFieldLabel;
	}
	
	public JLabel getSetNumberOfSeniorCitizensTextFieldLabel()
	{
		return setNumberOfSeniorCitizensTextFieldLabel;
	}
	
	public JLabel getSetModeOfPaymentBoxLabel()
	{
		return setModeOfPaymentBoxLabel;
	}
	
	// Get Buttons
	public JButton getSetNextButton()
	{
		return setNextButton;
	}
	
	public JButton getSetCheckPricesButton()
	{
		return setCheckPricesButton;
	}
	
	public JButton getSetBackButton()
	{
		return setBackButton;
	}
	
	// Get Array of Strings
	public String[] getInternationalAirlineChoices()
	{
		return internationalAirlineChoices;
	}
	
	public String[] getLocalAirlineChoices()
	{
		return localAirlineChoices;
	}
	
	public String[] getClassTypeChoices()
	{
		return classTypeChoices;
	}
	
	public String[] getFlightTypeChoices()
	{
		return flightTypeChoices;
	}
	
	public String[] getTripTypeChoices()
	{
		return tripTypeChoices;
	}
	
	public String[] getmodeOfPaymentChoices()
	{
		return modeOfPaymentChoices;
	}
	
	// Get Integers
	public int getNumberOfPassengers()
	{
		return numberOfPassengers;
	}
	
	public int getNumberOfInfants()
	{
		return numberOfInfants;
	}
	
	public int getNumberOfAdults()
	{
		return numberOfAdults;
	}
	
	public int getNumberOfSeniorCitizens()
	{
		return numberOfSeniorCitizens;
	}
	
	// Other methods
	public void parseNumberOfPassengersToInt()
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