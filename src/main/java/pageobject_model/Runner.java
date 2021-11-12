package pageobject_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Runner {

    public static void main(String[] args) {

        final String LOGIN = "marusika6464@mail.ru";
        final String PASSWORD = "RDZ7KuLX8s6aWUt";

        WebDriver driver = new FirefoxDriver();

        MyAccountPage myAccountPage = new ExnessHomePage(driver)
                .openPage()
                .openLoginPage()
                .inputLogin(LOGIN)
                .inputPassword(PASSWORD)
                .signIn()
                .setBalance();

        boolean isNewBalanceCorrect = myAccountPage.isNewBalanceCorrect();

        System.out.println(isNewBalanceCorrect);

        //driver.quit();

    }
}
