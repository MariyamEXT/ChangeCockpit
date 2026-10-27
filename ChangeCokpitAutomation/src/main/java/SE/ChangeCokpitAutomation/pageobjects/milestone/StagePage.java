package SE.ChangeCokpitAutomation.pageobjects.milestone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StagePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public StagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By addStageButton =
            By.xpath("//button[contains(.,'Add Stage')]");

    private By stageNameTextbox =
            By.xpath("//input[contains(@name,'MasterData.Stages_NewEdit')]");

    private By orderSlider =
            By.xpath("//input[@type='range']");

    private By coreTeamRadio =
            By.cssSelector("input[value='CoreTeam']");

    private By saveStageButton =
            By.cssSelector(
                    "button[data-button-id='p.MasterData.Stages_NewEdit.actionButton1']");

    public void clickAddStage() {
        wait.until(ExpectedConditions.elementToBeClickable(addStageButton))
                .click();
    }

    public void enterStageName(String stageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(stageNameTextbox))
                .sendKeys(stageName);
    }

    public void setOrder(int order) {
        // We'll implement properly once you share the exact Stage popup DOM.
    }

    public void selectCoreTeamStageType() {
        wait.until(ExpectedConditions.elementToBeClickable(coreTeamRadio))
                .click();
    }

    public void clickSaveStage() {
        wait.until(ExpectedConditions.elementToBeClickable(saveStageButton))
                .click();
    }
}