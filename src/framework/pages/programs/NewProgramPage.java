package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





import framework.pages.NavigationPage;

public class NewProgramPage extends NavigationPage{

	@FindBy(id="form:inputName")
	WebElement inputName;

	@FindBy(id="form:inputTitle")
	WebElement inputTitle;

	@FindBy(id="form:inputDescription")
	WebElement inputDescription;

	@FindBy(xpath=".//*[@id='form:j_id_18']")
	WebElement saveButton;

	@FindBy(id="form:j_id_19")
	WebElement cancelButton;


	//Set Program's name in inputName textbox
	public NewProgramPage setProgramName(String strName){
		inputName.clear();
		inputName.sendKeys(strName);
		return this;
	}

	//Set Program's title in inputTitle textbox
	public NewProgramPage setProgramTitle(String strTitle) throws InterruptedException{
		inputTitle.click();
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form:inputTitle' and contains(@value, " + strName + ")])"))));
		inputTitle.clear();
		inputTitle.sendKeys(strTitle);
		return this;
	}

	//Set Program's description in inputDescription textbox
	public NewProgramPage setProgramDescription(String strDescription){
		inputDescription.clear();
		inputDescription.sendKeys(strDescription);
		return this;
	}

	//Click Save Button
	public ProgramDetailsPage clickSaveButton(){
		saveButton.click();
		return new ProgramDetailsPage();
	}

	//Click Cancel Button
	public ProgramsPage clickCancelButton(){
		cancelButton.click();
		return new ProgramsPage();
	}

	
}
