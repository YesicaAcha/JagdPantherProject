package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;
import pages.login.LoginPage;


public class TestSuit {
	
	@BeforeSuite
	public void LoginApplication(){

		//Create Login Page object
		LoginPage jagdPantherLogin = new LoginPage();

		//login to application
		jagdPantherLogin.loginToJagdPanther("admin@admin.com", "admin11");
						
	}
	
	@AfterSuite
	public void terminateBrowser(){
		HomePage HomePage = new HomePage();
		HomePage
			.logout()
			.terminateBrowser();
	} 
}
