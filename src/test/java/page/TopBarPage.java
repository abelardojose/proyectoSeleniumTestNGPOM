package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBarPage extends BasePage {

    private final By title = By.xpath("//div[text()='Swag Labs']");
    private final By menuBurger = By.id("react-burger-menu-btn");


    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando el top bar")
    public void verifyPage() {
        Logs.info("Verificando el top bar");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(menuBurger).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Abriendo el menu Burger")
    public void openMenuBurger() {
        Logs.info("Abriendo el menu Burger");
        find(menuBurger).click();
    }
}
