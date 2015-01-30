package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.HomePage;
import framework.pages.programs.ProgramDetailsPage;
import framework.utils.DataProviderClass;

/**
 * Title: 
 * ID: 
 * @author Yesica Acha
 *
 */
public class ProgramsTest {

	/**
	 * This test case verifies a new program is created 
	 * @param name
	 * @param title
	 * @param description
	 * @throws Exception
	 */
	@Test  (dataProvider = "ProgramCreation", dataProviderClass = DataProviderClass.class)
	public void verifyNewProgramIsCreated(String name, String title, String description) throws Exception{

		//Create Home Page object
		HomePage HomePage = new HomePage();
		ProgramDetailsPage jagdPantherProgramDetailsPage = new ProgramDetailsPage();

		//Create new Program
		HomePage
		.clickProgramasLink()
		.clickNewProgramButton()
		.setProgramName(name)
		.setProgramTitle(title)
		.setProgramDescription(description)
		.clickSaveButton();

		Assert.assertTrue(jagdPantherProgramDetailsPage.getProgramName().contains(name));
		 
	}
	
}
