package tests;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBTest {

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

	@BeforeTest
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

	@Test
	public void test() {
		try{
//			String query = "select * from jp_user";

			// the mysql insert statement
		      String query = "delete from `PROGRAM` where id=2";
		 
		      // create the mysql insert preparedstatement
//		      PreparedStatement preparedStmt = con.prepareStatement(query);
//		      preparedStmt.setInt (1, 61);
//		      preparedStmt.setString (1, "Program Description");
//		      preparedStmt.setString (2, "ProgramName61");
//		      preparedStmt.setString(3, "ProgramTitle61");

		 
		      // execute the preparedstatement
		 //     query.execute();
		      
			// Get the contents of userinfo table from DB
			stmt.execute(query);

			// Print the result until all the records are printed
//			// res.next() returns true if there is any next record else returns false
//			while (res.next())
//			{
//				System.out.print(res.getString(1));
//				System.out.print("\t" + res.getString(2));
//				System.out.print("\t" + res.getString(3));
//				System.out.println("\t" + res.getString(4));
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}     
	}

	@AfterTest
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}

