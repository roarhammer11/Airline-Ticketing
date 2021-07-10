
public class Receipt 
{
	private String receipt = "";
	
	public void setReceipt(String string, int number)
	{
		receipt += string + Integer.toString(number) + "\n";
	}
	
	public void setReceipt(String string, Object object)
	{
		receipt += string + object + "\n";
	}
	
	public String getReceipt()
	{
		return receipt;
	}
}


