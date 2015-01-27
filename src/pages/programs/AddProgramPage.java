package pages.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.NavigationPage;

public class AddProgramPage extends NavigationPage{

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
	public AddProgramPage setProgramName(String strName){
		inputName.clear();
		inputName.sendKeys(strName);
		return this;
	}

	//Set Program's title in inputTitle textbox
	public AddProgramPage setProgramTitle(String strTitle, String strName) throws InterruptedException{
		inputTitle.click();
		//Thread.sleep(2000);
		//driver.navigate().refresh();
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElementValue(By.id("form:inputTitle"),strName)));
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form:inputTitle' and contains(@value, " + strName + ")])"))));
		inputTitle.clear();
		inputTitle.sendKeys(strTitle);
		return this;
		
//		driver.findElement(By.id("form:inputTitle")).click();
//		Thread.sleep(2000);
////		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("form:inputTitle"),strName));
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form:inputTitle' and contains(@value, '" + strName + "')])")));
//		driver.findElement(By.id("form:inputTitle")).clear();
//		driver.findElement(By.id("form:inputTitle")).sendKeys(strTitle);
//		return this;
	}

	//Set Program's description in inputDescription textbox
	public AddProgramPage setProgramDescription(String strDescription){
		inputName.clear();
		inputName.sendKeys(strDescription);
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
