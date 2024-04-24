package utilities;

import org.openqa.selenium.Cookie;
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

    public void assignLoginCookie() {
        Logs.debug("Asignando la cookie al login");
        getDriver().get("https://www.saucedemo.com/404");
        final var loginCookie = new Cookie("session-username", "standard_user");
        getDriver().manage().addCookie(loginCookie);
    }

    public void goToLoginPage() {
        getDriver().get("https://www.saucedemo.com/");
        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {

        assignLoginCookie();
        getDriver().get("https://www.saucedemo.com/inventory.html");
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
