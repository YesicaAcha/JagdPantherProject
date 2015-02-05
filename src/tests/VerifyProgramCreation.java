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
 * Title: Verify a user can created a new program
 * ID: 
 * @author Yesica Acha
 */
public class VerifyProgramCreation {
	Database db = new Database();

	/*Connect to the database*/
	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();
	}

	/**
	 * This test case verifies a new program is created and if its information is 
	 * displayed in Program Details Page
	 * @param name: Program's name
	 * @param title: Program's title
	 * @param description: Program's description
	 * @throws Exception
	 */
	@Test(dataProvider = "ProgramCreation", dataProviderClass = DataProviderClass.class)
	public void verifyANewProgramIsCreated(String name, String title, String description) throws Exception {
		HomePage HomePage = new HomePage();

		//Go to New program Page
		NewProgramPage newProgram = HomePage
				.clickProgramasLink()
				.clickNewProgramButton();

		//Create a new program
		ProgramDetailsPage programDetails = newProgram.setNewProgramInformation
				(name, title, description)
				.clickSaveButton();

		//Verify program name is displayed in Program Detail page
		Assert.assertEquals(programDetails.getProgramName(), name);

		//Verify program is created in the database
		Assert.assertEquals(db.getProgramNameDB(name), name);
	}

	/*Delete Stage data from table*/
	@AfterTest
	public void closeConnection() throws Exception {
		db.deleteDataFromProgramTable();
		db.tearDown();
	}


}
