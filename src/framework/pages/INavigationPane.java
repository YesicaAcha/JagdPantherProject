package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pages.applicants.ApplicantsPage;
import framework.pages.login.LoginPage;
import framework.pages.periods.PeriodsPage;
import framework.pages.programs.ProgramsPage;
import framework.pages.registeredusers.RegisteredUsersPage;
import framework.pages.stages.StagesPage;
import framework.webdriver.SeleniumDriverManager;

public interface INavigationPane {
	WebDriver driver = SeleniumDriverManager.getManager().getDriver();
	WebDriverWait wait = SeleniumDriverManager.getManager().getWait();

	By programsLink = By.linkText("Programas");
	By periodsLink = By.linkText("Periodos");
	By applicantsLink = By.linkText("Postulantes");
	By stagesLink = By.linkText("Etapas");
	By registeredUsersLink = By.linkText("Usuarios de Sistema Registrados");
	By userNameLink = By.xpath("//form[@id='j_id_d']/ul/li[2]/table/tbody/tr/td/a");
	By logoutLink = By.xpath(".//*[@id='j_id_d']/ul/li[2]/table/tbody/tr[2]/td/a");

	/**
	 * Click Programs Link
	 * @return a new Programs Page
	 */
	default ProgramsPage clickProgramasLink() {
		driver.findElement(programsLink).click();   
		return new ProgramsPage();
	}

	/**
	 * Click Periods Link
	 * @return a new Periods Page
	 */
	default PeriodsPage clickPeriodsLink() {
		driver.findElement(periodsLink).click();   
		return new PeriodsPage();
	}

	/**
	 * Click Applicants Link
	 * @return a new Applicants Page
	 */
	default ApplicantsPage clickApplicantsLink() {
		driver.findElement(applicantsLink).click();   
		return new ApplicantsPage();
	}

	/**
	 * Click Stages Link
	 * @return a new Stages Page
	 */
	default StagesPage clickStagesLink() {
		driver.findElement(stagesLink).click();     
		return new StagesPage();
	}

	/**
	 * Click Registered users Link
	 * @return a new Registered Users Page
	 */
	default RegisteredUsersPage clickRegisteredUsersLink() {
		driver.findElement(registeredUsersLink).click();     
		return new RegisteredUsersPage();
	}

	/**
	 * Get the User name from RegisteredUsers page
	 * @return a String with the name of the user 
	 */
	default String getUserName() {
		return driver.findElement(userNameLink).getText();
	}

	/**
	 * Logout from application
	 * @return a new Login Page
	 */
	default LoginPage logout() {
		driver.findElement(logoutLink).click();   
		return new LoginPage();
	}
}
