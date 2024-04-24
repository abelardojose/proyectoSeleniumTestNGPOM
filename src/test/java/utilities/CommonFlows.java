package utilities;

import org.openqa.selenium.WebDriver;
import page.ItemDetailPage;
import page.LoginPage;
import page.MenuBurger;
import page.ShoppingPage;
import page.TopBarPage;

public class CommonFlows {
    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    public void goToLoginPage() {
        getDriver().get("https://www.saucedemo.com/");
        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {

        goToLoginPage();

        new LoginPage().fillLogin("standard_user", "secret_sauce");
        new ShoppingPage().waitPageToLoad();
    }

    public void openBurgueMenu() {

        goToShoppingPage();

        new TopBarPage().openMenuBurger();
        new MenuBurger().waitPageToLoad();
    }

    public void goToItemDetail(String itemName) {
        goToShoppingPage();
        new ShoppingPage().goToItemDetail(itemName);
        new ItemDetailPage().waitPageToLoad();
    }
}
