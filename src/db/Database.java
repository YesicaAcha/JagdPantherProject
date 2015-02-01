package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {

	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:mysql://172.20.200.19/jagdpanther";   
	// Constant for Database Username
	public static String DB_USER = "panther";
	// Constant for Database Password
	public static String DB_PASSWORD = "panther11";

	public void setUp() throws Exception {

		try{
			// Make the database connection
			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getProgramNameDB(String name) throws Exception {

		String value = null;
		try{
			String query = "SELECT NAME FROM PROGRAM WHERE NAME='" + name + "'";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			while(res.next()){
				//Assert.assertTrue(res.getString(1).contains(name));
				value = res.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}   
			
		return value;
	}
	
	public String getStageNameDB(String name) throws Exception {

		String value = null;
		try{
			String query = "SELECT NAME FROM STAGE WHERE NAME='" + name + "'";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			while(res.next()){
				//Assert.assertTrue(res.getString(1).contains(name));
				value = res.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}   
			
		return value;
	}
	
	public String getUserNameDB(String name) throws Exception {

		String value = null;
		try{
			String query = "SELECT NAME FROM jp_user WHERE NAME='" + name + "'";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			while(res.next()){
				//Assert.assertTrue(res.getString(1).contains(name));
				value = res.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}   
			
		return value;
	}

	public void deleteDataFromProgramTable() throws SQLException{
		String query = "delete from `PROGRAM` where id>=1";
		stmt.execute(query);
	}
	
	public void deleteDataFromStageTable() throws SQLException{
		String query = "delete from `STAGE` where id>=1";
		stmt.execute(query);
	}
	
	public void deleteDataFromUserTable() throws SQLException{
		String query = "delete from message where id >=1";
		stmt.execute(query);
		
		String query2 = "delete from jp_user where CI != 123";
		stmt.execute(query2);
		
	}
	
	public void tearDown() throws Exception {
		
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}

