package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Ingresando a la url");
        commonFlows.goToLoginPage();
    }

    @Test(groups = regression)
    public void invalidLoginTest() {

        loginPage.fillLogin("locked_out_user", "secret_sauce");
        loginPage.verifyErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(groups = regression)
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    @Test(groups = regression)
    public void validLoginTest() {
        loginPage.fillLogin("standard_user", "secret_sauce");
        loginPage.entryPage();
    }
}
