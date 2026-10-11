package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProcessPage {

	WebDriver driver;
	WebDriverWait wait;

	public CreateProcessPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Master Data']")
	WebElement MasterData;

	@FindBy(xpath = "//a[@title='Processes']")
	WebElement ProcessesMenu;

	@FindBy(xpath = "//button[@title='Add new process']")
	WebElement AddProcessButton;

	@FindBy(xpath = "//input[contains(@id,'textBox3')]")
	WebElement processName;

	@FindBy(xpath = "//input[contains(@id,'textBox4')]")
	WebElement abbreviation;

	@FindBy(xpath = "(//div[contains(@class,'widget-combobox-down-arrow')])[1]")
	WebElement changeObjectTypeDropdown;

	@FindBy(xpath = "//li[contains(.,'Change Request')]")
	WebElement changeRequestOption;

	@FindBy(xpath = "(//div[contains(@class,'widget-combobox-input-container')])[2]")
	WebElement assignUserGroupsContainer;

	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//button[@title='Create a new Milestone']")
	WebElement addMilestoneButton;

	@FindBy(xpath = "//button[@title='Create a new Milestone']")
	WebElement createNewMilestoneBtn;

	public void goToProcessesPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(MasterData));
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", MasterData);

		wait.until(ExpectedConditions.visibilityOf(ProcessesMenu));
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ProcessesMenu);
	}

	public void clickAddProcess() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(AddProcessButton));

		AddProcessButton.click();
	}

	public void createProcess(
	        String processType,
	        String processPrefix,
	        String userGroup)
	        throws InterruptedException {

	    wait.until(ExpectedConditions.visibilityOf(processName));

	    String processNameValue =
	            processPrefix + System.currentTimeMillis();

	    processName.sendKeys(processNameValue);

	    abbreviation.sendKeys(processNameValue);

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    changeObjectTypeDropdown));

	    changeObjectTypeDropdown.click();

	    WebElement processOption =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.xpath("//li[contains(.,'"
	                                    + processType
	                                    + "')]")));

	    processOption.click();

	    selectUserGroup(userGroup);

	    saveButton.click();

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    addMilestoneButton));
	}
	public void selectUserGroup(String userGroup) {

		wait.until(ExpectedConditions.elementToBeClickable(assignUserGroupsContainer));

		assignUserGroupsContainer.click();

		WebElement option = driver.findElement(org.openqa.selenium.By.xpath("//li[contains(.,'" + userGroup + "')]"));

		wait.until(ExpectedConditions.elementToBeClickable(option));

		option.click();
	}

	public void clickAddMilestone() {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'mx-underlay')]")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mxui_widget_Progress_0")));

		wait.until(ExpectedConditions.elementToBeClickable(createNewMilestoneBtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createNewMilestoneBtn);

		System.out.println("Clicked Add Milestone");
	}
	public void createChangeOrderProcess()
	        throws InterruptedException {

	    wait.until(ExpectedConditions.visibilityOf(processName));

	    String processNameValue =
	            "AutomationCO" + System.currentTimeMillis();

	    Thread.sleep(1000);

	    processName.sendKeys(processNameValue);

	    abbreviation.sendKeys(processNameValue);

	    Thread.sleep(1000);

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    changeObjectTypeDropdown));

	    changeObjectTypeDropdown.click();

	    Thread.sleep(1000);

	    WebElement changeOrderOption =
	            driver.findElement(
	                    By.xpath("//li[contains(.,'Change Order')]"));

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    changeOrderOption));

	    changeOrderOption.click();

	    selectUserGroup("Change Manager");

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveButton));

	    saveButton.click();

	    Thread.sleep(1000);

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    addMilestoneButton));
	}
}