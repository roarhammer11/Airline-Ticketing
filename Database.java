import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Database {
	Connection database = null;
	Statement statement = null;
	String url = "jdbc:postgresql:", username = "", password = "";
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
//			String table = "CREATE TABLE IF NOT EXISTS \"Tickets\"(\n" +
//			           "\"Customer ID\" 		  		SERIAL PRIMARY KEY     	  NOT NULL,\n" +
//			           "\"Flight Type\"           		TEXT		  		  	  ,\n" +
//			           "\"Origin\"            	  		VARCHAR(200)  		  	  ,\n" +
//			           "\"Destination\"        	  		VARCHAR(200)			  ,\n" +
//			           "\"Trip Type\"			  		VARCHAR(200)	          ,\n" +
//			           "\"Airline\"			 	  		VARCHAR(200)	          ,\n" +
//			           "\"Schedule\"			  		VARCHAR(200)	          ,\n" +
//			           "\"Class Type\"			  		VARCHAR(200)	          ,\n" +
//			           "\"Number Of Passengers\"  		VARCHAR(200)	          ,\n" +
//			           "\"Number Of Infants\"	  		VARCHAR(200)	          ,\n" +
//			           "\"Number Of Adults\"	  		VARCHAR(200)	          ,\n" +
//			           "\"Number Of Senior Citizens\"	VARCHAR(200)	          ,\n" +
//			           "\"Mode Of Payment\"	  			VARCHAR(200)	          ,\n" +
//			           "\"Bank Account Name\"	  		VARCHAR(200)	          ,\n" +
//			           "\"Bank Account Number\"	 		VARCHAR(200)	          ,\n" +
//			           "\"Bank Account Email\"	 		VARCHAR(200)	          ,\n" +
//			           "\"Bank Account Phone Number\"	VARCHAR(200)	          \n" +
//			           ")";
			statement.executeUpdate(table);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
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
					JOptionPane.showMessageDialog(null,e);
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
					JOptionPane.showMessageDialog(null,e);
				}
			}
		}   
	}
	
	public void connectToDatabase()
	{
		try 
		{	
			Class.forName("org.postgresql.Driver");
		    database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123456");
		    if (database != null)
		    {
		    	//JOptionPane.showMessageDialog(null,"Opened database successfully"); 
		    }
		    else
		    {
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
		        JTextField password = new JTextField();
		        controls.add(password);
		        panel.add(controls, BorderLayout.CENTER);
		    	//JOptionPane.showMessageDialog(null,"Failed to open database");
		    	int confirmation = JOptionPane.showConfirmDialog(null, panel, "Connect to Database", JOptionPane.OK_CANCEL_OPTION);
	   	
		    	if(confirmation == 0)
		    	{
//		    		this.url = url.getText();
//		    		this.username = username.getText();
//		    		this.password = password.getText();
		    		setupDatabase(url.getText(), username.getText(), password.getText());
		    		connectToDatabase();
		    	}
		    	else if (confirmation == 1)
		    	{
		    		JOptionPane.showMessageDialog(null,"helo");
		    	}
		    }
		     
		} 
		catch (Exception e) 
		{	
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public void insertToTable(String valueArguments)
	{
		try 
		{
			database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123456");
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
					JOptionPane.showMessageDialog(null,e);
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
					JOptionPane.showMessageDialog(null,e);
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
}