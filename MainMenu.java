import javax.swing.JButton;

public class MainMenu 
{
	private JButton setManageTicketsButton;
	private JButton setBookTicketButton;
	private JButton setQuitButton;
	
	public MainMenu()
	{
		setManageTicketsButton = new JButton("Access Tickets");
		setBookTicketButton = new JButton("Book Tickets");
		setQuitButton = new JButton("Quit");
	}
	
	public void setManageTicketsButton()
	{
		setManageTicketsButton.setBounds(547, 208, 145, 26);
	}
	
	public void setBookTicketButton()
	{
		
		setBookTicketButton.setBounds(547, 275, 145, 26);
	}
	
	public void setQuitButton()
	{
		setQuitButton.setBounds(547, 347, 145, 26);
	}
	
	public JButton getSetManageTicketsButton()
	{
		return setManageTicketsButton;
	}
	
	public JButton getSetBookTicketButton()
	{
		return setBookTicketButton;
	}
	
	public JButton getSetQuitButton()
	{
		return setQuitButton;
	}
	
	
}
