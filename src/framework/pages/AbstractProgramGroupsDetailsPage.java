package framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractProgramGroupsDetailsPage {

	@FindBy(id = "j_id_t:idInput")
	WebElement codeLabel;

	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement nameLabel;

	@FindBy(id = "j_id_t:inputTitle_display")
	WebElement titleLabel;

	@FindBy(id = "j_id_t:inputDescription_display")
	WebElement descriptionLabel;
	
	@FindBy (xpath = "//button[@type='button']")
	WebElement saveNameButton;
	
	@FindBy (xpath = "(//button[@type='button'])[3]")
	WebElement saveTitleButton;
	
	@FindBy (xpath = "(//button[@type='button'])[5]")
	WebElement saveDescriptionButton;
	
	@FindBy (xpath = "(//button[@type='button'])[2]")
	WebElement cancelNameButton;
	
	@FindBy (xpath = "(//button[@type='button'])[4]")
	WebElement cancelTitleButton;
	
	@FindBy (xpath = "(//button[@type='button'])[6]")
	WebElement cancelDescriptionButton;
	
	/**
	 * Get program's  or group's code
	 * @return The code from Program 
	 */
	public String getCode() {
		return codeLabel.getText();
	}

	/**
	 * Get program's or group's name
	 * @return The Program Name
	 */
	public String getName() {
		return nameLabel.getText();
	}

	/**
	 * Get program's or group's title
	 * @return The Program Title
	 */
	public String getTitle() {
		return titleLabel.getText();
	}

	/**
	 * Get program's or group's description
	 * @return The Program's Description
	 */
	public String getDescription() {
		return descriptionLabel.getText();
	}
	
	/**
	 * Click program's or group's name label 
	 */
	public void clickNameLabel() {
		nameLabel.click();
	}
	
	/**
	 * Click program's or group's title label 
	 */
	public void clickTitleLabel() {
		titleLabel.click();
	}
	
	/**
	 * Click program's or group's description label 
	 */
	public void clickDescriptionLabel() {
		descriptionLabel.click();
	}
	
	/**
	 * Click save name button
	 */
	public void clickSaveNameButton() {
		saveNameButton.click();
	}
	
	/**
	 * Click save title button
	 */
	public void clickSaveTitleButton() {
		saveTitleButton.click();
	}
	
	/**
	 * Click save description button
	 */
	public void clickSaveDescriptionButton() {
		saveDescriptionButton.click();
	}
}
