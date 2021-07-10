import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class FlightDetails {
	
	private JLabel setFlightTypeBoxLabel, setAirlineBoxLabel, setTripTypeBoxLabel;
	private JComboBox<String> setFlightTypeBox, setAirlineBox, setTripTypeBox;
	private String[] internationalAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia", "Kansai Intl. Airport", 
    		"Hiroshima Airport", "Dunhuang Airport", "Beijing Capital Intl. Airport", "Taipei Songshan Airport", "Tainan Airport", "Daegu Int'l. Airport", 
    		"Jeju Int'l. Airport", "Banyuwangi Int'l Airport", "Hang Nadim Int'l Airport"},
					  localAirlineChoices = {"Philippine Airline", "Air Asia", "Cebu Pacific", "Quatar Airways", "Saudia"},
					  classTypeChoices = {"Business", "Economy", "Premium"},
					  flightTypeChoices = { "Local", "International"},
					  tripTypeChoices = {"One-Way Trip", "Round Trip"},
					  modeOfPaymentChoices = {"Credit","Debit", "GCash"};
	public FlightDetails()
	{
		setFlightTypeBox = new JComboBox<String>();
		setAirlineBox = new JComboBox<String>();
		setTripTypeBox = new JComboBox<String>();
		
		setFlightTypeBoxLabel = new JLabel("Flight Type");
		setAirlineBoxLabel = new JLabel("Airlines");
		setTripTypeBoxLabel = new JLabel("Trip Type");
	}
	
				
	public void setFlightTypeBox()
	{
		setFlightTypeBox.setBounds(106, 111, 225, 25);		
		setFlightTypeBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setFlightTypeBox.setModel(new DefaultComboBoxModel<String>(flightTypeChoices));
		
		setFlightTypeBoxLabel.setBounds(12, 111, 97, 25);
		setFlightTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		setFlightTypeBoxLabel.setLabelFor(setFlightTypeBox);
	}
	
	public void setAirlineBox()
	{
		setAirlineBox.setBounds(106, 141, 225, 25);
		setAirlineBox.setFont(new Font("Dialog", Font.BOLD, 16));
		setAirlineBox.setModel(new DefaultComboBoxModel<String>(localAirlineChoices));
		
		setAirlineBoxLabel.setBounds(12, 141, 97, 25);
		setAirlineBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		setAirlineBoxLabel.setLabelFor(setAirlineBox);
	}
	
	public void setTripTypeBox()
	{
		
		setTripTypeBox.setBounds(106, 171, 225, 25);
		setTripTypeBox.setFont(new Font("Dialog", Font.BOLD, 17));
		setTripTypeBox.setModel(new DefaultComboBoxModel<String>(tripTypeChoices));
		
		setTripTypeBoxLabel.setLabelFor(setTripTypeBox);
		setTripTypeBoxLabel.setBounds(12, 171, 97, 25);
		setTripTypeBoxLabel.setFont(new Font("Dialog", Font.BOLD, 17));
	}
	
	//Get Boxes
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
	
	//Get Labels
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
	
	
	
	
	
	

}
