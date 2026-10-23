package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCRPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewCRPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='New CR']")
    WebElement newCRMenu;

    @FindBy(xpath = "//input[contains(@id,'NewEditCO_Title')]")
    WebElement crTitle;

    @FindBy(xpath = "//input[contains(@id,'comboBox1')]")
    WebElement processFlow;

    @FindBy(xpath = "//input[contains(@id,'comboBox2')]")
    WebElement changeReason;

    @FindBy(xpath = "//input[contains(@id,'comboBox3')]")
    WebElement changeUrgency;

    @FindBy(xpath = "//textarea[contains(@id,'NewCR_Description')]")
    WebElement descriptionTxt;

    public void clickNewCR() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        newCRMenu));

        newCRMenu.click();

        System.out.println("Clicked New CR");
    }

    public String enterCRTitle() {

        String crName =
                "AutomationCR_"
                        + System.currentTimeMillis();

        wait.until(
                ExpectedConditions.visibilityOf(
                        crTitle));

        crTitle.sendKeys(crName);

        System.out.println(
                "CR Name Created : "
                        + crName);

        return crName;
    }

    public void selectProcessFlow(
            String processName) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        processFlow));

        processFlow.click();

        processFlow.sendKeys(processName);

        WebElement option =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//*[contains(text(),'"
                                                + processName
                                                + "')]")));

        option.click();

        System.out.println(
                "Process Selected : "
                        + processName);
    }

    public void selectChangeReason(String reason) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        changeReason));

        changeReason.click();

        WebElement option =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//*[contains(text(),'"
                                                + reason
                                                + "')]")));

        option.click();

        System.out.println(
                "Change Reason Selected : "
                        + reason);
    }

    public void selectChangeUrgency(String urgency) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        changeUrgency));

        changeUrgency.click();

        WebElement option =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//*[contains(text(),'"
                                                + urgency
                                                + "')]")));

        option.click();

        System.out.println(
                "Change Urgency Selected : "
                        + urgency);
    }

    public void enterDescription(String description) {

        wait.until(
                ExpectedConditions.visibilityOf(
                        descriptionTxt));

        descriptionTxt.clear();

        descriptionTxt.sendKeys(description);

        System.out.println(
                "Description Entered : "
                        + description);
    }
    
}
