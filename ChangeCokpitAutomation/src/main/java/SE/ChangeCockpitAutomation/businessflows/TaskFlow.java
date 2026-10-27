package SE.ChangeCockpitAutomation.businessflows;

import org.openqa.selenium.WebDriver;

import SE.ChangeCokpitAutomation.pageobjects.task.DecisionTaskPage;
import SE.ChangeCokpitAutomation.pageobjects.task.NotificationTaskPage;
import SE.ChangeCokpitAutomation.pageobjects.task.TaskPage;
public class TaskFlow {

    private TaskPage taskPage;
    private DecisionTaskPage decisionTaskPage;
    private NotificationTaskPage notificationTaskPage;

    public TaskFlow(WebDriver driver) {

        taskPage = new TaskPage(driver);
        decisionTaskPage = new DecisionTaskPage(driver);
        notificationTaskPage = new NotificationTaskPage(driver);
    }

    public void createNormalTask(String userGroup) {

        taskPage.selectUserGroup(userGroup);

        taskPage.saveTask();
    }

    public void createDecisionTask(String userGroup) {

        decisionTaskPage.createDecisionTask(userGroup);
    }

    public void createNotificationTask() {

        notificationTaskPage.createNotificationTask();
    }
}
