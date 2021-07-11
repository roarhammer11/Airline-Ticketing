import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class App extends JFrame 
{
	//Instance Variables
	private JPanel mainPanel, firstPanel, secondPanel;
	private JLayeredPane layeredPane;
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
		initializeComponents();
		createEvents();
	}
	
	private void initializeComponents() 
	{
		// TODO Auto-generated method stub
		setResizable(false);
		setTitle("Airplane Ticketing System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/resources/213569889_535845414403206_7341132822717748611_n.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		setMinimumSize(new Dimension(800, 650));
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		firstPanel = new JPanel();		
		secondPanel = new JPanel();
	
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 777, 604);		
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.add(firstPanel, "name_20276457840900");
		layeredPane.add(secondPanel, "name_20276470582800");
		
		mainPanel.add(layeredPane);
		
		flight.setFlightDetails(firstPanel);
		flight.setFlightTypeBox();
		flight.setAirlineBox();
		flight.setTripTypeBox();
		flight.setOriginBox();
		flight.setDestinationBox();
		flight.setScheduleBox();
		flight.setClassTypeBox();
		flight.setNumberOfPassengerTextField();
		flight.setNumberOfInfantsTextField();
		flight.setNumberOfAdultsTextField();
		flight.setNumberOfSeniorCitizenTextField();
		flight.setModeOfPaymentBox();
		flight.setNextButton();
		
		bank.setBankDetails(secondPanel);
		bank.setBankAccountNameTextField();
		bank.setBankAcountNumberTextField();
		bank.setBankAccountEmailTextField();
		bank.setBankAccountPhoneNumberTextField();
		bank.setBackButton();
		bank.setSubmitButton();

		firstPanel.setLayout(null);
		firstPanel.add(flight.getFlightDetailsLabel());
		firstPanel.add(flight.getSetFlightTypeBoxLabel());
		firstPanel.add(flight.getSetFlightTypeBox());	
		firstPanel.add(flight.getSetAirlineBoxLabel());
		firstPanel.add(flight.getSetAirlineBox());
		firstPanel.add(flight.getSetTripTypeBoxLabel());
		firstPanel.add(flight.getSetTripTypeBox());
		firstPanel.add(flight.getSetOriginBoxLabel());
		firstPanel.add(flight.getSetOriginBox());
		firstPanel.add(flight.getSetDestinationBoxLabel());
		firstPanel.add(flight.getSetDestinationBox());
		firstPanel.add(flight.getSetScheduleBoxLabel());
		firstPanel.add(flight.getSetScheduleBox());
		firstPanel.add(flight.getSetClassTypebBoxLabel());
		firstPanel.add(flight.getSetClassTypebBox());
		firstPanel.add(flight.getSetNumberOfPassengersTextFieldLabel());
		firstPanel.add(flight.getSetNumberOfPassengersTextField());
		firstPanel.add(flight.getSetNumberOfInfantsTextFieldLabel());
		firstPanel.add(flight.getSetNumberOfInfantsTextField());
		firstPanel.add(flight.getSetNumberOfAdultsTextFieldLabel());
		firstPanel.add(flight.getSetNumberOfAdultsTextField());
		firstPanel.add(flight.getSetNumberOfSeniorCitizensTextFieldLabel());
		firstPanel.add(flight.getSetNumberOfSeniorCitizensTextField());
		firstPanel.add(flight.getSetModeOfPaymentBoxLabel());
		firstPanel.add(flight.getSetModeOfPaymentBox());
		firstPanel.add(flight.getSetNextButton());
		
		secondPanel.setLayout(null);
		secondPanel.add(bank.getSetBankDetailsLabel());
		secondPanel.add(bank.getSetBankAccountNameTextFieldLabel());
		secondPanel.add(bank.getSetBankAccountNameTextField());
		secondPanel.add(bank.getSetBankAccountNumberTextFieldLabel());
		secondPanel.add(bank.getSetBankAccountNumberTextField());
		secondPanel.add(bank.getSetBankAccountEmailTextFieldLabel());
		secondPanel.add(bank.getSetBankAccountEmailTextField());
		secondPanel.add(bank.getSetBankAccountPhoneNumberTextFieldLabel());
		secondPanel.add(bank.getSetBankAccountPhoneNumberTextField());
		secondPanel.add(bank.getSetBackButton());
		secondPanel.add(bank.getSetSubmitButton());
	}
	
	private void createEvents()
	{
		flight.getSetNextButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(firstPanel.getParent() == layeredPane)
				{
					try
					{
						if (flight.getSetNumberOfInfantsTextField().getText().trim().isEmpty())
						{
							flight.getSetNumberOfInfantsTextField().setText("0");
						}
						
						if (flight.getSetNumberOfAdultsTextField().getText().trim().isEmpty())
						{
							flight.getSetNumberOfAdultsTextField().setText("0");
						}
						
						if (flight.getSetNumberOfSeniorCitizensTextField().getText().trim().isEmpty())
						{
							flight.getSetNumberOfSeniorCitizensTextField().setText("0");
						}
						
						int totalPassengers = 0 ; 

						if (flight.getNumberOfPassengers() > 200)
						{
							JOptionPane.showMessageDialog(null,"Number of Passengers should not exceed 200");
						}
						
						else if (flight.getNumberOfPassengers() < 0)
						{
							JOptionPane.showMessageDialog(null,"Number of Passengers should not be less than 0");
						}
						
						else if (flight.checkStringForLetters(flight.getSetNumberOfPassengersTextField().getText()) == false)
						{
							flight.parseNumberOfPassengersToInt();
							if (flight.checkStringForLetters(flight.getSetNumberOfInfantsTextField().getText()) == false)
							{
								flight.parseNumberOfInfantsToInt();
								totalPassengers += flight.getNumberOfInfants();
							}
							
							if (flight.checkStringForLetters(flight.getSetNumberOfAdultsTextField().getText()) == false)
							{
								flight.parseNumberOfAdultsToInt();
								totalPassengers += flight.getNumberOfAdults();
							}
							
							if (flight.checkStringForLetters(flight.getSetNumberOfSeniorCitizensTextField().getText()) == false)
							{
								flight.parseNumberOfSeniorCitizensToInt();
								totalPassengers += flight.getNumberOfSeniorCitizens();
							}
							
							if (flight.checkStringForLetters(flight.getSetNumberOfInfantsTextField().getText()) == true)
							{
								JOptionPane.showMessageDialog(null,"Number of Infants must only contain numbers");
							}
							
							else if (flight.checkStringForLetters(flight.getSetNumberOfAdultsTextField().getText()) == true)
							{
								JOptionPane.showMessageDialog(null,"Number of Adults must only contain numbers");
							}
							
							else if (flight.checkStringForLetters(flight.getSetNumberOfSeniorCitizensTextField().getText()) == true)
							{
								JOptionPane.showMessageDialog(null,"Number of Senior Citizens must only contain numbers");
							}
											
							else if (totalPassengers != flight.getNumberOfPassengers())
							{
								JOptionPane.showMessageDialog(null,"Total passengers error, Please recheck passenger allocation");
							}
								
							else if(flight.getNumberOfPassengers() != 0 && flight.checkStringForLetters(flight.getSetNumberOfInfantsTextField().getText()) == false && 
								totalPassengers == flight.getNumberOfPassengers())
							{		
								receipt.setReceipt("FLIGHT DETAILS", "");
								receipt.setReceipt("Flight Type: ", flight.getSetFlightTypeBox().getSelectedItem());
								receipt.setReceipt("Airlines: ", flight.getSetAirlineBox().getSelectedItem());
								receipt.setReceipt("Trip Type: ", flight.getSetTripTypeBox().getSelectedItem());
								receipt.setReceipt("Origin: ", flight.getSetOriginBox().getSelectedItem());
								receipt.setReceipt("Destination: ", flight.getSetDestinationBox().getSelectedItem());
								receipt.setReceipt("Schedule: ", flight.getSetScheduleBox().getSelectedItem());
								receipt.setReceipt("Class Type: ", flight.getSetClassTypebBox().getSelectedItem());
								receipt.setReceipt("Number Of Passengers: ", flight.getSetNumberOfPassengersTextField().getText());
								receipt.setReceipt("Infants: ", flight.getNumberOfInfants());
								receipt.setReceipt("Adults: ", flight.getNumberOfAdults());
								receipt.setReceipt("Senior Citizen: ", flight.getNumberOfSeniorCitizens());
								receipt.setReceipt("Mode of Payment: ", flight.getSetModeOfPaymentBox().getSelectedItem());
								receipt.setReceiptToTemp();
								switchPanels(secondPanel, layeredPane);
							}					
						}
						
						else if (flight.getNumberOfPassengers() == 0 && flight.checkStringForLetters(flight.getSetNumberOfPassengersTextField().getText()) == false)
						{
							JOptionPane.showMessageDialog(null,"Number of Passengers should not be 0");
						}
						
						else if(flight.checkStringForLetters(flight.getSetNumberOfPassengersTextField().getText()))
						{
							JOptionPane.showMessageDialog(null, "Number of Passengers must only contain numbers");
						}				
					}
					catch(Exception NumberFormatException)
					{	
						JOptionPane.showMessageDialog(null, "Error");
					}		
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Could Not Switch Pane");
				}					
			}
		});
		
		bank.getSetBackButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				receipt.resetReceipt();
				switchPanels(firstPanel, layeredPane);
			}
		});
		
		bank.getSetSubmitButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (!bank.getSetBankAccountNameTextField().getText().trim().isEmpty() && !bank.getSetBankAccountNumberTextField().getText().trim().isEmpty() && 
					!bank.getSetBankAccountEmailTextField().getText().trim().isEmpty() && !bank.getSetBankAccountPhoneNumberTextField().getText().trim().isEmpty())
					{
						receipt.setReceipt("\nBANK DETAILS", "");
						receipt.setReceipt("Account Name: ", bank.getSetBankAccountNameTextField().getText());
						receipt.setReceipt("Account Number: ", bank.getSetBankAccountNumberTextField().getText());
						receipt.setReceipt("Account Email: ", bank.getSetBankAccountEmailTextField().getText());
						receipt.setReceipt("Phone Number: ", bank.getSetBankAccountPhoneNumberTextField().getText());

						int confirmation = JOptionPane.showConfirmDialog(null, receipt.getReceipt(), "Confirm fields", 0);
						
						if (confirmation == 0)
						{
							JOptionPane.showMessageDialog(null, "Thank you for purchasing");
							switchPanels(firstPanel, layeredPane);
							receipt.resetReceipt();
						}
						else if (confirmation == 1)
						{
							receipt.resetReceipt();
							switchPanels(firstPanel, layeredPane);
						}
						else
						{
							receipt.setTempToReceipt();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter required fields");
					}		
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

	private void switchPanels(JPanel panel, JLayeredPane pane)
	{
		pane.removeAll();
		pane.add(panel);
		pane.repaint();
		pane.revalidate();
		
	}
}