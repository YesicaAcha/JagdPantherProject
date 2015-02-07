package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.programs.ProgramDetailsPage;
import framework.utils.DataProviderClass;

/**
 * 
 * @author Yesica Acha
 *
 */
public class VerifyProgramEdition {
	Database db = new Database();

	/*Connect to the database*/
	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();
		db.creaeNewProgramDB();
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
		Assert.assertEquals(programDetails.getProgramName(), name);
		Assert.assertEquals(programDetails.getProgramTitle(), title);
		Assert.assertEquals(programDetails.getProgramDescription(), description);

		//Verify program is created in the database
		//Assert.assertEquals(db.getProgramNameDB(name), name);
	}

	/*Delete Stage data from table*/
	@AfterTest
	public void closeConnection() throws Exception {
		db.deleteDataFromProgramTable();
		db.tearDown();
	}
}
