package framework.pages.registeredusers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class RegisteredUsersPage implements INavigationPane {
	@FindBy(id = "j_id_t:j_id_16")
	WebElement newUserButton;
	
	@FindBy(id = "j_id_t:AllUserTable_data")
	WebElement tableData;
	
	public RegisteredUsersPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Click on add button
	 * @return New User Page
	 */
	public NewUserPage clickNewUserButton(){
		newUserButton.click();   
		return new NewUserPage();
	}
	
	/**
	 * Get program's name from ProgramDetails page
	 * @return String with all information of Users
	 */
	public String getNewUserName(){
		return tableData.getText();
	}
}
