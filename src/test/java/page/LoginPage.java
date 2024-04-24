package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By userNameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private final By titlePage = By.className("app_logo");

    @Override
    public void waitPageToLoad() {
        waitPage(userNameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(userNameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Rellenando el formulario de Login")
    public void fillLogin(String userName, String password) {
        Logs.info("Escribiendo el username");
        find(userNameInput).sendKeys(userName);
        Logs.info("Escribiendo el password");
        find(passwordInput).sendKeys(password);
        Logs.info("Click en el boton Login");
        find(loginButton).click();
    }

    @Step("Verificando el mensaje de error")
    public void verifyErrorMessage(String errorText) {
        Logs.info("Verificando que el error sea visible y tenga el texto correcto");
        softAssert.assertTrue(find(errorMessage).isDisplayed());
        softAssert.assertEquals(find(errorMessage).getText(), errorText);
        softAssert.assertAll();
    }

    public void entryPage() {
        Logs.info("Valido ingreso a la pagina principal");
        softAssert.assertTrue(find(titlePage).isDisplayed());
        softAssert.assertEquals(find(titlePage).getText(), "Swag Labs");
        softAssert.assertAll();
    }
}
