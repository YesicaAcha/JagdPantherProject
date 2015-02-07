package framework.pages.stages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.AbstractNewProgramStageBasePage;
import framework.pages.INavigationPane;

/**
 * Page for New Stage Creation
 * @author Yesica Acha
 *
 */
public class NewStagePage extends AbstractNewProgramStageBasePage implements INavigationPane {
	@FindBy(id = "form:stageTypeId_label")
	WebElement stageTypeLabel;

	@FindBy(id = "form:inputGrade")
	WebElement inputGrade;

	@FindBy(id = "form:j_id_1k")
	WebElement saveButton;

	@FindBy(id = "form:j_id_1l")
	WebElement cancelButton;

	public NewStagePage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * click Añadir button in StagesPage
	 * @param strStageType: Stage's Type
	 * @return The same page
	 */
	public NewStagePage setStageType(String strStageType) {
		stageTypeLabel.sendKeys(strStageType);  
		return this;
	}

	/**
	 * Set Stage's grade in inputGrade textbox
	 * @param strStageGrade: Stage's Grade
	 * @return The same Page
	 */
	public NewStagePage setStageGrade(String strStageGrade) {
		inputGrade.clear();
		inputGrade.sendKeys(strStageGrade);
		return this;
	}

	/**
	 * Set Stage's information in New Stage form
	 * @param strStageName: Stage's Name
	 * @param strStageTitle: Stage's Title
	 * @param strStageDescription: Stage's Description
	 * @return The same page
	 */
	public NewStagePage setNewNormalStageInformation(String strStageName, String strStageTitle,String strStageDescription) {
		setDescription(strStageDescription);
		setTitle(strStageTitle);
		setName(strStageName);
		return this;                                                                                                                                                                                   
	}

	/**
	 * Click Save Button
	 * @return Stage Page
	 */
	public StagesPage clickSaveButton() {
		saveButton.click();
		return new StagesPage();
	}

	/**
	 * Click Cancel Button
	 * @return Stage Page
	 */
	public StagesPage clickCancelButton() {
		cancelButton.click();
		return new StagesPage();
	}

}

