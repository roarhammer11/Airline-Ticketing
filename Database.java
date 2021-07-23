import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import lombok.Getter;

public class Database
{
	private Connection database = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private String url = "jdbc:postgresql:", username = "", password = "";
	
	private @Getter String flightType = "", origin = "", destination = "", tripType = "", airline = "", schedule = "", classType = "", numberOfPassengers = "", numberOfInfants = "", numberOfAdults = "",
				   numberOfSeniorCitizens = "", modeOfPayment = "", bankCompany = "", bankAccountName = "", bankAccountNumber = "", bankAccountEmail = "", bankAccountPhoneNumber = "", totalPrice = "", ticketNumber = "";
	private JSONObject credentials;
	
	public void createTable()
	{
		try 
		{
			connectToDatabase();
			statement = database.createStatement();
			String table = "CREATE TABLE IF NOT EXISTS \"Tickets\"(\n" +
				           "\"Customer ID\" 		  		SERIAL PRIMARY KEY     	  NOT NULL,\n" +
				           "\"Flight Type\"           		VARCHAR(200)  		  	  NOT NULL,\n" +
				           "\"Origin\"            	  		VARCHAR(200)  		  	  NOT NULL,\n" +
				           "\"Destination\"        	  		VARCHAR(200)			  NOT NULL,\n" +
				           "\"Trip Type\"			  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Airline\"			 	  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Schedule\"			  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Class Type\"			  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Number Of Passengers\"  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Number Of Infants\"	  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Number Of Adults\"	  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Number Of Senior Citizens\"	VARCHAR(200)	          NOT NULL,\n" +
				           "\"Mode Of Payment\"	  			VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Company\"	  			VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Name\"	  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Number\"	 		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Email\"	 		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Phone Number\"	VARCHAR(200)	          NOT NULL,\n" +
				           "\"Total Price\"					VARCHAR(200)	          NOT NULL,\n" +
				           "\"Ticket Number\"				BIGINT	         		  NOT NULL UNIQUE \n" +
				           ")";

			statement.executeUpdate(table);
		} 
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Create table: " + e);
			System.exit(0);
		}
		finally
		{
			if (statement != null)
			{
				try 
				{
					statement.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Create table: " + e); 
				}
			}
			if (database != null )
			{
				try 
				{
					database.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Create table: " + e); 
				}
			}
		}   
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void connectToDatabase()
	{
		try 
		{	
			Class.forName("org.postgresql.Driver");  
			JSONParser parser = new JSONParser();
	    	File f = new File(".\\credentials.json");
	    	
	    	//Checks if cretendials.json is already created and automatically sets url, username and password for database connection
			if (f.exists())
			{
				try (Reader reader = new FileReader(".\\credentials.json"))
		    	{
		            JSONObject jsonObject = (JSONObject) parser.parse(reader);		 

		            this.url = (String) jsonObject.get("url");;
		            this.username = (String) jsonObject.get("username");		            
		            this.password = (String) jsonObject.get("password");
		        } 
		    	catch (IOException q) 
		    	{
		    		setupDatabase();
		    		JOptionPane.showMessageDialog(null,"Connect to database: " + q ); 
		        } 
		    	catch (ParseException q) 
		    	{
		    		setupDatabase();
		    		JOptionPane.showMessageDialog(null,"Connect to database: " + q); 
		        }
			}
	  		
			//If application has connection to database, saves the url username and password to credentials.json, else calls setupDatabase()
			database = DriverManager.getConnection(url,username, password);
			
			credentials = new JSONObject();
    		credentials.clear();
	    	credentials.put("url", url);
	    	credentials.put("username", username);
	    	credentials.put("password", password);
	    	
	    	try (FileWriter file = new FileWriter(".\\credentials.json")) 
	    	{
	            file.write(credentials.toJSONString());
	        } 
	    	
	    	catch (IOException e) 
	    	{
	            JOptionPane.showMessageDialog(null,"Connect to database: " + e);
	        }
			
		} 
		
		catch (Exception e) 
		{	
			setupDatabase();
		}
	}
	
	public void insertToTable(String valueArguments)
	{
		try 
		{
			database = DriverManager.getConnection(url,username, password);
			statement = database.createStatement();
	
			String toInsert = "INSERT INTO \"Tickets\""+
					 		"(\"Flight Type\", \"Origin\", \"Destination\", \"Trip Type\", \"Airline\", \"Schedule\", \"Class Type\", \"Number Of Passengers\", \"Number Of Infants\"," +
							"\"Number Of Adults\", \"Number Of Senior Citizens\", \"Mode Of Payment\", \"Bank Company\", \"Bank Account Name\", \"Bank Account Number\", \"Bank Account Email\","+
							"\"Bank Account Phone Number\", \"Total Price\", \"Ticket Number\") "+ "VALUES (" + valueArguments +");";
			
			statement.executeUpdate(toInsert);
		} 
		
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Insert to table: " + e);
		}
		
		finally
		{
			if (statement != null)
			{
				try 
				{
					statement.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Insert to table: " + e); 
				}
			}
			if (database != null)
			{
				try 
				{
					database.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Insert to table: " + e); 
				}
			}
		}
	}
	
	public void setupDatabase(String url, String username, String password)
	{
		this.url += url;
		this.username = username;
		this.password = password;
	}
	
	//Sets up database and tries to connect to database with the given url, username and password
	private void setupDatabase()
	{
		url = "jdbc:postgresql:";
		username = "";
		password = "";
		
		JPanel panel = new JPanel(new BorderLayout(5, 5));
        JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
        label.add(new JLabel("Url", SwingConstants.RIGHT));
        label.add(new JLabel("Username", SwingConstants.RIGHT));
        label.add(new JLabel("Password", SwingConstants.RIGHT));
        panel.add(label, BorderLayout.WEST);
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField url = new JTextField();
        controls.add(url);
        JTextField username = new JTextField();
        controls.add(username);
        JPasswordField password = new JPasswordField();
        controls.add(password);
        panel.add(controls, BorderLayout.CENTER);
        url.setText("//localhost:5432/postgres");
        username.setText("postgres");
        
    	int confirmation = JOptionPane.showConfirmDialog(null, panel, "Connect to Database", JOptionPane.OK_CANCEL_OPTION);
    	
    	if (confirmation == 0)
    	{
    		String paswd = String.valueOf(password.getPassword());
    		setupDatabase(url.getText(), username.getText(), paswd);
	    	connectToDatabase();
    	}
    	else if (confirmation == 2)
    	{
    		int anotherConfirmation = JOptionPane.showConfirmDialog(null, "Do you wish to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
    		
    		if (anotherConfirmation == 0)
    		{
    			System.exit(0);
    		}
    		else if (anotherConfirmation == 2)
    		{
    			connectToDatabase();
    		}
    		else
    		{
    			System.exit(0);
    		}
    	}
    	else 
    	{
    		System.exit(0);
    	}
	}
	
	public boolean findInDatabase(String ticketNumber)
	{
		try 
		{
			String x = "";
			database = DriverManager.getConnection(url,username, password);
			statement = database.createStatement();
		    resultSet = statement.executeQuery("Select * FROM \"Tickets\" Where \"Ticket Number\" = " + ticketNumber + ";");
			while(resultSet.next())
			{
	            x = resultSet.getString("Trip Type");	            
	            setFields(resultSet.getString("Flight Type"), resultSet.getString("Origin"), resultSet.getString("Destination"), resultSet.getString("Trip Type"), resultSet.getString("Airline"), 
	            		resultSet.getString("Schedule"), resultSet.getString("Class Type"), resultSet.getString("Number Of Passengers"), resultSet.getString("Number Of Infants"), 
	            		resultSet.getString("Number Of Adults"), resultSet.getString("Number Of Senior Citizens"), resultSet.getString("Mode Of Payment"), resultSet.getString("Bank Company"), resultSet.getString("Bank Account Name"), 
	            		resultSet.getString("Bank Account Number"), resultSet.getString("Bank Account Email"), resultSet.getString("Bank Account Phone Number"), resultSet.getString("Total Price"), resultSet.getString("Ticket Number"));
	        }

			switch(x)
			{
				case "ROUND TRIP":
					return true;
				case "ONE-WAY TRIP":
					return true;
				default:
					return false;
			}
		} 
		
		catch (SQLException e) 
		{
			return false;
		}
		
		finally
		{
			if (resultSet != null)
			{
				try 
				{
					resultSet.close();
				} 
				
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Find in database: " + e); 
				}
			}
			
			if (statement != null)
			{
				try 
				{
					statement.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Find in database: " + e); 
				}
			}
			
			if (database != null )
			{
				try 
				{
					database.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Find in database: " + e); 
				}
			}
		}
	}
	
	public void updateDatabase(String flightType, String origin, String destination, String tripType, String airline, String schedule, String classType, String numberOfPassengers, String numberOfInfants, String numberOfAdults,
			   String numberOfSeniorCitizens, String modeOfPayment, String bankCompany, String bankAccountName, String bankAccountNumber, String bankAccountEmail, String bankAccountPhoneNumber, String totalPrice, String ticketNumber)
	{
		try 
		{
			database = DriverManager.getConnection(url,username, password);
			statement = database.createStatement();

			String toUpdate = " UPDATE \"Tickets\" \n SET \"Flight Type\" = " + "\'"+ flightType + "\'" + ", \"Origin\" = " + "\'"+ origin + "\'"+ ", \"Destination\" = " + "\'"+ destination  + "\'" + ", \"Trip Type\" = " + "\'"+ tripType + "\'" + 
			", \"Airline\" = " + "\'"+ airline  + "\'" + ", \"Schedule\" = " + "\'"+ schedule + "\'"+ ", \"Class Type\" = " + "\'"+ classType  + "\'" + ", \"Number Of Passengers\" = " + "\'"+ numberOfPassengers + "\'" + 
			", \"Number Of Infants\" = " + "\'"+ numberOfInfants  + "\'" + ", \"Number Of Adults\" = " + "\'"+ numberOfAdults + "\'"+ ", \"Number Of Senior Citizens\" = " + "\'"+ numberOfSeniorCitizens  + "\'" + 
			", \"Mode Of Payment\" = " + "\'"+ modeOfPayment + "\'" +  ", \"Bank Company\" = " + "\'"+ bankCompany + "\'" + ", \"Bank Account Name\" = " + "\'"+ bankAccountName  + "\'" + ", \"Bank Account Number\" = " + "\'"+ bankAccountNumber + "\'"+ 
			", \"Bank Account Email\" = " + "\'"+ bankAccountEmail  + "\'" + ", \"Bank Account Phone Number\" = " + "\'" + bankAccountPhoneNumber + "\'" + ", \"Total Price\" = " + "\'" + totalPrice + "\'" +
			"WHERE \"Ticket Number\" = " + ticketNumber +";";
			
			statement.executeUpdate(toUpdate);
		} 
		
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Update Database: " + e); 
		}
		
		finally
		{
			if (resultSet != null)
			{
				try 
				{
					resultSet.close();
				} 
				
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Update Database: " + e); 
				}
			}
			
			if (statement != null)
			{
				try 
				{
					statement.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Update Database: " + e); 
				}
			}
			
			if (database != null )
			{
				try 
				{
					database.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Update Database: " + e); 
				}
			}
		}
	}
	
	
	
	public void deleteInDatabase(String ticketNumber)
	{
		try 
		{
			database = DriverManager.getConnection(url,username, password);
			statement = database.createStatement();
			String toDelete = "DELETE from \"Tickets\" where \"Ticket Number\" = " + ticketNumber + ";";
			statement.executeUpdate(toDelete);
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Delete in database: " + e); 
		}
		
		finally
		{
			if (statement != null)
			{
				try 
				{
					statement.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Delete in database: " + e); 
				}
			}
			
			if (database != null )
			{
				try 
				{
					database.close();
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null,"Delete in database: " + e); 
				}
			}
		}
	}
	
	public void setFields(String flightType, String origin, String destination, String tripType, String airline, String schedule, String classType, String numberOfPassengers, String numberOfInfants, String numberOfAdults,
			   String numberOfSeniorCitizens, String modeOfPayment, String bankCompany, String bankAccountName, String bankAccountNumber, String bankAccountEmail, String bankAccountPhoneNumber, String totalPrice, String ticketNumber)
	{
		this.flightType = flightType;
		this.origin = origin;
		this.destination = destination;
		this.tripType = tripType;
		this.airline = airline;
		this.schedule = schedule;
		this.classType = classType;
		this.numberOfPassengers = numberOfPassengers;
		this.numberOfInfants = numberOfInfants;
		this.numberOfAdults = numberOfAdults;
		this.numberOfSeniorCitizens = numberOfSeniorCitizens;
		this.modeOfPayment = modeOfPayment;
		this.bankCompany = bankCompany;
		this.bankAccountName = bankAccountName;
		this.bankAccountNumber = bankAccountNumber;
		this.bankAccountEmail = bankAccountEmail;
		this.bankAccountPhoneNumber = bankAccountPhoneNumber;
		this.totalPrice = totalPrice;
		this.ticketNumber = ticketNumber;
	}
}