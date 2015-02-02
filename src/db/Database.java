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

	/**
	 * This method is used to connect to the database
	 * @throws Exception
	 */
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
		return getDatafromTable("PROGRAM", name);
	}
	
	/**
	 * This method gets the name of the stage if it is created in the database
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getStageNameDB(String name) throws Exception {
	return getDatafromTable("stage", name);	
	}
	
	public String getUserNameDB(String name) throws Exception {
		return getDatafromTable("jp_user", name);	
	}
	
	/**
	 * This method confirms if an element was create on a table and returns its name
	 * @param tableName
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getDatafromTable(String tableName, String name) throws Exception {

		String value = null;
		try{
			String query = "SELECT NAME FROM " + tableName +" WHERE NAME='" + name + "'";
			
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
		executeDelete("PROGRAM", "id>=1");
	}
	
	public void deleteDataFromStageTable() throws SQLException{
		executeDelete("STAGE", "id>=1");
	}
	
	public void deleteDataFromUserTable() throws SQLException{
		executeDelete("message", "id>=1");
		executeDelete("jp_user", "CI != 123");
	}
	
	/**
	 * Execute a delete statements for post conditions
	 * @param tableName
	 * @param condition
	 * @throws SQLException
	 */
	public void executeDelete(String tableName, String condition) throws SQLException
	{
		String query = "delete from " + tableName + " where " + condition;
		stmt.execute(query);
	}
	
	/**
	 * This method close the connection with the database
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}

