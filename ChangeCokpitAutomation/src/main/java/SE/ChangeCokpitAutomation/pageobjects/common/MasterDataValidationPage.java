package SE.ChangeCokpitAutomation.pageobjects.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterDataValidationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By saveButton =
            By.xpath("//button[contains(.,'Save')]");

    private By okButton =
            By.xpath("//button[contains(.,'OK')]");

    private By cancelButton =
            By.xpath("//button[contains(.,'Cancel')]");

    private By validationMessage =
            By.xpath("//*[contains(@class,'alert') "
                    + "or contains(@class,'validation') "
                    + "or contains(@class,'mx-name-container')]");

    public MasterDataValidationPage(WebDriver driver) {

        this.driver = driver;
        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));
    }

    public void clickSave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        saveButton))
                .click();
    }

    public void clickOK() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        okButton))
                .click();
    }

    public void clickCancel() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cancelButton))
                .click();
    }

    public String getValidationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        validationMessage))
                .getText();
    }

    public String getValidationMessage(
            String message) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//*[contains(text(),'"
                                        + message
                                        + "')]")))
                .getText();
    }

    public boolean isValidationMessageDisplayed(
            String message) {

        try {

            return wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    By.xpath(
                                            "//*[contains(text(),'"
                                                    + message
                                                    + "')]")))
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isValidationDisplayed(
            String message) {

        return isValidationMessageDisplayed(
                message);
    }

    public boolean waitForValidationMessage(
            String message) {

        try {

            wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    By.xpath(
                                            "//*[contains(text(),'"
                                                    + message
                                                    + "')]")));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isSaveButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    saveButton))
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}