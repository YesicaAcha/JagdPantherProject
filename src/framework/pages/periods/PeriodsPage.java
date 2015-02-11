package framework.pages.periods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class PeriodsPage implements INavigationPane {

	@FindBy(id = "j_id_t:programs:0:j_id_17")
	WebElement editPeriodButton;
	
	public PeriodsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * click Añadir button in StagesPage
	 * @return New Stage Page
	 */
	public PeriodDetailsPage clickEditPeriodButton(){
		editPeriodButton.click();   
		return new PeriodDetailsPage();
	}
}
