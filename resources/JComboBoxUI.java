package resources;

import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class JComboBoxUI extends BasicComboBoxUI 
{
	private Color skyBlue = new Color(106, 218, 255);
	@Override
    protected ComboPopup createPopup()
    {
        BasicComboPopup bcp = (BasicComboPopup) super.createPopup();
        bcp.setBorder(BorderFactory.createLineBorder(skyBlue, 1));
        return bcp;
    }
    
    @Override
    protected JButton createArrowButton() 
    {
    	JButton button = new ImageButton (new ImageIcon(getClass()
	              .getResource("/resources/combobox button.png"))
	              .getImage(), 28, 24);
    	button.setBackground(skyBlue);
    	button.setFocusPainted(false);
    	button.setOpaque(false);
    	button.setContentAreaFilled(false);
    	button.setBorderPainted(false);
		return button;
    }
}