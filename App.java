import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import resources.ImagePanel;

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
	private String toDatabase = "", ticketNumber = "";
	
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
	
	public App() 
	{		
		initializeComponents();
		createEvents();
		database.createTable();
		switchPanels(thirdPanel,layeredPane);
	}
	
	private void initializeComponents() 
	{
		setResizable(false);
		setTitle("Airplane Ticketing System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/resources/213569889_535845414403206_7341132822717748611_n.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		setMinimumSize(new Dimension(800, 650));
		setUndecorated(true);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		//TODO add banks BPI , CHINABANK , LANDBANK, and implement ui design  apply new fonts, redesign ui
		
//		firstPanel = new ImagePanel(new ImageIcon(getClass()
//                .getResource("/resources/1.png"))
//                .getImage())
		firstPanel = new JPanel();		
		firstPanel.setBackground(Color.WHITE);
		;
		secondPanel = new JPanel();
		secondPanel.setBackground(Color.WHITE);
		thirdPanel = new JPanel();
		thirdPanel.setLayout(null);
		thirdPanel.setBackground(Color.WHITE);
		fourthPanel = new JPanel();
		fourthPanel.setBackground(Color.WHITE);
		fourthPanel.setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 650);		
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
		flight.setExitButton();
		flight.setMinimizeButton();
		
		bank.setBankDetails(secondPanel);
		bank.setBankAccountNameTextField();
		bank.setBankAcountNumberTextField();
		bank.setBankAccountEmailTextField();
		bank.setBankAccountPhoneNumberTextField();
		bank.setBackButton();
		bank.setSubmitButton();
		bank.setExitButton();
		bank.setMinimizeButton();
		
		menu.setManageTicketsButton();
		menu.setBookTicketButton();
		menu.setQuitButton();
		menu.setExitButton();
		menu.setMinimizeButton();
		menu.setLeftSide();
		
		mTicket.setTicketNumberTextField();
		mTicket.setBackButton();
		mTicket.setExitButton();
		mTicket.setMinimizeButton();
		mTicket.setTicketTextArea();
		mTicket.setEditTicketButton();
		mTicket.setDeleteTicketButton();
		
		firstPanel.setLayout(null);
		firstPanel.add(flight.getSetFlightDetailsLabel());
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
		firstPanel.add(flight.getExitButton());
		firstPanel.add(flight.getMinimizeButton());
	
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
		secondPanel.add(bank.getExitButton());
		secondPanel.add(bank.getMinimizeButton());
		
		thirdPanel.add(menu.getSetManageTicketsButton());
		thirdPanel.add(menu.getSetBookTicketButton());
		thirdPanel.add(menu.getSetQuitButton());
		thirdPanel.add(menu.getExitButton());
		thirdPanel.add(menu.getMinimizeButton());
		thirdPanel.add(menu.getLeftSide());
		//thirdPanel.paintComponents(menu.getLeftSide());
		
		fourthPanel.add(mTicket.getSetTicketNumberTextField());
		fourthPanel.add(mTicket.getSetTicketNumberTextFieldLabel());
		fourthPanel.add(mTicket.getSetBackButton());
		fourthPanel.add(mTicket.getExitButton());
		fourthPanel.add(mTicket.getMinimizeButton());
		fourthPanel.add(mTicket.getSetTicketTextArea());
		fourthPanel.add(mTicket.getEditTicketButton());
		fourthPanel.add(mTicket.getDeleteTicketButton());
		
		InputMap im = (InputMap)UIManager.get("Button.focusInputMap");
		im.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
		im.put(KeyStroke.getKeyStroke("released SPACE"), "none");
	}
	
	private void createEvents()
	{
		flight.getSetNextButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (flight.getSetOriginBox().getSelectedItem() != flight.getSetDestinationBox().getSelectedItem())
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
							
							int totalPassengers = 0; 
							flight.parseNumberOfPassengersToInt();
							if (flight.getNumberOfPassengers() > 200)
							{
								JOptionPane.showMessageDialog(null,"Number of Passengers should not exceed 200");
							}
							
							else if (flight.getNumberOfPassengers() < 1 && !flight.getSetNumberOfPassengersTextField().getText().isEmpty() && 
									 flight.checkStringForLetters(flight.getSetNumberOfPassengersTextField().getText()) == false)
							{
								JOptionPane.showMessageDialog(null,"Number of Passengers should not be less than 1");
							}
							
							else if (flight.getNumberOfPassengers() != 0 && flight.checkStringForLetters(flight.getSetNumberOfPassengersTextField().getText()) == false)
							{
								
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
				
				else 
				{
					JOptionPane.showMessageDialog(null, "Origin and Destination must not be the same");
				}
			}
		});
		
		flight.getSetOriginBox().addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (flight.getSetOriginBox().getSelectedItem() != flight.getSetDestinationBox().getSelectedItem())
				{
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
							   flight.getSetTripTypeBox().getSelectedItem().toString(), flight.getSetAirlineBox().getSelectedItem().toString(), flight.getSetClassTypeBox().getSelectedItem().toString(), 0, 0, 0);
					
					String [] schedule = new String[] {flight.getSchedule()} ;	
					flight.getSetScheduleBox().setModel(new DefaultComboBoxModel<String>(schedule));
				}
			}
		});
		
		flight.getSetDestinationBox().addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				if (flight.getSetOriginBox().getSelectedItem() != flight.getSetDestinationBox().getSelectedItem())
				{
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
									   flight.getSetTripTypeBox().getSelectedItem().toString(), flight.getSetAirlineBox().getSelectedItem().toString(), flight.getSetClassTypeBox().getSelectedItem().toString(), 0, 0, 0);
					
					String [] schedule = new String[] {flight.getSchedule()} ;	
					flight.getSetScheduleBox().setModel(new DefaultComboBoxModel<String>(schedule));
				}
			}
		});
		
		flight.getSetFlightTypeBox().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (flight.getSetFlightTypeBox().getSelectedItem() == "International")
				{
					flight.getSetOriginBox().setModel(new DefaultComboBoxModel<String>(flight.getLocalOriginDestinationChoices()));
					flight.getSetDestinationBox().setModel(new DefaultComboBoxModel<String>(flight.getInternationalOriginDestinationChoices()));
					flight.getSetDestinationBox().setSelectedIndex(1);
				}
				
				if (flight.getSetFlightTypeBox().getSelectedItem() == "Local")
				{
					flight.getSetOriginBox().setModel(new DefaultComboBoxModel<String>(flight.getLocalOriginDestinationChoices()));
					flight.getSetDestinationBox().setModel(new DefaultComboBoxModel<String>(flight.getLocalOriginDestinationChoices()));
					flight.getSetDestinationBox().setSelectedIndex(1);
				}
			}
		});
		
		flight.getSetBackButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (bank.getSetSubmitButton().getText() == "Edit Ticket")
				{
					int confirmation = JOptionPane.showConfirmDialog(null,"Would you like to stop editing your ticket? " , "Exit confirmation", 0);
					
					if (confirmation == 0)
					{
						flight.getSetFlightTypeBox().setSelectedIndex(0);
						flight.getSetOriginBox().setSelectedItem("EMPTY");
						flight.getSetDestinationBox().setSelectedItem("EMPTY");
						flight.getSetTripTypeBox().setSelectedIndex(0);
						flight.getSetAirlineBox().setSelectedIndex(0);
						flight.getSetScheduleBox().setSelectedItem("EMPTY");
						flight.getSetClassTypeBox().setSelectedIndex(0);
						flight.getSetNumberOfPassengersTextField().setText("");
						flight.getSetNumberOfInfantsTextField().setText("");
						flight.getSetNumberOfAdultsTextField().setText("");
						flight.getSetNumberOfSeniorCitizensTextField().setText("");
						flight.getSetModeOfPaymentBox().setSelectedIndex(0);
						flight.setNumberOfPassengers(0);
						
						toDatabase = "";
						receipt.resetReceipt();
						
						bank.getSetBankAccountNameTextField().setText("");
						bank.getSetBankAccountNumberTextField().setText("");
						bank.getSetBankAccountEmailTextField().setText("");
						bank.getSetBankAccountPhoneNumberTextField().setText("");
						bank.getSetSubmitButton().setText("Submit");
						
						switchPanels(thirdPanel,layeredPane);					
					}
			   }
				
			   else
			   {
					flight.getSetFlightTypeBox().setSelectedIndex(0);
					flight.getSetOriginBox().setSelectedItem("EMPTY");
					flight.getSetDestinationBox().setSelectedItem("EMPTY");
					flight.getSetTripTypeBox().setSelectedIndex(0);
					flight.getSetAirlineBox().setSelectedIndex(0);
					flight.getSetScheduleBox().setSelectedItem("EMPTY");
					flight.getSetClassTypeBox().setSelectedIndex(0);
					flight.getSetNumberOfPassengersTextField().setText("");
					flight.getSetNumberOfInfantsTextField().setText("");
					flight.getSetNumberOfAdultsTextField().setText("");
					flight.getSetNumberOfSeniorCitizensTextField().setText("");
					flight.getSetModeOfPaymentBox().setSelectedIndex(0);
					flight.setNumberOfPassengers(0);
					
					toDatabase = "";
					receipt.resetReceipt();
					
					bank.getSetBankAccountNameTextField().setText("");
					bank.getSetBankAccountNumberTextField().setText("");
					bank.getSetBankAccountEmailTextField().setText("");
					bank.getSetBankAccountPhoneNumberTextField().setText("");
					switchPanels(thirdPanel,layeredPane);
				}
				
			}
		});
		
		flight.getExitButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				System.exit(0);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				flight.getExitButton().setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				flight.getExitButton().setBackground(Color.WHITE);
			}});
		
		flight.getMinimizeButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				flight.getMinimizeButton().setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				flight.getMinimizeButton().setBackground(Color.WHITE);
			}});
		
		flight.getSetCheckPricesButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{			
				if (flight.getSetOriginBox().getSelectedItem() != flight.getSetDestinationBox().getSelectedItem())
				{			
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
									   flight.getSetTripTypeBox().getSelectedItem().toString(), "Philippine Airlines", flight.getSetClassTypeBox().getSelectedItem().toString(), 1, 1, 1);
					
					String philippineAirlinesInfantPrice =  Double.toString(flight.getInfantPrice());
					String philippineAirlinesAdultPrice =  Double.toString(flight.getAdultPrice());
					String philippineAirlinesSeniorCitizenPrice =  Double.toString(flight.getSeniorCitizenPrice());
					
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
							   flight.getSetTripTypeBox().getSelectedItem().toString(), "AirAsia Philippines", flight.getSetClassTypeBox().getSelectedItem().toString(), 1, 1, 1);
			
					String airAsiaPhilippinesInfantPrice =  Double.toString(flight.getInfantPrice());
					String airAsiaPhilippinesAdultPrice =  Double.toString(flight.getAdultPrice());
					String airAsiaPhilippinesSeniorCitizenPrice =  Double.toString(flight.getSeniorCitizenPrice());
					
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
							   flight.getSetTripTypeBox().getSelectedItem().toString(), "Cebu Pacific", flight.getSetClassTypeBox().getSelectedItem().toString(), 1, 1, 1);
			
					String cebuPacificInfantPrice =  Double.toString(flight.getInfantPrice());
					String cebuPacificAdultPrice =  Double.toString(flight.getAdultPrice());
					String cebuPacificSeniorCitizenPrice =  Double.toString(flight.getSeniorCitizenPrice());
					
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
							   flight.getSetTripTypeBox().getSelectedItem().toString(), "Qatar Airways", flight.getSetClassTypeBox().getSelectedItem().toString(), 1, 1, 1);
			
					String qatarAirwaysInfantPrice =  Double.toString(flight.getInfantPrice());
					String qatarAirwaysAdultPrice =  Double.toString(flight.getAdultPrice());
					String qatarAirwaysSeniorCitizenPrice =  Double.toString(flight.getSeniorCitizenPrice());
					
					flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
							   flight.getSetTripTypeBox().getSelectedItem().toString(), "Saudi Airlines Saudia", flight.getSetClassTypeBox().getSelectedItem().toString(), 1, 1, 1);
			
					String saudiAirlinesSaudiaInfantPrice =  Double.toString(flight.getInfantPrice());
					String saudiAirlinesSaudiaAdultPrice =  Double.toString(flight.getAdultPrice());
					String saudiAirlinesSaudiaSeniorCitizenPrice =  Double.toString(flight.getSeniorCitizenPrice());
					
					Object[][] rows = 
						{
						    {"Infant Price", "                   " + philippineAirlinesInfantPrice, "                   " + airAsiaPhilippinesInfantPrice, "                   " + cebuPacificInfantPrice, "                   " + qatarAirwaysInfantPrice, "                   " + saudiAirlinesSaudiaInfantPrice},
						    {"Adult Price" , "                   " + philippineAirlinesAdultPrice, "                   " + airAsiaPhilippinesAdultPrice, "                   " + cebuPacificAdultPrice, "                   " + qatarAirwaysAdultPrice, "                   " + saudiAirlinesSaudiaAdultPrice},
						    {"Senior Citizen Price", "                   " + philippineAirlinesSeniorCitizenPrice, "                   " + airAsiaPhilippinesSeniorCitizenPrice, "                   " + cebuPacificSeniorCitizenPrice, "                   " + qatarAirwaysSeniorCitizenPrice, "                   " + saudiAirlinesSaudiaSeniorCitizenPrice}
						};
					
					Object[] cols = 
					{
					    "","Philippine Airlines", "AirAsia Philippines", "Cebu Pacific", "Qatar Airways", "Saudi Airlines Saudia"
					};
					
					JTable table = new JTable(rows, cols)
					{
					    @Override
					    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) 
					    {
				           Component component = super.prepareRenderer(renderer, row, column);
				           TableColumn tableColumn = getColumnModel().getColumn(column);
				           tableColumn.setPreferredWidth(150);
				           return component;
					    }
					};;
					
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setPreferredSize(new Dimension(903, 71));
					JOptionPane.showMessageDialog(null, scrollPane);				
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Origin and Destination must not be the same");
				}
			}
		});
		
		bank.getSetBackButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				receipt.resetReceipt();
				switchPanels(firstPanel, layeredPane);
			}
		});
		
		bank.getSetSubmitButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (!bank.getSetBankAccountNameTextField().getText().trim().isEmpty() && !bank.getSetBankAccountNumberTextField().getText().trim().isEmpty() && 
					!bank.getSetBankAccountEmailTextField().getText().trim().isEmpty() && !bank.getSetBankAccountPhoneNumberTextField().getText().trim().isEmpty())
					{
					
						flight.setSchedule(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),
										   flight.getSetTripTypeBox().getSelectedItem().toString(), flight.getSetAirlineBox().getSelectedItem().toString(), flight.getSetClassTypeBox().getSelectedItem().toString(), flight.getNumberOfInfants(), 
										   flight.getNumberOfAdults(), flight.getNumberOfSeniorCitizens());
					
						receipt.setReceipt("\nBANK DETAILS", "");
						receipt.setReceipt("Account Name: ", bank.getSetBankAccountNameTextField().getText());
						receipt.setReceipt("Account Number: ", bank.getSetBankAccountNumberTextField().getText());
						receipt.setReceipt("Account Email: ", bank.getSetBankAccountEmailTextField().getText());
						receipt.setReceipt("Phone Number: ", bank.getSetBankAccountPhoneNumberTextField().getText());
						receipt.setReceipt("\nTotal price: " , flight.getTotalPrice());
						 
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
							toDatabase(bank.getSetBankAccountPhoneNumberTextField().getText(), false);
							toDatabase(flight.getTotalPrice(), false);
							
							if (bank.getSetSubmitButton().getText() == "Submit")
							{
								
								ticketNumber = "";
								ticketNumber = generateTicketNumber();
								
								//If ticket number is already available in database, create another ticket
								while(database.findInDatabase(ticketNumber))
								{
									ticketNumber = generateTicketNumber();
								}
								
								toDatabase(ticketNumber, true);		
								
								String[] options = {"OK"};
								JPanel panel = new JPanel();
								JLabel ticketNumberLabel = new JLabel("Ticket Number: ");
								JTextField ticketNumberTextField = new JTextField(10);
								ticketNumberTextField.setText(ticketNumber);
								
								panel.add(ticketNumberLabel);
								panel.add(ticketNumberTextField);
								
								ticketNumberTextField.addFocusListener(new FocusListener() 
								{				            
									@Override
									public void focusGained(FocusEvent e) 
									{
										ticketNumberTextField.selectAll();
									}
									@Override
									public void focusLost(FocusEvent e) 
									{
										;
									}
								});
								
								JOptionPane.showOptionDialog(null, panel, "Thank you for pruchasing", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options , options[0]);
								switchPanels(thirdPanel, layeredPane);
								
								database.insertToTable(toDatabase);
								receipt.resetReceipt();
								toDatabase = "";
								ticketNumber = "";
								
								flight.getSetFlightTypeBox().setSelectedIndex(0);
								flight.getSetOriginBox().setSelectedItem("EMPTY");
								flight.getSetDestinationBox().setSelectedItem("EMPTY");
								flight.getSetTripTypeBox().setSelectedIndex(0);
								flight.getSetAirlineBox().setSelectedIndex(0);
								flight.getSetScheduleBox().setSelectedItem("EMPTY");
								flight.getSetClassTypeBox().setSelectedIndex(0);
								flight.getSetNumberOfPassengersTextField().setText("");
								flight.getSetNumberOfInfantsTextField().setText("");
								flight.getSetNumberOfAdultsTextField().setText("");
								flight.getSetNumberOfSeniorCitizensTextField().setText("");
								flight.getSetModeOfPaymentBox().setSelectedIndex(0);
								flight.setNumberOfPassengers(0);
								
								bank.getSetBankAccountNameTextField().setText("");
								bank.getSetBankAccountNumberTextField().setText("");
								bank.getSetBankAccountEmailTextField().setText("");
								bank.getSetBankAccountPhoneNumberTextField().setText("");
								bank.getSetSubmitButton().setText("Submit");
							}
							else
							{
								String totalPrice = Double.toString(flight.getTotalPrice());
								database.updateDatabase(flight.getSetFlightTypeBox().getSelectedItem().toString(), flight.getSetOriginBox().getSelectedItem().toString(), flight.getSetDestinationBox().getSelectedItem().toString(),  
														flight.getSetTripTypeBox().getSelectedItem().toString(), flight.getSetAirlineBox().getSelectedItem().toString(), flight.getSetScheduleBox().getSelectedItem().toString(),  
														flight.getSetClassTypeBox().getSelectedItem().toString(), flight.getSetNumberOfPassengersTextField().getText(), flight.getSetNumberOfInfantsTextField().getText(), 
														flight.getSetNumberOfAdultsTextField().getText(), flight.getSetNumberOfSeniorCitizensTextField().getText(), flight.getSetModeOfPaymentBox().getSelectedItem().toString(), 
														bank.getSetBankAccountNameTextField().getText(), bank.getSetBankAccountNumberTextField().getText(), bank.getSetBankAccountEmailTextField().getText(), 
														bank.getSetBankAccountPhoneNumberTextField().getText(), totalPrice, ticketNumber);
								
								JOptionPane.showMessageDialog(null, "Your ticket with Ticket Number: " + ticketNumber +" has been successfully edited");
								ticketNumber = "";
								toDatabase = "";
								receipt.resetReceipt();
								flight.getSetFlightTypeBox().setSelectedIndex(0);
								flight.getSetOriginBox().setSelectedItem("EMPTY");
								flight.getSetDestinationBox().setSelectedItem("EMPTY");
								flight.getSetTripTypeBox().setSelectedIndex(0);
								flight.getSetAirlineBox().setSelectedIndex(0);
								flight.getSetScheduleBox().setSelectedItem("EMPTY");
								flight.getSetClassTypeBox().setSelectedIndex(0);
								flight.getSetNumberOfPassengersTextField().setText("");
								flight.getSetNumberOfInfantsTextField().setText("");
								flight.getSetNumberOfAdultsTextField().setText("");
								flight.getSetNumberOfSeniorCitizensTextField().setText("");
								flight.getSetModeOfPaymentBox().setSelectedIndex(0);
								flight.setNumberOfPassengers(0);
								
								bank.getSetBankAccountNameTextField().setText("");
								bank.getSetBankAccountNumberTextField().setText("");
								bank.getSetBankAccountEmailTextField().setText("");
								bank.getSetBankAccountPhoneNumberTextField().setText("");
								bank.getSetSubmitButton().setText("Submit");
								
								switchPanels(thirdPanel, layeredPane);
							}
							
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
		
		bank.getExitButton().addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				System.exit(0);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				bank.getExitButton().setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				bank.getExitButton().setBackground(Color.WHITE);
			}});
			
		bank.getMinimizeButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				bank.getMinimizeButton().setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				bank.getMinimizeButton().setBackground(Color.WHITE);
			}});
		
		menu.getSetManageTicketsButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(fourthPanel,layeredPane);
			}
		});
		
		menu.getSetBookTicketButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(firstPanel,layeredPane);
			}
		});
		
		menu.getSetQuitButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		menu.getExitButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				System.exit(0);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				menu.getExitButton().setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				menu.getExitButton().setBackground(Color.WHITE);
			}});
		
		menu.getMinimizeButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				menu.getMinimizeButton().setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				menu.getMinimizeButton().setBackground(Color.WHITE);
			}});
			
		mTicket.getExitButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				System.exit(0);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				mTicket.getExitButton().setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				mTicket.getExitButton().setBackground(Color.WHITE);
			}});
		
		
		mTicket.getMinimizeButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				;
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				mTicket.getMinimizeButton().setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				mTicket.getMinimizeButton().setBackground(Color.WHITE);
			}});
		
		mTicket.getSetTicketNumberTextField().addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				;
			}

			@Override
			public void keyPressed(KeyEvent e) 
			{
				;
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				if (database.findInDatabase(mTicket.getSetTicketNumberTextField().getText()))
				{
					receipt.setReceipt("FLIGHT DETAILS", "");
					receipt.setReceipt("Flight Type: ", database.getFlightType());
					receipt.setReceipt("Airlines: ",  database.getAirline());
					receipt.setReceipt("Trip Type: ",  database.getTripType());
					receipt.setReceipt("Origin: ",  database.getOrigin());
					receipt.setReceipt("Destination: ",  database.getDestination());
					receipt.setReceipt("Schedule: ", database.getSchedule());
					receipt.setReceipt("Class Type: ",  database.getFlightType());
					receipt.setReceipt("Number Of Passengers: ",  database.getNumberOfPassengers());
					receipt.setReceipt("Infants: ",  database.getNumberOfInfants());
					receipt.setReceipt("Adults: ",  database.getNumberOfAdults());
					receipt.setReceipt("Senior Citizen: ",  database.getNumberOfSeniorCitizens());
					receipt.setReceipt("Mode of Payment: ",  database.getModeOfPayment());
					receipt.setReceipt("\nBANK DETAILS", "");
					receipt.setReceipt("Account Name: ", database.getBankAccountName());
					receipt.setReceipt("Account Number: ", database.getBankAccountNumber());
					receipt.setReceipt("Account Email: ", database.getBankAccountEmail());
					receipt.setReceipt("Phone Number: ", database.getBankAccountPhoneNumber());
					receipt.setReceipt("\nTotal price: " , database.getTotalPrice());
					mTicket.getSetTicketTextArea().setText(receipt.getReceipt());
					receipt.resetReceipt();			
				}
				
				else if (mTicket.getSetTicketNumberTextField().getText().trim().isEmpty())
				{
					mTicket.getSetTicketTextArea().setText("");
				}
				else
				{
					mTicket.getSetTicketTextArea().setText("Could not find your ticket");
				}
			}
		});
			
		mTicket.getDeleteTicketButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{		
				if (!mTicket.getSetTicketNumberTextField().getText().trim().isEmpty() )
				{				
					if (database.findInDatabase(mTicket.getSetTicketNumberTextField().getText()))
					{
						int confirmation = JOptionPane.showConfirmDialog(null,"Do you wish to delete ticket with Ticket Number: " + mTicket.getSetTicketNumberTextField().getText(), 
											"Confirm deletion of ticket", 0);
						
						if (confirmation == 0)
						{	
							database.deleteInDatabase(mTicket.getSetTicketNumberTextField().getText());	
							
							if (!database.findInDatabase(mTicket.getSetTicketNumberTextField().getText()))
							{
								JOptionPane.showMessageDialog(null, "Your ticket has successfully been deleted");
								mTicket.getSetTicketTextArea().setText("Could not find ticket");
							}
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "The ticket you are trying to delete is not available");
					}				
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Ticket number should not be empty.");
				}
			}
		});
		
		mTicket.getEditTicketButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (!mTicket.getSetTicketNumberTextField().getText().trim().isEmpty() )
				{				
					if (database.findInDatabase(mTicket.getSetTicketNumberTextField().getText()))
					{
						int confirmation = JOptionPane.showConfirmDialog(null,"Do you wish to edit ticket with Ticket Number: " + mTicket.getSetTicketNumberTextField().getText(), 
											"Confirm edition of ticket", 0);
						
						if (confirmation == 0)
						{	
							switchPanels(firstPanel, layeredPane);
							flight.getSetFlightTypeBox().setSelectedItem(database.getFlightType());
							flight.getSetOriginBox().setSelectedItem(database.getOrigin());
							flight.getSetDestinationBox().setSelectedItem(database.getDestination());
							flight.getSetTripTypeBox().setSelectedItem(database.getTripType());
							flight.getSetAirlineBox().setSelectedItem(database.getAirline());
							flight.getSetScheduleBox().setSelectedItem(database.getSchedule());
							flight.getSetClassTypeBox().setSelectedItem(database.getClass());
							flight.getSetNumberOfPassengersTextField().setText(database.getNumberOfPassengers());
							flight.getSetNumberOfInfantsTextField().setText(database.getNumberOfInfants());
							flight.getSetNumberOfAdultsTextField().setText(database.getNumberOfAdults());
							flight.getSetNumberOfSeniorCitizensTextField().setText(database.getNumberOfSeniorCitizens());
							flight.getSetModeOfPaymentBox().setSelectedItem(database.getModeOfPayment());
							
							bank.getSetBankAccountNameTextField().setText(database.getBankAccountName());
							bank.getSetBankAccountNumberTextField().setText(database.getBankAccountNumber());
							bank.getSetBankAccountEmailTextField().setText(database.getBankAccountEmail());
							bank.getSetBankAccountPhoneNumberTextField().setText(database.getBankAccountPhoneNumber());
							bank.getSetSubmitButton().setText("Edit Ticket");
							
							ticketNumber = mTicket.getSetTicketNumberTextField().getText();
							
							mTicket.getSetTicketNumberTextField().setText("");
							mTicket.getSetTicketTextArea().setText("");
							
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "The ticket you are trying to edit is not available");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Ticket Number should not be empty.");
				}
			}
			
		});
		
		mTicket.getSetBackButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				mTicket.getSetTicketNumberTextField().setText("");
				mTicket.getSetTicketTextArea().setText("");
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
	
	private String generateTicketNumber()
	{
		Random random = new Random();
		
		while (ticketNumber.length() != 13)
		{
			String rand = Integer.toString(random.nextInt(10));
			ticketNumber += rand;
		}
		return ticketNumber;
	}
	
	protected void paintComponent(Graphics g) {
	    g.setColor(new Color(5,5,5));
	    g.fillRect(0,0,100,100);
	    g.setColor(Color.GREEN);
	    g.drawRoundRect(30,30,20,20,5,5);
	    g.setColor(new Color(200,200,200));
	    g.setFont(new Font("Eras Bold ITC", Font.BOLD, 150));
	    g.drawString("hi",25,25);
	}
}