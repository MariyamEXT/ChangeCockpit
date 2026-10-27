package SE.ChangeCokpitAutomation.pageobjects.task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPage {

    WebDriver driver;
    WebDriverWait wait;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By taskName =
            By.xpath("//input[contains(@id,'Task_NE_Name')]");

    private By saveTaskButton =
            By.xpath("//button[contains(@class,'Task_NE_Save')]");

    private By taskTypeClear =
            By.xpath("//label[contains(text(),'Task Type')]/following::*[contains(@class,'clear')][1]");

    private By userGroupClear =
            By.xpath("//label[contains(text(),'User Group')]/following::*[contains(@class,'clear')][1]");

    private By notificationTypeClear =
            By.xpath("//label[contains(text(),'Notification Type')]/following::*[contains(@class,'clear')][1]");

    private By userGroupDropdown =
            By.xpath("//label[contains(.,'User Group')]/following::div[contains(@class,'widget-combobox-down-arrow')][1]");

    public void clearTaskName() {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(taskName));

        element.clear();
    }

    public void clearTaskType() {

        wait.until(
                ExpectedConditions.elementToBeClickable(taskTypeClear))
                .click();
    }

    public void clearUserGroup() {

        wait.until(
                ExpectedConditions.elementToBeClickable(userGroupClear))
                .click();
    }

    public void clearNotificationType() {

        wait.until(
                ExpectedConditions.elementToBeClickable(notificationTypeClear))
                .click();
    }

    public void selectUserGroup(String userGroup) {

        wait.until(
                ExpectedConditions.elementToBeClickable(userGroupDropdown))
                .click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[contains(.,'" + userGroup + "')]")))
                .click();
    }

    public void saveTask() {

        wait.until(
                ExpectedConditions.elementToBeClickable(saveTaskButton))
                .click();
    }
}