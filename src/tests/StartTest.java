package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.common.ConfigConstants;
import framework.pages.HomePage;
import framework.pages.login.LoginPage;


public class StartTest {
	
	@BeforeSuite
	public void init() {

		//Create LoginPage object
		LoginPage jagdPantherLogin = new LoginPage();

		//login to application
		jagdPantherLogin.loginToJagdPanther(ConfigConstants.USER_MAIL, ConfigConstants.PASSWORD);		
	}
	
	@AfterSuite
	public void quit() {
		/*Create HomePage object*/
		HomePage HomePage = new HomePage();
		HomePage
			.logout()				/*logout application*/
			.terminateBrowser();	/*quit browser*/  
	} 
}
