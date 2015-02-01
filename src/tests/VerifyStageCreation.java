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

public class VerifyStageCreation {
	
	Database db = new Database();
	
	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();
		
	}
	@Test (dataProvider = "StageDataXlsx", dataProviderClass = DataProviderClass.class)
	public void verifyNewStageIsCreated(String stageName, String stageTitle, String stageDescription) throws Exception{

		//Create Home Page object
		HomePage HomePage = new HomePage();
		

		//Create new Stage
		NewStagePage stagePage = HomePage
		.clickStagesLink()
		.clickNewStageButton();
		
		//
		StagesPage jagdPantherStagesPage = stagePage
		.setNewNormalStageInformation(stageName, stageTitle, stageDescription)
		.clickSaveButton();
		
		//Verify if Stage was created
		Assert.assertTrue(jagdPantherStagesPage.getStageName().contains(stageName));
		
				
		/*Validating with the database*/
		Assert.assertTrue(db.getStageNameDB(stageName).contains(stageName));
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		db.deleteDataFromStageTable();
		db.tearDown();
	}
	
}
