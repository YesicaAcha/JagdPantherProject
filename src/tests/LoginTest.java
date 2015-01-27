package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.login.LoginPage;
import pages.programs.ProgramDetailsPage;
import pages.registeredusers.RegisteredUsersPage;

public class LoginTest {

	@Test (priority = 0)
	public void verifyUsersLogin(){

		//Create Login Page object
		LoginPage jagdPantherLogin = new LoginPage();

		//login to application
		RegisteredUsersPage jagdPantherRegisteredUsersPage = jagdPantherLogin.loginToJagdPanther("admin@admin.com", "admin11");

		//Verify home page
		Assert.assertTrue(jagdPantherRegisteredUsersPage.getUserName().contains("Admin Admin"));
				
	}
	
	@Test (priority = 1)
	public void createNewProgramTest() throws Exception{
		
		String name = "ProgramName13";
		String title = "ProgramTitle7";
		
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
