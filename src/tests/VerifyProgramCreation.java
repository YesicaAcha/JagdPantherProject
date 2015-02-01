package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.programs.NewProgramPage;
import framework.pages.programs.ProgramDetailsPage;
import framework.utils.DataProviderClass;

/**
 * Title: This test case verifies a new program is created in JagdPanther
 * ID: 
 * @author Yesica Acha
 *
 */
public class VerifyProgramCreation {

	/**
	 * 
	 * @param name
	 * @param title
	 * @param description
	 * @throws Exception
	 */
	Database db = new Database();
	
	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();
		
	}

	@Test(dataProvider = "ProgramCreation", dataProviderClass = DataProviderClass.class)
	public void test(String name, String title, String description) throws Exception {
		HomePage HomePage = new HomePage();
		

		//Create new Program
		NewProgramPage newProgram = HomePage
		.clickProgramasLink()
		.clickNewProgramButton();
		
		ProgramDetailsPage programDetails =newProgram.setNewProgramInformation(name, title, description)
		.clickSaveButton();
		
		Assert.assertTrue(programDetails.getProgramName().contains(name));
		
		/*Validating with the database*/
		Assert.assertTrue(db.getProgramNameDB(name).contains(name));
		
	}

	@AfterTest
	public void closeConnection() throws Exception {
		db.deleteDataFromProgramTable();
		db.tearDown();
	}

	
}
