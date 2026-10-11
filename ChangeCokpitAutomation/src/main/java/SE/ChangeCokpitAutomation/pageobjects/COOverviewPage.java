package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class COOverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    public COOverviewPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(30));

        PageFactory.initElements(
                driver,
                this);
    }

}