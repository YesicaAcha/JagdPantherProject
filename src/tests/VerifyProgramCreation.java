package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.programs.NewProgramPage;
import framework.pages.programs.ProgramDetailsPage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * Title: Verify a user can created a new program
 * ID: 
 * @author Yesica Acha
 */
@Listeners(JyperionListener.class)
public class VerifyProgramCreation {
	Database db = new Database();

	/**
	 * Connect to the database
	 * @throws Exception
	 */
	@BeforeClass
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
		Assert.assertEquals(programDetails.getName(), name);

		//Verify program is created in the database
		Assert.assertEquals(db.getProgramNameDB(name), name);
	}

	/**
	 * Delete Stage data from table
	 * @throws Exception
	 */
	@AfterClass
	public void closeConnection() throws Exception {
		db.deleteDataFromProgramTable();
		db.tearDown();
	}
}
