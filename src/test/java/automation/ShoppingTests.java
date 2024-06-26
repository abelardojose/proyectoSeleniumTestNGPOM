package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ShoppingPage;
import utilities.BaseTest;

public class ShoppingTests extends BaseTest {

    private final ShoppingPage shoppingPage = new ShoppingPage();


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingPage();
    }

    @Test(groups = regression)
    public void verifyPageTest() {
        shoppingPage.verifyPage();
    }

}
