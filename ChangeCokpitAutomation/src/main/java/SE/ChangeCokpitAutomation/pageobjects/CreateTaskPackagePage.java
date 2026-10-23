package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTaskPackagePage {

    WebDriver driver;
    WebDriverWait wait;

    public CreateTaskPackagePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@title,'Master Data')]")
    WebElement masterData;

    @FindBy(xpath = "//*[contains(@title,'Task Package')]")
    WebElement taskPackageMenu;

    @FindBy(xpath = "//*[contains(@title,'create a new task package')]")
    WebElement createTaskPackageButton;

    @FindBy(xpath = "//input[contains(@id,'TaskPackage_NE_Name')]")
    WebElement taskPackageName;

    @FindBy(xpath = "//textarea[contains(@id,'TP_NE_Des')]")
    WebElement taskPackageDescription;

    @FindBy(xpath = "//button[contains(@class,'taskPackageFormAddTaskButton')]")
    WebElement addTaskButton;

    @FindBy(xpath = "//button[contains(@class,'BTN_Milestone_NE_SelectTP')]")
    WebElement addTaskPackageButton;
    
    @FindBy(xpath = "//button[@data-button-id='p.MasterData.TaskPackage_NewEdit_2.BTN_TP_NE_Save']")
    WebElement saveTaskPackageBtn;
    
    public void goToNewTaskPackagePage() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        masterData));

        masterData.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        taskPackageMenu));

        taskPackageMenu.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        createTaskPackageButton));

        createTaskPackageButton.click();
    }

    public void clickAddTaskPackageButton() {

        WebElement addTaskPackageBtn =
                wait.until(
                        ExpectedConditions.visibilityOf(
                                addTaskPackageButton));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        addTaskPackageBtn);
    }

    public String createTaskPackage(
            String tpName,
            String tpDesc) {

        wait.until(
                ExpectedConditions.visibilityOf(
                        taskPackageName));

        taskPackageName.click();
        taskPackageName.clear();
        taskPackageName.sendKeys(tpName);

        wait.until(
                ExpectedConditions.visibilityOf(
                        taskPackageDescription));

        taskPackageDescription.click();
        taskPackageDescription.clear();
        taskPackageDescription.sendKeys(tpDesc);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addTaskButton));

        addTaskButton.click();

        return tpName;
    }
    
    public void clearTaskPackageName() {

        wait.until(ExpectedConditions.visibilityOf(taskPackageName));
        taskPackageName.clear();
    }

    public void clearTaskPackageDescription() {

        wait.until(ExpectedConditions.visibilityOf(taskPackageDescription));
        taskPackageDescription.clear();
    }

    public void saveTaskPackage() {

        wait.until(ExpectedConditions.elementToBeClickable(saveTaskPackageBtn));
        saveTaskPackageBtn.click();
    }
    
}