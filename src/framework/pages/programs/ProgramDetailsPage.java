package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class ProgramDetailsPage implements INavigationPane {

	//"Regresar a la lista de programas" button
	@FindBy(id="j_id_t:j_id_y")
	WebElement programListButton;

	//Program's Code Display text
	@FindBy(id="j_id_t:idInput")
	WebElement programCode;

	//Program's Name Display text
	@FindBy(id="j_id_t:nameInput_display") 
	WebElement programName;

	//Program's Title Display text
	@FindBy(id="j_id_t:inputTitle_display")
	WebElement programTitle;

	//Program's Description Display text
	@FindBy(id="j_id_t:inputDescription_display")
	WebElement programDescription;

	//Program's Name Input
	@FindBy(id="j_id_t:j_id_16") 
	WebElement inputProgramName;
	
	public ProgramDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	//Click "Regresar a la lista de programas" to return Programs page
	public ProgramsPage returnProgramsPage(){
		programListButton.click();
		return new ProgramsPage();
	}

	//Get program's code from ProgramDetails page
	public String getProgramCode(){
		return programCode.getText();
	}

	//Get program's name from ProgramDetails page
	public String getProgramName(){
		return programName.getText();
	}

	//Get program's title from ProgramDetails page
	public String getProgramTitle(){
		return programTitle.getText();
	}

	//Get program's description from ProgramDetails page
	public String getProgramDescription(){
		return programDescription.getText();
	}

	//Change program's description in ProgramDetails page
	public ProgramDetailsPage changeProgramDescription(String newProgramDescription){
		programDescription.click();
		inputProgramName.clear();
		inputProgramName.sendKeys(newProgramDescription);
		return this;
	}

}
