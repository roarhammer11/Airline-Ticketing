import java.awt.*;

import javax.swing.*;

public class AirplaneTicketingSystem 
{

	
	
	public AirplaneTicketingSystem()
	{
		JPanel panel = new JPanel();
		JLabel chooseAirlineLabel = new JLabel("Choose Airline");
		panel.add(chooseAirlineLabel);
		
		String[] airlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"};
        JComboBox<String> airline = new JComboBox<String>(airlineChoices);
        panel.add(airline);
          
        JLabel chooseTripTypeLabel = new JLabel("Choose Trip Type");
        panel.add(chooseTripTypeLabel);
        String[] tripTypeChoices = {"One-Way Trip", "Round Trip"};
        JComboBox<String> tripType = new JComboBox<String>(tripTypeChoices);
        panel.add(tripType);
        
        JLabel setScheduleLabel = new JLabel("Set Schedule");
        panel.add(setScheduleLabel);
        String[] scheduleChoices = {"EMPTY"};
        JComboBox<String> schedule = new JComboBox<String>(scheduleChoices);
        panel.add(schedule);
        
        JPanel panel2 = new JPanel();
        panel2.setAlignmentX(-1);
        panel.add(panel2);
        JLabel chooseFlightType = new JLabel("Choose Flight Type");
        panel2.add(chooseFlightType);
        String[] flightTypeChoices = {"International", "Local"};
        JComboBox<String> flightType = new JComboBox<String>(flightTypeChoices);
        panel2.add(flightType);
        
        JLabel setOrigin = new JLabel("Set Origin");
        panel.add(setOrigin);
        String[] originChoices = {"EMPTY"};
        JComboBox<String> origin = new JComboBox<String>(originChoices);
        panel.add(origin);
        
        JLabel setDestination = new JLabel("Set Destination");
        panel.add(setDestination);
        String[] destinationChoices = {"EMPTY"};
        JComboBox<String> destination = new JComboBox<String>(destinationChoices);
        panel.add(destination);
        
        JLabel chooseClassType = new JLabel("Choose Class Type");
        panel.add(chooseClassType);
        String[] classTypeChoices = {"Business", "Economy", "Premium"};
        JComboBox<String> classType = new JComboBox<String>(classTypeChoices);
        panel.add(classType);
        
 
        
        
		JFrame frame = new JFrame();
		frame.setTitle("Airplane Ticketing System");
		frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.WEST);
        frame.setSize(new Dimension(800, 650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        
        
        
      
	}
}
