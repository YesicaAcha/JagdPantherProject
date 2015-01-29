package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.HomePage;
import framework.pages.stages.NewStagePage;
import framework.pages.stages.StagesPage;
import framework.utils.DataProviderClass;

public class StagesTest {

	@Test (dataProvider = "StageDataTxt", dataProviderClass = DataProviderClass.class)
	public void verifyNewStageIsCreated(String stageName, String stageTitle, String stageDescription) throws Exception{

		//Create Home Page object
		HomePage HomePage = new HomePage();
		

		//Create new Stage
		NewStagePage stagePage = HomePage
		.clickStagesLink()
		.clickNewStageButton();
		
		//
		StagesPage jagdPantherStagesPage = stagePage
		.setStageTitle(stageTitle)
		.setStageName(stageName)
		.setStageDescription(stageDescription)
		.clickSaveButton();
		
		//Verify if Stage was created
		Assert.assertTrue(jagdPantherStagesPage.getStageName().contains(stageName));
	}
	
}
