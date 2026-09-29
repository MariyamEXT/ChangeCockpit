package SE.ChangeCokpitAutomation.pageobjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCOPage {
	
WebDriver driver;
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(70L));
			
			public NewCOPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			
			@FindBy(xpath="//*[contains(@title, 'New CO')]")
			WebElement NewCOTab;
			
			@FindBy(xpath="//input[contains(@id, 'Lbl_NewEditCO_Title')]")
			WebElement NewCOTitle;
			
			@FindBy(xpath="//select[contains(@id, 'ChangeOrder_NewEdit.DDL_NewCO_ChangeType')]")
			WebElement NewCOProcessFlow;
			
			@FindBy(xpath="//select[contains(@id, 'ChangeOrder_NewEdit.DDL_NewCO_ChangeReason')]")
			WebElement NewCOChangeReason;
			
			@FindBy(xpath="//select[contains(@id, 'ChangeOrder_NewEdit.DDL_NewCO_ChangeUrgency')]")
			WebElement NewCOChangeUrgency;
			
			@FindBy(xpath="//select[contains(@id, 'ChangeOrder_NewEdit.DDL_NewCO_BusinessImpact')]")
			WebElement NewCOBusninessImpact;
			
			@FindBy(xpath="//textarea[contains(@id, 'ChangeOrder_NewEdit.NewCO_Description')]")
			WebElement NewCODescription;
			
			@FindBy(xpath="//input[contains(@id, 'ChangeOrder_NewEdit.NewCO_Benefit')]")
			WebElement NewCOBenefit;
			
			@FindBy(xpath="//span[contains(@class, 'CO_NE_Plant_Abbreviation')]")
			List <WebElement> NewSelectPlantsLabels;
			
			@FindBy(xpath="//input[contains(@id, 'ChangeOrder_NewEdit.CKB_CO_NE_SelectPlant')]")
			List <WebElement> NewSelectPlantsCheckboxes;
			
			@FindBy(xpath="//button[contains(@class, 'BTN_CreateCO')]")
			WebElement CreateCOButton;
			
			
			@FindBy(css="#mxui_widget_DialogMessage_0_content > p")
			WebElement CreateCOConfirmMsg;
			
			@FindBy(css="#mxui_widget_DialogMessage_0 > div.modal-content.mx-dialog-content > div.modal-footer.mx-dialog-footer > button")
			WebElement CreateCOConfirmMsgOkButton;
			
			
			
			
			
	public void CreateNewCOPage(String Tit, String PF, String CR, String CU, String BI, String Desc, String Bf, String APlant) {
				
		NewCOTab.click();
		NewCOTitle.sendKeys(Tit);
		Select s1=new Select(NewCOProcessFlow);
		s1.selectByVisibleText(PF);
		Select s2=new Select(NewCOChangeReason);
		s2.selectByVisibleText(CR);
		Select s3=new Select(NewCOChangeUrgency);
		s3.selectByVisibleText(CU);
		Select s4=new Select(NewCOBusninessImpact);
		s4.selectByVisibleText(BI);
		NewCODescription.sendKeys(Desc);
		NewCOBenefit.sendKeys(Bf);
		System.out.println(NewSelectPlantsLabels.size());
		System.out.println(NewSelectPlantsCheckboxes.size());
		for (int i=0; i<NewSelectPlantsLabels.size(); i++) {
			
			System.out.println(NewSelectPlantsLabels.get(i).getText());
			String plant=NewSelectPlantsLabels.get(i).getText();
			if (plant.equalsIgnoreCase(APlant)) {
				
				NewSelectPlantsCheckboxes.get(i).click();
			}
			
			break;
		}
		
		
		
		CreateCOButton.click();
		
		
						
	}
	

	public String getCOConfirmatiomMsg() {
		
		String cnfrmMsg=CreateCOConfirmMsg.getText();
		System.out.println(cnfrmMsg);
		//String PO=cnfrmMsg.substring(13,26);
		//System.out.println(PO);
		return cnfrmMsg;
	}
	
	public void okConfirm() {
		
		CreateCOConfirmMsgOkButton.click();
	}
	
	public String getCOId() {
		
		
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyyMMdd").format(date);
		System.out.println(modifiedDate);
		String ID="PCO" + modifiedDate;
		return ID;
	}
}
