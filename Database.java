import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class Database
{
	private Connection database = null;
	private Statement statement = null;
	private String url = "jdbc:postgresql:", username = "", password = "";
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
				           "\"Bank Account Name\"	  		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Number\"	 		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Email\"	 		VARCHAR(200)	          NOT NULL,\n" +
				           "\"Bank Account Phone Number\"	VARCHAR(200)	          NOT NULL\n" +
				           ")";

			statement.executeUpdate(table);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"5");
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
					JOptionPane.showMessageDialog(null,"Create table"+e); 
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
					JOptionPane.showMessageDialog(null,"Create table"+e); 
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
		    //database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123456");
			
			JSONParser parser = new JSONParser();
	    	File f = new File(".\\src\\credentials.json");
			if (f.exists())
			{
				try (Reader reader = new FileReader(".\\src\\credentials.json")) 
		    	{

		            JSONObject jsonObject = (JSONObject) parser.parse(reader);
		            //System.out.println(jsonObject);

		            this.url = (String) jsonObject.get("url");
		           // System.out.println(this.url);

		            this.username = (String) jsonObject.get("username");
		            //System.out.println(this.username);
		            
		            this.password = (String) jsonObject.get("password");
		            //System.out.println(this.password);

		        } 
		    	catch (IOException q) 
		    	{
		    		//JOptionPane.showMessageDialog(null,"IOException: "+q);
		    		setupDatabase();
		    		JOptionPane.showMessageDialog(null,"Connect to database4"+q); 
		        } 
		    	catch (ParseException q) 
		    	{
		    		//JOptionPane.showMessageDialog(null,"ParseException: "+q);
		    		setupDatabase();
		    		JOptionPane.showMessageDialog(null,"Connect to database3"+q); 
		        }
			}
	    		
			database = DriverManager.getConnection(url,username, password);
//		    if (database != null)
//		    {
//		    	//JOptionPane.showMessageDialog(null,"Opened database successfully"); 
//		    }
//		    else
//		    {
//		    	
//		    }
			credentials = new JSONObject();
    		credentials.clear();
	    	credentials.put("url", url);
	    	credentials.put("username", username);
	    	credentials.put("password", password);
	    	try (FileWriter file = new FileWriter(".\\src\\credentials.json")) 
	    	{
	            file.write(credentials.toJSONString());
	        } 
	    	catch (IOException e) {
	            //q.printStackTrace();
	            JOptionPane.showMessageDialog(null,"Connect to database1"+e);
	        }
			
		} 
		catch (Exception e) 
		{	
			setupDatabase();
			//JOptionPane.showMessageDialog(null,"Connect to database2"+e); 
		}
	}
	
	public void insertToTable(String valueArguments)
	{
		try 
		{
			database = DriverManager.getConnection(url,username, password);
			statement = database.createStatement();
			//String toInsert = "INSERT INTO \"Tickets\" "+ tableArguments + "VALUES "+valueArguments;
			String toInsert = "INSERT INTO \"Tickets\""+
					 		"(\"Flight Type\", \"Origin\", \"Destination\", \"Trip Type\", \"Airline\", \"Schedule\", \"Class Type\", \"Number Of Passengers\", \"Number Of Infants\"," +
							"\"Number Of Adults\", \"Number Of Senior Citizens\", \"Mode Of Payment\", \"Bank Account Name\", \"Bank Account Number\", \"Bank Account Email\","+
							"\"Bank Account Phone Number\") "+ "VALUES ("+valueArguments +");";
			statement.executeUpdate(toInsert);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
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
					JOptionPane.showMessageDialog(null,"Insert to table"+e); 
				}
			}
			if (database != null )
			{
				try 
				{
					//database.commit();
					database.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Insert to table"+e); 
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
	
	private void setupDatabase()
	{
		//JOptionPane.showMessageDialog(null,e);
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
    	//JOptionPane.showMessageDialog(null,"Failed to open database");
        url.setText("//localhost:5432/postgres");
        username.setText("postgres");
    	int confirmation = JOptionPane.showConfirmDialog(null, panel, "Connect to Database", JOptionPane.OK_CANCEL_OPTION);
    	//System.out.print(confirmation);
    	
    	
    	if (confirmation == 0)
    	{
//    		this.url = url.getText();
//    		this.username = username.getText();
//    		this.password = password.getText();
    		String paswd = String.valueOf(password.getPassword());
    		setupDatabase(url.getText(), username.getText(), paswd);
	    	connectToDatabase();
    	}
    	else if (confirmation == 2)
    	{
    		//JOptionPane.showMessageDialog(null,"helo");
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
	
	

}