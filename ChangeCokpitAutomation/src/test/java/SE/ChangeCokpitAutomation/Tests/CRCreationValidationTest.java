package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import SE.ChangeCokpitAutomation.pageobjects.cr.NewCRPage;
import SE.ChangeCokpitAutomation.utils.TestDataStore;

public class CRCreationValidationTest extends BaseTest {

    
    @Test(dataProvider = "getCRData")
    public void createNewCR(
            HashMap<String, String> data)
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
                TestDataStore.createdCRProcessName;

        newCRPage.selectProcessFlow(
                processName);

        newCRPage.selectProcessFlow(processName);

        newCRPage.selectChangeReason(
                data.get("reas"));

        newCRPage.selectChangeUrgency(
                data.get("urg"));

        newCRPage.enterDescription(
                data.get("desc"));
    }
    
    @DataProvider
    public Object[][] getCRData() throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(
                        System.getProperty("user.dir")
                                + "/src/main/java/SE/ChangeCokpitAutomation/Data/CreateCRData.json");

        return new Object[][] {
                { data.get(0) }
        };
    }
    
    
}