package SE.ChangeCockpitAutomation.businessflows;

import org.openqa.selenium.WebDriver;

import SE.ChangeCockpitAutomation.Data.Common.StageData;
import SE.ChangeCokpitAutomation.pageobjects.milestone.AssessmentPage;
import SE.ChangeCokpitAutomation.pageobjects.milestone.StagePage;

public class AssessmentStageFlow {

    private StagePage stagePage;
    private AssessmentPage assessmentPage;

    public AssessmentStageFlow(WebDriver driver) {
        stagePage = new StagePage(driver);
        assessmentPage = new AssessmentPage(driver);
    }

    public String createStageAndDocumentType() {

        String stageName = StageData.getStageName();

        stagePage.clickAddStage();
        stagePage.enterStageName(stageName);
        stagePage.setOrder(StageData.getOrder());
        stagePage.selectCoreTeamStageType();
        stagePage.clickSaveStage();

        String documentTypeName = StageData.getDocumentTypeName();

        assessmentPage.createDocumentType(documentTypeName);

        assessmentPage.saveAssessment();

        return stageName;
    }
}