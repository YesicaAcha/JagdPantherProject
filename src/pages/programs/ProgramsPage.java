package pages.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.NavigationPage;

public class ProgramsPage extends NavigationPage{

	WebDriver driver;
	
	@FindBy(id="j_id_y:j_id_1a")
	WebElement addProgram;
	
	public AddProgramPage clickAddButton(){
		addProgram.click();   
		return new AddProgramPage();
	}
}
