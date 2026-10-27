package SE.ChangeCokpitAutomation.Tests;

import org.testng.annotations.Test;

import SE.ChangeCockpitAutomation.Data.Common.AssessmentData;
import SE.ChangeCockpitAutomation.businessflows.AssessmentFlow;
import SE.ChangeCockpitAutomation.businessflows.COFlow;
import SE.ChangeCokpitAutomation.TestComponents.BaseTest;

public class COProcessWithMilestoneTaskPackageTaskAssessmentTest extends BaseTest {

    @Test(description = "Create CO Process with Milestone, Task Package, Normal Task and Assessment")
    public void createCOProcessWithAssessment() {

        String assessmentName = AssessmentData.getAssessmentName();

        COFlow coFlow = new COFlow(driver);

        // Process -> Milestone -> Task Package -> Normal Task
        coFlow.createCOProcessWithMilestoneTaskPackageTask();

        AssessmentFlow assessmentFlow = new AssessmentFlow(driver);

        // Assessment Required ON
        // Add Assessment
        assessmentFlow.createAssessment(assessmentName);

        System.out.println(
                "CO Assessment Created Successfully : "
                        + assessmentName);
    }
}