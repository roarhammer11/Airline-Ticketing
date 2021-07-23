import java.awt.Color;
import java.awt.Font;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import lombok.Getter;
import resources.ImageButton;
import resources.JComboBoxUI;

@Getter
public class BankDetails 
{
	private JTextField setBankAccountNameTextField, setBankAccountNumberTextField, setBankAccountEmailTextField, setBankAccountPhoneNumberTextField;
	private JButton setBackButton, setSubmitButton, minimizeButton, exitButton;
	private JComboBox<String> setBankCompany;
	private Color skyBlue = new Color(106, 218, 255);
	private String[] bankCompany = {"BPI", "CHINA BANK", "LAND BANK"};
	
	private Border lineBorder;
	
	// Constructor
	public BankDetails()
	{	
		setBankAccountNameTextField = new JTextField();
		setBankAccountNumberTextField = new JTextField();
		setBankAccountEmailTextField = new JTextField();
		setBankAccountPhoneNumberTextField = new JTextField();
		
		setBackButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/back.png"))
	              .getImage(), 149, 30);
		setSubmitButton = new ImageButton(new ImageIcon(getClass()
	              .getResource("/resources/submit.png"))
	              .getImage(), 149, 30);
		minimizeButton = new JButton();
		exitButton = new JButton();
		
		setBankCompany = new JComboBox<String>();
		
		 lineBorder = new LineBorder(skyBlue, 1, true);

	}
	
	// Initialization
	
	public void setBankCompany()
	{
		setBankCompany.setUI(new JComboBoxUI());
		setBankCompany.setFocusable(false);
		setBankCompany.setBounds(230, 263, 312, 25);
		setBankCompany.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setBankCompany.setBackground(skyBlue);
		setBankCompany.setForeground(Color.WHITE);
		setBankCompany.setModel(new DefaultComboBoxModel<String>(bankCompany));	
	}
	
	public void setBankAccountNameTextField()
	{	
		setBankAccountNameTextField.setBorder(lineBorder);
		setBankAccountNameTextField.setForeground(skyBlue);
		setBankAccountNameTextField.setBounds(222, 400, 311, 26);
		setBankAccountNameTextField.setColumns(10);		
		setBankAccountNameTextField.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
	}
	
	public void setBankAcountNumberTextField()
	{
		setBankAccountNumberTextField.setBorder(lineBorder);
		setBankAccountNumberTextField.setForeground(skyBlue);
		setBankAccountNumberTextField.setBounds(222, 432, 311, 26);
		setBankAccountNumberTextField.setColumns(10);
		setBankAccountNumberTextField.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
	}
	
	public void setBankAccountEmailTextField()
	{
		setBankAccountEmailTextField.setBorder(lineBorder);
		setBankAccountEmailTextField.setForeground(skyBlue);
		setBankAccountEmailTextField.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setBankAccountEmailTextField.setColumns(10);
		setBankAccountEmailTextField.setBounds(222, 465, 311, 26);
	}
	
	public void setBankAccountPhoneNumberTextField()
	{
		setBankAccountPhoneNumberTextField.setBorder(lineBorder);
		setBankAccountPhoneNumberTextField.setForeground(skyBlue);
		setBankAccountPhoneNumberTextField.setFont(new Font("Malgun gothic semilight", Font.PLAIN, 20));
		setBankAccountPhoneNumberTextField.setColumns(10);
		setBankAccountPhoneNumberTextField.setBounds(222, 500, 311, 26);
	}
	
	public void setBackButton()
	{	
		setBackButton.setFocusPainted(false);
		setBackButton.setOpaque(false);
		setBackButton.setContentAreaFilled(false);
		setBackButton.setBorderPainted(false);
		setBackButton.setBounds(14, 748, 149, 30);
	}
	
	public void setSubmitButton()
	{
		setSubmitButton.setName("Submit");
		setSubmitButton.setFocusPainted(false);
		setSubmitButton.setOpaque(false);
		setSubmitButton.setContentAreaFilled(false);
		setSubmitButton.setBorderPainted(false);
		setSubmitButton.setBounds(398, 749, 149, 30);
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
	
	protected boolean checkStringForDigits(String s) 
	{
	    if (s == null)
	    {
	    	return false;
	    }
	    int len = s.length();
	    for (int i = 0; i < len; i++) 
	    {
	    	if ((Character.isDigit(s.charAt(i)) == true)) 
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	protected boolean checkStringForLetters(String s) 
	{
	    if (s == null)
	    {
	    	return false;
	    }
	    
	    int len = s.length();
	    
	    for (int i = 0; i < len; i++) 
	    {
	    	if ((Character.isLetter(s.charAt(i)) == true)) 
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	protected boolean checkStringForEmailAddress(String s)
	{
		if (s == null)
		{
			return false;
		}
		
		else
		{
			try 
			{	
				InternetAddress emailAddress = new InternetAddress(s);
				emailAddress.validate();
				return true;
			} 
			
			catch (AddressException e) 
			{
				return false;
			}
		}	
	}
	
	protected boolean checkPhoneNumber(String s) 
	{
	    if (s == null)
	    {
	    	return false;
	    }
	    
	    else
	    {
	    	if (s.length() != 11)
	    	{
	    		return false;
	    	}
	    	
	    	else if (s.charAt(0) != '0')
	    	{
	    		return false;
	    	}
	    	
	    	else if (s.charAt(1) != '9')
	    	{
	    		return false;
	    	}
	    	
	    	else
	    	{
	    		for (int i = 0; i < s.length(); i++) 
    		    {
    		    	if ((Character.isLetter(s.charAt(i)) == true)) 
    		        {
    		            return false;
    		        }
    		    }   		
	    	}
	    }
	    return true;
	}
}
