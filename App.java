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
import java.awt.Font;

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
		
		layeredPane = new JLayeredPane();
		
		firstPanel = new JPanel();
		
		secondPanel = new JPanel();
		secondPanel.setLayout(null);
		
		
		//Labels
		setClassTypeBoxLabel = new JLabel("Class Type");
		setClassTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		setClassTypeBoxLabel.setLabelFor(setClassTypeBox);
		
		setFlightTypeBoxLabel = new JLabel("Flight Type  ");
		setFlightTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setAirlineBoxLabel = new JLabel("Airlines");
		setAirlineBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setTripTypeBoxLabel = new JLabel("Trip Type");
		setTripTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setOriginBoxLabel = new JLabel("Origin");
		setOriginBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setDestinationLabel = new JLabel("Destination");
		setDestinationLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setScheduleBoxLabel = new JLabel("Schedule");
		setScheduleBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setNumberOfPassengerBoxLabel = new JLabel("Number Of Passengers");
		setNumberOfPassengerBoxLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		setNumberOfPassengerBoxLabel.setLabelFor(setNumberOfPassengersTextField);
		
		setNumberOfAdultsLabel = new JLabel("Adults");
		setNumberOfAdultsLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setNumberOfInfantsLabel = new JLabel("Infants");
		setNumberOfInfantsLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setNumberOfSeniorCitizenLabel = new JLabel("Senior Citizen");
		setNumberOfSeniorCitizenLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setModeOfPaymentBoxLabel = new JLabel("Mode of Payment");
		setModeOfPaymentBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		
		setBankAccountNameLabel = new JLabel("Account Name");
		setBankAccountNameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		setBankAccountNameLabel.setBounds(40, 15, 122, 25);
		secondPanel.add(setBankAccountNameLabel);
		
		
		
		
		//Box
		setClassTypeBox = new JComboBox<String>();
		setClassTypeBox.setFont(new Font("Dialog", Font.BOLD, 17));
		String[] classTypeChoices = {"Business", "Economy", "Premium"};
		setClassTypeBox.setModel(new DefaultComboBoxModel<String>(classTypeChoices));
		
		setDestinationBox = new JComboBox<String>();
		setDestinationBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setDestinationLabel.setLabelFor(setDestinationBox);
		String[] destinationChoices = {"EMPTY"};
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(destinationChoices));
		
		setOriginBox = new JComboBox<String>();
		setOriginBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setOriginBoxLabel.setLabelFor(setOriginBox);
		String[] originChoices = {"EMPTY"};
		setOriginBox.setModel(new DefaultComboBoxModel<String>(originChoices));
		
		setFlightTypeBox = new JComboBox<String>();
		setFlightTypeBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setFlightTypeBoxLabel.setLabelFor(setFlightTypeBox);
		String[] flightTypeChoices = {"International", "Local"};
		setFlightTypeBox.setModel(new DefaultComboBoxModel<String>(flightTypeChoices));
		
		setAirlineBox = new JComboBox<String>();
		setAirlineBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setAirlineBoxLabel.setLabelFor(setAirlineBox);
		setAirlineBox.setModel(new DefaultComboBoxModel<String>(internationalAirlineChoices));
		
		setTripTypeBox = new JComboBox<String>();
		setTripTypeBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setTripTypeBoxLabel.setLabelFor(setTripTypeBox);
		String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
		
		setScheduleBox = new JComboBox<String>();
		setScheduleBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setScheduleBoxLabel.setLabelFor(setScheduleBox);
		String[] scheduleChoices = {"EMPTY"};
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(scheduleChoices));
		
		setModeOfPaymentBox = new JComboBox<String>();
		setModeOfPaymentBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setModeOfPaymentBoxLabel.setLabelFor(setModeOfPaymentBox);
		String[] modeOfPayment = {"Credit","Debit", "GCash"};
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(modeOfPayment));
		
		
		//Text Fields
		setNumberOfPassengersTextField = new JTextField();
		setNumberOfPassengersTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfPassengersTextField.setColumns(10);
	
		setNumberOfInfantsTextField = new JTextField();
		setNumberOfInfantsTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfInfantsLabel.setLabelFor(setNumberOfInfantsTextField);
		setNumberOfInfantsTextField.setColumns(10);
		
		setNumberOfAdultsTextField = new JTextField();
		setNumberOfAdultsTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfAdultsLabel.setLabelFor(setNumberOfAdultsTextField);
		setNumberOfAdultsTextField.setColumns(10);
		
		setNumberOfSeniorCitizensTextField = new JTextField();
		setNumberOfSeniorCitizensTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		setNumberOfSeniorCitizenLabel.setLabelFor(setNumberOfSeniorCitizensTextField);
		setNumberOfSeniorCitizensTextField.setColumns(10);
		setBankAccountName = new JTextField();
		setBankAccountName.setBounds(180, 15, 160, 25);
		secondPanel.add(setBankAccountName);
		setBankAccountName.setColumns(10);
		
		
		
		
		
		
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		rightTextArea = new JTextArea();
		rightTextArea.setFont(new Font("Dialog", Font.PLAIN, 17));
		rightTextArea.setEditable(false);
		rightTextArea.setLineWrap(false);
		rightTextArea.setBackground(new Color(241,241,241));
		rightTextArea.setWrapStyleWord(true);
		rightTextArea.setBorder(blackline);
		
		//Buttons
		backButton = new JButton("Back");
		backButton.setBounds(50, 559, 98, 26);
		secondPanel.add(backButton);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.add(firstPanel, "name_20276457840900");
		GroupLayout gl_firstPanel = new GroupLayout(firstPanel);
		gl_firstPanel.setHorizontalGroup(
			gl_firstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setFlightTypeBoxLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setFlightTypeBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setAirlineBoxLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setAirlineBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setTripTypeBoxLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setTripTypeBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setOriginBoxLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setOriginBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setDestinationLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setDestinationBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setScheduleBoxLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setScheduleBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(setClassTypeBoxLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setClassTypeBox, 0, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(4)
					.addComponent(setNumberOfPassengerBoxLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(setNumberOfPassengersTextField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(setNumberOfInfantsLabel, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(45)
					.addComponent(setNumberOfAdultsLabel, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(setNumberOfSeniorCitizenLabel, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(setNumberOfInfantsTextField, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setNumberOfAdultsTextField, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(setNumberOfSeniorCitizensTextField, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(46))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(30)
					.addComponent(setModeOfPaymentBoxLabel, GroupLayout.PREFERRED_SIZE, 133, Short.MAX_VALUE)
					.addGap(15)
					.addComponent(setModeOfPaymentBox, 0, 162, Short.MAX_VALUE)
					.addGap(4))
		);
		gl_firstPanel.setVerticalGroup(
			gl_firstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setFlightTypeBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setFlightTypeBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setAirlineBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setAirlineBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setTripTypeBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setTripTypeBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setOriginBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setOriginBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setDestinationLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setDestinationBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setScheduleBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setScheduleBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setClassTypeBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setClassTypeBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setNumberOfPassengerBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setNumberOfPassengersTextField, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setNumberOfInfantsLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setNumberOfAdultsLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setNumberOfSeniorCitizenLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addGap(20)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setNumberOfInfantsTextField, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setNumberOfAdultsTextField, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setNumberOfSeniorCitizensTextField, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(setModeOfPaymentBoxLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(setModeOfPaymentBox, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(239))
		);
		firstPanel.setLayout(gl_firstPanel);
		layeredPane.add(secondPanel, "name_20276470582800");
		
		nextButton = new JButton("Next");
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rightTextArea, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(237)
							.addComponent(nextButton, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addGap(72)))
					.addGap(14))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(rightTextArea, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		mainPanel.setLayout(gl_mainPanel);
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