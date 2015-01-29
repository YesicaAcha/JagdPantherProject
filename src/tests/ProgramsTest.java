package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.programs.ProgramDetailsPage;

public class ProgramsTest {

	@DataProvider(name = "ProgramCreation")
	public Object[][] programData() {
		return new Object[][] {{"ProgramName1","ProgramTitle1","ProgramDescription1"},
				{"ProgramName1","ProgramTitle1","ProgramDescription1"}};

	}

	/**
	 * This test case verifies a new program is created 
	 * @param name
	 * @param title
	 * @param description
	 * @throws Exception
	 */
	@Test  (dataProvider = "ProgramCreation")
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
