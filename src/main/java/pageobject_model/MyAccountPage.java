package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends AbstractPage{

    private final By locatorDemoTab = By.xpath("/html/body/div[1]/div[2]/main/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]");

//    @FindBy(xpath = "/html/body/div[1]/div[2]/main/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]")
//    private WebElement demoTab;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/main/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div/div[1]/button")
    private WebElement setBalanceButton;

    @FindBy(id = "amount")
    private WebElement inputArea;

    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div[3]/div/form/button")
    private WebElement saveChanges;

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    public MyAccountPage setBalance(){

        WebElement demoTab = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorDemoTab));
        demoTab.click();

        setBalanceButton.click();

        String value = inputArea.getAttribute("value");
        String newValue = Integer.toString(Integer.parseInt(value)+1);

        inputArea.clear();
        inputArea.sendKeys(newValue);

        saveChanges.click();

        driver.navigate().refresh();

        return this;
    }

}
