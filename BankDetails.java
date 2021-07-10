import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankDetails {
	private JTextField setBankAccountName;
	private JLabel setBankAccountNumberLabel,setBankAccountNameLabel;
	
	public BankDetails()
	{
		setBankAccountName = new JTextField();
	}
	public void setBankAccountNameField()
	{	
		setBankAccountName.setBounds(165, 109, 170, 28);
		setBankAccountName.setColumns(10);		
		setBankAccountNameLabel = new JLabel("Account Name");
		setBankAccountNameLabel.setBounds(24, 109, 133, 28);
		setBankAccountNameLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		setBankAccountNameLabel.setLabelFor(setBankAccountName);
	}
	
	public JTextField getSetBankAccountName()
	{
		return setBankAccountName;
	}
	public JLabel getSetBankAccountNameLabel()
	{
		return setBankAccountNameLabel;
	}
	
	
	
}
