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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SE.ChangeCokpitAutomation.pageobjects.common.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage login;

	public Properties getFileObj() throws IOException {

		Properties prop = new Properties();

		String filePath = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\SE\\ChangeCokpitAutomation\\Data\\data.properties";

		System.out.println("File Path = " + filePath);

		File file = new File(filePath);

		System.out.println("File Exists = " + file.exists());

		FileInputStream fs = new FileInputStream(file);

		prop.load(fs);

		System.out.println("Browser Property = " + prop.getProperty("browser"));
		System.out.println("URL Property = " + prop.getProperty("url"));

		return prop;
	}

	public WebDriver initializeDriver() throws IOException {

		System.out.println("Inside initializeDriver()");

		Properties prop = getFileObj();

		System.out.println("Properties Loaded Successfully");

		String browserName = prop.getProperty("browser");

		System.out.println("Browser Name = " + browserName);

		if (browserName == null || browserName.trim().isEmpty()) {
			throw new RuntimeException("Browser value not found in data.properties");
		}

		System.out.println("Launching Browser : " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--start-maximized");

			System.out.println("Creating Chrome Driver");

			try {
				driver = new ChromeDriver(chromeOptions);
				System.out.println("Chrome Driver Created");
			} catch (Throwable e) {
				System.out.println("ERROR OCCURRED");
				e.printStackTrace();
				throw e;
			}

			System.out.println("Chrome Driver Created");

		}

		else if (browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");

			EdgeOptions edgeOptions = new EdgeOptions();

			edgeOptions.addArguments("--remote-allow-origins=*");
			edgeOptions.addArguments("--disable-dev-shm-usage");
			edgeOptions.addArguments("--no-sandbox");
			edgeOptions.addArguments("--start-maximized");

			driver = new EdgeDriver(edgeOptions);
		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			File firefoxFile = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			System.out.println("Firefox Exists = " + firefoxFile.exists());

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions firefoxOptions = new FirefoxOptions();

			System.out.println("Creating Firefox Driver");

			try {
				driver = new FirefoxDriver(firefoxOptions);

				driver.manage().window().maximize();

				((JavascriptExecutor) driver)
				        .executeScript(
				                "document.body.style.zoom='80%'");

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				System.out.println("Firefox Driver Created");
			} catch (Throwable e) {
				System.out.println("ERROR OCCURRED");
				e.printStackTrace();
				throw e;
			}
		}

		else {

			throw new RuntimeException("Unsupported Browser : " + browserName);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {

		System.out.println("Step 1 : Initializing Driver");

		driver = initializeDriver();

		System.out.println("Step 2 : Driver Initialized");

		login = new LoginPage(driver);

		System.out.println("Step 3 : Login Page Object Created");

		Properties prop = getFileObj();

		String urlName = prop.getProperty("url");

		System.out.println("Step 4 : URL Value = [" + urlName + "]");

		driver.get(urlName);
		System.out.println("URL from properties = " + urlName);
		driver.get(urlName);
		System.out.println("Current URL = " + driver.getCurrentUrl());
		System.out.println("Step 5 : Navigation completed");

		System.out.println("Current URL = " + driver.getCurrentUrl());

		return login;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		if (driver == null) {

			System.out.println("Driver is null. Screenshot cannot be captured.");

			return "";
		}

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;
	}

	public void validatePageTitleContains(String expectedTitle) {

		String actualTitle = driver.getTitle();

		System.out.println("Actual Page Title = " + actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title does not contain : " + expectedTitle);
	}
	public String captureScreenshot(
	        String testCaseName)
	        throws IOException {

	    TakesScreenshot ts =
	            (TakesScreenshot) driver;

	    File source =
	            ts.getScreenshotAs(
	                    OutputType.FILE);

	    String filePath =
	            System.getProperty(
	                    "user.dir")
	            + "/reports/screenshots/"
	            + testCaseName
	            + ".png";

	    FileUtils.copyFile(
	            source,
	            new File(filePath));

	    return filePath;
	}
}