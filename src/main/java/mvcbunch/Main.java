package mvcbunch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Main {
	public static void main(String[] args)
	{
			try {
				System.out.println("Connecting to database.");
				String connectionUrl = "jdbc:derby://localhost:1527/daubuoi22002";
				Connection connection = DriverManager.getConnection(connectionUrl);
				
				Statement insertRowStatement = connection.createStatement();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				insertRowStatement.executeUpdate("create table endUser (Name varchar(255), Message varchar(255), Time timestamp)");
//				insertRowStatement.executeUpdate("drop table endUser");
				System.out.println("Added Ada to the People table.");
				

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Done.");
		
	}

}
