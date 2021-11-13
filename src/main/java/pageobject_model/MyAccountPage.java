package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends AbstractPage{

    private final By locatorDemoTab = By.xpath("//div[@class='Tabs_container__2lcvP AccountsPage_tabs__iedhG']/div[contains(text(),'Demo')]");

    private final By locatorSetBalance = By.xpath("//button[contains(text(),'Set Balance')]");

    private final By locatorBalance = By.xpath("//div/span[@class='Money_balanceLarge__2DKXD']");

    @FindBy(id = "amount")
    private WebElement inputArea;

    @FindBy(xpath = "//form/button")
    private WebElement saveChanges;

    private float initialBalance;

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    public MyAccountPage setBalance(){

        WebElement demoTab = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorDemoTab));
        demoTab.click();

        WebElement setBalanceButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorSetBalance));
        setBalanceButton.click();

        String value = inputArea.getAttribute("value");
        initialBalance = Float.parseFloat(value);
        String newValue = Float.toString(initialBalance+1);

        inputArea.clear();
        inputArea.sendKeys(newValue);

        saveChanges.click();

        driver.navigate().refresh();

        return this;
    }

    public boolean isNewBalanceCorrect(){

        WebElement balance = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorBalance));

        String newBalance = balance.getAttribute("innerHTML").replaceAll(",","");
        if(Float.parseFloat(newBalance) - initialBalance == 1f)
            return true;
        else return false;
    }

}
