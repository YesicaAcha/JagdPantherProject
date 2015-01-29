package framework.pages.stages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.NavigationPage;

public class StagesPage extends NavigationPage{

	@FindBy(id="j_id_t:j_id_10")
	WebElement newStageButton;
	
	@FindBy(id="j_id_t:stages_data")
	WebElement stagesTable;

	//click Añadir button in StagesPage
	public NewStagePage clickNewStageButton(){
		newStageButton.click();   
		return new NewStagePage();
	}
	
	//get stage's name from Stages page
	public String getStageName(){
		return stagesTable.getText();
	}
}
