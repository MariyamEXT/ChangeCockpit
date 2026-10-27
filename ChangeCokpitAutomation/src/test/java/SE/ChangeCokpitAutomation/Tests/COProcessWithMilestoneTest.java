package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.milestone.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.process.CreateProcessPage;

public class COProcessWithMilestoneTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void createCOProcessMilestoneFlow(
            HashMap<String, String> input)
            throws IOException, InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginApplication(
                input.get("userName"),
                input.get("password"));

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

        // Generic Task Creation
        milestonePage.createTaskPackage(input);

        milestonePage.saveTaskPackageAndMilestone();

        milestonePage.clickEditMilestone(
                milestoneName);

        milestonePage.publishMilestone();

//        processPage.makeProcessActive();
//
//        processPage.saveProcess();
//
//        processPage.clickProcessCancel();

//        String processName =
//                processPage.getCreatedProcessName();
//
//        processPage.searchProcess(processName);
//
//        Assert.assertTrue(
//                processPage.verifyProcessIsActive(
//                        processName));
    }

    @DataProvider
    public Object[][] getData()
            throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(
                        System.getProperty("user.dir")
                        + "\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateTaskData.json");

        return new Object[][] {
                { data.get(0) }  // Normal Task
        };
    }
}