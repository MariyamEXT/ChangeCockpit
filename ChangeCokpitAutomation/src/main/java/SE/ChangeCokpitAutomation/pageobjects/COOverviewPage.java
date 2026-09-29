package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;
import java.util.List;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class COOverviewPage {

	
WebDriver driver;
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(70L));
			
			public COOverviewPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			
			@FindBy(xpath="//*[contains(@title, 'CO Overview')]")
			WebElement COOverviewTab;
			
			@FindBy(xpath="//div[contains(@class, 'table-content')]")   
			WebElement COOverviewData;
			
			@FindBy(xpath="//span[contains(@class, 'td-text')]")   
			List <WebElement> COOverviewCOIDData;
			
			@FindBy(xpath="//span[contains(@class, 'td-text')]/following-sibling::div[contains(@class, 'td')]")   
			WebElement COOverviewCOStatus;
			
			@FindBy(xpath="//div[contains(@class, 'textFilter2')]/input")   
			WebElement COIDFilter;
			
			
			public void getAllCOData() throws StaleElementReferenceException {
				
				COOverviewTab.click();
				//COIDFilter.sendKeys("PCO20240724");
				 /*for (int i=0; i<COOverviewCOIDData.size(); i++) {
					 
					 String CONO = COOverviewCOIDData.get(i).getText();
					 System.out.println(i);
					 if (CONO.equalsIgnoreCase("PCO20240724296")) {
						 
							System.out.println("Reached");
							
							WebElement parentCO=COOverviewCOIDData.get(i).findElement(By.xpath("//span[contains(@class, 'td-text')]/parent::div"));
							WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(70L));
							wait.until(ExpectedConditions.elementToBeClickable(parentCO));
							parentCO.click();
							System.out.println(COOverviewCOIDData.get(i).findElement(By.xpath("//span[contains(@class, 'td-text')]/parent::div/div")).getCssValue("class"));
							break;
							
                          }
				 }
			*/
				driver.findElement(By.xpath("//*[@id='2']/div[2]/div/input")).click();
	
				driver.findElement(By.xpath("//*[@id='2']/div[2]/div/input")).sendKeys("PCO20240724296");
				

			
	

						

					}
					
				}
				
				


                	
                
                
                
				         
				     
						

				
			
			

	
	
	

