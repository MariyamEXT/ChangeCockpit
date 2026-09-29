package SE.ChangeCokpitAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTaskPackagePage {

WebDriver driver;
	
	public CreateTaskPackagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@title, 'Master Data')]")
	WebElement MasterData;
	
	@FindBy (xpath="//*[contains(@title, 'Task Package')] ")
	WebElement TasPackagekMenu;
	
	@FindBy (xpath="//*[contains(@title, 'create a new task package')] ")
	WebElement CreateTasPackageButton;
	
	@FindBy (xpath="//input[contains(@id, 'TaskPackage_NewEdit')] ")
	WebElement TaskPackageName;
	
	@FindBy (xpath="//textarea[contains(@id, 'TaskPackage_NewEdit')] ")
	WebElement TaskPackageDescription;
	
	@FindBy (xpath="//button[contains(@class, 'taskPackageFormAddTaskButton')] ")
	WebElement AddTask;
	
public void goToNewTaskPackagePage() {
		
		MasterData.click();
		TasPackagekMenu.click();
		CreateTasPackageButton.click();
	}
	
}
