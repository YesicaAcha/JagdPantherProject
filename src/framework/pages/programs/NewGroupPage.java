package framework.pages.programs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.AbstractNewProgramStageBasePage;
import framework.pages.INavigationPane;

public class NewGroupPage extends AbstractNewProgramStageBasePage implements INavigationPane {
	@FindBy(id = "form:j_id_18")
	WebElement saveButton;

	@FindBy(id = "form:j_id_19")
	WebElement cancelButton;

	public NewGroupPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Set program's information in new program page
	 * @param strName: Groups's Name
	 * @param strTitle: Group's Title
	 * @param strDescription: Group's Description
	 * @return the same New Group Page
	 * @throws InterruptedException
	 */
	public NewGroupPage setNewGroupInformation(String strName, String strTitle, String strDescription) throws InterruptedException{
		setDescription(strDescription);
		setTitle(strTitle);
		setName(strName);
		return this;
	}

	/**
	 * Click Save Button
	 * @return New Group Details page
	 */
	public GroupDetailsPage clickSaveButton() {
		saveButton.click();
		return new GroupDetailsPage();
	}

	/**
	 * Click Cancel Button
	 * @return Program Details Page
	 */
	public ProgramDetailsPage clickCancelButton() {
		cancelButton.click();
		return new ProgramDetailsPage();
	}	
}
