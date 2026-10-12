package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.CreateProcessPage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;

public class CreateCOProcessTest extends BaseTest {

    @Test
    public void createCOProcess()
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

        processPage.clickAddProcess();

        processPage.createProcess(
                "Change Order",
                "AutomationCO",
                "Change Manager");

        processPage.clickAddMilestone();

        CreateMilestonePage milestonePage =
                new CreateMilestonePage(driver);

        String milestoneName =
                milestonePage.createMilestoneInProcess();

        milestonePage.saveMilestone();

        Assert.assertTrue(
                milestonePage.verifyCreatedMilestone(
                        milestoneName));
    }
}