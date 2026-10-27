package SE.ChangeCokpitAutomation.Tests;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.common.MasterDataValidationPage;
import SE.ChangeCokpitAutomation.pageobjects.milestone.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.process.CreateProcessPage;

public class TaskFieldValidationTest extends BaseTest {

    private CreateProcessPage processPage;
    private CreateMilestonePage milestonePage;
    private MasterDataValidationPage validationPage;
    private Properties prop;

    @BeforeMethod
    public void setup() throws Exception {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginApplication(
                prop.getProperty("username"),
                prop.getProperty("password"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "document.body.style.zoom='80%'");

        processPage =
                new CreateProcessPage(driver);

        milestonePage =
                new CreateMilestonePage(driver);

        validationPage =
                new MasterDataValidationPage(driver);

        processPage.goToProcessesPage();
        processPage.clickAddProcess();
        processPage.createChangeOrderProcess();

        processPage.clickAddMilestone();

        milestonePage.enterMilestoneName(
                "AutoMilestone");

        milestonePage.enterMilestoneDescription(
                "Description");

        milestonePage.saveMilestone();

        milestonePage.clickEditMilestone(
                "AutoMilestone");

        milestonePage.clickAddTaskPackage();

        milestonePage.enterTaskPackageName(
                "AutoTP");

        milestonePage.enterTaskPackageDescription(
                "TP Description");

        milestonePage.clickAddTask();
    }

    @Test
    public void validateTaskMandatoryFields() {

        milestonePage.clearTaskName();

        milestonePage.enterTaskDescription(
                "Task Description");

        milestonePage.clickSaveTaskForValidation();

        Assert.assertTrue(
                validationPage.isValidationMessageDisplayed(
                        "Please Enter Name!"));

        milestonePage.enterTaskName(
                "AutoTask");

        milestonePage.clearTaskDescription();

        milestonePage.clickSaveTaskForValidation();

        Assert.assertTrue(
                validationPage.isValidationMessageDisplayed(
                        "Please Enter Description!"));

        System.out.println(
                "Task Validation Completed");
    }
}