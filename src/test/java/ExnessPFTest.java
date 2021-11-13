import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.ExnessHomePage;
import pageobject_model.MyAccountPage;

public class ExnessPFTest {

    private WebDriver driver;
    private MyAccountPage myAccountPage;

    final String LOGIN = "marusika6464@mail.ru";
    final String PASSWORD = "RDZ7KuLX8s6aWUt";



    @BeforeMethod
    private void initializeBrowser() {
        driver = new FirefoxDriver();
        myAccountPage = new ExnessHomePage(driver)
                .openPage()
                .openLoginPage()
                .inputLogin(LOGIN)
                .inputPassword(PASSWORD)
                .signIn();
    }

    @Test
    public void setBalance() {
        boolean isNewBalanceCorrect = myAccountPage
                .setBalance()
                .isNewBalanceCorrect();

//        MyAccountPage page = myAccountPage
//                .setBalance();
//
//        boolean isNewBalanceCorrect =
//                page.isNewBalanceCorrect();

        Assert.assertTrue(isNewBalanceCorrect);
    }

    @AfterMethod
    private void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
