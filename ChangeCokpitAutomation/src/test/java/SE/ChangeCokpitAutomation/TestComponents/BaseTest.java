package SE.ChangeCokpitAutomation.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SE.ChangeCokpitAutomation.pageobjects.LoginPage;



public class BaseTest {

	
	public WebDriver driver;
	public LoginPage login;
	
	public Properties getFileObj() throws IOException {
		
		Properties prop= new Properties();
		//FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\data.properties");
		FileInputStream fs=new FileInputStream("C:\\Users\\z003zr4w\\OneDrive - Siemens Energy\\Eclipse\\ChangeCokpitAutomation\\src\\main\\java\\SE\\ChangeCockpitAutomation\\Data\\data.properties");
		//C:\Users\z003zr4w\eclipse-workspace\ChangeCokpitAutomation\src\main\java\SE\ChangeCockpitAutomation\Data\data.properties
		prop.load(fs);
		return prop;
	}
	
	
	public WebDriver initializeDriver() throws IOException {

	Properties	prop=getFileObj();
	String browserName=prop.getProperty("browser");
	System.out.println(prop.getProperty("browser"));
	
	if(browserName.isEmpty()) {
		
		System.out.println("No browser details available");
	}
	
	 if (browserName.equalsIgnoreCase("edge")) {
		 
       driver= new EdgeDriver();
    }
	
	else if (browserName.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	   
		}
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));
    //driver.manage().window().maximize();
   
    
	return driver;

	}
	
	@BeforeMethod (alwaysRun=true)
	public LoginPage launchApplication() throws IOException {
		
		 driver= initializeDriver();
		 login =new LoginPage(driver);
		 Properties	prop=getFileObj();
		 String urlName=prop.getProperty("url");
		 login.goTo(urlName);
		return login;
	}
	


	
	//@AfterMethod (alwaysRun=true)
	
	public void tearDown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  
	  return data;
	//{map, map}

	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
}
