package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.NewCOPage;
import SE.ChangeCokpitAutomation.pageobjects.COOverviewPage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;

public class CreateNewCOTest extends BaseTest {
	
	@Test(dataProvider="getData")
	public void createNewCO (HashMap<String,String> inp) throws IOException, InterruptedException, StaleElementReferenceException {
		
		LocalDateTime myObj = LocalDateTime.now();
        LoginPage page=new LoginPage(driver);
		page.loginApplication(inp.get("userName"), inp.get("password"));
		/*NewCOPage newCOObj=new NewCOPage(driver);
		newCOObj.CreateNewCOPage(inp.get("Title").concat(" " + myObj),inp.get("Process Flow"), inp.get("Change Reason"), inp.get("Change Urgency"), inp.get("Business Impact"), inp.get("Description"), inp.get("Benefit"), inp.get("Plants"));
		String ConfirmCOMsg=newCOObj.getCOConfirmatiomMsg();
		Assert.assertTrue(ConfirmCOMsg.contains("created successfully"));
		String PO=ConfirmCOMsg.substring(13,26);
		System.out.println(PO);
		String CONo=newCOObj.getCOId();
		Assert.assertTrue(PO.contains(CONo));
		newCOObj.okConfirm();*/
		COOverviewPage overview= new COOverviewPage(driver);
		overview.getAllCOData();
		

	}
			
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateNewCOData.json");
		//return new Object[][]  {{data.get(0)}, {data.get(1) } };
         return new Object[][]  {{data.get(0)}};
        //return data;		
	}

}
