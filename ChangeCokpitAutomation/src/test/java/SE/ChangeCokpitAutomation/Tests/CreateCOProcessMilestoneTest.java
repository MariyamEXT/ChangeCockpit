package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.CreateProcessPage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;

public class CreateCOProcessMilestoneTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void createCOProcessMilestoneFlow(
            HashMap<String, String> input)
            throws IOException, InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        Thread.sleep(1000);

        loginPage.loginApplication(
                input.get("userName"),
                input.get("password"));

        Thread.sleep(1000);

        CreateProcessPage processPage =
                new CreateProcessPage(driver);

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        processPage.createChangeOrderProcess();

        processPage.clickAddMilestone();

        CreateMilestonePage milestonePage =
                new CreateMilestonePage(driver);

        String milestoneName =
                milestonePage.createMilestoneInProcess();

        milestonePage.saveMilestone();

        milestonePage.clickEditMilestone(
                milestoneName);

        milestonePage.clickAddTaskPackage();

        milestonePage.createTaskPackage(
                input.get("TaskPackageName"),
                input.get("TaskPackageDec"),
                input.get("TaskName"),
                input.get("TaskDesc"));

        milestonePage.saveTaskPackageAndMilestone();
//        milestonePage.setTaskPackageAndMilestoneOrder();
        milestonePage.clickEditMilestone(milestoneName);

        milestonePage.publishMilestone();
        processPage.makeProcessActive();
        processPage.saveProcess();
        processPage.clickProcessCancel();
        
        String processName =
                processPage.getCreatedProcessName();

        processPage.searchProcess(processName);

        Assert.assertTrue(
                processPage.verifyProcessIsActive(processName));
        
        
    }

    @DataProvider
    public Object[][] getData()
            throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(
                        System.getProperty("user.dir")
                        + "\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateMilestoneData.json");

        return new Object[][] {
                { data.get(0) }
        };
    }
}