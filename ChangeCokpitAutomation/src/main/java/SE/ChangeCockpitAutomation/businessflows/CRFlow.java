package SE.ChangeCockpitAutomation.businessflows;

import org.openqa.selenium.WebDriver;

public class CRFlow {

    private WebDriver driver;

    public CRFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void createCRProcessWithMilestoneTaskPackageTask() {

        System.out.println(
                "Create CR Process -> Milestone -> Task Package -> Task");
    }
}