package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class ProgramsPage implements INavigationPane {
	@FindBy(id = "j_id_y:j_id_1a")
	WebElement newProgramButton;
	
	@FindBy(id = "j_id_y:programs_data")
	WebElement programTable;
	
	@FindBy(id = "j_id_y:programs:0:j_id_18")
	WebElement editButton;
	
	public ProgramsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click Añadir in Program Page
	 * @return New Program's Page
	 */
	public NewProgramPage clickNewProgramButton(){
		newProgramButton.click();   
		return new NewProgramPage();
	}
	
	/**
	 * Click Edit button in Program Page
	 * @return Program's Details page
	 */
	public ProgramDetailsPage clickEditProgramButton(){
		editButton.click();   
		return new ProgramDetailsPage();
	}		
}
