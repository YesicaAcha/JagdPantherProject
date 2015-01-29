package pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.NavigationPage;

public class ProgramsPage extends NavigationPage{

	@FindBy(id="j_id_y:j_id_1a")
	WebElement newProgramButton;
	
	public NewProgramPage clickNewProgramButton(){
		newProgramButton.click();   
		return new NewProgramPage();
	}
}
