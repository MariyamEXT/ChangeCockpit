package SE.ChangeCokpitAutomation.Tests;

import org.testng.annotations.Test;

import SE.ChangeCockpitAutomation.Data.Common.AssessmentData;
import SE.ChangeCokpitAutomation.TestComponents.BaseTest;
import SE.ChangeCockpitAutomation.businessflows.AssessmentFlow;
import SE.ChangeCockpitAutomation.businessflows.CRFlow;

public class CRProcessWithMilestoneTaskPackageTaskAssessmentTest extends BaseTest {

    @Test(description = "Create CR Process with Milestone, Task Package, Normal Task and Assessment")
    public void createCRProcessWithAssessment() {

        String assessmentName = AssessmentData.getAssessmentName();

        CRFlow crFlow = new CRFlow(driver);

        // Process -> Milestone -> Task Package -> Normal Task
        crFlow.createCRProcessWithMilestoneTaskPackageTask();

        AssessmentFlow assessmentFlow = new AssessmentFlow(driver);

        // Assessment Required ON
        // Add Assessment
        assessmentFlow.createAssessment(assessmentName);

        System.out.println(
                "CR Assessment Created Successfully : "
                        + assessmentName);
    }
}