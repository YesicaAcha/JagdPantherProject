package framework.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.registeredusers.RegisteredUsersPage;
import framework.webdriver.SeleniumDriverManager;

/**
 * This class represents the login page
 * @author Yesica Acha
 *
 */
public class LoginPage {

	WebDriver driver;

	@FindBy(id="j_id_i:userName")
	WebElement inputEmail;

	@FindBy(id="j_id_i:password")
	WebElement inputPassword;

	@FindBy(id="j_id_i:j_id_q")
	WebElement loginButton;

	public LoginPage(){

		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);

		// launch browser and direct it to the Base URL
		driver.get("http://172.20.200.19:8080");
	}

	/*Set email in email textbox*/
	public void setEmail(String strEmail){
		inputEmail.clear();
		inputEmail.sendKeys(strEmail);
	}

	/*Set password in password textbox*/
	public void setPassword(String strPassword){
		inputPassword.clear();
		inputPassword.sendKeys(strPassword);
	}

	/*Click on login button*/
	public void clickLogin(){
		loginButton.click();
	}

	/**
	 * This method is used to login to JagdPanther
	 * @param strEmail 		User's email
	 * @param strPasword	User's password
	 * @return
	 */
	public RegisteredUsersPage loginToJagdPanther(String strEmail,String strPasword){

		//Fill user's email
		this.setEmail(strEmail);

		//Fill password
		this.setPassword(strPasword);

		//Click Login button
		this.clickLogin();  

		return new RegisteredUsersPage();

	}

	//Close browser windows
	public void terminateBrowser(){
		SeleniumDriverManager.getManager().quitDriver();
	}
}
