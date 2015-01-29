package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.registeredusers.RegisteredUsersPage;
import webdriver.SeleniumDriverManager;


public class LoginPage {

	WebDriver driver;

	@FindBy(id="j_id_i:userName")
	WebElement email;

	@FindBy(id="j_id_i:password")
	WebElement password;

	@FindBy(id="j_id_i:j_id_q")
	WebElement login;

	//By email = By.id("j_id_i:userName");
	//By password = By.id("j_id_i:password");
	//By login = By.id("j_id_i:j_id_q");

	public LoginPage(){

		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		driver.get("http://172.20.200.19:8080");
	}

	//Set email in email textbox
	public void setEmail(String strEmail){
		email.clear();
		email.sendKeys(strEmail);

	}

	//Set password in password textbox
	public void setPassword(String strPassword){
		password.clear();
		password.sendKeys(strPassword);
	}

	//Click on login button
	public void clickLogin(){
		login.click();
	}

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
