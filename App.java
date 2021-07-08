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
	private JButton backButton;
	private int numberOfPassengers, numberOfInfants, numberOfAdults, numberOfSeniorCitizens;
	private JButton nextButton;
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
		layeredPane.setBounds(5, 5, 767, 594);
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
		
		setFlightTypeBoxLabel = new JLabel("Flight Type  ");
		
		setAirlineBoxLabel = new JLabel("Airlines");
		
		setTripTypeBoxLabel = new JLabel("Trip Type");
		
		setOriginBoxLabel = new JLabel("Origin");
		
		setDestinationLabel = new JLabel("Destination");
		
		setScheduleBoxLabel = new JLabel("Schedule");
		
		setNumberOfPassengerBoxLabel = new JLabel("Number Of Passengers");
		setNumberOfPassengerBoxLabel.setLabelFor(setNumberOfPassengersTextField);
		
		setNumberOfAdultsLabel = new JLabel("Adults");
		
		setNumberOfInfantsLabel = new JLabel("Infants");
		
		setNumberOfSeniorCitizenLabel = new JLabel("Senior Citizen");
		
		setModeOfPaymentBoxLabel = new JLabel("Mode of Payment");
		
		setBankAccountNameLabel = new JLabel("Account Name");
		setBankAccountNameLabel.setBounds(12, 12, 92, 16);
		secondPanel.add(setBankAccountNameLabel);
		
		
		
		
		//Box
		setClassTypeBox = new JComboBox<String>();
		String[] classTypeChoices = {"Business", "Economy", "Premium"};
		setClassTypeBox.setModel(new DefaultComboBoxModel<String>(classTypeChoices));
		
		setDestinationBox = new JComboBox<String>();
		setDestinationLabel.setLabelFor(setDestinationBox);
		String[] destinationChoices = {"EMPTY"};
		setDestinationBox.setModel(new DefaultComboBoxModel<String>(destinationChoices));
		
		setOriginBox = new JComboBox<String>();
		setOriginBoxLabel.setLabelFor(setOriginBox);
		String[] originChoices = {"EMPTY"};
		setOriginBox.setModel(new DefaultComboBoxModel<String>(originChoices));
		
		setFlightTypeBox = new JComboBox<String>();
		setFlightTypeBoxLabel.setLabelFor(setFlightTypeBox);
		String[] flightTypeChoices = {"International", "Local"};
		setFlightTypeBox.setModel(new DefaultComboBoxModel<String>(flightTypeChoices));
		
		setAirlineBox = new JComboBox<String>();
		setAirlineBoxLabel.setLabelFor(setAirlineBox);
		setAirlineBox.setModel(new DefaultComboBoxModel<String>(internationalAirlineChoices));
		
		setTripTypeBox = new JComboBox<String>();
		setTripTypeBoxLabel.setLabelFor(setTripTypeBox);
		String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
		
		setScheduleBox = new JComboBox<String>();
		setScheduleBoxLabel.setLabelFor(setScheduleBox);
		String[] scheduleChoices = {"EMPTY"};
		setScheduleBox.setModel(new DefaultComboBoxModel<String>(scheduleChoices));
		
		setModeOfPaymentBox = new JComboBox<String>();
		setModeOfPaymentBoxLabel.setLabelFor(setModeOfPaymentBox);
		String[] modeOfPayment = {"Credit","Debit", "GCash"};
		setModeOfPaymentBox.setModel(new DefaultComboBoxModel<String>(modeOfPayment));
		
		
		//Text Fields
		setNumberOfPassengersTextField = new JTextField();
		setNumberOfPassengersTextField.setColumns(10);
	
		setNumberOfInfantsTextField = new JTextField();
		setNumberOfInfantsLabel.setLabelFor(setNumberOfInfantsTextField);
		setNumberOfInfantsTextField.setColumns(10);
		
		setNumberOfAdultsTextField = new JTextField();
		setNumberOfAdultsLabel.setLabelFor(setNumberOfAdultsTextField);
		setNumberOfAdultsTextField.setColumns(10);
		
		setNumberOfSeniorCitizensTextField = new JTextField();
		setNumberOfSeniorCitizenLabel.setLabelFor(setNumberOfSeniorCitizensTextField);
		setNumberOfSeniorCitizensTextField.setColumns(10);
		
		nextButton = new JButton("Next");
		
		rightTextArea = new JTextArea();
		rightTextArea.setWrapStyleWord(true);
		rightTextArea.setLineWrap(false);
		rightTextArea.setEditable(false);
		rightTextArea.setBackground(new Color(241, 241, 241));
		GroupLayout gl_firstPanel = new GroupLayout(firstPanel);
		gl_firstPanel.setHorizontalGroup(
			gl_firstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setFlightTypeBoxLabel)
							.addGap(36)
							.addComponent(setFlightTypeBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setAirlineBoxLabel)
							.addGap(59)
							.addComponent(setAirlineBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setTripTypeBoxLabel)
							.addGap(50)
							.addComponent(setTripTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setOriginBoxLabel)
							.addGap(68)
							.addComponent(setOriginBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setDestinationLabel)
							.addGap(38)
							.addComponent(setDestinationBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setScheduleBoxLabel)
							.addGap(49)
							.addComponent(setScheduleBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setClassTypeBoxLabel)
							.addGap(40)
							.addComponent(setClassTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addComponent(setNumberOfPassengerBoxLabel)
							.addGap(4)
							.addComponent(setNumberOfPassengersTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(19)
							.addComponent(setNumberOfInfantsLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(setNumberOfAdultsLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(setNumberOfSeniorCitizenLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addComponent(setNumberOfInfantsTextField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(setNumberOfAdultsTextField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(setNumberOfSeniorCitizensTextField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(setModeOfPaymentBoxLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(setModeOfPaymentBox, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addComponent(rightTextArea, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(633)
					.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
		);
		gl_firstPanel.setVerticalGroup(
			gl_firstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(setFlightTypeBoxLabel))
								.addComponent(setFlightTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(setAirlineBoxLabel))
								.addComponent(setAirlineBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(3)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(setTripTypeBoxLabel))
								.addComponent(setTripTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(9)
									.addComponent(setOriginBoxLabel))
								.addComponent(setOriginBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(9)
									.addComponent(setDestinationLabel))
								.addComponent(setDestinationBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(9)
									.addComponent(setScheduleBoxLabel))
								.addComponent(setScheduleBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(setClassTypeBoxLabel))
								.addComponent(setClassTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(setNumberOfPassengerBoxLabel))
								.addComponent(setNumberOfPassengersTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(setNumberOfInfantsLabel)
								.addComponent(setNumberOfAdultsLabel)
								.addComponent(setNumberOfSeniorCitizenLabel))
							.addGap(12)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(setNumberOfInfantsTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(setNumberOfAdultsTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(setNumberOfSeniorCitizensTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_firstPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_firstPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(setModeOfPaymentBoxLabel))
								.addComponent(setModeOfPaymentBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_firstPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(rightTextArea, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
					.addGap(42)
					.addComponent(nextButton)
					.addGap(27))
		);
		firstPanel.setLayout(gl_firstPanel);
		setBankAccountName = new JTextField();
		setBankAccountName.setBounds(122, 10, 114, 20);
		secondPanel.add(setBankAccountName);
		setBankAccountName.setColumns(10);
		
		
		
		
		
		
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		//Buttons
		backButton = new JButton("Back");
		backButton.setBounds(47, 556, 98, 26);
		secondPanel.add(backButton);
	}
	
	private void createEvents()
	{
		
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