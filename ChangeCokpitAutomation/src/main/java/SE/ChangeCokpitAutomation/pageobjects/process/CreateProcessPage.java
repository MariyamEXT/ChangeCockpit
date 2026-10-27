package SE.ChangeCokpitAutomation.pageobjects.process;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProcessPage {

	WebDriver driver;
	WebDriverWait wait;
	private String createdProcessName;

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
	
	@FindBy(xpath = "//div[contains(@id,'switch1_hdi') and @role='switch']")
	WebElement activeToggle;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement processCancelBtn;
	
	@FindBy(xpath = "(//input[contains(@class,'filter-input')])[1]")
	WebElement processNameFilter;
	
	@FindBy(xpath = "//textarea[contains(@id,'textArea')]")
	WebElement processDescription;
		
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

	    createdProcessName =
	            processPrefix + System.currentTimeMillis() % 100000;

	    processName.sendKeys(createdProcessName);

	    abbreviation.sendKeys(createdProcessName);

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

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveButton));
	    
	    saveButton.click();
	    
	}
	
	public void selectUserGroup(String userGroup) {

	    wait.until(ExpectedConditions.elementToBeClickable(assignUserGroupsContainer));

	    assignUserGroupsContainer.click();

	    WebElement option = driver.findElement(
	            By.xpath("//li[contains(.,'" + userGroup + "')]"));

	    wait.until(ExpectedConditions.elementToBeClickable(option));

	    option.click();

	    // Close dropdown
	    assignUserGroupsContainer.sendKeys(Keys.ESCAPE);
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

	    createdProcessName =
	            "AutomationCO" + System.currentTimeMillis();

	    processName.sendKeys(createdProcessName);

	    abbreviation.sendKeys(createdProcessName);

	    Thread.sleep(1000);

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
	
	public void makeProcessActive() throws InterruptedException {

	    Thread.sleep(3000);

	    By toggleLocator =
	            By.xpath("//div[@role='switch']");

	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    toggleLocator));

	    WebElement toggle =
	            driver.findElement(toggleLocator);

	    String status =
	            toggle.getAttribute("aria-checked");

	    System.out.println("Current Toggle Status = " + status);

	    if ("false".equals(status)) {

	        ((JavascriptExecutor) driver)
	                .executeScript(
	                        "arguments[0].click();",
	                        toggle);

	        System.out.println("Process Activated");
	    }
	    else {

	        System.out.println("Process Already Active");
	    }
	}
	
	
	public void saveProcess() {

	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));

	    saveButton.click();
	}
	
	public void clickProcessCancel() {

	    wait.until(ExpectedConditions.elementToBeClickable(processCancelBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", processCancelBtn);

	    System.out.println("Process Cancel Clicked");
	}
	
	public void searchProcess(String processName)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    processNameFilter));


	    System.out.println(
	            "Rows Found : "
	                    + driver.findElements(
	                            By.xpath(
	                                    "//*[contains(text(),'"
	                                            + processName
	                                            + "')]"))
	                            .size());
	}
	
	public boolean verifyProcessIsActive(
	        String processName) {

	    System.out.println(
	            "Verifying Process : "
	                    + processName);

	    List<WebElement> processRows =
	            driver.findElements(
	                    By.xpath(
	                            "//*[contains(text(),'"
	                                    + processName
	                                    + "')]"));

	    System.out.println(
	            "Matching Process Rows = "
	                    + processRows.size());

	    List<WebElement> activeRows =
	            driver.findElements(
	                    By.xpath(
	                            "//*[contains(text(),'"
	                                    + processName
	                                    + "')]"
	                                    + "/ancestor::*[contains(@class,'tr')]"
	                                    + "//*[text()='Yes']"));

	    System.out.println(
	            "Active Rows Found = "
	                    + activeRows.size());

	    return activeRows.size() > 0;
	}
	
	public boolean isProcessActive() {

	    WebElement toggle =
	            driver.findElement(
	                    By.xpath("//div[@role='switch']"));

	    return "true".equals(
	            toggle.getAttribute("aria-checked"));
	}

	public String getCreatedProcessName() {
	    return createdProcessName;
	}
	
	public void clearProcessName() {

	    wait.until(ExpectedConditions.visibilityOf(processName));

	    processName.clear();
	}
	public void clearProcessAbbreviation() {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    abbreviation));

	    abbreviation.clear();
	}
	public void clickSaveForValidation() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveButton));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    saveButton);
	}
	public void clearProcessDescription() {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    processDescription));

	    processDescription.clear();
	}
	
	
	
	
}