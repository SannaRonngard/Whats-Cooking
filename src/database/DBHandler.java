package database;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 * 
 * @author Sofia Larsson
 *
 */
public class DBHandler {

	public static void main(String[] args) throws Exception {
		getConnection();

	}
	
	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/dabaseName"; // Endast lokalt
			String username = "DittAnvändarnamn";
			String password = "DittLösenord";
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("You are connected");
			return connection;
			
		} catch(Exception e){ System.out.println(e);}
		
		return null;
	}

}
