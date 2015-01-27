package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.programs.ProgramDetailsPage;

public class ProgramsTest {
	
	@Test
	public void createNewProgramTest() throws Exception{

		String name = "ProgramName6";
		String title = "ProgramTitle6";
		
		//Create Home Page object
		HomePage HomePage = new HomePage();
		ProgramDetailsPage jagdPantherProgramDetailsPage = new ProgramDetailsPage();
		
		//Create new Program
		HomePage
			.clickProgramasLink()
			.clickAddButton()
			.setProgramTitle(title,name)
			.setProgramName(name)
			.clickSaveButton();
	
		Assert.assertTrue(jagdPantherProgramDetailsPage.getProgramName().contains(name));
		
	}
}
