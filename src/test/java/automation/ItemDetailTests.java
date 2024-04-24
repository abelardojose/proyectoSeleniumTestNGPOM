package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ItemDetailPage;
import page.LoginPage;
import page.ShoppingPage;
import utilities.BaseTest;
import utilities.Logs;

public class ItemDetailTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Ingresando a la url");
        driver.get("https://www.saucedemo.com/");

        loginPage.waitPageToLoad();

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad();
        shoppingPage.goToItemDetail("Sauce Labs Fleece Jacket");
        itemDetailPage.waitPageToLoad();
    }

    @Test(groups = regression)
    public void itemDetailTest() {
        itemDetailPage.verifyPage();
    }

    @Test(groups = regression)
    public void backToProductsTest() {
        itemDetailPage.clickingBackToProducts();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
