//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class ExnessPFTest {
//
//    private WebDriver driver;
//    //private DerivTrader tradePage;
//
//    private final String login = "qcp44330@cuoly.com";
//    private final String password = "5@ymQMBrPyf3@3";
//
//    @BeforeMethod
//    private void initializeBrowser() {
//        driver = new ChromeDriver();
//        tradePage = new DerivHome(driver)
//                .openPage()
//                .openLoginPage()
//                .enterLogin(login)
//                .enterPassword(password)
//                .signIn();
//    }
//
//    @Test
//    public void putOnRiseWithSetDuration() {
//        boolean isPositionCreated = tradePage
//                .setDuration(1)
//                .putOnRise()
//                .checkCreatedPosition();
//
//        Assert.assertTrue(isPositionCreated);
//    }
//
//    @AfterMethod
//    private void closeBrowser() {
//        driver.quit();
//        driver = null;
//    }
//}
