package framework.pages.stages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.NavigationPage;
/**
 * Page for New Stage Creation
 * @author Yesica Acha
 *
 */
public class NewStagePage extends NavigationPage{
	@FindBy(id="form:stageTypeId_label")
	WebElement stageTypeLabel;

	@FindBy(id="form:inputName")
	WebElement inputName;

	@FindBy(id="form:inputTitle")
	WebElement inputTitle;

	@FindBy(id="form:inputDescription")
	WebElement inputDescription;

	@FindBy(id="form:inputGrade")
	WebElement inputGrade;

	@FindBy(id="form:j_id_1k")
	WebElement saveButton;

	@FindBy(id="form:j_id_1l")
	WebElement cancelButton;

	/*click Añadir button in StagesPage*/
	public NewStagePage setStageType(String strStageType){
		stageTypeLabel.sendKeys(strStageType);  
		return this;
	}

	//Set Stage's name in inputName textbox
	public NewStagePage setStageName(String strStageName){
		inputName.clear();
		inputName.sendKeys(strStageName);
		return this;
	}

	//Set Stage's title in inputTitle textbox
	public NewStagePage setStageTitle(String strStageTitle){
		inputTitle.click();
		inputTitle.clear();
		inputTitle.sendKeys(strStageTitle);
		return this;
	}

	//Set Stage's description in inputDescription textbox
	public NewStagePage setStageDescription(String strStageDescription){
		inputDescription.clear();
		inputDescription.sendKeys(strStageDescription);
		return this;
	}

	//Set Stage's grade in inputGrade textbox
	public NewStagePage setStageGrade(String strStageGrade){
		inputGrade.clear();
		inputGrade.sendKeys(strStageGrade);
		return this;
	}

	//Set Stage's information in New Stage form
	public NewStagePage setNewNormalStageInformation(String strStageName, String strStageTitle,String strStageDescription){
		setStageTitle(strStageTitle);
		setStageName(strStageName);
		setStageDescription(strStageDescription);
		return this;
	}

	//Click Save Button
	public StagesPage clickSaveButton(){
		saveButton.click();
		return new StagesPage();
	}

	//Click Cancel Button
	public StagesPage clickCancelButton(){
		cancelButton.click();
		return new StagesPage();
	}

}

