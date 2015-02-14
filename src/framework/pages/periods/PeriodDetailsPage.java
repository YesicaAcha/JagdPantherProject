package framework.pages.periods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class PeriodDetailsPage implements INavigationPane {
	@FindBy (xpath = "//div[@id='j_id_t:applcantStageTabs']/ul/li[2]/a")
	WebElement stagesButton;
	
	@FindBy (id = "j_id_t:applcantStageTabs:j_id_25:0:j_id_2d")
	WebElement gradeButton;
	
	public PeriodDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to go to stages in Period details page
	 * @return NewGroupPage
	 */
	public PeriodDetailsPage clickStagesButton(){
		stagesButton.click();
		return this;
	}
	
	public StageGradePage clickGradeButton(){
		gradeButton.click();
		return new StageGradePage();
	}
	
	
}
