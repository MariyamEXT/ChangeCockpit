package SE.ChangeCokpitAutomation.pageobjects.common;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    WebElement userName;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@title='Master Data']")
    WebElement masterData;

    public void loginApplication(
            String username,
            String pwd) {

        wait.until(
                ExpectedConditions.visibilityOf(
                        userName));

        userName.clear();
        userName.sendKeys(username);

        wait.until(
                ExpectedConditions.visibilityOf(
                        password));

        password.clear();
        password.sendKeys(pwd);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton));

        loginButton.click();

        wait.until(
                ExpectedConditions.visibilityOf(
                        masterData));

        System.out.println(
                "Login Successful");
    }

    public String getTitle() {

        return driver.getTitle();
    }

    public void clickMasterData() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        masterData));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        masterData);
    }
}