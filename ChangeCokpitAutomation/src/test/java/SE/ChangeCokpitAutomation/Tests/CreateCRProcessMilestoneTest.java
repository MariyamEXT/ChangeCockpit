package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.CreateProcessPage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;
import SE.ChangeCokpitAutomation.utils.ProcessTypes;
import SE.ChangeCokpitAutomation.utils.UserGroups;

public class CreateCRProcessMilestoneTest extends BaseTest {

    @Test
    public void createCRProcessMilestoneFlow()
            throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        Properties prop = getFileObj();

        loginPage.loginApplication(
                prop.getProperty("username"),
                prop.getProperty("password"));

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@title='Master Data']")));

        CreateProcessPage processPage =
                new CreateProcessPage(driver);

        processPage.goToProcessesPage();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@title='Add new process']")));

        processPage.clickAddProcess();

        processPage.createProcess(
                ProcessTypes.CHANGE_REQUEST,
                "AutomationCR",
                UserGroups.CHANGE_MANAGER);

        // Add Milestone
        processPage.clickAddMilestone();

        CreateMilestonePage milestonePage =
                new CreateMilestonePage(driver);

        String milestoneName =
                milestonePage.createMilestoneInProcess();

        // Save Milestone
        milestonePage.saveMilestone();

        AssertJUnit.assertTrue(
                milestonePage.verifyCreatedMilestone(
                        milestoneName));

        // Re-open Milestone
        milestonePage.clickEditMilestone(
                milestoneName);

        // Add Task Package
        milestonePage.clickAddTaskPackage();

        milestonePage.createTaskPackage(
                "AutomationTaskPackage",
                "Automation Task Package Description",
                "AutomationTask",
                "Automation Task Description");

        milestonePage.saveTaskPackageAndMilestone();

        milestonePage.clickEditMilestone(milestoneName);

        milestonePage.publishMilestone();
        processPage.clickProcessCancel();
        processPage.searchProcess(milestoneName);
        processPage.makeProcessActive();
        processPage.saveProcess();
    }
}