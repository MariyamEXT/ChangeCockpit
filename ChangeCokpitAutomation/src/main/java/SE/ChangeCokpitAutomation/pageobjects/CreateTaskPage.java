package SE.ChangeCokpitAutomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTaskPage {

WebDriver driver;
	
	public CreateTaskPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@title, 'Master Data')]")
	WebElement MasterData;
	
	@FindBy (xpath="//*[contains(@title, 'Tasks')] ")
	WebElement TaskMenu;
	
	@FindBy  (xpath="//button[contains(@class, 'actionButton4')] ")
	WebElement CreateTaskButton;
	
	@FindBy (xpath="//input[contains(@id, 'Task_NewEdit.Task_NE_Name')] ")
	WebElement TaskName;
	
	@FindBy (xpath="//textarea[contains(@id, 'Task_NewEdit.Task_NE_Desc')] ")
	WebElement TaskDescription;
	
	@FindBy (xpath="//select[contains(@id, 'Task_NewEdit.RS_TaskNE_UserGroup')]")
	WebElement UserGroupDropDown;
	
	@FindBy (xpath="//button[contains(@class, 'Task_NE_Save')]")
	WebElement TaskSaveButton;
	
	@FindBy (xpath="//button[contains(@class, 'actionButton1')]")
	WebElement TaskCloseButton;
	
	
	@FindBy (xpath="//div[contains(@class, 'mx-dialog-body')]")
	WebElement TaskConfirmationMsg;
	
	
	
	public void goToNewTaskPage() {
		
		MasterData.click();
		TaskMenu.click();
		CreateTaskButton.click();
	}
	
	public void selectUserGroup() {
		
		Select s=new Select(UserGroupDropDown);
		s.selectByIndex(1);
	}
	
	public void submitNewTask(String TaskN, String TaskD) {
		
		TaskName.sendKeys(TaskN);
		TaskDescription.sendKeys(TaskD);
		selectUserGroup();
		TaskSaveButton.click();
		}
	
	public String getConfirmationMsg() {
		
		String msg=TaskConfirmationMsg.getText();
		System.out.println(TaskConfirmationMsg.getText());
		return msg;
	}
	
	
	
	
}
