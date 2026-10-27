package SE.ChangeCokpitAutomation.pageobjects.task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DecisionTaskPage {

    WebDriver driver;
    WebDriverWait wait;

    public DecisionTaskPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[contains(.,'Task Type')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
    private WebElement taskTypeDropdown;

    @FindBy(xpath = "//label[contains(.,'Outcomes')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
    private WebElement outcomesDropdown;

    @FindBy(xpath = "//label[contains(.,'User Group')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]")
    private WebElement userGroupDropdown;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    public void selectTaskType(String taskType) {

        wait.until(
                ExpectedConditions.elementToBeClickable(taskTypeDropdown))
                .click();

        WebElement option =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//li[contains(.,'" + taskType + "')]")));

        option.click();
    }

    public void selectOutcome(String outcome) {

        WebElement option =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//li[contains(.,'" + outcome + "')]")));

        option.click();
    }

    public void selectDecisionOutcomes() {

        wait.until(
                ExpectedConditions.elementToBeClickable(outcomesDropdown))
                .click();

        selectOutcome("without rework");
        selectOutcome("rework");
        selectOutcome("scrapping");

        driver.findElement(By.tagName("body"))
                .sendKeys(Keys.ESCAPE);
    }

    public void selectUserGroup(String userGroup) {

        wait.until(
                ExpectedConditions.elementToBeClickable(userGroupDropdown))
                .click();

        WebElement option =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//li[contains(.,'" + userGroup + "')]")));

        option.click();
    }

    public void saveTask() {

        wait.until(
                ExpectedConditions.elementToBeClickable(saveButton))
                .click();
    }

    public void createDecisionTask(String userGroup) {

        selectTaskType("Decision");

        selectDecisionOutcomes();

        selectUserGroup(userGroup);

        saveTask();
    }
}