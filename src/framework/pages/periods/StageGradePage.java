package framework.pages.periods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class StageGradePage implements INavigationPane{

	@FindBy (id = "j_id_t:applicants:0:j_id_16")
	WebElement inputGrade;
	
	@FindBy (id = "j_id_t:j_id_1d")
	WebElement saveButton;
	
	public StageGradePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to go to stages in Period details page
	 * @return NewGroupPage
	 */
	public StageGradePage setGrade(String grade){
		inputGrade.clear();
		inputGrade.sendKeys(grade);
		return this;
	}
	
	public PeriodDetailsPage clickSaveButton(){
		saveButton.click();
		return new PeriodDetailsPage();
	}
}
