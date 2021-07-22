import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Price 
{
	private double adultPrice, infantPrice, seniorCitizenPrice;
	
	public void setPrice(double basePrice, int numberOfAdults, int numberOfInfants, int numberOfSeniorCitizens, String classType, String tripType)
	{
		if (numberOfAdults != 0)
		{
			this.adultPrice = calculatePrices(basePrice, classType, tripType) * numberOfAdults;
		}
		
		else
		{
			adultPrice = 0;
		}
				
		if (numberOfInfants != 0)
		{
			infantPrice = (basePrice - (basePrice * 0.50));
			infantPrice = calculatePrices(infantPrice, classType, tripType) * numberOfInfants;
		}
		
		else
		{
			infantPrice = 0;
		}
		
		if (numberOfSeniorCitizens != 0)
		{
			seniorCitizenPrice = (basePrice - (basePrice*0.20));
			seniorCitizenPrice = calculatePrices(seniorCitizenPrice, classType, tripType) * numberOfSeniorCitizens;
		}
		
		else
		{
			seniorCitizenPrice = 0;
		}
	}
	
	private double calculatePrices(double price,String classType, String tripType)
	{
		switch(tripType)
		{
			case "ROUND TRIP":
			{
				switch(classType)
				{
					case "ECONOMY":
					{
						price = (price * 0.6) + price;
						break;
					}
					case "PREMIUM":
					{
						price = premiumClass(price, true);
						break;
					}
					case "BUSINESS":
					{						
						price = businessClass(price, true);
						break;
					}
				}
				break;
			}
			case "ONE-WAY TRIP":
			{
				switch(classType)
				{
					case "ECONOMY":
					{
						break;
					}
					case "PREMIUM":
					{
						price = premiumClass(price, false);
						break;
					}
					case "BUSINESS":
					{						
						price = businessClass(price, false);
						break;
					}
				}
				break;
			}
		}
		return price;
	}
	
	private double premiumClass(double price, boolean roundTrip)
	{
		if (roundTrip)
		{		
			return price = (price * 2.1) + price;
		}
		
		else
		{
			return price = (price * 1.50) + price;
		}
	}
	
	private double businessClass(double price, boolean roundTrip)
	{
		if (roundTrip)
		{
			return price = (price * 2.6) + price;
		}
		else
		{
			return price = (price * 2.0) + price;
		}	
	}
	
	public double getAdultPrice()
	{
		adultPrice = Math.round(adultPrice * 100.0) / 100.0;
		return adultPrice; 
	}
	
	public double getInfantPrice()
	{
		infantPrice = Math.round(infantPrice * 100.0) / 100.0;
		return infantPrice;
	}
	
	public double getSeniorCitizenPrice()
	{
		seniorCitizenPrice = Math.round(seniorCitizenPrice * 100.0) / 100.0;
		return seniorCitizenPrice;
	}
	
	public double getTotalPrice()
	{
		return Math.round((adultPrice + infantPrice + seniorCitizenPrice) * 100.0) / 100.0;
	}
}