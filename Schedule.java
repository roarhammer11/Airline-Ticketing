import lombok.Getter;

@Getter
public class Schedule extends Price
{
	private  String schedule = "";
	private double basePrice;
	
	public void setSchedule(String flightType,  String origin, String destination, String tripType, String airline, String classType, int numberOfInfants, int numberOfAdults,  int numberOfSeniorCitizen)
	{
		
		if (flightType == "LOCAL")
		{
			//PHILIPPINES		
			if (airline == "PHILIPPINE AIRLINES")
			{
				if (origin == "NAIA" && destination == "MCIA")
				{
					schedule = "DAILY 8:00AM - 9:20AM";
					basePrice = 831;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "NAIA" && destination == "DIA")
				{
					schedule = "DAILY 6:00AM - 7:50AM";
					basePrice = 1188;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "NAIA")
				{
					schedule = "DAILY 10:30AM - 11:50AM";
					basePrice = 1010;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "DIA")
				{
					schedule = "DAILY 7:30AM - 12:05PM";
					basePrice = 2300;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "NAIA")
				{
					schedule = "DAILY 8:55AM - 10:40AM";
					basePrice = 1200;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "MCIA")
				{
					schedule = "DAILY 8:55AM - 2:50PM";
					basePrice = 2180;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "AIRASIA PHILIPPINES")
			{
				if (origin == "NAIA" && destination == "MCIA")
				{
					schedule = "DAILY 5:20AM - 6:45AM";
					basePrice = 1250;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "NAIA" && destination == "DIA")
				{
					schedule = "DAILY 6:20AM - 7:45AM";
					basePrice = 2307;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "NAIA")
				{
					schedule = "DAILY 7:10AM - 8:45AM";
					basePrice = 1201;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "DIA")
				{
					schedule = "DAILY 3:20AM - 4:50PM";
					basePrice = 1002;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "NAIA")
				{
					schedule = "DAILY 8:20PM - 10:35PM";
					basePrice = 2101;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "MCIA")
				{
					schedule = "DAILY 7:10AM - 12:10AM";
					basePrice = 1310;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "CEBU PACIFIC")
			{
				if (origin == "NAIA" && destination == "MCIA")
				{
					schedule = "DAILY 6:35AM - 8:05AM";
					basePrice = 1278;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "NAIA" && destination == "DIA")
				{
					schedule = "DAILY 6:00AM - 7:20AM";
					basePrice = 1730;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "NAIA")
				{
					schedule = "DAILY 8:20AM - 9:40AM";
					basePrice = 1743;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "DIA")
				{
					schedule = "DAILY 6:30AM - 7:40AM";
					basePrice = 1416;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "DIA" && destination == "NAIA")
				{
					schedule = "DAILY 10:55AM - 12:45PM";
					basePrice = 1751;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "DIA" && destination == "MCIA")
				{
					schedule = "DAILY 8:10AM - 9:20PM";
					basePrice = 1432;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "QATAR AIRWAYS")
			{
				if (origin == "NAIA" && destination == "MCIA")
				{
					schedule = "DAILY 8:00AM - 9:20AM";
					basePrice = 1800;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "DIA")
				{
					schedule = "DAILY 6:00AM - 7:50AM";
					basePrice = 2470;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "NAIA")
				{
					schedule = "DAILY 7:30AM - 9:00AM";
					basePrice = 1785;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "DIA")
				{
					schedule = "DAILY 1:00AM - 5:30PM";
					basePrice = 1850;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "NAIA")
				{
					schedule = "DAILY 8:55AM - 10:40AM";
					basePrice = 2270;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "MCIA")
				{
					schedule = "DAILY 1:10AM - 4:40PM";
					basePrice = 1890;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
			}
			else if (airline == "SAUDI AIRLINES SAUDIA")
			{
				if (origin == "NAIA" && destination == "MCIA")
				{
					schedule = "DAILY 5:20AM - 6:45AM";
					basePrice = 1875;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "DIA")
				{
					schedule = "DAILY 5:30AM - 7:30AM";
					basePrice = 2175;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "NAIA")
				{
					schedule = "DAILY 7:10AM - 8:45AM";
					basePrice = 1875;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "DIA")
				{
					schedule = "DAILY 3:20AM - 4:50PM";
					basePrice = 1860;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "NAIA")
				{
					schedule = "DAILY 8:20AM - 10:35AM";
					basePrice = 2050;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);

				}

				else if (origin == "DIA" && destination == "MCIA")
				{
					schedule = "DAILY 7:10AM - 12:10PM";
					basePrice = 1865;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
		}
		
		else
		{
			
			if (airline == "PHILIPPINE AIRLINES")
			{
				//JAPAN
				if (origin == "NAIA" && destination == "KIA")
				{
					schedule = "Friday 7:55AM - 1:40PM";
					basePrice = 20500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "NAIA" && destination == "HA")
				{
					schedule = "Monday 7:55AM - 1:40PM";
					basePrice = 41000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "KIA")
				{
					schedule = "Friday 7:55AM - 1:40PM";
					basePrice = 21500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "HA")
				{
					schedule = "Wednesday 7:55AM - 1:40PM";
					basePrice = 55000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "KIA")
				{
					schedule = "Friday 7:55AM - 1:40PM";
					basePrice = 46000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "DIA" && destination == "HA")
				{
					schedule = "Monday 7:55AM - 1:40PM";
					basePrice = 92500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//SOUTH KOREA
				else if (origin == "NAIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 6:15AM - 9:50AM";
					basePrice = 88941;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 6:50PM - 11:20PM";
					basePrice = 85784;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 10:00AM - 2:15PM";
					basePrice = 38144.12;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 9:00AM - 2:15PM";
					basePrice = 35308.12;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 4:00AM - 11:00AM";
					basePrice = 41825.54;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 6:00AM - 1:00PM";
					basePrice = 36613.11;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//TAIWAN
				else if (origin == "NAIA" && destination == "TSA")
				{
					schedule = "Friday 11:10AM - 1:25PM";
					basePrice = 6525;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "TA")
				{
					schedule = "Monday 1:15AM - 3:30PM";
					basePrice = 9601;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "TSA")
				{
					schedule = "Friday 7:55AM - 10:35AM";
					basePrice = 11208;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "TA")
				{
					schedule = "Wednesday 3:40AM - 6:20PM";
					basePrice = 11433;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TSA")
				{
					schedule = "Friday 1:15PM - 7:35PM";
					basePrice = 6439;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TA")
				{
					schedule = "Monday 3:05PM - 9:25AM";
					basePrice = 19760;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "AIRASIA PHILIPPINES")
			{
				//JAPAN
				if (origin == "NAIA" && destination == "KIA")
				{
					schedule = "Friday 2:00PM - 6:15PM";
					basePrice = 24000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "NAIA" && destination == "HA")
				{
					schedule = "Wednesday 11:15AM - 3:00PM";
					basePrice = 27010;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "KIA")
				{
					schedule = "Monday 4:55AM - 9:00PM";
					basePrice = 18000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);

				}

				else if (origin == "MCIA" && destination == "HA")
				{
					schedule = "Friday 2:00PM - 6:15PM";
					basePrice = 19000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "KIA")
				{
					schedule = "Wednesday 11:15AM - 3:00PM";
					basePrice = 35100;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "DIA" && destination == "HA")
				{
					schedule = "Monday 4:55AM - 9:00PM";
					basePrice = 26000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//SOUTH KOREA
				else if (origin == "NAIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 6:45AM - 10:20AM";
					basePrice = 44007;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 7:20PM - 11:50PM";
					basePrice = 41095;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 10:30AM - 2:45PM";
					basePrice = 50936;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 9:30AM - 2:45PM";
					basePrice = 44077;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 4:30AM - 11:30AM";
					basePrice = 50181;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 6:30AM - 1:30PM";
					basePrice = 48810;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//TAIWAN
				
				else if (origin == "NAIA" && destination == "TSA")
				{
					schedule = "Friday 5:25AM - 7:40AM";
					basePrice = 9136;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "TA")
				{
					schedule = "Wednesday 12:40PM - 2:55PM";
					basePrice = 9966;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "TSA")
				{
					schedule = "Monday 4:45PM - 7:00PM";
					basePrice = 12123;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "TA")
				{
					schedule = "Friday 6:15AM - 8:30AM";
					basePrice = 12895;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TSA")
				{
					schedule = "Wednesday 1:10PM - 8:05AM";
					basePrice = 13550;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TA")
				{
					schedule = "Monday 8:55AM - 3:15PM";
					basePrice = 17300;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "CEBU PACIFIC")
			{
				//JAPAN
				if (origin == "NAIA" && destination == "KIA")
				{
					schedule = "Friday 2:10PM - 7:30PM";
					basePrice = 34000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "NAIA" && destination == "HA")
				{
					schedule = "Wednesday 5:20AM - 10:35PM";
					basePrice = 32400;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "KIA")
				{
					schedule = "Monday 2:00AM - 7:30PM";
					basePrice = 23000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "HA")
				{
					schedule = "Monday 2:00PM - 6:15PM";
					basePrice = 17000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "KIA")
				{
					schedule = "Wednesday 5:20AM - 10:35PM";
					basePrice = 38000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "DIA" && destination == "HA")
				{
					schedule = "Friday 2:10AM - 7:30PM";
					basePrice = 28000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//SOUTH KOREA
				else if (origin == "NAIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 6:30AM - 10:05AM";
					basePrice = 50715.45;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 7:05PM - 11:35PM";
					basePrice = 55208.62;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 10:15AM - 2:30PM";
					basePrice = 63667.98;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 9:15AM - 2:30PM";
					basePrice = 65819.39;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 4:15AM - 11:15AM";
					basePrice = 70716.32;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 6:15AM - 1:15PM";
					basePrice = 65918.21;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//TAIWAN
				else if (origin == "NAIA" && destination == "TSA")
				{
					schedule = "Friday 6:10PM - 8:25PM";
					basePrice = 7124;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "TA")
				{
					schedule = "Wednesday 4:20PM - 6:35PM";
					basePrice = 7955;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "TSA")
				{
					schedule = "Monday 8:00PM - 10:40PM";
					basePrice = 11042;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "TA")
				{
					schedule = "Monday 1:10PM - 3:50PM";
					basePrice = 12313;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TSA")
				{
					schedule = "Wednesday 7:45PM - 2:05AM";
					basePrice = 15120;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TA")
				{
					schedule = "Friday 2:10PM - 8:30PM";
					basePrice = 16120;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "QATAR AIRWAYS")
			{
				//JAPAN
				if (origin == "NAIA" && destination == "KIA")
				{
					schedule = "Monday 6:00PM - 8:25PM";
					basePrice = 34000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "NAIA" && destination == "HA")
				{
					schedule = "Wednesday 4:20AM - 8:35PM";
					basePrice = 32400;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "KIA")
				{
					schedule = "Friday 2:00AM - 7:30PM";
					basePrice = 23000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "HA")
				{
					schedule = "Monday 6:00PM - 8:55PM";
					basePrice = 17000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "KIA")
				{
					schedule = "Wednesday 4:20AM - 10:35PM";
					basePrice = 38000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "DIA" && destination == "HA")
				{
					schedule = "Friday 2:00AM - 9:30PM";
					basePrice = 28000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//SOUTH KOREA
				else if (origin == "NAIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 7:00AM - 10:35AM";
					basePrice = 56928.46;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 7:35PM - 12:05PM";
					basePrice = 59019.54;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "MCIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 10:45AM - 3:00PM";
					basePrice = 70817.64;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 9:45AM - 2:50PM";
					basePrice = 75618.01;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 4:45AM - 11:45AM";
					basePrice = 64918.39;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 6:45AM - 1:45PM";
					basePrice = 59093.28;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//TAIWAN
				else if (origin == "NAIA" && destination == "TSA")
				{
					schedule = "Friday 11:30PM - 1:45AM";
					basePrice = 17300;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "TA")
				{
					schedule = "Monday 5:15PM - 7:30PM";
					basePrice = 18200;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "TSA")
				{
					schedule = "Wednesday 6:25AM - 9:05AM";
					basePrice = 19400;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "TA")
				{
					schedule = "Monday 2:15PM - 5:30PM";
					basePrice = 21500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TSA")
				{
					schedule = "Friday 4:25PM - 10:25PM";
					basePrice = 23150;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TA")
				{
					schedule = "Monday 5:50PM - 12:10PM";
					basePrice = 25040;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
			
			else if (airline == "SAUDI AIRLINES SAUDIA")
			{
				//JAPAN
				if (origin == "NAIA" && destination == "KIA")
				{
					schedule = "Wednesday 7:20PM - 11:35PM";
					basePrice = 24500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				else if (origin == "NAIA" && destination == "HA")
				{
					schedule = "Friday 3:10AM - 7:30PM";
					basePrice = 25500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "KIA")
				{
					schedule = "Monday 2:00AM - 6:00PM";
					basePrice = 34760;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "HA")
				{
					schedule = "Friday 3:10PM - 7:30PM";
					basePrice = 19560;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "KIA")
				{
					schedule = "Wednesday 7:20AM - 11:35PM";
					basePrice = 18340;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);

				}
				
				else if (origin == "DIA" && destination == "HA")
				{
					schedule = "Monday 2:00AM - 7:30PM";
					basePrice = 23180;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//SOUTH KOREA
				if (origin == "NAIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 7:15AM - 10:50AM";
					basePrice = 55275.33;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 7:50PM - 12:20PM";
					basePrice = 60679.72;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 11:00AM - 3:15PM";
					basePrice = 57207.46;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 10:00AM - 3:15PM";
					basePrice = 63540.30;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "D Int'l Airport")
				{
					schedule = "Wednesday 5:00AM - 12:00AM";
					basePrice = 56046.79;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "Jeju Int'l Airport")
				{
					schedule = "Saturday 7:00AM - 2:00PM";
					basePrice = 69410.38;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				
				//TAIWAN
				else if (origin == "NAIA" && destination == "TSA")
				{
					schedule = "Wednesday 7:20AM - 9:35AM";
					basePrice = 52250;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "NAIA" && destination == "TA")
				{
					schedule = "Friday 3:10PM - 5:25PM";
					basePrice = 55100;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
				else if (origin == "MCIA" && destination == "TSA")
				{
					schedule = "Monday 2:00PM - 5:30PM";
					basePrice = 55500;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "MCIA" && destination == "TA")
				{
					schedule = "Friday 4:30PM - 8:00PM";
					basePrice = 56100;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TSA")
				{
					schedule = "Wednesday 10:15AM - 4:35PM";
					basePrice = 60100;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}

				else if (origin == "DIA" && destination == "TA")
				{
					schedule = "Monday 8:15PM = 2:35AM";
					basePrice = 63000;
					setPrice(basePrice, numberOfAdults, numberOfInfants, numberOfSeniorCitizen, classType, tripType);
				}
			}
		}
	}
}
		
