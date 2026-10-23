package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.CreateProcessPage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;
import SE.ChangeCokpitAutomation.utils.ProcessTypes;
import SE.ChangeCokpitAutomation.utils.TestDataStore;
import SE.ChangeCokpitAutomation.utils.UserGroups;

public class CreateCRProcessMilestoneTaskTest extends BaseTest {

    @Test(dataProvider = "getTaskData")
    public void createCRProcessMilestoneTaskFlow(
            HashMap<String, String> input)
            throws IOException, InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        Properties prop =
                getFileObj();

        loginPage.loginApplication(
                prop.getProperty("username"),
                prop.getProperty("password"));

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

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

        TestDataStore.createdCRProcessName =
                processPage.getCreatedProcessName();

        processPage.clickAddMilestone();

        CreateMilestonePage milestonePage =
                new CreateMilestonePage(driver);

        String milestoneName =
                milestonePage.createMilestoneInProcess();

        milestonePage.saveMilestone();

        AssertJUnit.assertTrue(
                milestonePage.verifyCreatedMilestone(
                        milestoneName));

        milestonePage.clickEditMilestone(
                milestoneName);

        milestonePage.clickAddTaskPackage();

        milestonePage.createTaskPackage(input);

        milestonePage.saveTaskPackageAndMilestone();

        milestonePage.clickEditMilestone(
                milestoneName);

        milestonePage.publishMilestone();

        processPage.makeProcessActive();

        processPage.saveProcess();

        processPage.clickProcessCancel();

        String processName =
                processPage.getCreatedProcessName();

        processPage.searchProcess(processName);

        AssertJUnit.assertTrue(
                processPage.verifyProcessIsActive(
                        processName));
    }

    @DataProvider
    public Object[][] getTaskData()
            throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(
                        System.getProperty("user.dir")
                                + "\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateTaskData.json");

        return new Object[][] {
                { data.get(0) }, // Normal
                { data.get(1) }, // Decision
                { data.get(2) }  // Notification
        };
    }
}
