package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MenuBurger;
import page.ShoppingPage;
import page.TopBarPage;
import utilities.BaseTest;

public class BurgerMenuTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final TopBarPage topBarPage = new TopBarPage();
    private final MenuBurger menuBurger = new MenuBurger();


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.openBurgueMenu();
    }

    @Test(groups = regression)
    public void logoutTest() {
        menuBurger.clickingLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test(groups = regression)
    public void aboutButtonTest() {
        menuBurger.verifyAboutOption("https://saucelabs.com/");
    }
}
