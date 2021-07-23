package resources;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class ImageLabel extends JLabel
{

  private Image img;
  private int width, height;
  public ImageLabel(Image img, int width, int height) 
  {
    this.img = img;
    this.width = width;
    this.height = height;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
    revalidate();
    repaint();
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    g.drawImage(img, 0, 0, width, height, null);
  }
}