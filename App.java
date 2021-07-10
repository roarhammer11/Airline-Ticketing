import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
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
import java.awt.Insets;

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
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;

@SuppressWarnings("serial")
public class App extends JFrame 
{
	//Instance Variables
	private JPanel mainPanel, firstPanel, secondPanel;

//	String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "Kansai Intl. Airport", 
//    		"Hiroshima Airport", "Dunhuang Airport", "Beijing Capital Intl. Airport", "Taipei Songshan Airport", "Tainan Airport", "Daegu Int'l. Airport", 
//    		"Jeju Int'l. Airport", "Banyuwangi Int'l Airport", "Hang Nadim Int'l Airport"},
//			localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"},
//			classTypeChoices = {"Business", "Economy", "Premium"},
//			flightTypeChoices = { "Local", "International"},
//			tripTypeChoices = {"One-Way Trip", "Round Trip"},
//			modeOfPayment = {"Credit","Debit", "GCash"};
	String print = "", temp = "";
	
	private JLayeredPane layeredPane;
	private JLabel   setOriginBoxLabel, setDestinationLabel, setScheduleBoxLabel, setClassTypeBoxLabel, 
				   setNumberOfPassengerBoxLabel, setNumberOfAdultsLabel, setNumberOfInfantsLabel, setNumberOfSeniorCitizenLabel, setModeOfPaymentBoxLabel;
	private JComboBox<String>    setOriginBox, setDestinationBox, setScheduleBox, setClassTypeBox, setModeOfPaymentBox;
	private JTextField setBankAccountName, setNumberOfPassengersTextField, setNumberOfInfantsTextField, setNumberOfAdultsTextField, setNumberOfSeniorCitizensTextField;
	private JButton backButton, nextButton;
	private int numberOfPassengers, numberOfInfants, numberOfAdults, numberOfSeniorCitizens;
	private JTextArea rightTextArea;
	private JLabel bankDetailsLabel;
	private JLabel setBankAccountNumberLabel;
	private JTextField setBankAccountNumber;
	private JTextField setBankAccountEmail;
	private JTextField setBankAccountPhoneNumber;
	private JLabel setBankAccountEmailLabel;
	private JLabel setBankAccountPhoneNumberLabel;	
	private JLabel flightDetailsLabel;
	private Receipt receipt = new Receipt();
	private FlightDetails flight = new FlightDetails();
	private BankDetails bank = new BankDetails();
	
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
	
	private void initializeComponent() 
	{
		// TODO Auto-generated method stub
		setResizable(false);
		setTitle("Airplane Ticketing System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/resources/213569889_535845414403206_7341132822717748611_n.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		setMinimumSize(new Dimension(800, 650));
		
		//Panels
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 347, 604);		
		firstPanel = new JPanel();		
		secondPanel = new JPanel();
		
		flight.setFlightTypeBox();
		flight.setAirlineBox();
		flight.setTripTypeBox();
		
		//Labels
		setClassTypeBoxLabel = new JLabel("Class Type");
		setClassTypeBoxLabel.setBounds(12, 291, 110, 25);
		setClassTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		setClassTypeBoxLabel.setLabelFor(setClassTypeBox);
		
		
		
		setOriginBoxLabel = new JLabel("Origin");
		setOriginBoxLabel.setBounds(12, 201, 97, 25);
		setOriginBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setDestinationLabel = new JLabel("Destination");
		setDestinationLabel.setBounds(12, 231, 97, 25);
		setDestinationLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setScheduleBoxLabel = new JLabel("Schedule");
		setScheduleBoxLabel.setBounds(12, 261, 97, 25);
		setScheduleBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setNumberOfPassengerBoxLabel = new JLabel("Number Of Passengers");
		setNumberOfPassengerBoxLabel.setBounds(12, 322, 163, 25);
		setNumberOfPassengerBoxLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		setNumberOfPassengerBoxLabel.setLabelFor(setNumberOfPassengersTextField);
		
		setNumberOfAdultsLabel = new JLabel("Adults");
		setNumberOfAdultsLabel.setBounds(131, 352, 50, 24);
		setNumberOfAdultsLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setNumberOfInfantsLabel = new JLabel("Infants");
		setNumberOfInfantsLabel.setBounds(33, 352, 53, 24);
		setNumberOfInfantsLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setNumberOfSeniorCitizenLabel = new JLabel("Senior Citizen");
		setNumberOfSeniorCitizenLabel.setBounds(215, 352, 110, 24);
		setNumberOfSeniorCitizenLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setModeOfPaymentBoxLabel = new JLabel("Mode of Payment");
		setModeOfPaymentBoxLabel.setBounds(12, 433, 142, 25);
		setModeOfPaymentBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		
			
		//Box
		setClassTypeBox = new JComboBox<String>();
		setClassTypeBox.setBounds(106, 291, 225, 25);
		setClassTypeBox.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setClassTypeBox.setModel(new DefaultComboBoxModel<String>(flight.getClassTypeChoices()));
		
		setDestinationBox = new JComboBox<String>();
		setDestinationBox.setBounds(106, 231, 225, 25);
		setDestinationBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setDestinationLabel.setLabelFor(setDestinationBox);
		String[] destinationChoices = {"EMPTY"};
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(destinationChoices));
		
		setOriginBox = new JComboBox<String>();
		setOriginBox.setBounds(106, 201, 225, 25);
		setOriginBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setOriginBoxLabel.setLabelFor(setOriginBox);
		String[] originChoices = {"EMPTY"};
		setOriginBox.setModel(new DefaultComboBoxModel<String>(originChoices));
		
		
		
		
		
		
		
		setScheduleBox = new JComboBox<String>();
		setScheduleBox.setBounds(106, 261, 225, 25);
		setScheduleBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setScheduleBoxLabel.setLabelFor(setScheduleBox);
		String[] scheduleChoices = {"EMPTY"};
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(scheduleChoices));
		
		setModeOfPaymentBox = new JComboBox<String>();
		setModeOfPaymentBox.setBounds(157, 433, 174, 25);
		setModeOfPaymentBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setModeOfPaymentBoxLabel.setLabelFor(setModeOfPaymentBox);
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(flight.getmodeOfPaymentChoices()));
			
		//Text Fields
		setNumberOfPassengersTextField = new JTextField();
		setNumberOfPassengersTextField.setBounds(180, 321, 151, 25);
		setNumberOfPassengersTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfPassengersTextField.setColumns(10);
	
		setNumberOfInfantsTextField = new JTextField();
		setNumberOfInfantsTextField.setBounds(33, 396, 70, 25);
		setNumberOfInfantsTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfInfantsLabel.setLabelFor(setNumberOfInfantsTextField);
		setNumberOfInfantsTextField.setColumns(10);
		
		setNumberOfAdultsTextField = new JTextField();
		setNumberOfAdultsTextField.setBounds(128, 396, 71, 25);
		setNumberOfAdultsTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfAdultsLabel.setLabelFor(setNumberOfAdultsTextField);
		setNumberOfAdultsTextField.setColumns(10);
		
		setNumberOfSeniorCitizensTextField = new JTextField();
		setNumberOfSeniorCitizensTextField.setBounds(224, 396, 71, 25);
		setNumberOfSeniorCitizensTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfSeniorCitizenLabel.setLabelFor(setNumberOfSeniorCitizensTextField);
		setNumberOfSeniorCitizensTextField.setColumns(10);
		
//		setBankAccountName = new JTextField();
//		setBankAccountName.setBounds(165, 109, 170, 28);
//		setBankAccountNameLabel.setLabelFor(setBankAccountName);
//		setBankAccountName.setColumns(10);
		bank.setBankAccountNameField();
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Border margin = new EmptyBorder(20, 20, 20, 20);
		rightTextArea = new JTextArea();
		rightTextArea.setBounds(370, 17, 405, 526);
		rightTextArea.setLineWrap(false);
		rightTextArea.setFont(new Font("Dialog", Font.PLAIN, 17));
		rightTextArea.setEditable(false);
		rightTextArea.setBackground(new Color(241,241,241));
		rightTextArea.setWrapStyleWord(true);
		rightTextArea.setBorder(new CompoundBorder(blackline,margin));
		
		//Buttons
		backButton = new JButton("Back");
		backButton.setBounds(75, 558, 98, 26);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.add(firstPanel, "name_20276457840900");
		
		flightDetailsLabel = new JLabel("Flight Details");
		flightDetailsLabel.setBounds(98, 34, 174, 35);
		flightDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		firstPanel.setLayout(null);
		firstPanel.add(flight.getSetFlightTypeBoxLabel());
		firstPanel.add(flight.getSetFlightTypeBox());	
		firstPanel.add(flight.getSetAirlineBoxLabel());
		firstPanel.add(flight.getSetAirlineBox());
		firstPanel.add(flight.getSetTripTypeBoxLabel());
		firstPanel.add(flight.getSetTripTypeBox());
		firstPanel.add(setOriginBoxLabel);
		firstPanel.add(setOriginBox);
		firstPanel.add(setDestinationLabel);
		firstPanel.add(setDestinationBox);
		firstPanel.add(setScheduleBoxLabel);
		firstPanel.add(setScheduleBox);
		firstPanel.add(setNumberOfInfantsLabel);
		firstPanel.add(setNumberOfAdultsLabel);
		firstPanel.add(setNumberOfSeniorCitizenLabel);
		firstPanel.add(setNumberOfInfantsTextField);
		firstPanel.add(setNumberOfAdultsTextField);
		firstPanel.add(setNumberOfSeniorCitizensTextField);
		firstPanel.add(setModeOfPaymentBoxLabel);
		firstPanel.add(setModeOfPaymentBox);
		firstPanel.add(setNumberOfPassengerBoxLabel);
		firstPanel.add(setNumberOfPassengersTextField);
		firstPanel.add(setClassTypeBoxLabel);
		firstPanel.add(setClassTypeBox);
		firstPanel.add(flightDetailsLabel);
		layeredPane.add(secondPanel, "name_20276470582800");
		
		bankDetailsLabel = new JLabel("Bank Details");
		bankDetailsLabel.setBounds(98, 34, 174, 35);
		bankDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		
		setBankAccountNumberLabel = new JLabel("Account Number");
		setBankAccountNumberLabel.setBounds(24, 155, 132, 28);
		setBankAccountNumberLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setBankAccountNumber = new JTextField();
		setBankAccountNumber.setBounds(168, 155, 167, 28);
		setBankAccountNumberLabel.setLabelFor(setBankAccountNumber);
		setBankAccountNumber.setColumns(10);
		
		setBankAccountEmailLabel = new JLabel("Email Address");
		setBankAccountEmailLabel.setBounds(24, 201, 132, 28);
		setBankAccountEmailLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setBankAccountEmail = new JTextField();
		setBankAccountEmail.setBounds(168, 201, 167, 30);
		setBankAccountEmailLabel.setLabelFor(setBankAccountEmail);
		setBankAccountEmail.setColumns(10);
		
		setBankAccountPhoneNumberLabel = new JLabel("Phone Number");
		setBankAccountPhoneNumberLabel.setBounds(24, 249, 132, 28);
		setBankAccountPhoneNumberLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setBankAccountPhoneNumber = new JTextField();
		setBankAccountPhoneNumber.setBounds(168, 249, 167, 30);
		setBankAccountPhoneNumberLabel.setLabelFor(setBankAccountPhoneNumber);
		setBankAccountPhoneNumber.setColumns(10);
		secondPanel.setLayout(null);
		secondPanel.add(bankDetailsLabel);
		secondPanel.add(setBankAccountPhoneNumberLabel);
		secondPanel.add(setBankAccountPhoneNumber);
		secondPanel.add(setBankAccountEmailLabel);
		secondPanel.add(setBankAccountEmail);
		secondPanel.add(setBankAccountNumberLabel);
		secondPanel.add(setBankAccountNumber);
		secondPanel.add(bank.getSetBankAccountNameLabel());
		secondPanel.add(bank.getSetBankAccountName());
		secondPanel.add(backButton);
		
		nextButton = new JButton("Next");
		nextButton.setBounds(595, 566, 108, 26);
		mainPanel.setLayout(null);
		mainPanel.add(layeredPane);
		mainPanel.add(nextButton);
		mainPanel.add(rightTextArea);
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
						if (setNumberOfInfantsTextField.getText().trim().isEmpty())
						{
							setNumberOfInfantsTextField.setText("0");
						}
						
						if (setNumberOfAdultsTextField.getText().trim().isEmpty())
						{
							setNumberOfAdultsTextField.setText("0");
						}
						
						if (setNumberOfSeniorCitizensTextField.getText().trim().isEmpty())
						{
							setNumberOfSeniorCitizensTextField.setText("0");
						}
						
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
							JOptionPane.showMessageDialog(null,"Total passengers error, Please recheck passenger allocation");
						}
						
						else 
						{
//							toPrint("FLIGHT DETAILS", "");
//							toPrint("Flight Type: ", setFlightTypeBox.getSelectedItem());
//							toPrint("Airlines: ", setAirlineBox.getSelectedItem());
//							toPrint("Trip Type: ", setTripTypeBox.getSelectedItem());
//							toPrint("Origin: ", setOriginBox.getSelectedItem());
//							toPrint("Destination: ", setDestinationBox.getSelectedItem());
//							toPrint("Schedule: ", setScheduleBox.getSelectedItem());
//							toPrint("Class Type: ", setClassTypeBox.getSelectedItem());
//							toPrint("Number Of Passengers: ", setNumberOfPassengersTextField.getText());
//							toPrint("Infants: ", numberOfInfants);
//							toPrint("Adults: ", numberOfAdults);
//							toPrint("Senior Citizen: ", numberOfSeniorCitizens);
//							toPrint("Mode of Payment: ", setModeOfPaymentBox.getSelectedItem());
							receipt.setReceipt("FLIGHT DETAILS", "");
							receipt.setReceipt("Flight Type: ", flight.getSetFlightTypeBox().getSelectedItem());
							receipt.setReceipt("Airlines: ", flight.getSetAirlineBox().getSelectedItem());
							temp = print;
							rightTextArea.setText(receipt.getReceipt());
							nextButton.setText("Submit");
							switchPanels(secondPanel, layeredPane);
						}				
					}
					catch(Exception NumberFormatException)
					{
						
						if (NumberFormatException != null && checkStringForLetters(setNumberOfPassengersTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Passengers must only contain numbers");
						}

						else if (NumberFormatException != null && checkStringForLetters(setNumberOfInfantsTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Infants must only contain numbers");
						}

						else if (NumberFormatException != null && checkStringForLetters(setNumberOfAdultsTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Adults must only contain numbers");
						}
					
						else if (NumberFormatException != null && checkStringForLetters(setNumberOfSeniorCitizensTextField.getText()) == true)
						{
							JOptionPane.showMessageDialog(null, "Number of Senior Citizens must only contain numbers");
						}

						if (NumberFormatException != null && setNumberOfPassengersTextField.getText().trim().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Number of Passengers is empty");
						}
			
					}		
				}
				else if(secondPanel.getParent() == layeredPane)
				{
					if (!setBankAccountName.getText().trim().isEmpty() && !setBankAccountNumber.getText().trim().isEmpty() && !setBankAccountEmail.getText().trim().isEmpty() 
						&& !setBankAccountPhoneNumber.getText().trim().isEmpty())
					{
						toPrint("\nBANK DETAILS", "");
						toPrint("Account Name: ", setBankAccountName.getText());
						toPrint("Account Number: ", setBankAccountNumber.getText());
						toPrint("Account Email: ", setBankAccountEmail.getText());
						toPrint("Phone Number: ", setBankAccountPhoneNumber.getText());
						//rightTextArea.setText(print);
						int confirmation = JOptionPane.showConfirmDialog(null, print, "Confirm fields", 0);
						if (confirmation == 0)
						{
							JOptionPane.showMessageDialog(null, "Thank you for purchasing");
							switchPanels(firstPanel, layeredPane);
							nextButton.setText("Next");
							print = "";
						}
						else if (confirmation == 1)
						{
							print = "";
							switchPanels(firstPanel, layeredPane);
							nextButton.setText("Next");
						}
						else
						{
							print = temp;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter required fields");
					}		
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
				print = "";
				switchPanels(firstPanel, layeredPane);
				nextButton.setText("Next");
			}
		});
		
		flight.getSetFlightTypeBox().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (flight.getSetFlightTypeBox().getSelectedItem() == "International")
				{
					flight.getSetAirlineBox().setModel(new DefaultComboBoxModel<String>(flight.getInternationalAirlineChoices()));
				}
				if (flight.getSetFlightTypeBox().getSelectedItem() == "Local")
				{
					flight.getSetAirlineBox().setModel(new DefaultComboBoxModel<String>(flight.getLocalAirlineChoices()));
				}
			}
		});
	}
	
//	private void toPrint(String string, int number)
//	{
//		print += string + Integer.toString(number) + "\n";
//	}
	
	private void toPrint(String string, Object object)
	{
		print += string + object + "\n";
	}
	
	private void switchPanels(JPanel panel, JLayeredPane pane)
	{
		pane.removeAll();
		pane.add(panel);
		pane.repaint();
		pane.revalidate();
		
	}
	
	private boolean checkStringForLetters(String s) 
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