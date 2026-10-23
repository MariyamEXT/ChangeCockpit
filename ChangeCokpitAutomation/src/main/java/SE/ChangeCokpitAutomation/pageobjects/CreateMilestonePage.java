package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMilestonePage {

	String createdMilestoneName;

	WebDriver driver;
	WebDriverWait wait;

	public CreateMilestonePage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@id,'MilestoneNE_Name')]")
	WebElement MilestoneNameInProcess;

	@FindBy(xpath = "//textarea[contains(@id,'MilestoneNE_Des')]")
	WebElement MilestoneDescInProcess;

	@FindBy(xpath = "//button[contains(@class,'BTN_Milestone_NE_SaveAsDraft')]")
	WebElement saveMilestoneBtn;

	@FindBy(xpath = "//button[contains(@class,'GV_DraftEdit')]")
	WebElement editMilestoneButton;

	@FindBy(xpath = "//button[contains(@class,'mx-name-BTN_Milestone_NE_SelectTP')]")
	WebElement CreateTaskPackageBttn;

	@FindBy(css = "#mxui_widget_ControlBarButton_1")
	WebElement CreateNewTasPackageInTaskPackageBttn;

	@FindBy(xpath = "//input[contains(@id,'TaskPackage_NE_Name')]")
	WebElement CreateNewTasPackageName;

	@FindBy(xpath = "//textarea[contains(@id,'TP_NE_Des')]")
	WebElement CreateNewTasPackageDec;

	@FindBy(xpath = "//button[contains(@class,'BTN_TP_NE_Save')]")
	WebElement SaveNewTasPackageBtn;

	@FindBy(xpath = "//button[contains(@class,'taskPackageFormAddTaskButton')]")
	WebElement AddTaskInTaskPackageBttn;

	@FindBy(css = "#mxui_widget_ControlBarButton_5")
	WebElement NewTaskInTaskPackageBttn;

	@FindBy(xpath = "//input[contains(@id,'Task_NE_Name')]")
	WebElement NewTaskName;

	@FindBy(xpath = "//textarea[contains(@id,'Task_NE_Desc')]")
	WebElement NewTaskDescription;

	@FindBy(xpath = "//button[contains(@class,'referencesetselector')]")
	WebElement NewTaskUserGroup;

	@FindBy(css = "#mxui_widget_DataGrid_2 div.mx-grid-content table tbody")
	WebElement UserGroupResultstable;

	@FindBy(xpath = "//button[contains(@class,'Task_NE_Save')]")
	WebElement NewTaskSaveBtn;

	@FindBy(css = "#mxui_widget_ControlBarButton_7")
	WebElement SelectUserGroupBtn;

	@FindBy(xpath = "//button[contains(@title,'OK')]")
	WebElement CloseBtninTaskSuccess;

	@FindBy(css = "#mxui_widget_DataGrid_1 div.mx-grid-content table tbody")
	WebElement SelectNewTaskstable;

	@FindBy(xpath = "//button[contains(@class,'TP_Task_searchButton1')]")
	WebElement SearchtNewTaskBtn;

	@FindBy(xpath = "//input[contains(@id,'SearchInput_5')]")
	WebElement SearchNameInputinTask;

	@FindBy(css = "#mxui_widget_Button_6")
	WebElement SearchNameinTask;

	@FindBy(css = "#mxui_widget_ControlBarButton_4")
	WebElement SelectNewTaskBtn;

	@FindBy(css = "#mxui_widget_DataGrid_0 div.mx-grid-content table tbody")
	WebElement SelectNewTasksPackagetable;

	@FindBy(css = "#mxui_widget_ControlBarButton_0")
	WebElement SearchtNewTaskPackageBtn;

	@FindBy(css = "#mxui_widget_SearchInput_0_input")
	WebElement SearchNameInputinTaskPackage;

	@FindBy(css = "#mxui_widget_Button_0")
	WebElement SearchNameinTaskPackage;

	@FindBy(css = "#mxui_widget_ControlBarButton_2")
	WebElement SelectNewTaskPackageBtn;

	@FindBy(xpath = "//button[@title='Change Milestone']")
	WebElement changeMilestoneButton;

	@FindBy(xpath = "//input[contains(@id,'TaskPackage_NE_Name')]")
	WebElement taskPackageName;

	@FindBy(xpath = "//textarea[contains(@id,'TP_NE_Des')]")
	WebElement taskPackageDescription;

	@FindBy(xpath = "//button[@title='Add new task']")
	WebElement addTaskButton;

	// Task Name
	@FindBy(xpath = "//input[contains(@id,'Task_NE_Name')]")
	WebElement taskNameTxt;

	// Task Description Editor
	@FindBy(xpath = "//div[contains(@class,'ProseMirror')]")
	WebElement taskDescriptionTxt;

	// Task Type Dropdown
	@FindBy(xpath = "//label[contains(text(),'Task Type')]/following::div[contains(@class,'widget-combobox-input-container')][1]")
	WebElement taskTypeDropdown;

	// User Group Dropdown
	@FindBy(xpath = "//label[contains(text(),'User Group')]/following::div[contains(@class,'widget-combobox-input-container')][1]")
	WebElement userGroupDropdown;

	// Save Button
	@FindBy(xpath = "//button[@data-button-id='p.MasterData.Task_NewEdit_2.Btn_Task_NE_Save']")
	WebElement saveTaskButton;

	@FindBy(xpath = "//button[@title='Add New Task Package']")
	WebElement addTaskPackageButton;

	@FindBy(xpath = "//label[contains(text(),'User Group')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
	WebElement userGroupDropDownArrow;

	@FindBy(xpath = "//*[normalize-space()='Save As Draft']")
	WebElement saveAsDraftButton;

	@FindBy(xpath = "//button[@data-button-id='p.MasterData.TaskPackage_NewEdit_2.BTN_TP_NE_Save' and normalize-space()='Save']")
	WebElement saveTaskPackageBtn;

	@FindBy(xpath = "//input[contains(@id,'Milestone_NE_textBox3')]")
	WebElement taskPackageOrderTxt;

	@FindBy(xpath = "//input[contains(@id,'MilestoneNE_Order')]")
	WebElement milestoneOrderTxt;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement successPopupOkBtn;

	@FindBy(xpath = "//button[contains(@class,'BTN_Milestone_NE_Publish')]")
	WebElement publishMilestoneBtn;

	@FindBy(xpath="//button[normalize-space()='Proceed']")
	WebElement proceedBtn;

	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement informationOkBtn;

	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement processCancelBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Outcomes')]/following::div[contains(@class,'mx-name-dropDown1')][1]")
	WebElement outcomesDropdown;
	
	// Task Type Dropdown Arrow
	@FindBy(xpath =
	"//label[contains(text(),'Task Type')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
	WebElement taskTypeDropDownArrow;

	// Outcomes Dropdown Arrow
	@FindBy(xpath =
	"//label[contains(text(),'Outcomes')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
	WebElement outcomesDropDownArrow;
	
	@FindBy(xpath =
			"//label[contains(text(),'Notification Type')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
	WebElement notificationTypeDropDownArrow;

	@FindBy(xpath = "//textarea")
	WebElement milestoneDescription;

	@FindBy(xpath = "//button[contains(text(),'Save As Draft')]")
	WebElement saveAsDraftBtn;

	@FindBy(xpath = "//button[contains(text(),'Add Task Package')]")
	WebElement addTaskPackageBtn;
	
	public String createMilestoneInProcess() {

		createdMilestoneName =
		        "M@" + String.format("%03d",
		                System.currentTimeMillis() % 1000);
		// Wait for loading overlay to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mxui_widget_Progress_0")));

		wait.until(ExpectedConditions.elementToBeClickable(MilestoneNameInProcess));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", MilestoneNameInProcess);

		MilestoneNameInProcess.clear();

		MilestoneNameInProcess.sendKeys(createdMilestoneName);

		wait.until(ExpectedConditions.visibilityOf(MilestoneDescInProcess));

		MilestoneDescInProcess.sendKeys("Automation Milestone Description");

		return createdMilestoneName;
	}

	public void saveMilestone() {

		wait.until(ExpectedConditions.elementToBeClickable(saveMilestoneBtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveMilestoneBtn);

		wait.until(ExpectedConditions.elementToBeClickable(successPopupOkBtn));

		successPopupOkBtn.click();
	}

	public boolean verifyCreatedMilestone(String milestoneName) {

		try {

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mxui_widget_Progress_0")));

			List<WebElement> milestones = driver
					.findElements(By.xpath("//*[contains(text(),'" + milestoneName + "')]"));

			System.out.println("Matching Milestones Found : " + milestones.size());

			return milestones.size() > 0;

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}
	}

	public void clickEditMilestone(String milestoneName) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mxui_widget_Progress_0")));

		wait.until(ExpectedConditions.elementToBeClickable(changeMilestoneButton));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changeMilestoneButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", changeMilestoneButton);

		System.out.println("Clicked Change Milestone Button : " + milestoneName);
	}

	public void selectTaskType(String taskType)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    taskTypeDropDownArrow));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    taskTypeDropDownArrow);

	    Thread.sleep(1000);

	    WebElement option =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.xpath(
	                                    "//*[normalize-space()='"
	                                            + taskType
	                                            + "']")));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    option);

	    System.out.println(
	            "Task Type Selected : "
	                    + taskType);
	}
	
	public void selectUserGroup()
	        throws InterruptedException {

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    userGroupDropDownArrow);

	    WebElement changeManagerOption =
	            wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath(
	                                    "//*[normalize-space()='Change Manager']")));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    changeManagerOption);

	    System.out.println(
	            "User Group Selected : Change Manager");
	}

	public void clickAddTaskPackage() throws InterruptedException {

		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addTaskPackageButton));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

		System.out.println("Add Task Package button clicked");

        Thread.sleep(1000);
	}
	
	public void createTaskPackage(
	        String packageName,
	        String packageDesc)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskPackageName));

	    taskPackageName.clear();
	    taskPackageName.sendKeys(packageName);

	    taskPackageDescription.clear();
	    taskPackageDescription.sendKeys(packageDesc);

	    System.out.println(
	            "Task Package Created : "
	                    + packageName);
	}
	
	public void createTaskPackage(
	        HashMap<String, String> input)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskPackageName));

	    taskPackageName.clear();
	    taskPackageName.sendKeys(
	            input.get("TaskPackageName"));

	    taskPackageDescription.clear();
	    taskPackageDescription.sendKeys(
	            input.get("TaskPackageDec"));

	    System.out.println(
	            "Task Package Created : "
	                    + input.get("TaskPackageName"));

	    clickAddTask();

	    String taskType =
	            input.get("TaskType");

	    if ("Decision".equalsIgnoreCase(taskType)) {

	        createDecisionTask(
	                input.get("TaskName"),
	                input.get("TaskDesc"),
	                Arrays.asList(
	                        input.get("Outcomes")
	                                .split(",")));
	    }
	    else {

	        createTask(
	                input.get("TaskName"),
	                input.get("TaskDesc"));
	    }
	}
	
	public void clickAddTask() {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mxui_widget_Progress_0")));

		WebElement addTask = wait.until(ExpectedConditions.elementToBeClickable(addTaskButton));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addTask);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addTask);

		System.out.println("Add Task Clicked");

		// Wait for page refresh
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Wait for loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mxui_widget_Progress_0")));

		// Wait for Task page to load
		wait.until(ExpectedConditions.visibilityOf(taskNameTxt));

		System.out.println("Task Page Opened Successfully");
	}

	public void createTask(
	        String taskName,
	        String taskDesc)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskNameTxt));

	    taskNameTxt.clear();
	    taskNameTxt.sendKeys(taskName);

	    taskDescriptionTxt.click();
	    taskDescriptionTxt.sendKeys(taskDesc);

	    ((JavascriptExecutor) driver)
	            .executeScript("window.scrollBy(0,500)");

	    Thread.sleep(1000);

	    selectUserGroup();

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveTaskButton));

	    saveTaskButton.click();

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    successPopupOkBtn));

	    successPopupOkBtn.click();

	    System.out.println(
	            "Normal Task Created Successfully");
	}
	public void saveTaskPackageAndMilestone() throws InterruptedException {

        Thread.sleep(1000);

	    // Save Task Package
	    saveTaskPackageBtn.click();
	    System.out.println("Task Package Saved");

	    // Wait for Milestone Page
        Thread.sleep(1000);

	    // Task Package Order
	    wait.until(ExpectedConditions.visibilityOf(taskPackageOrderTxt));
	    taskPackageOrderTxt.clear();
	    taskPackageOrderTxt.sendKeys("1");

	    System.out.println("Task Package Order Set");

	    // Milestone Order
	    wait.until(ExpectedConditions.visibilityOf(milestoneOrderTxt));
	    milestoneOrderTxt.clear();
	    milestoneOrderTxt.sendKeys("1");

	    System.out.println("Milestone Order Set");

	    // Save Milestone
	    wait.until(ExpectedConditions.elementToBeClickable(saveAsDraftButton));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", saveAsDraftButton);

	    System.out.println("Milestone Saved");

	    // Draft Popup
	    wait.until(ExpectedConditions.elementToBeClickable(successPopupOkBtn));
	    successPopupOkBtn.click();

	    System.out.println("Draft Confirmation Closed");
	}
	
	
	public void setTaskPackageAndMilestoneOrder() throws InterruptedException {

	    wait.until(ExpectedConditions.visibilityOf(taskPackageOrderTxt));
	    taskPackageOrderTxt.clear();
	    taskPackageOrderTxt.sendKeys("1");

	    System.out.println("Task Package Order Set");

	    wait.until(ExpectedConditions.visibilityOf(milestoneOrderTxt));
	    milestoneOrderTxt.clear();
	    milestoneOrderTxt.sendKeys("1");

	    System.out.println("Milestone Order Set");

	    wait.until(ExpectedConditions.elementToBeClickable(saveAsDraftButton));
	    saveAsDraftButton.click();

	    System.out.println("Milestone Saved As Draft");

	    wait.until(ExpectedConditions.elementToBeClickable(successPopupOkBtn));
	    successPopupOkBtn.click();

	    System.out.println("Draft Popup Closed");
	    

	}
	
	public void publishMilestone() throws InterruptedException {

	    // Publish Milestone
	    wait.until(ExpectedConditions.elementToBeClickable(publishMilestoneBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", publishMilestoneBtn);

	    System.out.println("Publish Clicked");

	    // Proceed
	    wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", proceedBtn);

	    System.out.println("Proceed Clicked");

	    // Information Popup OK
	    wait.until(ExpectedConditions.elementToBeClickable(informationOkBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", informationOkBtn);

	    System.out.println("Information Popup Closed");

	    // Wait until Process page is visible
        Thread.sleep(1000);

	    // Process Cancel
//	    wait.until(ExpectedConditions.elementToBeClickable(processCancelBtn));
//
//	    ((JavascriptExecutor) driver)
//	            .executeScript("arguments[0].click();", processCancelBtn);
//
//	    System.out.println("Process Cancel Clicked");
	}
	public void createDecisionTask(
	        String taskName,
	        String taskDesc,
	        List<String> outcomes)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskNameTxt));

	    taskNameTxt.clear();
	    taskNameTxt.sendKeys(taskName);

	    taskDescriptionTxt.click();
	    taskDescriptionTxt.sendKeys(taskDesc);

	    // Select Task Type = Decision
	    selectTaskType("Decision");

	    // Select Outcomes
	    selectOutcomes(outcomes);

	    // User Group
	    selectUserGroup();

	    saveTaskButton.click();

	    Thread.sleep(1000);

	    successPopupOkBtn.click();

	    System.out.println(
	            "Decision Task Created");
	}
	
	public void selectOutcomes(
	        List<String> outcomes)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    outcomesDropDownArrow));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    outcomesDropDownArrow);

	    Thread.sleep(1000);

	    for (String outcome : outcomes) {

	        WebElement option =
	                wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(
	                                By.xpath(
	                                        "//*[normalize-space()='"
	                                                + outcome
	                                                + "']")));

	        ((JavascriptExecutor) driver)
	                .executeScript(
	                        "arguments[0].click();",
	                        option);

	        System.out.println(
	                "Selected Outcome : "
	                        + outcome);

	        Thread.sleep(500);
	    }

	    // Close dropdown
	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    outcomesDropDownArrow);

	    System.out.println(
	            "Outcome Selection Completed");
	}
	
	public void selectNotificationType(
	        String notificationType)
	        throws InterruptedException {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    notificationTypeDropDownArrow));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    notificationTypeDropDownArrow);

	    Thread.sleep(1000);

	    WebElement option =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.xpath(
	                                    "//*[normalize-space()='"
	                                            + notificationType
	                                            + "']")));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    option);

	    System.out.println(
	            "Notification Type Selected : "
	                    + notificationType);
	}
	
	public void clearMilestoneName() {

	    wait.until(ExpectedConditions.visibilityOf(
	            MilestoneNameInProcess));

	    MilestoneNameInProcess.clear();

	    System.out.println("Milestone Name Cleared");
	}

	public void clearDescription() {

	    wait.until(ExpectedConditions.visibilityOf(MilestoneDescInProcess));
	    MilestoneDescInProcess.clear();
	}

	public void clearOrder() {

	    wait.until(ExpectedConditions.visibilityOf(milestoneOrderTxt));
	    milestoneOrderTxt.clear();
	}
	
	public void enterMilestoneDescription(String description) {

	    wait.until(ExpectedConditions.visibilityOf(
	            milestoneDescription));

	    milestoneDescription.clear();
	    milestoneDescription.sendKeys(description);

	    System.out.println("Milestone Description : "
	            + description);
	}

	public void enterMilestoneOrder(String order) {

	    wait.until(ExpectedConditions.visibilityOf(
	            milestoneOrderTxt));

	    milestoneOrderTxt.clear();
	    milestoneOrderTxt.sendKeys(order);

	    System.out.println(
	            "Milestone Order : " + order);
	}


	public void saveAsDraft() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveAsDraftButton));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    saveAsDraftButton);

	    System.out.println(
	            "Save As Draft Clicked");
	}
	

	public void publish() {

	    wait.until(ExpectedConditions.elementToBeClickable(publishMilestoneBtn));
	    publishMilestoneBtn.click();
	}
	public void enterMilestoneName(String name) {

	    wait.until(ExpectedConditions.visibilityOf(
	            MilestoneNameInProcess));

	    MilestoneNameInProcess.clear();
	    MilestoneNameInProcess.sendKeys(name);

	    System.out.println("Milestone Name : " + name);
	}
	
	public void saveMilestone(String order) {

	    wait.until(ExpectedConditions.visibilityOf(
	    		milestoneOrderTxt));

	    milestoneOrderTxt.clear();
	    milestoneOrderTxt.sendKeys(order);

	    System.out.println("Milestone Order : "
	            + order);
	}
	
	public void clearMilestoneDescription() {

	    wait.until(ExpectedConditions.visibilityOf(
	            MilestoneDescInProcess));

	    MilestoneDescInProcess.clear();

	    System.out.println("Milestone Description Cleared");
	}
	public void clickSaveForValidation() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveMilestoneBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    saveMilestoneBtn);

	    System.out.println(
	            "Save Clicked For Validation");
	}
	
	public void clearTaskPackageName() {

	    wait.until(ExpectedConditions.visibilityOf(
	            taskPackageName));

	    taskPackageName.clear();

	    System.out.println(
	            "Task Package Name Cleared");
	}
	
	public void enterTaskPackageName(
	        String name) {

	    wait.until(ExpectedConditions.visibilityOf(
	            taskPackageName));

	    taskPackageName.clear();
	    taskPackageName.sendKeys(name);

	    System.out.println(
	            "Task Package Name : " + name);
	}
	
	public void clearTaskPackageDescription() {

	    wait.until(ExpectedConditions.visibilityOf(
	            taskPackageDescription));

	    taskPackageDescription.clear();

	    System.out.println(
	            "Task Package Description Cleared");
	}
	
	public void enterTaskPackageDescription(
	        String description) {

	    wait.until(ExpectedConditions.visibilityOf(
	            taskPackageDescription));

	    taskPackageDescription.clear();
	    taskPackageDescription.sendKeys(description);

	    System.out.println(
	            "Task Package Description : "
	                    + description);
	}
	
	public void clickSaveTaskPackageForValidation() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveTaskPackageBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    saveTaskPackageBtn);

	    System.out.println(
	            "Task Package Save Clicked");
	}
	
	public void clearTaskName() {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskNameTxt));

	    taskNameTxt.clear();

	    System.out.println("Task Name Cleared");
	}
	
	public void enterTaskName(String taskName) {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskNameTxt));

	    taskNameTxt.clear();

	    taskNameTxt.sendKeys(taskName);

	    System.out.println("Task Name : " + taskName);
	}public void clearTaskDescription() {

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].innerHTML='';",
	                    taskDescriptionTxt);

	    System.out.println(
	            "Task Description Cleared");
	}public void enterTaskDescription(
	        String description) {

	    wait.until(
	            ExpectedConditions.visibilityOf(
	                    taskDescriptionTxt));

	    taskDescriptionTxt.click();

	    taskDescriptionTxt.sendKeys(description);

	    System.out.println(
	            "Task Description : "
	                    + description);
	}public void clickSaveTaskForValidation() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    saveTaskButton));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    saveTaskButton);

	    System.out.println(
	            "Task Save Clicked");
	}
	
	public void clearTaskType() {

	    WebElement clearIcon =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.xpath(
	                                    "//label[contains(text(),'Task Type')]"
	                                    + "/following::*[contains(@class,'mx-icon-clear')][1]")));

	    clearIcon.click();

	    System.out.println(
	            "Task Type Cleared");
	}
	
	public void clickOkButton() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    successPopupOkBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    successPopupOkBtn);

	    System.out.println(
	            "OK Button Clicked");
	}

	
	

}