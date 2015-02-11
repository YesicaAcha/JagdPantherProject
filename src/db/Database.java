package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import framework.utils.ExternalData;

public class Database {
	ExternalData externalData = new ExternalData();

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
		try {

			// Make the database connection
			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass).newInstance();

			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method confirms if an element was create on a table and returns its name
	 * @param tableName
	 * @param name
	 * @return
	 * @throws Exception
	 */
	private String getDataFromTable(String columnName, String tableName, String condition) throws Exception {
		String value = null;
		try {
			String query = "SELECT " + columnName + " FROM " + tableName + " " + condition; 
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				value = res.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
		return value;
	}

	/**
	 * This method gets the name of the stage if it exists in the database
	 * @param name: Stage's name
	 * @return
	 * @throws Exception
	 */
	public String getStageNameDB(String name) throws Exception {
		return getDataFromTable("NAME", "stage", "WHERE NAME='" + name + "'");	
	}

	/**
	 * This method gets the name of the user if it exists in the database
	 * @param ci: User's CI
	 * @return
	 * @throws Exception
	 */
	public String getUserCIDB(String ci) throws Exception {
		return getDataFromTable("NAME", "jp_user", "WHERE CI='" + ci + "'");	
	}

	/**
	 * This method gets the name of the program if it exists in the database
	 * @param name: Program's Name
	 * @return
	 * @throws Exception
	 */
	public String getProgramNameDB(String name) throws Exception {
		return getDataFromTable("NAME", "PROGRAM", "WHERE NAME='" + name + "'");
	}

	/**
	 * This method gets the title of the program if it exists in the database
	 * @param name: Program's Name
	 * @return
	 * @throws Exception
	 */
	public String getProgramTitleDB(String name) throws Exception {
		return getDataFromTable("TITLE", "PROGRAM", "WHERE NAME='" + name + "'");
	}

	/**
	 * This method gets the description of the program if it exists in the database
	 * @param name: Program's Name
	 * @return
	 * @throws Exception
	 */
	public String getProgramDescriptionDB(String name) throws Exception {
		return getDataFromTable("DESCRIPTION", "PROGRAM", "WHERE NAME='" + name + "'");
	}

	/**
	 * Execute a delete statements for post conditions
	 * @param tableName
	 * @param condition
	 * @throws SQLException
	 */
	private void executeDelete(String tableName, String condition) throws SQLException {
		String query = "DELETE FROM " + tableName + " WHERE " + condition;
		stmt.execute(query);
	}

	public void deleteDataFromProgramTable() throws SQLException {
		executeDelete("PROGRAM", "id>=0");
	}

	public void deleteDataFromStageTable() throws SQLException {
		executeDelete("STAGE", "id>=1");
	}

	public void deleteDataFromUserTable() throws SQLException {
		executeDelete("message", "id>=1");
		executeDelete("jp_user", "CI!= 123");
	}

	public void createProgramsByBD() throws Exception {
		List<Map<String, String>> programsXLS = externalData.readExternalProgramData();
		System.out.println("Starting to create Programs......");
		for (Map<String, String> programInfo : programsXLS) {
			createNewProgramDB (programInfo.get("ProgramName"), programInfo.get("ProgramTitle"), programInfo.get("ProgramDescription"));
		}
		System.out.println("Finishing the creation of Programs......");
	}
	
	//TODO Refactor
	public void createStagesDB() throws SQLException {
		String query = "INSERT INTO `stage` VALUES (1,'stageDescription',80,'stageName', 'stageTitle', 1);";
		stmt.execute(query);
	}
	
	public void createGroupDB() throws SQLException {
		String query = "INSERT INTO `jp_group` VALUES (1,'groupDescription','groupName', 0, 'groupTitle', 1);";
		stmt.execute(query);
		query = "INSERT INTO `group_stage` VALUES (1, 1)";
		stmt.execute(query);
	}
	
	public void createPeriodDB() throws SQLException {
		String query = "INSERT INTO `jp_period` VALUES (1, NULL,'2015-02-02', 'periodName', 'ACTIVE', 1);";
		stmt.execute(query);
		query = "INSERT INTO `stage_value` VALUES (1, 80, 1, 1);";
		stmt.execute(query);
		
	}
	
	public void createApplicantDB() throws SQLException{
		String query = "INSERT INTO `JP_USER` VALUES (4902260,'Applicant',1,0,NULL,NULL,NULL,'yesica@acha.com','applicantLastname','applicantName',NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL);";
		stmt.execute(query);
		query = "INSERT INTO `USER_PERIOD` VALUES (1, 4902260);";
		stmt.execute(query);
	}

	//TODO: Refactor the code to have createNewElementDB 
	private void createNewProgramDB(String programName, String programTitle, String programDescription) throws Exception {

		String query = "INSERT INTO `PROGRAM` VALUES ("+ getNextUsableProgramCode() +",'"+programDescription+ "','" + programName+"','" + programTitle + "')";
		stmt.execute(query);
	}

	public String getNextUsableProgramCode() throws Exception{
		String lastCodeDB = getDataFromTable("ID", "program", "ORDER BY ID desc limit 1");
		System.out.println(lastCodeDB);
		int code;
		if (lastCodeDB == null) {
			code = 1;
		} else {
			code = Integer.parseInt(lastCodeDB) + 1;
		}
		return code + "";
	}

	/**
	 * This method close the connection with the database
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		if (con != null) {
			con.close();
		}
	}
}

