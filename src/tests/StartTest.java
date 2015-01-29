package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.pages.HomePage;
import framework.pages.login.LoginPage;


public class StartTest {
	
	@BeforeSuite
	public void init(){

		//Create LoginPage object
		LoginPage jagdPantherLogin = new LoginPage();

		//login to application
		jagdPantherLogin.loginToJagdPanther("admin@admin.com", "admin11");		
	}
	
	@AfterSuite
	public void quit(){
		/*Create HomePage object*/
		HomePage HomePage = new HomePage();
		
		
		HomePage
			.logout()				/*logout application*/
			.terminateBrowser();	/*quit browser*/  
	} 
}
