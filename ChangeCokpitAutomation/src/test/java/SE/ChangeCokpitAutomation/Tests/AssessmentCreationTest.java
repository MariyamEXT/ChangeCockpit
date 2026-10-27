package SE.ChangeCokpitAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import SE.ChangeCockpitAutomation.Data.Common.AssessmentData;
import SE.ChangeCockpitAutomation.Data.Common.StageData;
import SE.ChangeCockpitAutomation.Validation.MasterDataValidation;
import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCokpitAutomation.pageobjects.milestone.AssessmentPage;
import SE.ChangeCokpitAutomation.pageobjects.milestone.CreateMilestonePage;

public class AssessmentCreationTest extends BaseTest {

    @Test(priority = 1, description = "Verify Assessment Creation")
    public void verifyAssessmentCreation() throws InterruptedException {

        AssessmentPage assessmentPage =
                new AssessmentPage(driver);

        CreateMilestonePage createMilestonePage =
                new CreateMilestonePage(driver);

        MasterDataValidation validation =
                new MasterDataValidation(driver);

        String assessmentName =
                AssessmentData.getAssessmentName();

        // Create Assessment
        assessmentPage.clickAddAssessment();
        assessmentPage.enterAssessmentName(assessmentName);

        // Create Document Type
        assessmentPage.createDocumentType(
                StageData.getDocumentTypeName());

        // Save Assessment
        assessmentPage.saveAssessment();

        // Save Milestone
        createMilestonePage.saveMilestone();

        // Publish Milestone
        createMilestonePage.publishMilestone();


    }
}