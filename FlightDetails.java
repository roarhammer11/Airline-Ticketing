import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import lombok.Getter;
import resources.ImageButton;
import resources.JComboBoxUI;

@Getter
public class FlightDetails extends Schedule
{
	private  JTextField setNumberOfPassengersTextField, setNumberOfInfantsTextField, setNumberOfAdultsTextField, setNumberOfSeniorCitizensTextField;
	
	private  JComboBox<String> setFlightTypeBox, setAirlineBox, setTripTypeBox, setOriginBox, setDestinationBox, setScheduleBox, setClassTypeBox, setModeOfPaymentBox;
	
	private  JButton setNextButton, setCheckPricesButton, setBackButton, minimizeButton, exitButton;
	
	private  String[] airlineChoices = {"PHILIPPINE AIRLINES", "AIRASIA PHILIPPINES", "CEBU PACIFIC", "QATAR AIRWAYS", "SAUDI AIRLINES SAUDIA"},
					  localOriginDestinationChoices = {"NAIA", "MCIA", "DIA"},
					  internationalOriginDestinationChoices = {"KIA", "HA", "D INT'L AIRPORT", "JEJU INT'L AIRPORT", "TSA", "TA"},
					  classTypeChoices = {"ECONOMY", "PREMIUM", "BUSINESS"},
					  flightTypeChoices = { "LOCAL", "INTERNATIONAL"},
					  tripTypeChoices = {"ONE-WAY TRIP", "ROUND TRIP"},
					  modeOfPaymentChoices = {"CREDIT CARD","DEBIT CARD", "GCASH"};
	
	private	int numberOfPassengers, numberOfInfants, numberOfAdults, numberOfSeniorCitizens;
	
	
	private Color skyBlue = new Color(106, 218, 255);
	
	private Border lineBorder, empty, border;
	
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
		
		setNumberOfPassengersTextField = new JTextField();
		setNumberOfInfantsTextField = new JTextField();
		setNumberOfAdultsTextField = new JTextField();
		setNumberOfSeniorCitizensTextField = new JTextField();
		
		setNextButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/next.png"))
	              .getImage(), 149, 30);
		setCheckPricesButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/check prices.png"))
	              .getImage(), 150, 30);
		setBackButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/back.png"))
	              .getImage(), 149, 30);
		
		exitButton = new JButton();
		
		minimizeButton = new JButton();	
		
		 lineBorder = new LineBorder(skyBlue, 1, true);
		 empty = new EmptyBorder(0, 40, 0, 0);
		 border = new CompoundBorder(lineBorder, empty);
	}
	
	// Initialization
	
	public void setFlightTypeBox()
	{
		setFlightTypeBox.setUI(new JComboBoxUI());
		setFlightTypeBox.setFocusable(false);
		setFlightTypeBox.setBounds(230, 263, 312, 25);
		setFlightTypeBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setFlightTypeBox.setBackground(skyBlue);
		setFlightTypeBox.setForeground(Color.WHITE);
		setFlightTypeBox.setModel(new DefaultComboBoxModel<String>(flightTypeChoices));		
	}
	
	public void setOriginBox()
	{
		setOriginBox.setUI(new JComboBoxUI());
		setOriginBox.setFocusable(false);
		setOriginBox.setBounds(230, 296, 312, 25);
		setOriginBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setOriginBox.setBackground(skyBlue);
		setOriginBox.setForeground(Color.WHITE);;
		setOriginBox.setModel(new DefaultComboBoxModel<String>(localOriginDestinationChoices));		
	}
	
	public void setDestinationBox()
	{
		setDestinationBox.setUI(new JComboBoxUI());
		setDestinationBox.setFocusable(false);
		setDestinationBox.setBounds(230, 329, 312, 25);
		setDestinationBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setDestinationBox.setBackground(skyBlue);
		setDestinationBox.setForeground(Color.WHITE);
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(localOriginDestinationChoices));
		setDestinationBox.setSelectedIndex(1);
	}
	
	public void setTripTypeBox()
	{	
		setTripTypeBox.setUI(new JComboBoxUI());
		setTripTypeBox.setFocusable(false);
		setTripTypeBox.setBounds(230, 362, 312, 25);
		setTripTypeBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setTripTypeBox.setBackground(skyBlue);
		setTripTypeBox.setForeground(Color.WHITE);
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
	}
	
	public void setAirlineBox()
	{
		setAirlineBox.setUI(new JComboBoxUI());
		setAirlineBox.setFocusable(false);
		setAirlineBox.setBounds(230, 395, 312, 25);
		setAirlineBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setAirlineBox.setBackground(skyBlue);
		setAirlineBox.setForeground(Color.WHITE);
		setAirlineBox.setModel(new DefaultComboBoxModel<String>(airlineChoices));
	}
	
	public void setScheduleBox()
	{
		setScheduleBox.setUI(new JComboBoxUI());
		setScheduleBox.setFocusable(false);
		setScheduleBox.setBounds(230, 428, 312, 25);
		setScheduleBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setScheduleBox.setBackground(skyBlue);
		setScheduleBox.setForeground(Color.WHITE);	
		String [] schedule = new String[] {"DAILY 8:00AM - 9:20AM"} ;	
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(schedule));
	}
	
	public void setClassTypeBox()
	{
		setClassTypeBox.setUI(new JComboBoxUI());
		setClassTypeBox.setFocusable(false);
		setClassTypeBox.setBounds(230, 461, 312, 25);
		setClassTypeBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setClassTypeBox.setBackground(skyBlue);
		setClassTypeBox.setForeground(Color.WHITE);
		setClassTypeBox.setModel(new DefaultComboBoxModel<String>(classTypeChoices));
	}
	
	public void setNumberOfPassengersTextField()
	{	
		setNumberOfPassengersTextField.setBorder(border);
		setNumberOfPassengersTextField.setBounds(344, 490, 101, 30);
		setNumberOfPassengersTextField.setFont(new Font("Malgun gothic semilight", Font.BOLD, 20));
		setNumberOfPassengersTextField.setForeground(skyBlue);
		setNumberOfPassengersTextField.setText("0");
		setNumberOfPassengersTextField.setColumns(10);
	}
	
	public void setNumberOfInfantsTextField()
	{
		setNumberOfInfantsTextField.setBorder(border);	
		setNumberOfInfantsTextField.setBounds(344, 526, 101, 30);
		setNumberOfInfantsTextField.setFont(new Font("Malgun gothic semilight", Font.BOLD, 20));
		setNumberOfInfantsTextField.setForeground(skyBlue);
		setNumberOfInfantsTextField.setText("0");
		setNumberOfInfantsTextField.setColumns(10);
	}
	
	public void setNumberOfAdultsTextField()
	{
		setNumberOfAdultsTextField.setBorder(border);	
		setNumberOfAdultsTextField.setBounds(344, 562, 101, 30);
		setNumberOfAdultsTextField.setFont(new Font("Malgun gothic semilight", Font.BOLD, 20));
		setNumberOfAdultsTextField.setForeground(skyBlue);
		setNumberOfAdultsTextField.setText("0");
		setNumberOfAdultsTextField.setColumns(10);
	}
	
	public void setNumberOfSeniorCitizenTextField()
	{
		setNumberOfSeniorCitizensTextField.setBorder(border);	
		setNumberOfSeniorCitizensTextField.setBounds(344, 598, 101, 30);
		setNumberOfSeniorCitizensTextField.setFont(new Font("Malgun gothic semilight", Font.BOLD, 20));
		setNumberOfSeniorCitizensTextField.setForeground(skyBlue);
		setNumberOfSeniorCitizensTextField.setText("0");
		setNumberOfSeniorCitizensTextField.setColumns(10);
	}
	
	public void setModeOfPaymentBox()
	{
		setModeOfPaymentBox.setUI(new JComboBoxUI());
		setModeOfPaymentBox.setFocusable(false);
		setModeOfPaymentBox.setBounds(230, 678, 312, 25);
		setModeOfPaymentBox.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setModeOfPaymentBox.setBackground(skyBlue);
		setModeOfPaymentBox.setForeground(Color.WHITE);
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(modeOfPaymentChoices));
	}
	
	public void setNextButton()
	{
		setNextButton.setFocusPainted(false);
		setNextButton.setOpaque(false);
		setNextButton.setContentAreaFilled(false);
		setNextButton.setBorderPainted(false);
		setNextButton.setBounds(398, 749, 149, 30);
	}
	
	public void setCheckPricesButton()
	{
		setCheckPricesButton.setFocusPainted(false);
		setCheckPricesButton.setOpaque(false);
		setCheckPricesButton.setContentAreaFilled(false);
		setCheckPricesButton.setBorderPainted(false);
		setCheckPricesButton.setBounds(207, 748, 150, 30);
	}
	
	public void setBackButton()
	{
		setBackButton.setFocusPainted(false);
		setBackButton.setOpaque(false);
		setBackButton.setContentAreaFilled(false);
		setBackButton.setBorderPainted(false);
		setBackButton.setBounds(14, 748, 149, 30);
	}
	
	public void setExitButton()
	{
		exitButton.setFocusPainted(false);
		exitButton.setBounds(515, 15, 40, 35);
		exitButton.setOpaque(true);
		exitButton.setContentAreaFilled(true);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorderPainted(false);
		exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/x.png")));	
	}
	
	public void setMinimizeButton()
	{
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBounds(475, 15, 40, 35);
		minimizeButton.setOpaque(true);
		minimizeButton.setContentAreaFilled(true);
		minimizeButton.setBackground(Color.WHITE);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/-.png")));	
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
	
	public int parseNumberOfInfantsToInt(String numberOfInfantsTextField)
	{
		return Integer.parseInt(numberOfInfantsTextField);		
	}
	
	public int parseNumberOfAdultsToInt(String numberOfAdultsTextField)
	{		
		return Integer.parseInt(numberOfAdultsTextField);				
	}
	
	public int parseNumberOfSeniorCitizensToInt(String numberOfSeniorCitizensTextField)
	{		
		return Integer.parseInt(numberOfSeniorCitizensTextField);				
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