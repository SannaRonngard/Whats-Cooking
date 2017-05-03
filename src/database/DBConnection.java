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
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public DBConnection(){
		this.driver = "org.postgresql.Driver";
		this.url = "jdbc:postgresql://localhost:5432/testdb";
		this.username = "user";
		this.password = "password";
	}
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
	
	   public static void main(String args[]) {
		   DBConnection db = new DBConnection();
		   Connection connection = null;
		   try {
			   Class.forName(db.driver);
		       connection = DriverManager.getConnection(db.getUrl(),db.getUsername(), db.getPassword());
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		      System.out.println("Opened database successfully");
		   }
	   
}

