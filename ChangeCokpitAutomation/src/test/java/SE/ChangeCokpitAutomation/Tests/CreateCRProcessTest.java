package SE.ChangeCokpitAutomation.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SE.ChangeCokpitAutomation.pageobjects.CreateProcessPage;
import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateMilestonePage;

import SE.ChangeCokpitAutomation.pageobjects.LoginPage;
import SE.ChangeCokpitAutomation.utils.ProcessTypes;
import SE.ChangeCokpitAutomation.utils.UserGroups;

public class CreateCRProcessTest extends BaseTest {

	@Test
	public void createCrProcess() throws IOException, InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		Properties prop = getFileObj();

		loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Master Data']")));

		CreateProcessPage processPage = new CreateProcessPage(driver);

		processPage.goToProcessesPage();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add new process']")));
		processPage.clickAddProcess();

		processPage.createProcess(
		        ProcessTypes.CHANGE_REQUEST,
		        "AutomationCR",
		        UserGroups.CHANGE_MANAGER);

		processPage.clickAddMilestone();

		CreateMilestonePage milestonePage = new CreateMilestonePage(driver);

		String milestoneName =
		        milestonePage.createMilestoneInProcess();

		milestonePage.saveMilestone();

		AssertJUnit.assertTrue(
		        milestonePage.verifyCreatedMilestone(
		                milestoneName));
		

	}
}
