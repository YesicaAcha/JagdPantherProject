package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import framework.common.ConfigConstants;
import framework.utils.ExternalData;

public class Database {
	ExternalData externalData = new ExternalData();

	// Connection object
	static Connection con = null;

	// Statement object
	private static Statement stmt;

	// Constant for Database URL
	public static String DB_URL = ConfigConstants.DB_URL;   

	// Constant for Database Username
	public static String DB_USER = ConfigConstants.DB_USER;

	// Constant for Database Password
	public static String DB_PASSWORD = ConfigConstants.DB_PASSWORD;

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

	private void createNewElementDB (String tableName, String values) throws SQLException {
		String query = "INSERT INTO " + tableName + " VALUES " + values +";";
		stmt.execute(query);
	}

	public void createProgramsByBD() throws Exception {
		List<Map<String, String>> programsXLS = externalData.readExternalProgramData();
		for (Map<String, String> programInfo : programsXLS) {
			String values = "("+ getNextUsableCode("PROGRAM") +",'"+ programInfo.get("ProgramDescription") + "','" + programInfo.get("ProgramName") +"','" + programInfo.get("ProgramTitle") + "')";
			createNewElementDB("PROGRAM", values);
		}
	}

	public void createStagesDB() throws Exception {
		List<Map<String, String>> stagesXLS = externalData.readExternalStageData();
		for (Map<String, String> stageInfo : stagesXLS ) {
			String values = "("+ getNextUsableCode("STAGE") +",'"+ stageInfo.get("DESCRIPTION") + "'," + stageInfo.get("MINGRADE") + ",'" + stageInfo.get("NAME") +"','" + stageInfo.get("TITLE") + "'," + stageInfo.get("TYPE") + ")";
			createNewElementDB("STAGE", values);
		}
	}

	public void createGroupDB() throws Exception {
		List<Map<String, String>> groupsXLS = externalData.readExternalGroupData();
		for (Map<String, String> groupsInfo : groupsXLS ) {
			String values = "("+ getNextUsableCode("JP_GROUP") +",'"+ groupsInfo.get("DESCRIPTION") 
					+ "','" + groupsInfo.get("NAME") + "'," + groupsInfo.get("ORDERINLIST") +",'" 
					+ groupsInfo.get("TITLE") + "'," + getCode("PROGRAM", groupsInfo.get("PROGRAM")) + ")";
			createNewElementDB("jp_group", values);
			values = "("+ getCode("JP_GROUP", groupsInfo.get("NAME")) + ","+getCode("STAGE", groupsInfo.get("STAGE")) + ")";
			createNewElementDB("GROUP_STAGE", values);
		}
	}

	public void createPeriodDB() throws SQLException, Exception {
		String query = "INSERT INTO `jp_period` VALUES (1, NULL, '2015-02-02', 'periodName', 'ACTIVE', 1);";
		stmt.execute(query);
		query = "INSERT INTO `stage_value` VALUES (1, 80, 1, 1);";
		stmt.execute(query);
	
		//TODO: colocar un if para asociar distintas etapas a un periodo en la tabla STAGE_VALUE\
		//Si el nombre del periodo ya existe no debe crearlo de nuevo
		List<Map<String, String>> periodsXLS = externalData.readExternalPeriodData();
		for (Map<String, String> periodInfo : periodsXLS ) {
			String values = "("+ getNextUsableCode("JP_PERIOD") +", NULL, '" + periodInfo.get("INITIALDATE") 
					+ "','" + periodInfo.get("NAME") + "','" + periodInfo.get("PERIODSTATE") + "'," 
					+ getCode("PROGRAM", periodInfo.get("PROGRAM")) + ")";
			createNewElementDB("JP_PERIOD", values);
			values = "("+ getNextUsableCode("STAGE_VALUE") +", " + periodInfo.get("MINVALUE") 
					+ "," + getCode("STAGE", periodInfo.get("STAGE")) + "," + getCode("JP_PERIOD", periodInfo.get("NAME")) + ")";
			createNewElementDB("STAGE_VALUE", values);
		}
	}

	public void createApplicantDB() throws SQLException{
		String query = "INSERT INTO `JP_USER` VALUES (4902260,'Applicant',1,0,NULL,NULL,NULL,'yesica@acha.com','applicantLastname','applicantName',NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL);";
		stmt.execute(query);
		query = "INSERT INTO `USER_PERIOD` VALUES (1, 4902260);";
		stmt.execute(query);
	}

	public String getApplicantGrade(String ci) throws Exception{
		return getDataFromTable("GRADEVALUE", "stage_grade", "WHERE APPLICANT_CI = 4902260 and STAGEVALUE_ID = 1 order by id desc limit 1");
	}
	
	public String getNextUsableCode(String tableName) throws Exception{
		String lastCodeDB = getDataFromTable("ID", tableName, "ORDER BY ID desc limit 1");
		int code;
		if (lastCodeDB == null) {
			code = 1;
		} else {
			code = Integer.parseInt(lastCodeDB) + 1;
		}
		return code + "";
	}

	public String getCode(String tableName, String name) throws Exception {
		return getDataFromTable("ID", tableName, "WHERE NAME = '" + name +"';");
	}

	public void deleteDataFromDB() throws SQLException{
		//		deleteDataFromUserTable();
			
		//		
		String query = "DELETE FROM STAGE_GRADE WHERE APPLICANT_CI = 4902260 and STAGEVALUE_ID = 1;";
		stmt.execute(query);
		query = "DELETE FROM USER_PERIOD WHERE PERIOD_ID = 1;";
		stmt.execute(query);
		query = "DELETE FROM JP_USER where CI = 4902260;";
		stmt.execute(query);
		query = "DELETE FROM STAGE_VALUE WHERE PERIOD_ID = 1;";
		stmt.execute(query);
		query = "DELETE FROM JP_PERIOD WHERE ID = 1;";
		stmt.execute(query);
		query = "DELETE FROM GROUP_STAGE WHERE GROUP_ID = 1;";
		stmt.execute(query);
		query = "DELETE FROM JP_GROUP WHERE ID >= 1;";
		stmt.execute(query);
		deleteDataFromProgramTable();
		deleteDataFromStageTable();		
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

