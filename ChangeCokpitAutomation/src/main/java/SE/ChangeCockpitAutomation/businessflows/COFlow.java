package SE.ChangeCockpitAutomation.businessflows;

import org.openqa.selenium.WebDriver;

public class COFlow {

    private WebDriver driver;

    public COFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void createCOProcessWithMilestoneTaskPackageTask() {

        System.out.println(
                "Create CO Process -> Milestone -> Task Package -> Task");
    }
}