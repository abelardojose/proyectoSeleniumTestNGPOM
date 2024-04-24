package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class MenuBurger extends BasePage {

    private final By btnLogout = By.id("logout_sidebar_link");
    private final By btnAbout = By.xpath("//a[text()='About']");


    @Override
    @Step("Esperando que el menu burger aparezca")
    public void waitPageToLoad() {
        waitPage(btnLogout, this.getClass().getSimpleName());

        Logs.info("Esperando que sea clickeable ya que tiene una transicion");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogout));
    }

    @Override
    @Step("Verificando el menu burger")
    public void verifyPage() {
        Logs.info("Verificando el menu burger");
        softAssert.assertTrue(find(btnLogout).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clickenado el boton de Logout")
    public void clickingLogout() {
        Logs.info("Clickenado Logout");
        find(btnLogout).click();
    }

    @Step("Clickenado el boton de Logout")
    public void clickingAbout() {
        Logs.info("Clickenado Logout");
        find(btnAbout).click();
    }

    public void verifyAboutOption(String aboutUrl) {
        final var aboutLink = find(btnAbout);

        softAssert.assertTrue(aboutLink.isDisplayed());
        softAssert.assertTrue(aboutLink.isEnabled());
        softAssert.assertEquals(aboutLink.getAttribute("href"), aboutUrl);
        softAssert.assertAll();
    }
}
