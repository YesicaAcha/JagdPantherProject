package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.applicants.ApplicantsPage;
import pages.login.LoginPage;
import pages.periods.PeriodsPage;
import pages.programs.ProgramsPage;
import pages.registeredusers.RegisteredUsersPage;
import pages.stages.StagesPage;
import webdriver.SeleniumDriverManager;

public class NavigationPage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@FindBy(linkText="Programas")
	WebElement programsLink;

	@FindBy(linkText="Periodos")
	WebElement periodsLink;

	@FindBy(linkText="Postulantes")
	WebElement applicantsLink;

	@FindBy(linkText="Etapas")
	WebElement stagesLink;

	@FindBy(linkText="Usuarios de Sistema Registrados")
	WebElement registeredUsersLink;

	@FindBy(xpath="//form[@id='j_id_d']/ul/li[2]/table/tbody/tr/td/a")
	WebElement userNameLink;
	
	@FindBy(xpath=".//*[@id='j_id_d']/ul/li[2]/table/tbody/tr[2]/td/a")
	WebElement logoutLink;

	public NavigationPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		this.wait = SeleniumDriverManager.getManager().getWait();
		
	}

	//Click Programs Link
	public ProgramsPage clickProgramasLink(){
		programsLink.click();   
		return new ProgramsPage();
	}

	//Click Periods Link
	public PeriodsPage clickPeriodsLink(){
		periodsLink.click();   
		return new PeriodsPage();
	}

	//Click Applicants Link
	public ApplicantsPage clickApplicantsLink(){
		applicantsLink.click();   
		return new ApplicantsPage();
	}

	//Click Stages Link
	public StagesPage clickStagesLink(){
		stagesLink.click();   
		return new StagesPage();
	}

	//Click Registered users Link
	public RegisteredUsersPage clickRegisteredUsersLink(){
		registeredUsersLink.click();   
		return new RegisteredUsersPage();
	}

	//Get the User name from RegisteredUsers page
	public String getUserName(){
		return userNameLink.getText();
	}
	
	//Logout from application
	public LoginPage logout(){
		logoutLink.click();
		return new LoginPage();
	}
	
	
}
