package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.stages.NewStagePage;
import framework.pages.stages.StagesPage;
import framework.utils.DataProviderClass;

/**
 * Title: This test case verifies if a new Stage is created
 * @author Yesica Acha
 *
 */
public class VerifyStageCreation {

	Database db = new Database();

	/*Connect to the database*/
	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();

	}

	/**
	 * This test case verifies a new normal stage is created and it is displayed in Stages Page and it is save in the database
	 * @param stageName
	 * @param stageTitle
	 * @param stageDescription
	 * @throws Exception
	 */	

	@Test (dataProvider = "StageDataXlsx", dataProviderClass = DataProviderClass.class)
	public void verifyNewStageIsCreated(String stageName, String stageTitle, String stageDescription) throws Exception{

		//Create Home Page object
		HomePage HomePage = new HomePage();

		//Go to stagePage
		NewStagePage stagePage = HomePage
				.clickStagesLink()
				.clickNewStageButton();

		//Create new Stage in New Stage Page
		StagesPage jagdPantherStagesPage = stagePage
				.setNewNormalStageInformation(stageName, stageTitle, stageDescription)
				.clickSaveButton();

		//Verify if Stage was created
		Assert.assertTrue(jagdPantherStagesPage.getStageName().contains(stageName));

		//Verify id Stage was created in the database
		Assert.assertEquals(db.getStageNameDB(stageName), stageName);
	}

	/*Delete Stage data from table*/
	@AfterTest
	public void tearDown() throws Exception {
		db.deleteDataFromStageTable();
		db.tearDown();
	}

}
