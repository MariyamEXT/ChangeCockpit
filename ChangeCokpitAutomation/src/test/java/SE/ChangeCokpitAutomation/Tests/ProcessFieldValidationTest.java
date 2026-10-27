package SE.ChangeCokpitAutomation.Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.common.MasterDataValidationPage;
import SE.ChangeCokpitAutomation.pageobjects.process.CreateProcessPage;

public class ProcessFieldValidationTest extends BaseTest {

    private CreateProcessPage processPage;
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

        validationPage =
                new MasterDataValidationPage(driver);

        processPage.goToProcessesPage();
        processPage.clickAddProcess();
    }

    @Test
    public void validateProcessMandatoryFields() {

        processPage.clearProcessName();

        processPage.clickSaveForValidation();

        Assert.assertTrue(
                validationPage.isValidationDisplayed(
                        "Please Enter Name!"));

        System.out.println(
                "Process Name Validation Verified");
    }
}