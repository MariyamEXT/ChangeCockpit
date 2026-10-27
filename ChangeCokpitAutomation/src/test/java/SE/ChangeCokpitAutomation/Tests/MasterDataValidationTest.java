package SE.ChangeCokpitAutomation.Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.common.MasterDataValidationPage;
import SE.ChangeCokpitAutomation.pageobjects.process.CreateProcessPage;

public class MasterDataValidationTest extends BaseTest {

    private LoginPage loginPage;
    private CreateProcessPage processPage;
    private MasterDataValidationPage validationPage;

    @BeforeMethod
    public void setUpValidation() {

        loginPage = new LoginPage(driver);

        loginPage.loginApplication(
                "automationadmin",
                "AutomationAdmin@123");

        ((JavascriptExecutor) driver)
                .executeScript(
                        "document.body.style.zoom='80%'");

        processPage =
                new CreateProcessPage(driver);

        validationPage =
                new MasterDataValidationPage(driver);
    }

    @Test
    public void verifyProcessNameMandatoryValidation()
            throws InterruptedException {

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        processPage.clearProcessName();

        validationPage.clickSave();

        Assert.assertTrue(
                validationPage.isValidationDisplayed(
                        "Please Enter Name!"));
    }

    @Test
    public void verifyProcessDescriptionMandatoryValidation()
            throws InterruptedException {

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        processPage.clearProcessDescription();

        validationPage.clickSave();

        Assert.assertTrue(
                validationPage.waitForValidationMessage(
                        "Please Enter Description!"));
    }

    @Test
    public void verifyProcessAbbreviationMandatoryValidation()
            throws InterruptedException {

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        processPage.clearProcessAbbreviation();

        validationPage.clickSave();

        Assert.assertTrue(
                validationPage.isValidationDisplayed(
                        "Please Enter Abbreviation!"));
    }

    @Test
    public void verifySaveButtonDisplayed()
            throws InterruptedException {

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        Assert.assertTrue(
                validationPage.isSaveButtonDisplayed());
    }
}