package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class ProgramDetailsPage implements INavigationPane {
	@FindBy(id = "j_id_t:j_id_y")
	WebElement programListButton;

	@FindBy(id = "j_id_t:idInput")
	WebElement programCodeLabel;

	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement programNameLabel;

	@FindBy(id = "j_id_t:inputTitle_display")
	WebElement programTitleLabel;

	@FindBy(id = "j_id_t:inputDescription_display")
	WebElement programDescriptionLabel;

	@FindBy(id = "j_id_t:j_id_16") 
	WebElement inputProgramName;
		
	@FindBy(id = "j_id_t:j_id_1a") 
	WebElement inputProgramTitle;
	
	@FindBy(id = "j_id_t:j_id_1e") 
	WebElement inputProgramDescription;
	
	@FindBy (xpath = "//button[@type='button']")
	WebElement saveProgramNameButton;
	
	@FindBy (xpath = "(//button[@type='button'])[3]")
	WebElement saveProgramTitleButton;
	
	@FindBy (xpath = "(//button[@type='button'])[5]")
	WebElement saveProgramDescriptionButton;
	
	@FindBy (xpath = "(//button[@type='button'])[2]")
	WebElement cancelProgramNameButton;
	
	@FindBy (xpath = "(//button[@type='button'])[4]")
	WebElement cancelProgramTitleButton;
	
	@FindBy (xpath = "(//button[@type='button'])[6]")
	WebElement cancelProgramDescriptionButton;
	
	public ProgramDetailsPage() {
		PageFactory.initElements(driver, this);
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
	 * Get program's code from ProgramDetails page
	 * @return The code from Program 
	 */
	public String getProgramCode() {
		return programCodeLabel.getText();
	}

	/**
	 * Get program's name from ProgramDetails page
	 * @return The Program Name
	 */
	public String getProgramName() {
		return programNameLabel.getText();
	}

	/**
	 * Get program's title from ProgramDetails page
	 * @return The Program Title
	 */
	public String getProgramTitle() {
		return programTitleLabel.getText();
	}

	/**
	 * Get program's description from ProgramDetails page
	 * @return The Program's Description
	 */
	public String getProgramDescription() {
		return programDescriptionLabel.getText();
	}

	/**
	 * Change program's name in ProgramDetails page
	 * @param newProgramName: Program's Name
	 */
	public void modifyProgramName(String newProgramName) {
		programNameLabel.click();
		inputProgramName.clear();
		inputProgramName.sendKeys(newProgramName);
		saveProgramNameButton.click();
	}	
	
	/**
	 * Change program's title in ProgramDetails page
	 * @param newProgramTitle: Program's Title
	 */
	public void modifyProgramTitle(String newProgramTitle) {
		programTitleLabel.click();
		inputProgramTitle.clear();
		inputProgramTitle.sendKeys(newProgramTitle);
		saveProgramTitleButton.click();
	}
	
	/**
	 * Change program's description in ProgramDetails page
	 * @param newProgramDescription: Program's Description
	 */
	public void modifyProgramDescription(String newProgramDescription) {
		programDescriptionLabel.click();
		inputProgramDescription.clear();
		inputProgramDescription.sendKeys(newProgramDescription);
		saveProgramDescriptionButton.click();
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
