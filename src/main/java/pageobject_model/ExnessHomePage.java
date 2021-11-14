package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExnessHomePage extends AbstractPage{

    private final String HOME_PAGE_URL = "https://exness.com";

    private final By locatorSignInButton = By.xpath("//div[@class='sidebar-tabs__buttons']/a");

    public ExnessHomePage(WebDriver driver) {
        super(driver);
    }

    public ExnessSignInPage openLoginPage() {
        WebElement signInButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorSignInButton));
        String currentHandle = driver.getWindowHandle();
        String URLToClick = signInButton.getAttribute("href");
        driver.get(URLToClick);
        return new ExnessSignInPage(driver);
    }

    public ExnessHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

}
