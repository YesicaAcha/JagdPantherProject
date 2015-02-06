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

/**
 * Title: Verify an admin user can create register new users
 * @author Yesica Acha
 *
 */
public class VerifyUserCreation {
	Database db = new Database();

	@BeforeTest
	public void setUp() throws Exception {
		db.setUp();
	}

	/**
	 * This test case verifies an administrator can registered new user, new user information is displayed in Registered Users table and the information is saved in the database.
	 * @param strCI: User's CI
	 * @param strName: User's Name
	 * @param strLastName: User's LastName
	 * @param strEmail: User's Email
	 * @throws Exception
	 */
	@Test  (dataProvider = "UserData", dataProviderClass = DataProviderClass.class)
	public void verifyNewUserIsCreated(String strCI, String strName, String strLastName, String strEmail) throws Exception {

		//Create Home Page object
		HomePage homePage = new HomePage();

		//Go to new user page
		NewUserPage newUserPage = homePage
				.clickRegisteredUsersLink()
				.clickNewUserButton();

		//Create a new user
		RegisteredUsersPage registeredUsersPage = newUserPage
				.setNewUserInformation(strCI, strName, strLastName, strEmail)
				.clickSaveButton();

		//Verify user's name is displayed in Registered Users table
		Assert.assertTrue(registeredUsersPage.getNewUserName().contains(strName));

		//Verify user information is saved in the database 
		Assert.assertEquals(db.getUserCIDB(strCI), strName);
	}

	@AfterTest
	public void tearDown() throws Exception {
		db.deleteDataFromUserTable();
		db.tearDown();
	}
}
