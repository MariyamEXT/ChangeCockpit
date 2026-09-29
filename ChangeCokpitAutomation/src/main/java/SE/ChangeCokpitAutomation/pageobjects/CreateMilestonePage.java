package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMilestonePage {
	
	WebDriver driver;
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(70L));
			
			public CreateMilestonePage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="//*[contains(@title, 'Master Data')]")
			WebElement MasterData;
			
			@FindBy (xpath="//*[contains(@title, 'Milestone')] ")
			WebElement MilestoneMenu;

			@FindBy (xpath="//button[contains(@class, 'CreateNewMileStoneBtn')] ")
			WebElement CreateMilestoneBttn;
			
			@FindBy (xpath="//input[contains(@id, 'Milestone_NewEdit.MilestoneNE_Name')] ")
			WebElement MilestoneName;
			
			@FindBy (xpath="//textarea[contains(@id, 'MasterData.Milestone_NewEdit.MilestoneNE_Des')] ")
			WebElement MilestoneDesc;
			
			@FindBy (xpath="//select[contains(@id, 'MilestoneNE_CO_Type')] ")
			WebElement MilestoneChangeObjectTypeDropDown;
			
			@FindBy (xpath="//input[contains(@id, 'MilestoneNE_Order')] ")
			WebElement MilestoneOrder;
			
			@FindBy (xpath="//input[contains(@id, 'MilestoneNE_ChangeType')] ")
			WebElement MilestoneProcessFlowField;
			
			@FindBy (css="#downshift-0-menu")
			WebElement MilestoneProcessFlowFieldOptions;
			
			@FindBy (xpath="//button[contains(@class, 'BTN_Milestone_NE_SaveAsDraft')] ")
			WebElement SaveAsDraftMilestoneBtn;
			
			@FindBy (xpath="//button[contains(@class, 'BTN_Milestone_NE_Publish')] ")
			WebElement PublishMilestoneBtn;
			
			@FindBy (xpath="//button[contains(@class, 'BTN_Milestone_NE_Cancel')] ")
			WebElement CancelMilestoneBtn;
			
			
			@FindBy (css="#mxui_widget_DialogMessage_1_content > p")
			WebElement MilestoneCreatedConfirmMsg;
			
			
			@FindBy (xpath="//button[contains(@class, 'mx-name-BTN_Milestone_NE_SelectTP')] ")
			WebElement CreateTaskPackageBttn;
			
			@FindBy (xpath="//button[contains(@class, 'mx-name-newButton1')] ")
			WebElement CreateNewTaskPackageBttn;
			
			@FindBy (xpath="//input[contains(@id, 'TaskPackage_NewEdit')] ")
			WebElement CreateNewTaskPackageName;
						
			//New Task Package button
			@FindBy (css="#mxui_widget_ControlBarButton_1")
			WebElement CreateNewTasPackageInTaskPackageBttn;
			
			//Task Package Name
			@FindBy (xpath="//input[contains(@id, 'TaskPackage_NE_Name')] ")
			WebElement CreateNewTasPackageName;
			
			//Task Package Description
			@FindBy (xpath="//textarea[contains(@id, 'TP_NE_Des')] ")
			WebElement CreateNewTasPackageDec;
			
			//Save Button for New Task Package
			@FindBy (xpath="//button[contains(@class, 'BTN_TP_NE_Save')] ")
			WebElement SaveNewTasPackageBtn;
			
			
			
			// Add Task button in New Task Package pop up
			@FindBy (xpath="//button[contains(@class, 'taskPackageFormAddTaskButton')] ")
			WebElement AddTaskInTaskPackageBttn;
			
			//New Task button in Select Task pop up
			@FindBy(css="#mxui_widget_ControlBarButton_5")
			WebElement NewTaskInTaskPackageBttn;
			
			//Name field in New Task pop up
			@FindBy (xpath="//input[contains(@id, 'Task_NE_Name')] ")
			WebElement NewTaskName;
			
			
			//Description field in New Task pop up
			@FindBy (xpath="//textarea[contains(@id, 'Task_NE_Desc')] ")
			WebElement NewTaskDescription;
			
			//User Group reference selector
			@FindBy (xpath="//button[contains(@class, 'referencesetselector')] ")
			WebElement NewTaskUserGroup;
			
			//table of User groups inside User Group reference selector
			@FindBy(css="#mxui_widget_DataGrid_2 > div.mx-grid-content > table > tbody")
			WebElement UserGroupResultstable;
			
			
			//Save button in New Task pop up
			@FindBy (xpath="//button[contains(@class, 'Task_NE_Save')] ")
			WebElement NewTaskSaveBtn;
			
			@FindBy (tagName="tr")
			List <WebElement> UserGroupResults;
			
			//Select User Group inside Task pop up
			@FindBy (css="#mxui_widget_ControlBarButton_7")
			WebElement SelectUserGroupBtn;
			
			//Close button in Task created success pop up
			@FindBy (xpath="//button[contains(@title, 'OK')] ")
			WebElement CloseBtninTaskSuccess;
			
			//table of tasks in select task pop up
			@FindBy(css="#mxui_widget_DataGrid_1 > div.mx-grid-content > table > tbody")
			WebElement SelectNewTaskstable;
		
			
			//Search button in select task pop up to toggle search
			@FindBy (xpath="//button[contains(@class, 'TP_Task_searchButton1')] ")
			WebElement SearchtNewTaskBtn;
			
			//Search input field in select task pop up
			//@FindBy (css="#mxui_widget_SearchInput_8_input")
			@FindBy (xpath="//input[contains(@id, 'SearchInput_5')] ")
			WebElement SearchNameInputinTask;
			
			//Search button in select task pop up
			@FindBy (css="#mxui_widget_Button_6")
			WebElement SearchNameinTask;
			
			//Select button in select task pop up
			@FindBy (css="#mxui_widget_ControlBarButton_4")
			WebElement SelectNewTaskBtn;
			
			//table of task packages in select task package pop up
			@FindBy(css="#mxui_widget_DataGrid_0 > div.mx-grid-content > table > tbody")
			WebElement SelectNewTasksPackagetable;
			
			//Search button in task package pop up to toggle search
			@FindBy (css="#mxui_widget_ControlBarButton_0")
			WebElement SearchtNewTaskPackageBtn;
			
			//Search input field in task package pop up
			@FindBy (css="#mxui_widget_SearchInput_0_input")
			WebElement SearchNameInputinTaskPackage;
			
			//Search button in task package in pop up
			@FindBy (css="#mxui_widget_Button_0")
			WebElement SearchNameinTaskPackage;
			
			//pagination in select task package task pop up
			@FindBy (css="#mxui_widget_Button_5")
			WebElement NextPageInTaskPackage;
			
			//Select button in created task package in select task pop up
			@FindBy (css="#mxui_widget_ControlBarButton_2")
			WebElement SelectNewTaskPackageBtn;
			
			
			
			
			
	
			
	public void goToNewMilestonePage() throws InterruptedException {
				
				MasterData.click();
				MilestoneMenu.click();
				
	}
	
	public void createMilestone(String mName, String mDesc, String Order, String ChangeObj, String ProcessFlow) throws InterruptedException {
		
		CreateMilestoneBttn.click();
		MilestoneName.sendKeys(mName);
		MilestoneDesc.sendKeys(mDesc);
		Select s1= new Select (MilestoneChangeObjectTypeDropDown);
		s1.selectByValue(ChangeObj);
		MilestoneOrder.sendKeys(Order);
		MilestoneProcessFlowField.click();
		System.out.println(MilestoneProcessFlowFieldOptions);
		MilestoneProcessFlowField.sendKeys(ProcessFlow);
		MilestoneProcessFlowFieldOptions.click();
		
	}	
	
		public void createTaskPackageinMilestone(String tpackageName, String tpDesc, String tName, String tDesc) throws InterruptedException {
			
			//Add new task package details
			CreateTaskPackageBttn.click();
		    wait.until(ExpectedConditions.elementToBeClickable(CreateNewTasPackageInTaskPackageBttn));
			CreateNewTasPackageInTaskPackageBttn.click();
			wait.until(ExpectedConditions.elementToBeClickable(CreateNewTasPackageName));
            CreateNewTasPackageName.sendKeys(tpackageName);
			wait.until(ExpectedConditions.elementToBeClickable(CreateNewTasPackageDec));
            CreateNewTasPackageDec.sendKeys(tpDesc);
            createTaskinMilestone(tName, tDesc);
			
            
          //Save Task package
            wait.until(ExpectedConditions.elementToBeClickable(SaveNewTasPackageBtn));
            Thread.sleep(50L);
			SaveNewTasPackageBtn.click();
			 				
            //searching task package in milestone
			wait.until(ExpectedConditions.elementToBeClickable(SearchtNewTaskPackageBtn));
            SearchtNewTaskPackageBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(SearchNameInputinTaskPackage));
			SearchNameInputinTaskPackage.sendKeys(tpackageName);
			wait.until(ExpectedConditions.elementToBeClickable(SearchNameinTaskPackage));
			SearchNameinTaskPackage.click();
			
			//Looping through search result
			List <WebElement> taskPRows=SelectNewTasksPackagetable.findElements(By.tagName("tr"));
			System.out.println(taskPRows.size());
			for (int i=0; i<taskPRows.size(); i++) {
				
			    Thread.sleep(100L);
				String style=taskPRows.get(i).getAttribute("style");
				if (!style.contains("display: none;")) {
					
					WebElement tPName=taskPRows.get(i).findElement(By.tagName("td"));
					System.out.println(tPName.getAttribute("title"));
					String TaskPackageName=tPName.getAttribute("title");
					
                    if (TaskPackageName.equalsIgnoreCase(tpackageName)) {
                    	
					wait.until(ExpectedConditions.elementToBeClickable(tPName));
					Thread.sleep(50L);
				    tPName.click();
				    
                    }
					
             }
			
				break;
			}
			
			 //Save Task Package
		      wait.until(ExpectedConditions.elementToBeClickable(SelectNewTaskPackageBtn));
		      Thread.sleep(100L);
			  SelectNewTaskPackageBtn.click(); 
            

}
		public void createTaskinMilestone(String TaskName, String TaskDesc) throws InterruptedException {
			
			wait.until(ExpectedConditions.elementToBeClickable(AddTaskInTaskPackageBttn));
			AddTaskInTaskPackageBttn.click();
			wait.until(ExpectedConditions.elementToBeClickable(NewTaskInTaskPackageBttn));
            Actions a = new Actions(driver);
			a.moveToElement(NewTaskInTaskPackageBttn).click().build().perform();
			
			//Adding task details
			wait.until(ExpectedConditions.elementToBeClickable(NewTaskName));
			NewTaskName.sendKeys(TaskName);
			NewTaskDescription.sendKeys(TaskDesc);
			wait.until(ExpectedConditions.elementToBeClickable(NewTaskUserGroup));
            NewTaskUserGroup.click();
			System.out.println(UserGroupResults.size());
			List <WebElement> rows=UserGroupResultstable.findElements(By.tagName("tr"));
			System.out.println(rows.size());
			WebElement row=rows.get(0);
			wait.until(ExpectedConditions.elementToBeClickable(row));
			row.click();
			wait.until(ExpectedConditions.elementToBeClickable(SelectUserGroupBtn));
			SelectUserGroupBtn.click();
			NewTaskSaveBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(CloseBtninTaskSuccess));
			CloseBtninTaskSuccess.click();
			
			//searching task in select task pop up
			wait.until(ExpectedConditions.elementToBeClickable(SearchtNewTaskBtn));
			SearchtNewTaskBtn.click();
			//wait.until(ExpectedConditions.elementToBeClickable(SearchNameInputinTask));
			SearchNameInputinTask.sendKeys(TaskName);
			wait.until(ExpectedConditions.elementToBeClickable(SearchNameinTask));
			SearchNameinTask.click();
			
			//Looping through task search results
			
			List <WebElement> taskRows=SelectNewTaskstable.findElements(By.tagName("tr"));
			System.out.println(taskRows.size());
			for (int j=0; j<taskRows.size(); j++) {
				
			    Thread.sleep(100L);
				String styleT=taskRows.get(j).getAttribute("style");
				System.out.println(styleT);
				if (!styleT.contains("display: none;")) {
				
					WebElement taskRow=taskRows.get(j).findElement(By.tagName("td"));
					System.out.println(taskRow.getAttribute("title"));
					String taskNameTitle=taskRow.getAttribute("title");
                    if (taskNameTitle.equalsIgnoreCase(TaskName)) {
                    
					wait.until(ExpectedConditions.elementToBeClickable(taskRow));

					Thread.sleep(100L);
					taskRow.click();

                    }
                    
					
				}
				
				break;
			}
				
           
			//Selecting task
			wait.until(ExpectedConditions.elementToBeClickable(SelectNewTaskBtn));
			Thread.sleep(100L);
			SelectNewTaskBtn.click();
			
			}
		
		public void saveMilestoneasDraft() {
			
			  wait.until(ExpectedConditions.elementToBeClickable(SaveAsDraftMilestoneBtn));
              SaveAsDraftMilestoneBtn.click();
		}
		
		public String milestoneConfirmMsg() {
			
			String confirmMsg=MilestoneCreatedConfirmMsg.getText();
			return confirmMsg;
			
		}
				
	
}
