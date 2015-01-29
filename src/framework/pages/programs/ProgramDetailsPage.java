package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.NavigationPage;

public class ProgramDetailsPage extends NavigationPage{

	@FindBy(id="j_id_t:nameInput_display")
	WebElement programName;

	//Get program's name from ProgramDetails page
	public String getProgramName(){
		return programName.getText();
	}

}
