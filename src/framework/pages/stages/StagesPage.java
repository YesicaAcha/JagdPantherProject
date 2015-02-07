package framework.pages.stages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.INavigationPane;

public class StagesPage implements INavigationPane {
	@FindBy(id = "j_id_t:j_id_10")
	WebElement newStageButton;
	
	@FindBy(id = "j_id_t:stages_data")
	WebElement stagesTable;
	
	public StagesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * click Añadir button in StagesPage
	 * @return New Stage Page
	 */
	public NewStagePage clickNewStageButton(){
		newStageButton.click();   
		return new NewStagePage();
	}
	
	/**
	 * get stage's name from Stages page
	 * @return String with all information of Stages
	 */
	public String getStageName(){
		return stagesTable.getText();
	}
}
