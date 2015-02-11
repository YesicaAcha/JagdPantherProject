package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.AbstractProgramGroupsDetailsPage;
import framework.pages.INavigationPane;

public class ProgramDetailsPage extends AbstractProgramGroupsDetailsPage implements INavigationPane {
	@FindBy(id = "j_id_t:j_id_y")
	WebElement programListButton;

	@FindBy(id = "j_id_t:j_id_16") 
	WebElement inputProgramName;
		
	@FindBy(id = "j_id_t:j_id_1a") 
	WebElement inputProgramTitle;
	
	@FindBy(id = "j_id_t:j_id_1e") 
	WebElement inputProgramDescription;
	
	@FindBy (linkText = "Grupos")
	WebElement groupsButton;
	
	@FindBy (linkText = "Periodos")
	WebElement periodsButton;
	
	@FindBy(id = "j_id_t:programTabDetails:j_id_23")
	WebElement addButton;
		
	public ProgramDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to go to NewGroupPage
	 * @return NewGroupPage
	 */
	public NewGroupPage clickAddButton(){
		addButton.click();
		return new NewGroupPage();
	}
	
	/**
	 * Click "Regresar a la lista de programas" to return Programs page
	 * @return New Programs Page
	 */
	public ProgramsPage returnProgramsPage() {
		programListButton.click();
		return new ProgramsPage();
	}

	/**
	 * Change program's name in ProgramDetails page
	 * @param newProgramName: Program's Name
	 */
	public void modifyProgramName(String newProgramName) {
		clickNameLabel();
		inputProgramName.clear();
		inputProgramName.sendKeys(newProgramName);
		clickSaveNameButton();
	}	
	
	/**
	 * Change program's title in ProgramDetails page
	 * @param newProgramTitle: Program's Title
	 */
	public void modifyProgramTitle(String newProgramTitle) {
		clickTitleLabel();
		inputProgramTitle.clear();
		inputProgramTitle.sendKeys(newProgramTitle);
		clickSaveTitleButton();
	}
	
	/**
	 * Change program's description in ProgramDetails page
	 * @param newProgramDescription: Program's Description
	 */
	public void modifyProgramDescription(String newProgramDescription) {
		clickDescriptionLabel();
		inputProgramDescription.clear();
		inputProgramDescription.sendKeys(newProgramDescription);
		clickSaveDescriptionButton();
	}
	
	/**
	 *  Change program's information in ProgramDetails page
	 * @param newProgramName: Program's Name
	 * @param newProgramTitle: Program's Title
	 * @param newProgramDescription: Program's Description
	 * @return the same page
	 */
	public ProgramDetailsPage modifyProgramInformation(String newProgramName, String newProgramTitle, String newProgramDescription) {
		modifyProgramName(newProgramName); 
		modifyProgramTitle(newProgramTitle);
		modifyProgramDescription(newProgramDescription);
		return this;
	}
}
