package framework.pages.registeredusers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class NewUserPage implements INavigationPane {
	@FindBy(id = "j_id_t:inputCi")
	WebElement inputCI;

	@FindBy(id = "j_id_t:inputName")
	WebElement inputName;

	@FindBy(id = "j_id_t:inputLastName")
	WebElement inputLastName;

	@FindBy(id = "j_id_t:inputEmail")
	WebElement inputEmail;

	@FindBy(id = "j_id_t:j_id_1d")
	WebElement saveButton;

	@FindBy(id = "j_id_t:j_id_1e")
	WebElement cancelButton;

	public NewUserPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set User's CI in inputCI textbox
	 * @param strCI: User's CI
	 * @return The same page
	 */
	public NewUserPage setUserCI(String strCI){
		inputCI.clear();
		inputCI.sendKeys(strCI);
		return this;
	}

	/**
	 * Set User's name in inputName textbox
	 * @param strName: User's Name
	 * @return The same page
	 */
	public NewUserPage setUserName(String strName){
		inputName.clear();
		inputName.sendKeys(strName);
		return this;
	}

	/**
	 * Set User's Last Name in inputLastName textbox
	 * @param strLastName: User's lastName
	 * @return The same page
	 */
	public NewUserPage setUserLastName(String strLastName){
		inputLastName.clear();
		inputLastName.sendKeys(strLastName);
		return this;
	}

	/**
	 * Set User's email in inputEmail textbox
	 * @param strEmail: User's Email
	 * @return The same page
	 */
	public NewUserPage setUserEmail(String strEmail){
		inputEmail.clear();
		inputEmail.sendKeys(strEmail);
		return this;
	}
	
	/**
	 * This method sets all the information for the cration of a new User
	 * @param strCI: User's CI
	 * @param strName: User's Name
	 * @param strLastName: User's LastName
	 * @param strEmail: User's Email
	 * @return The same page
	 */
	public NewUserPage setNewUserInformation(String strCI, String strName, String strLastName, 
											 String strEmail) {
		setUserCI(strCI);
		setUserName(strName);
		setUserLastName(strLastName);
		setUserEmail(strEmail);
		return this;
	}

	/**
	 * Click Save Button
	 * @return Registered User's Page
	 */
	public RegisteredUsersPage clickSaveButton(){
		saveButton.click();
		return new RegisteredUsersPage();
	}

	/**
	 * Click Cancel Button
	 * @return Registered User's Page
	 */
	public RegisteredUsersPage clickCancelButton(){
		cancelButton.click();
		return new RegisteredUsersPage();
	}
}
