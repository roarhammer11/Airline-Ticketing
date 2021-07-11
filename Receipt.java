
public class Receipt 
{
	private String receipt = "", temp = "";
	
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
	
	public String setReceiptToTemp()
	{
		return temp = receipt;
	}
	public String setTempToReceipt()
	{	
		return receipt = temp;
	}
	
	public String resetReceipt()
	{
		return receipt = "";
	}
}


