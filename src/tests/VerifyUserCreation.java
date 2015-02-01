package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;
import framework.pages.registeredusers.NewUserPage;
import framework.pages.registeredusers.RegisteredUsersPage;
import framework.utils.DataProviderClass;

public class VerifyUserCreation {

	Database db = new Database();
	
	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();
		
	}
	
	@Test  (dataProvider = "UserData", dataProviderClass = DataProviderClass.class)
	public void verifyNewUserIsCreated(String strCI, String strName, String strLastName, String strEmail) throws Exception{

		//Create Home Page object
		HomePage homePage = new HomePage();
		
		//Create new Program
		NewUserPage newUserPage = homePage
				.clickRegisteredUsersLink()
				.clickNewUserButton();
		
		RegisteredUsersPage registeredUsersPage = newUserPage
				.setNewUserInformation(strCI, strName, strLastName, strEmail)
				.clickSaveButton();

		Assert.assertTrue(registeredUsersPage.getNewUserName().contains(strName));
		
		/*Validating with the database*/
		Assert.assertTrue(db.getUserNameDB(strName).contains(strName));
		 
	}
	@AfterTest
	public void tearDown() throws Exception {
		db.deleteDataFromUserTable();
		db.tearDown();
	}
}
