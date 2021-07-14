import java.awt.EventQueue;
import java.awt.Font;

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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class App extends JFrame 
{
	//Instance Variables
	private JPanel mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel;
	private JLayeredPane layeredPane;
	private Receipt receipt = new Receipt();
	private FlightDetails flight = new FlightDetails();
	private BankDetails bank = new BankDetails();
	private MainMenu menu = new MainMenu();
	private Database database = new Database();
	private ManageTickets mTicket = new ManageTickets();
	private String toDatabase = "";


	
	
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
					JOptionPane.showMessageDialog(null,e);
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
		database.createTable();
		switchPanels(thirdPanel,layeredPane);
		thirdPanel.setLayout(null);
		
		
		
		
		
		
		
		
		
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
		thirdPanel = new JPanel();
		fourthPanel = new JPanel();
		fourthPanel.setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 777, 604);		
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.add(firstPanel, "name_20276457840900");
		layeredPane.add(secondPanel, "name_20276470582800");
		layeredPane.add(thirdPanel, "name_42503285724600");
		layeredPane.add(fourthPanel, "name_44322440987300");
		
		
		mainPanel.add(layeredPane);
		
		
		
		flight.setFlightDetails(firstPanel);
		flight.setFlightTypeBox();
		flight.setAirlineBox();
		flight.setTripTypeBox();
		flight.setOriginBox();
		flight.setDestinationBox();
		flight.setScheduleBox();
		flight.setClassTypeBox();
		flight.setNumberOfPassengersTextField();
		flight.setNumberOfInfantsTextField();
		flight.setNumberOfAdultsTextField();
		flight.setNumberOfSeniorCitizenTextField();
		flight.setModeOfPaymentBox();
		flight.setNextButton();
		flight.setCheckPricesButton();
		flight.setBackButton();
		bank.setBankDetails(secondPanel);
		bank.setBankAccountNameTextField();
		bank.setBankAcountNumberTextField();
		bank.setBankAccountEmailTextField();
		bank.setBankAccountPhoneNumberTextField();
		bank.setBackButton();
		bank.setSubmitButton();
		
		menu.setManageTicketsButton();
		menu.setBookTicketButton();
		menu.setQuitButton();
		
		mTicket.setTicketIDTextFieldLabel();
		mTicket.setTicketIDTextField();
		mTicket.setBackButton();

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
		firstPanel.add(flight.getSetClassTypeBoxLabel());
		firstPanel.add(flight.getSetClassTypeBox());
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
		firstPanel.add(flight.getSetCheckPricesButton());
		firstPanel.add(flight.getSetBackButton());
		
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
		
		
		thirdPanel.add(menu.getSetManageTicketsButton());
		thirdPanel.add(menu.getSetBookTicketButton());
		thirdPanel.add(menu.getSetQuitButton());
		
		fourthPanel.add(mTicket.getSetTicketIDTextField());
		fourthPanel.add(mTicket.getSetTicketIDTextFieldLabel());
		fourthPanel.add(mTicket.getSetBackButton());
		
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
								receipt.setReceipt("Class Type: ", flight.getSetClassTypeBox().getSelectedItem());
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
		
		flight.getSetBackButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(thirdPanel,layeredPane);
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
							toDatabase(flight.getSetFlightTypeBox().getSelectedItem(), false);
							toDatabase(flight.getSetOriginBox().getSelectedItem(), false);
							toDatabase(flight.getSetDestinationBox().getSelectedItem(), false);
							toDatabase(flight.getSetTripTypeBox().getSelectedItem(), false);
							toDatabase(flight.getSetAirlineBox().getSelectedItem(), false);
							toDatabase(flight.getSetScheduleBox().getSelectedItem(), false);
							toDatabase(flight.getSetClassTypeBox().getSelectedItem(), false);
							toDatabase(flight.getSetNumberOfPassengersTextField().getText(), false);
							toDatabase(flight.getSetNumberOfInfantsTextField().getText(), false);
							toDatabase(flight.getSetNumberOfAdultsTextField().getText(), false);
							toDatabase(flight.getSetNumberOfSeniorCitizensTextField().getText(), false);
							toDatabase(flight.getSetModeOfPaymentBox().getSelectedItem(), false);
							toDatabase(bank.getSetBankAccountNameTextField().getText(), false);
							toDatabase(bank.getSetBankAccountNumberTextField().getText(), false);
							toDatabase(bank.getSetBankAccountEmailTextField().getText(), false);
							toDatabase(bank.getSetBankAccountPhoneNumberTextField().getText(), true);
							JOptionPane.showMessageDialog(null, "Thank you for purchasing");
							switchPanels(thirdPanel, layeredPane);
							//database.insertToTable("(\"Flight Type\"\n)", "(\"1\");");
							database.insertToTable(toDatabase);
							//System.out.print(flight.getSetFlightTypeBox().getSelectedItem());
							//JOptionPane.showMessageDialog(null, "VALUES("+flight.getSetFlightTypeBox().getSelectedItem()+"\"");
							receipt.resetReceipt();
							toDatabase = "";
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
		
		
		
		menu.getSetManageTicketsButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(fourthPanel,layeredPane);
			}
		});
		
		menu.getSetBookTicketButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(firstPanel,layeredPane);
			}
		});
		
		menu.getSetQuitButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		mTicket.getSetBackButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(thirdPanel,layeredPane);
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
	
	private void toDatabase(Object object, Boolean last)
	{
		if(!last)
		{
			toDatabase += "'"+ object +"',";
		}
		else
		{
			toDatabase += "'"+ object +"'";
		}
	}
}