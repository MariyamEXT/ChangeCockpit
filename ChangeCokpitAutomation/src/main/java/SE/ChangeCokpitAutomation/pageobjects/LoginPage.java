package SE.ChangeCokpitAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="usernameInput")
	WebElement userName;
	
	@FindBy(id="passwordInput")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	public void loginApplication (String User, String Pwd) {
		userName.sendKeys(User);
		password.sendKeys(Pwd);
		loginButton.click();		
		
	}
	
	public void goTo(String URL) {
		  
		  {
				driver.get(URL);
	}
	
	
	}
}
