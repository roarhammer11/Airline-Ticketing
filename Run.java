import javax.swing.SwingUtilities;

public class Run {

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(() ->
		{
			// TODO Auto-generated method stub
			 new AirplaneTicketingSystem();
		});
//		SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				new AirplaneTicketingSystem();
//			}});
	}
}
