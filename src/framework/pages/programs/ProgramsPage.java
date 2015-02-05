package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class ProgramsPage implements INavigationPane {

	//Añadir button
	@FindBy(id="j_id_y:j_id_1a")
	WebElement newProgramButton;
	
	//table with the list of the name of all programs
	@FindBy(id="j_id_y:programs_data")
	WebElement programTable;
	
	//First program edit button
	@FindBy(id="j_id_y:programs:0:j_id_18")
	WebElement editButton;
	
	public ProgramsPage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * Click Añadir in Program Page
	 * @return
	 */
	public NewProgramPage clickNewProgramButton(){
		newProgramButton.click();   
		return new NewProgramPage();
	}
	
	//Click Edit button in Program Page
	public ProgramDetailsPage clickEditProgramButton(){
		editButton.click();   
		return new ProgramDetailsPage();
	}		
}
