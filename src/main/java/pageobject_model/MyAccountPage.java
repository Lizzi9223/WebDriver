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

//    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/main/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div/div[1]/button")
//    private WebElement setBalanceButton;

    private final By locatorSetBalance = By.xpath
            ("//*[@id=\"root\"]/div[2]/main/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div/div[1]/button");

    @FindBy(id = "amount")
    private WebElement inputArea;

    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div[3]/div/form/button")
    private WebElement saveChanges;

    //@FindBy(xpath = "//*[@id=\"root\"]/div[2]/main/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/span[1]")
    //@FindBy(xpath = "//div/span[@class='Money_balanceLarge__2DKXD']")
//    @FindBy(className = "Money_balanceLarge__2DKXD")
//    private WebElement balance;

    private final By locatorBalance = By.xpath("//div/span[@class='Money_balanceLarge__2DKXD']");


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

//        String newBalance = balance.getAttribute("innerHTML").replaceAll(",","");
//        if(Float.parseFloat(newBalance) - initialBalance == 1f)
//            return true;
//        else return false;

        WebElement balance = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorBalance));

        String newBalance = balance.getAttribute("innerHTML").replaceAll(",","");
        if(Float.parseFloat(newBalance) - initialBalance == 1f)
            return true;
        else return false;
    }

}
