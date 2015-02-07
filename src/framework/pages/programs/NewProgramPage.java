package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.AbstractNewProgramStageBasePage;
import framework.pages.INavigationPane;

public class NewProgramPage extends AbstractNewProgramStageBasePage implements INavigationPane {
	@FindBy(id = "form:j_id_18")
	WebElement saveButton;

	@FindBy(id = "form:j_id_19")
	WebElement cancelButton;

	public NewProgramPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Set program's information in new program page
	 * @param strName: Program's Name
	 * @param strTitle: Program's Title
	 * @param strDescription: Program's Description
	 * @return the same New Program Page
	 * @throws InterruptedException
	 */
	public NewProgramPage setNewProgramInformation(String strName, String strTitle, String strDescription) throws InterruptedException{
		setDescription(strDescription);
		setTitle(strTitle);
		setName(strName);
		return this;
	}

	/**
	 * Click Save Button
	 * @return New Program Details page
	 */
	public ProgramDetailsPage clickSaveButton() {
		saveButton.click();
		return new ProgramDetailsPage();
	}

	/**
	 * Click Cancel Button
	 * @return New Program Page
	 */
	public ProgramsPage clickCancelButton() {
		cancelButton.click();
		return new ProgramsPage();
	}	
}
