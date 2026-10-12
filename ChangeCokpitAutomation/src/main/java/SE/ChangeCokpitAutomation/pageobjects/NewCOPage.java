package SE.ChangeCokpitAutomation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCOPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewCOPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(30));

        PageFactory.initElements(
                driver,
                this);
    }

    public void createNewCO(
            String title,
            String processFlow,
            String changeReason,
            String changeUrgency,
            String businessImpact,
            String description,
            String benefit,
            String plants) {

        System.out.println(
                "CO Creation Method Started");

        // Add CO xpaths later

    }

    public String getCOConfirmationMsg() {

        return "";
    }

    public String getCOId() {

        return "";
    }

    public void clickOkConfirmation() {

    }
}