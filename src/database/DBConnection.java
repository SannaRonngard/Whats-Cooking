package database;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 * 
 * @author Sofia Larsson
 * @author Linus Forsberg
 *
 */
public class DBConnection {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/databaseName";
	private static String username = "user";
	private static String password = "password";
	
	public static void main(String[] args) throws Exception {
		getConnection();
	}
	
	public static Connection getConnection() throws Exception{
		try{
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("You are connected");
			return connection;
			
		} catch(Exception e){ System.out.println(e);}
		
		return null;
	}

}
