package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.NewCRPage;

public class CreateNewCRTest extends BaseTest {

    @Test
    public void createNewCR()
            throws IOException, InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        Properties prop =
                getFileObj();

        loginPage.loginApplication(
                prop.getProperty("username"),
                prop.getProperty("password"));

        NewCRPage newCRPage =
                new NewCRPage(driver);

        newCRPage.clickNewCR();

        String crName =
                newCRPage.enterCRTitle();

        String processName =
                "AutomationCRXXXX"; // replace with active process

        newCRPage.selectProcessFlow(
                processName);

        newCRPage.selectChangeReason();

        newCRPage.selectChangeUrgency();

        newCRPage.enterDescription();

        System.out.println(
                "CR Created : "
                        + crName);
    }
}