import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
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
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class App extends JFrame {

	private JPanel mainPanel;
	
	String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "ANA Airlines", 
    		"Japan Airlines", "Greater Bay Airlines", "Hongkong Airlines", "Air Busan", "Jeju Air", "Jetstar Asia Airways", 
    		"Singapore Airlines", "Indonesia Air Asia", "Lion Air"};
	
	private JLayeredPane layeredPane;
	private JPanel firstPanel;
	private JLabel setFlightTypeBoxLabel;
	private JComboBox<String> setFlightTypeBox;
	private JLabel setAirlineBoxLabel;
	private JComboBox<String> setAirlineBox;
	private JLabel setTripTypeBoxLabel;
	private JComboBox<String> setTripTypeBox;
	private JLabel setOriginBoxLabel;
	private JComboBox<String> setOriginBox;
	private JLabel setDestinationLabel;
	private JComboBox<String> setDestinationBox;
	private JLabel setScheduleBoxLabel;
	private JComboBox<String> setScheduleBox;
	private JLabel setClassTypeBoxLabel;
	private JComboBox setClassTypeBox;
	private JPanel secondPanel;
	private JLabel setBankAccountNameLabel;
	private JTextField setBankAccountName;
	private JButton backButton;
	private JButton nextButton;
	private JTextField textField;
	private JLabel setNumberOfPassengerBoxLabel;
	private JLabel setNumberOfAdultsLabel;
	private JLabel setNumberOfInfantsLabel;
	private JLabel setNumberOfSeniorCitizenLabel;
	private JTextField setNumberOfInfants;
	private JTextField setNumberOfAdults;
	private JTextField setNumberOfSeniorCitizen;
	private JLabel paymentBoxLabel;
	
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
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 280, 594);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		firstPanel = new JPanel();
		layeredPane.add(firstPanel, "name_45847991791500");
		
		setClassTypeBox = new JComboBox();
		setClassTypeBox.setBounds(82, 199, 81, 25);
		
		setClassTypeBoxLabel = new JLabel("Class Type");
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
		
		setDestinationBox = new JComboBox<String>();
		setDestinationBox.setBounds(82, 136, 67, 25);
		
		setOriginBox = new JComboBox<String>();
		setOriginBox.setBounds(82, 105, 67, 25);
		
		setFlightTypeBox = new JComboBox<String>();
		setFlightTypeBox.setBounds(82, 12, 99, 25);
		
		setAirlineBox = new JComboBox<String>();
		setAirlineBox.setBounds(82, 43, 146, 25);
		
		setTripTypeBox = new JComboBox<String>();
		setTripTypeBox.setBounds(82, 74, 105, 25);
		
		setScheduleBox = new JComboBox<String>();
		setScheduleBox.setBounds(82, 168, 67, 25);
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
		
		textField = new JTextField();
		textField.setBounds(154, 229, 114, 20);
		firstPanel.add(textField);
		textField.setColumns(10);
		
		setNumberOfPassengerBoxLabel = new JLabel("Number Of Passengers");
		setNumberOfPassengerBoxLabel.setBounds(12, 231, 133, 16);
		firstPanel.add(setNumberOfPassengerBoxLabel);
		
		setNumberOfAdultsLabel = new JLabel("Adults");
		setNumberOfAdultsLabel.setBounds(108, 259, 55, 16);
		firstPanel.add(setNumberOfAdultsLabel);
		
		setNumberOfInfantsLabel = new JLabel("Infants");
		setNumberOfInfantsLabel.setBounds(23, 259, 55, 16);
		firstPanel.add(setNumberOfInfantsLabel);
		
		setNumberOfSeniorCitizenLabel = new JLabel("Senior Citizen");
		setNumberOfSeniorCitizenLabel.setBounds(185, 259, 83, 16);
		firstPanel.add(setNumberOfSeniorCitizenLabel);
		
		setNumberOfInfants = new JTextField();
		setNumberOfInfants.setBounds(12, 284, 66, 20);
		firstPanel.add(setNumberOfInfants);
		setNumberOfInfants.setColumns(10);
		
		setNumberOfAdults = new JTextField();
		setNumberOfAdults.setColumns(10);
		setNumberOfAdults.setBounds(97, 284, 66, 20);
		firstPanel.add(setNumberOfAdults);
		
		setNumberOfSeniorCitizen = new JTextField();
		setNumberOfSeniorCitizen.setColumns(10);
		setNumberOfSeniorCitizen.setBounds(185, 284, 66, 20);
		firstPanel.add(setNumberOfSeniorCitizen);
		
		paymentBoxLabel = new JLabel("New label");
		paymentBoxLabel.setBounds(12, 325, 55, 16);
		firstPanel.add(paymentBoxLabel);
		
		secondPanel = new JPanel();
		layeredPane.add(secondPanel, "name_45848002587000");
		secondPanel.setLayout(null);
		
		setBankAccountNameLabel = new JLabel("Account Name");
		setBankAccountNameLabel.setBounds(12, 12, 92, 16);
		secondPanel.add(setBankAccountNameLabel);
		
		setBankAccountName = new JTextField();
		setBankAccountName.setBounds(122, 10, 114, 20);
		secondPanel.add(setBankAccountName);
		setBankAccountName.setColumns(10);
		
		backButton = new JButton("Back");
		
		backButton.setBounds(47, 556, 98, 26);
		secondPanel.add(backButton);
		mainPanel.add(layeredPane);
		
		nextButton = new JButton("Next");
		
		nextButton.setBounds(627, 559, 98, 26);
		mainPanel.add(nextButton);
	}
	
	private void createEvents()
	{
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(firstPanel.getParent() == layeredPane)
				{
					switchPanels(secondPanel, layeredPane);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Could Not Switch Pane");
				}
					
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(firstPanel, layeredPane);
			}
		});
	}
}
