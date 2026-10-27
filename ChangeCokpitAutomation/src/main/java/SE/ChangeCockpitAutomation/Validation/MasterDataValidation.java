package SE.ChangeCockpitAutomation.Validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MasterDataValidation {

    private WebDriver driver;

    public MasterDataValidation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAssessmentPresent(String assessmentName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + assessmentName + "']"))
                .size() > 0;
    }

    public boolean isStagePresent(String stageName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + stageName + "']"))
                .size() > 0;
    }

    public boolean isMilestonePresent(String milestoneName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + milestoneName + "']"))
                .size() > 0;
    }

    public boolean isTaskPackagePresent(String taskPackageName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + taskPackageName + "']"))
                .size() > 0;
    }

    public boolean isTaskPresent(String taskName) {
        return driver.findElements(
                By.xpath("//*[normalize-space()='" + taskName + "']"))
                .size() > 0;
    }
}