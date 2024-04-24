package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.FooterPage;
import page.LoginPage;
import page.ShoppingPage;
import utilities.BaseTest;

public class FooterTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final FooterPage footerPage = new FooterPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingPage();
    }

    @Test(groups = regression)
    public void socialMediaLinksTest() {
        footerPage.verifySocialMediaLinks(
                "https://twitter.com/saucelabs",
                "https://www.linkedin.com/company/sauce-labs/",
                "https://www.facebook.com/saucelabs");
    }
}
