package mvcbunch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DatabaseConnection {

	//make sure these match what you used during setup
	String connectionUrl = "jdbc:derby://localhost:1527/daubuoi22002";
	private final String dbname = "daubuoi2002";

	public Connection connection;
	public PreparedStatement addPostStatement ;
	
	
	//this class is a singleton and should not be instantiated directly!
	public static DatabaseConnection instance = new DatabaseConnection();
	public static DatabaseConnection getInstance(){
		
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	public DatabaseConnection(){
		try {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				connection = DriverManager.getConnection(connectionUrl);
				 addPostStatement = connection.prepareStatement("insert into endUser (Name, Message, Time) values(?, ?, ?)");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a List of all of the Posts in the database, sorted by postTime (newest first)
	 */
	public List<Message> getAllPosts() {
		List<Message> posts = new ArrayList<Message>();
		try{
			ResultSet resultSet = connection.createStatement().executeQuery("select * from endUser order by Time desc");
			while(resultSet.next()){
				String name = resultSet.getString("Name");
				String postText = resultSet.getString("Message");
				Timestamp postTime = resultSet.getTimestamp("Time");
				Message post = new Message(name, postText, postTime);
				posts.add(post);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return posts;
	}

	public synchronized void addPost(String name, String post, Timestamp postTime) {
		try {
			addPostStatement.setString(1, name);
			addPostStatement.setString(2, post);
			addPostStatement.setTimestamp(3, postTime);
			addPostStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}