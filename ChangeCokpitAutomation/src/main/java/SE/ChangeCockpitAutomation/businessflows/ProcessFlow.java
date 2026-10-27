package SE.ChangeCockpitAutomation.businessflows;

import org.openqa.selenium.WebDriver;

import SE.ChangeCokpitAutomation.pageobjects.milestone.CreateMilestonePage;
import SE.ChangeCokpitAutomation.pageobjects.process.CreateProcessPage;

public class ProcessFlow {

    private CreateProcessPage processPage;
    private CreateMilestonePage milestonePage;

    public ProcessFlow(WebDriver driver) {

        processPage = new CreateProcessPage(driver);
        milestonePage = new CreateMilestonePage(driver);
    }

    public String createCOProcess() throws Exception {

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        processPage.createChangeOrderProcess();

        return processPage.getCreatedProcessName();
    }

    public String createCRProcess() throws Exception {

        processPage.goToProcessesPage();

        processPage.clickAddProcess();

        processPage.createProcess(
                "Change Request",
                "AutomationCR",
                "Change Manager");

        return processPage.getCreatedProcessName();
    }

    public String createMilestone() {

        processPage.clickAddMilestone();

        return milestonePage.createMilestoneInProcess();
    }

    public void saveMilestone() {

        milestonePage.saveMilestone();
    }

    public void publishMilestone(String milestoneName) throws InterruptedException {

        milestonePage.clickEditMilestone(milestoneName);

        milestonePage.publishMilestone();
    }

    public void activateProcess() throws InterruptedException {

        processPage.makeProcessActive();

        processPage.saveProcess();

        processPage.clickProcessCancel();
    }
}