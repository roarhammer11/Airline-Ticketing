import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import lombok.Getter;

@Getter
public class ManageTickets 
{
	private  JTextField setTicketNumberTextField;
	private  JTextArea  setTicketTextArea;
	private  JButton setBackButton, minimizeButton, exitButton, editTicketButton, deleteTicketButton;
	private  JLabel setTicketNumberTextFieldLabel;
	public ManageTickets()
	{
		setTicketNumberTextField = new JTextField();
		setTicketNumberTextFieldLabel = new JLabel("Ticket Number");
		setBackButton = new JButton("Back");
		setTicketTextArea = new JTextArea();
		minimizeButton = new JButton();
		exitButton = new JButton();
		editTicketButton = new JButton("Edit Ticket");
		deleteTicketButton = new JButton("Delete Ticket");
	}
	
	public void setTicketNumberTextField()
	{
		setTicketNumberTextField.setBounds(333, 78, 114, 20);
		setTicketNumberTextField.setColumns(10);
		setTicketNumberTextFieldLabel.setBounds(350, 50, 100, 16);
	}
	
	public void setBackButton()
	{
		setBackButton.setFocusPainted(false);
		setBackButton.setFont(new Font("Dialog", Font.BOLD, 21));
		setBackButton.setBounds(58, 550, 98, 28);
	}
	
	public void setTicketTextArea()
	{
		setTicketTextArea.setBounds(240, 160, 300,370);
		setTicketTextArea.setColumns(10);
		setTicketTextArea.setRows(5);
		setTicketTextArea.setEditable(false);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Border margin = new EmptyBorder(20, 40, 20, 20);
		
		setTicketTextArea.setLineWrap(false);
		setTicketTextArea.setWrapStyleWord(true);
		setTicketTextArea.setBorder(new CompoundBorder(blackline,margin));
	}
	
	public void setMinimizeButton()
	{
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBounds(719, 0, 40, 35);
		minimizeButton.setOpaque(true);
		minimizeButton.setContentAreaFilled(true);
		minimizeButton.setBackground(Color.WHITE);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/-.png")));	
	}
	
	public void setExitButton()
	{
		exitButton.setFocusPainted(false);
		exitButton.setBounds(760, 0, 40, 35);
		exitButton.setOpaque(true);
		exitButton.setContentAreaFilled(true);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorderPainted(false);
		exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/x.png")));	
	}
	
	public void setEditTicketButton()
	{
		editTicketButton.setFocusPainted(false);
		editTicketButton.setFont(new Font("Dialog", Font.BOLD, 21));
		editTicketButton.setBounds(280, 550, 200, 26);
	}
	
	public void setDeleteTicketButton()
	{
		deleteTicketButton.setFocusPainted(false);
		deleteTicketButton.setFont(new Font("Dialog", Font.BOLD, 21));
		deleteTicketButton.setBounds(580, 550, 200, 26);
	}
}
