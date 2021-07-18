import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import lombok.Getter;


@Getter
public class MainMenu 
{
	private JButton setManageTicketsButton, minimizeButton, exitButton, setQuitButton, setBookTicketButton;
	private JPanel  leftSide;
	
	public MainMenu()
	{
		setManageTicketsButton = new JButton("Access Tickets");
		setBookTicketButton = new JButton();
		setQuitButton = new JButton("Quit");
		exitButton = new JButton();
		minimizeButton = new JButton();
		leftSide = new JPanel();
	}
	
	public void setManageTicketsButton()
	{
		setManageTicketsButton.setFocusPainted(false);
		setManageTicketsButton.setOpaque(false);
		setManageTicketsButton.setContentAreaFilled(false);
		setManageTicketsButton.setBorderPainted(false);
		setManageTicketsButton.setBounds(547, 208, 145, 26);
	}
	
	public void setBookTicketButton()
	{
		setBookTicketButton.setFocusPainted(false);
		setBookTicketButton.setOpaque(false);
		setBookTicketButton.setContentAreaFilled(false);
		setBookTicketButton.setBorderPainted(false);
		setBookTicketButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/book now.png")));	
		setBookTicketButton.setBounds(500, 275, 279, 50);
	}
	
	public void setQuitButton()
	{
		setQuitButton.setFocusPainted(false);
		setQuitButton.setOpaque(false);
		setQuitButton.setContentAreaFilled(false);
		setQuitButton.setBorderPainted(false);
		setQuitButton.setBounds(547, 347, 145, 26);
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
	
	public void setLeftSide()
	{
		leftSide.setPreferredSize(new java.awt.Dimension(400, 650));
		leftSide.setBounds(0,0,400,650);
		leftSide.setBackground(new java.awt.Color(56, 182, 255));
	}
}
