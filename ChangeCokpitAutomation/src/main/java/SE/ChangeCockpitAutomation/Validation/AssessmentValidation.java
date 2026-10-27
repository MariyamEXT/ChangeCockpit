package SE.ChangeCockpitAutomation.Validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssessmentValidation {

    private WebDriver driver;

    public AssessmentValidation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAssessmentPresent(String assessmentName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + assessmentName + "']"))
                .size() > 0;
    }
}