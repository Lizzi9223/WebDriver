package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExnessSignInPage extends AbstractPage{

    private final By locatorLoginInput = By.id("login");

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//exwc-button/button[@class='I9zSN6It64oATxkCVzN-j _3hH3VM03IxMiiGzxTRPpcN _2E_LesaXlBEyEBJXyaBQe-']")
    private WebElement continueButton;

    public ExnessSignInPage(WebDriver driver) {
        super(driver);
    }

    public ExnessSignInPage inputLogin(String login) {
        WebElement loginInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorLoginInput));
        loginInput.sendKeys(login);
        return this;
    }

    public ExnessSignInPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public MyAccountPage signIn() {
        continueButton.click();
        return new MyAccountPage(driver);
    }

}
