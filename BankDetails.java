import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankDetails {
	private JTextField setBankAccountNameTextField, setBankAccountNumberTextField, setBankAccountEmailTextField, setBankAccountPhoneNumberTextField;
	private JLabel setBankDetailsLabel, setBankAccountNumberTextFieldLabel,setBankAccountNameTextFieldLabel, setBankAccountEmailTextFieldLabel, setBankAccountPhoneNumberTextFieldLabel;
	private JButton setBackButton, setSubmitButton;
	
	// Constructor
	public BankDetails()
	{
		setBankDetailsLabel = new JLabel("Bank Details");
		setBankAccountNameTextFieldLabel = new JLabel("Account Name");
		setBankAccountNumberTextFieldLabel = new JLabel("Account Number");
		setBankAccountEmailTextFieldLabel = new JLabel("Email Address");
		setBankAccountPhoneNumberTextFieldLabel = new JLabel("Phone Number");
		
		setBankAccountNameTextField = new JTextField();
		setBankAccountNumberTextField = new JTextField();
		setBankAccountEmailTextField = new JTextField();
		setBankAccountPhoneNumberTextField = new JTextField();
		
		setBackButton = new JButton("Back");
		setSubmitButton = new JButton("Submit");
		
	}
	
	// Initialization
	public void setBankDetails(Component component)
	{
		setBankDetailsLabel.setLabelFor(component);
		setBankDetailsLabel.setBounds(304, 28, 174, 35);
		setBankDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 27));
	}
	
	public void setBankAccountNameTextField()
	{	
		setBankAccountNameTextField.setBounds(432, 111, 225, 30);
		setBankAccountNameTextField.setColumns(10);		
		setBankAccountNameTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		
		setBankAccountNameTextFieldLabel.setLabelFor(setBankAccountNameTextField);
		setBankAccountNameTextFieldLabel.setBounds(130, 111, 150, 30);
		setBankAccountNameTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setBankAcountNumberTextField()
	{
		setBankAccountNumberTextField.setBounds(432, 151, 225, 30);
		setBankAccountNumberTextField.setColumns(10);
		setBankAccountNumberTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		
		setBankAccountNumberTextFieldLabel.setLabelFor(setBankAccountNumberTextField);
		setBankAccountNumberTextFieldLabel.setBounds(130, 151, 180, 25);
		setBankAccountNumberTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));		
	}
	
	public void setBankAccountEmailTextField()
	{
		setBankAccountEmailTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		setBankAccountEmailTextField.setColumns(10);
		setBankAccountEmailTextField.setBounds(432, 191, 225, 30);
		
		setBankAccountEmailTextFieldLabel.setLabelFor(setBankAccountEmailTextField);
		setBankAccountEmailTextFieldLabel.setBounds(130, 191, 150, 28);
		setBankAccountEmailTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setBankAccountPhoneNumberTextField()
	{
		setBankAccountPhoneNumberTextField.setFont(new Font("Dialog", Font.PLAIN, 21));
		setBankAccountPhoneNumberTextField.setColumns(10);
		setBankAccountPhoneNumberTextField.setBounds(432, 231, 225, 30);
		
		setBankAccountPhoneNumberTextFieldLabel.setLabelFor(setBankAccountPhoneNumberTextField);
		setBankAccountPhoneNumberTextFieldLabel.setBounds(130, 231, 166, 28);
		setBankAccountPhoneNumberTextFieldLabel.setFont(new Font("Dialog", Font.BOLD, 21));
	}
	
	public void setBackButton()
	{
		
		setBackButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setBackButton.setBounds(58, 550, 98, 28);
	}
	
	public void setSubmitButton()
	{
		setSubmitButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setSubmitButton.setBounds(619, 550, 108, 26);
	}
	
	// Get TextFields
	public JTextField getSetBankAccountNameTextField()
	{
		return setBankAccountNameTextField;
	}
	
	public JTextField getSetBankAccountNumberTextField()
	{
		return setBankAccountNumberTextField;
	}
	
	public JTextField getSetBankAccountEmailTextField()
	{
		return setBankAccountEmailTextField;
	}
	
	public JTextField getSetBankAccountPhoneNumberTextField()
	{
		return setBankAccountPhoneNumberTextField;
	}
	
	// Get Labels
	public JLabel getSetBankDetailsLabel()
	{
		return setBankDetailsLabel;
	}
	
	public JLabel getSetBankAccountNameTextFieldLabel()
	{
		return setBankAccountNameTextFieldLabel;
	}
	
	public JLabel getSetBankAccountNumberTextFieldLabel()
	{
		return setBankAccountNumberTextFieldLabel;
	}
	
	public JLabel getSetBankAccountEmailTextFieldLabel()
	{
		return setBankAccountEmailTextFieldLabel;
	}
	
	public JLabel getSetBankAccountPhoneNumberTextFieldLabel()
	{
		return setBankAccountPhoneNumberTextFieldLabel;
	}
	
	// Get Buttons
	
	public JButton getSetBackButton()
	{
		return setBackButton;
	}
	
	public JButton getSetSubmitButton()
	{
		return setSubmitButton;
	}
}
