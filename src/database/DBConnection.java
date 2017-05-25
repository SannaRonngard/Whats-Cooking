package database;

import java.sql.*;

/**
 * Class that gets the database driver and user credentials. 
 * @author Sofia Larsson
 *
 */
public class DBConnection {
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection connection = null;
	/**
	 * User details are temporary and will later on be passed only by user. 
	 */
	public DBConnection(){
		
		this.driver = "org.postgresql.Driver";

		/*Database on MAH-server (EXTERN)*/
		this.url = "jdbc:postgresql://104.199.20.214/whatscooking?useUnicode=true&characterEncoding=utf-8";
		this.username = "ah1867";
		this.password = "6duag1oi";
		
		/*Database on MAH-server (INTERN)*/
//				this.url = "jdbc:postgresql://pgserver.mah.se/ae7689";
//				this.username = "ae7689";
//				this.password = "s05q21rc";
		
		/* Database cloud-server Google Cloud (costs with each use)*/
//		this.url = "jdbc:postgresql://104.155.0.136/whatscooking";
//		this.username = "postgres";
//		this.password = "bigheadteam";
	}
	/*Getters and setters*/
	public String getDriver(){
		return this.driver;
	}
	public String getUrl(){
		return this.url;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public Connection getConnection(){
		return this.connection;
	}
	/**
	 * Method that establishes a connection to the database server. 
	 * Trying for driver and connection with details. 
	 */
	public void initiate() {
		// Try for Driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;
		}
		//Try to connect to database with details
		try {
			connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		//If user details match and connection was successful or not
		if (connection != null) {
			System.out.println("You are connected!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}

