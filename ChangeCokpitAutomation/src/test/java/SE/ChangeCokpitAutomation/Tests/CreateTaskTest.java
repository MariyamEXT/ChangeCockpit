package SE.ChangeCokpitAutomation.Tests;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.CreateTaskPage;
import SE.ChangeCokpitAutomation.pageobjects.LoginPage;




public class CreateTaskTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void createTask (HashMap<String,String> input) throws IOException {
		
		LoginPage page=new LoginPage(driver);
		page.loginApplication(input.get("userName"), input.get("password"));
		CreateTaskPage task=new CreateTaskPage(driver);
		task.goToNewTaskPage();
		//task.submitNewTask(input.get("TaskName").concat(" ").concat(Long.toString(calendar.getTimeInMillis())), input.get("TaskDescription"));
        task.submitNewTask(input.get("TaskName").concat(" ").concat(Long.toString(System.currentTimeMillis())), input.get("TaskDescription"));
		String Confirmmsg=task.getConfirmationMsg();
		Assert.assertTrue(Confirmmsg.equalsIgnoreCase("Task details saved Successfully"));
	
		}
			
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\CreateTaskData.json");
		//return new Object[][]  {{data.get(0)}, {data.get(1) } };
        return new Object[][]  {{data.get(0)}};
        //return data;
		//C:\Users\z003zr4w\eclipse-workspace\ChangeCokpitAutomation\src\main\java\SE\ChangeCockpitAutomation\Data\CreateTaskData.json
		
	}
	
		
}

