package SE.ChangeCokpitAutomation.Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.common.MasterDataValidationPage;
import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.milestone.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.process.CreateProcessPage;

public class TaskPackageFieldValidationTest extends BaseTest {

    private CreateProcessPage processPage;
    private CreateMilestonePage milestonePage;
    private MasterDataValidationPage validationPage;

    @BeforeMethod
    public void setup() throws Exception {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginApplication(
                "automationadmin",
                "AutomationAdmin@123");

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
    }

    @Test
    public void validateTaskPackageMandatoryFields() {

        milestonePage.clearTaskPackageName();

        milestonePage.enterTaskPackageDescription(
                "TP Description");

        milestonePage.clickSaveTaskPackageForValidation();

        Assert.assertTrue(
                validationPage.isValidationDisplayed(
                        "Please Enter Name!"));

        milestonePage.enterTaskPackageName(
                "AutoTP");

        milestonePage.clearTaskPackageDescription();

        milestonePage.clickSaveTaskPackageForValidation();

        Assert.assertTrue(
                validationPage.isValidationDisplayed(
                        "Please Enter Description!"));

        System.out.println(
                "Task Package Validation Completed");
    }
}