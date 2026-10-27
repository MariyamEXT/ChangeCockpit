package SE.ChangeCokpitAutomation.pageobjects.milestone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    private By addDocTypeButton =
            By.cssSelector("button[data-button-id='p.MasterData.Assessment_NewEdit_2.actionButton8']");

    private By docTypeNameTextBox =
            By.xpath("//input[contains(@id,'DocumentTypeEdit.textBox1')]");

    private By saveDocTypeButton =
            By.cssSelector("button[data-button-id='p.MasterData.DocumentType_NewEdit.actionButton1']");
    
    private By saveAssessmentButton =
            By.xpath("(//button[normalize-space()='Save'])[last()]");
    
    public AssessmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enableAssessmentRequired() {
        System.out.println("Assessment Required Enabled");
    }

    public void clickAddAssessment() {
        System.out.println("Add Assessment Clicked");
    }

    public void enterAssessmentName(String assessmentName) {
        System.out.println("Assessment Name : " + assessmentName);
    }

    public void clickAddDocType() {
        wait.until(ExpectedConditions.elementToBeClickable(addDocTypeButton))
                .click();
    }
    public void enterDocTypeName(String documentTypeName) {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(docTypeNameTextBox));

        element.clear();
        element.sendKeys(documentTypeName);
    }
    public void clickSaveDocType() {

        wait.until(ExpectedConditions.elementToBeClickable(saveDocTypeButton))
                .click();
    }
    public void createDocumentType(String documentTypeName) {

        clickAddDocType();

        enterDocTypeName(documentTypeName);

        clickSaveDocType();
    }
    public void saveAssessment() {
        wait.until(
                ExpectedConditions.elementToBeClickable(saveAssessmentButton))
                .click();
    }
    
}