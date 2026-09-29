package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateTaskPackagePage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;


public class CreateTaskPackageTest extends BaseTest {

	
	@Test(dataProvider="getData")
	public void createTaskPackage (HashMap<String,String> input) throws IOException {
		
		LoginPage page=new LoginPage(driver);
		page.loginApplication(input.get("userName"), input.get("password"));
		CreateTaskPackagePage taskP=new CreateTaskPackagePage(driver);
		taskP.goToNewTaskPackagePage();
		
	
	}
			
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateTaskData.json");
		//return new Object[][]  {{data.get(0)}, {data.get(1) } };
        return new Object[][]  {{data.get(0)}};
		//C:\Users\z003zr4w\eclipse-workspace\ChangeCokpitAutomation\src\main\java\SE\ChangeCockpitAutomation\Data\CreateTaskData.json
		
	}
	
	
	
}
