package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateMilestonePage;

import SE.ChangeCokpitAutomation.pageobjects.LoginPage;

public class CreateMilestoneTest extends BaseTest {
	
	@Test(dataProvider="getData")
	public void createMilestone (HashMap<String,String> input) throws IOException, InterruptedException {
		
		LoginPage page=new LoginPage(driver);
		page.loginApplication(input.get("userName"), input.get("password"));
		CreateMilestonePage mile=new CreateMilestonePage(driver);
		mile.goToNewMilestonePage();
		mile.createMilestone(input.get("MilestoneName").concat(" " +Long.toString(System.currentTimeMillis())), input.get("MilestoneDescription"), input.get("Order"), input.get("ChangeObject"), input.get("ProcessFlow"));
		mile.createTaskPackageinMilestone(input.get("TaskPackageName"), input.get("TaskPackageDec"), input.get("TaskName"), input.get("TaskDesc"));
	    mile.saveMilestoneasDraft();
	    String msgConfirm=mile.milestoneConfirmMsg();
		Assert.assertTrue(msgConfirm.equalsIgnoreCase("Milestone data saved successfully."));

	}
			
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateMilestone.json");
		//return new Object[][]  {{data.get(0)}, {data.get(1) } };
         return new Object[][]  {{data.get(0)}};
        //return data;		
	}

}
