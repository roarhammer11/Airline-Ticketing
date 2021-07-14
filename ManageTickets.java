import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ManageTickets 
{
	private JTextField setTicketIDTextField;
	private JButton setBackButton;
	private JLabel setTicketIDTextFieldLabel;
	public ManageTickets()
	{
		setTicketIDTextField = new JTextField();
		setTicketIDTextFieldLabel = new JLabel("Ticket ID");
		setBackButton = new JButton("Back");
			
	}
	
	public void setTicketIDTextField()
	{
		setTicketIDTextField.setBounds(313, 78, 114, 20);
		setTicketIDTextField.setColumns(10);
	}
	
	public void setBackButton()
	{
		setBackButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setBackButton.setBounds(58, 550, 98, 28);
	}
	
	public void setTicketIDTextFieldLabel()
	{
		setTicketIDTextFieldLabel.setBounds(337, 50, 55, 16);
	}
	
	public JTextField getSetTicketIDTextField()
	{
		return setTicketIDTextField;
	}
	
	public JButton getSetBackButton()
	{
		return setBackButton;
	}
	
	public JLabel getSetTicketIDTextFieldLabel()
	{
		return setTicketIDTextFieldLabel;
	}
	
	
}
