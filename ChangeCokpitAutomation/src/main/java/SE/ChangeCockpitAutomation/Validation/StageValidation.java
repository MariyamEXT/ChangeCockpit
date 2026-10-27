package SE.ChangeCockpitAutomation.Validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StageValidation {

    private WebDriver driver;

    public StageValidation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStagePresent(String stageName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + stageName + "']"))
                .size() > 0;
    }
}