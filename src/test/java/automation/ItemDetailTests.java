package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ItemDetailPage;
import page.LoginPage;
import page.ShoppingPage;
import utilities.BaseTest;

public class ItemDetailTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToItemDetail("Sauce Labs Fleece Jacket");
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
