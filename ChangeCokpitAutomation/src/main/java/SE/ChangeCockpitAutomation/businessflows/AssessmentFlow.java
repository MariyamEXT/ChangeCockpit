package SE.ChangeCockpitAutomation.businessflows;

import org.openqa.selenium.WebDriver;

import SE.ChangeCokpitAutomation.pageobjects.milestone.AssessmentPage;

public class AssessmentFlow {

    private WebDriver driver;

    public AssessmentFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void createAssessment(String assessmentName) {

        AssessmentPage assessmentPage =
                new AssessmentPage(driver);

        assessmentPage.enableAssessmentRequired();
        assessmentPage.clickAddAssessment();
        assessmentPage.enterAssessmentName(assessmentName);
        assessmentPage.saveAssessment();
    }
}