package pageobject_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExnessHomePage extends AbstractPage{

    private final String HOME_PAGE_URL = "https://exness.com";

    @FindBy(xpath = "//div[@class='sidebar-tabs__buttons']/a")
    private WebElement signInButton;

    public ExnessHomePage(WebDriver driver) {
        super(driver);
    }

    public ExnessSignInPage openLoginPage() {
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
