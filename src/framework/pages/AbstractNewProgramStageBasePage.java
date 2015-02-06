package framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This is the Base page for creation of a new program or new stage
 * @author Yesica Acha
 *
 */
public abstract class AbstractNewProgramStageBasePage {
	@FindBy(id = "form:inputName")
	WebElement inputName;

	@FindBy(id = "form:inputTitle")
	WebElement inputTitle;

	@FindBy(id = "form:inputDescription")
	WebElement inputDescription;

	/**
	 * Set Program's or Stage name in inputName textbox
	 * @param strName: Program's or Stage's Name
	 */
	public void setName(String strName) {
		inputName.clear();
		inputName.sendKeys(strName);
	}

	/**
	 * Set Program's or Stage's title in inputTitle textbox
	 * @param strTitle: Program's or Stage's Title
	 */
	public void setTitle(String strTitle) {
		inputTitle.clear();
		inputTitle.sendKeys(strTitle);
	}

	/**
	 * Set Program's or Stage's description in inputDescription textbox
	 * @param strDescription: Program's or Stage's Description
	 */
	public void setDescription(String strDescription) {
		inputDescription.clear();
		inputDescription.sendKeys(strDescription);
	}
}
