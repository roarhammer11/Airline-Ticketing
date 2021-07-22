import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import resources.ImageButton;

@Getter
public class ManageTickets 
{
	private  JTextField setTicketNumberTextField;
	private  JTextArea  setTicketTextArea;
	private  JButton setBackButton, minimizeButton, exitButton, editTicketButton, deleteTicketButton;
	JScrollPane scrollPane;
	public ManageTickets()
	{
		setTicketNumberTextField = new JTextField();
		setBackButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/back.png"))
	              .getImage(), 149, 30);
		setTicketTextArea = new JTextArea();
		minimizeButton = new JButton();
		exitButton = new JButton();
		editTicketButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/edit ticket.png"))
	              .getImage(), 150, 30);
		deleteTicketButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/delete ticket.png"))
	              .getImage(), 150, 30);
		
		scrollPane= new JScrollPane(setTicketTextArea);
	}
	
	public void setTicketNumberTextField()
	{
		setTicketNumberTextField.setBorder(BorderFactory.createLineBorder(new Color(56, 182, 255), 1));
		setTicketNumberTextField.setBounds(127, 298, 312, 28);
		setTicketNumberTextField.setColumns(10);
	}
	
	public void setBackButton()
	{
		setBackButton.setFocusPainted(false);
		setBackButton.setOpaque(false);
		setBackButton.setContentAreaFilled(false);
		setBackButton.setBorderPainted(false);
		setBackButton.setBounds(14, 748, 149, 30);
	}
	
	public void setScrollPane()
	{
		scrollPane.setPreferredSize(new Dimension(457, 278));
		scrollPane.setBounds(55, 400, 457, 278);
	}
	
	public void setTicketTextArea()
	{
		setTicketTextArea.setBounds(55, 400, 457, 278);
		setTicketTextArea.setColumns(10);
		setTicketTextArea.setRows(5);
		setTicketTextArea.setEditable(false);
		
		Border blackline = BorderFactory.createLineBorder(new Color(56, 182, 255), 3);
		Border margin = new EmptyBorder(20, 40, 20, 20);
		
		setTicketTextArea.setLineWrap(false);
		setTicketTextArea.setWrapStyleWord(true);
		setTicketTextArea.setBorder(new CompoundBorder(blackline,margin));
	}
	
	public void setExitButton()
	{
		exitButton.setFocusPainted(false);
		exitButton.setBounds(515, 15, 40, 35);
		exitButton.setOpaque(true);
		exitButton.setContentAreaFilled(true);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorderPainted(false);
		exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/x.png")));	
	}
	
	public void setMinimizeButton()
	{
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBounds(475, 15, 40, 35);
		minimizeButton.setOpaque(true);
		minimizeButton.setContentAreaFilled(true);
		minimizeButton.setBackground(Color.WHITE);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/-.png")));	
	}
	
	public void setEditTicketButton()
	{
		editTicketButton.setFocusPainted(false);
		editTicketButton.setOpaque(false);
		editTicketButton.setContentAreaFilled(false);
		editTicketButton.setBorderPainted(false);
		editTicketButton.setBounds(207, 748, 150, 30);
	}
	
	public void setDeleteTicketButton()
	{
		deleteTicketButton.setFocusPainted(false);
		deleteTicketButton.setOpaque(false);
		deleteTicketButton.setContentAreaFilled(false);
		deleteTicketButton.setBorderPainted(false);
		deleteTicketButton.setBounds(398, 749, 150, 30);
	}
}
