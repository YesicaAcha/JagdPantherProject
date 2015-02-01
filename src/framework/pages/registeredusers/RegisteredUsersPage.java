package framework.pages.registeredusers;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.NavigationPage;


public class RegisteredUsersPage extends NavigationPage{

	@FindBy(id="j_id_t:j_id_16")
	WebElement newUserButton;
	
	@FindBy(id="j_id_t:AllUserTable_data")
	WebElement tableData;
	
	//Click on add button
	public NewUserPage clickNewUserButton(){
		newUserButton.click();   
		return new NewUserPage();
	}
	
	//Get program's name from ProgramDetails page
		public String getNewUserName(){
			return tableData.getText();
		}
}
