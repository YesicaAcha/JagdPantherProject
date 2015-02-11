package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.programs.ProgramDetailsPage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * 
 * @author Yesica Acha
 *
 */
@Listeners(JyperionListener.class)
public class VerifyProgramEdition {
	Database db = new Database();
	

	/**
	 * Connect to the database and create a program
	 * @throws Exception
	 */
	@BeforeClass
	public void setUp() throws Exception {
		db.setUp();
		db.createProgramsByBD();
	}
	
	/**
	 * This test case verifies program information is modified and displayed in Program Details Page 
	 * and this information is saved in the database
	 * @param name: Program's name
	 * @param title: Program's title
	 * @param description: Program's description
	 * @throws Exception
	 */
	@Test
	(dataProvider = "ProgramCreation", dataProviderClass = DataProviderClass.class)
	public void verifyAProgramIsEdited(String name, String title, String description) throws Exception {
		HomePage HomePage = new HomePage();

		//Go to ProgramDetailsPage
		ProgramDetailsPage programDetails = HomePage
				.clickProgramasLink()
				.clickEditProgramButton();

		//Edit porgram information
		programDetails = programDetails
				.modifyProgramInformation(name, title, description);

		//Verify program information has changed
		Assert.assertEquals(programDetails.getName(), name);
		Assert.assertEquals(programDetails.getTitle(), title);
		Assert.assertEquals(programDetails.getDescription(), description);

		//Verify program is created in the database
		Assert.assertEquals(db.getProgramNameDB(name), name);
		Assert.assertEquals(db.getProgramTitleDB(name), title);
		Assert.assertEquals(db.getProgramDescriptionDB(name), description);
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
