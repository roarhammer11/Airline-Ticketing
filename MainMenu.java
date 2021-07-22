import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import lombok.Getter;
import resources.ImageButton;
import resources.ImageLabel;

@Getter
public class MainMenu 
{
	private JButton setManageTicketsButton, minimizeButton, exitButton, setQuitButton, setBookTicketButton;
	private JLabel menu;
	
	public MainMenu()
	{
		setManageTicketsButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/manage tickets.png"))
	              .getImage(), 173, 32);
		setBookTicketButton = new ImageButton(new ImageIcon(getClass()
              .getResource("/resources/book now.png"))
              .getImage(), 173, 32);
		setQuitButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/quit.png"))
	              .getImage(), 42, 22);
		menu = new ImageLabel(new ImageIcon(getClass()
	              .getResource("/resources/main menu1.png"))
	              .getImage(), 283, 262);
		exitButton = new JButton();
		minimizeButton = new JButton();
	}
	
	public void setManageTicketsButton()
	{
		setManageTicketsButton.setFocusPainted(false);
		setManageTicketsButton.setOpaque(false);
		setManageTicketsButton.setContentAreaFilled(false);
		setManageTicketsButton.setBorderPainted(false);
		setManageTicketsButton.setBounds(192, 435, 173, 32);
	}
	
	public void setBookTicketButton()
	{
		setBookTicketButton.setFocusPainted(false);
		setBookTicketButton.setOpaque(true);
		setBookTicketButton.setContentAreaFilled(true);
		setBookTicketButton.setBorderPainted(false);
		setBookTicketButton.setBounds(192, 471, 173, 32);
	}
	
	public void setQuitButton()
	{
		setQuitButton.setFocusPainted(false);
		setQuitButton.setOpaque(true);
		setQuitButton.setContentAreaFilled(true);
		setQuitButton.setBorderPainted(false);
		setQuitButton.setBounds(253, 505, 42, 22);
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
	
	public void setMenu()
	{
		menu.setBounds(139, 160, 283, 262);
	}
}
