package page;

import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class FooterPage extends BasePage {

    private final By twitterButton = By.xpath("//a[text()='Twitter']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");
    private final By linkedinButton = By.xpath("//a[text()='LinkedIn']");

    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {

    }

    public void verifySocialMediaLinks(String twitterUrl, String linkedinUrl, String facebookUrl) {
        Logs.info("Verificando los links de las redes sociales");

        final var facebookLabel = find(facebookButton);
        final var linkedinLabel = find(linkedinButton);
        final var twitterLabel = find(twitterButton);


        softAssert.assertTrue(facebookLabel.isDisplayed());
        softAssert.assertTrue(facebookLabel.isEnabled());
        softAssert.assertEquals(facebookLabel.getAttribute("href"), facebookUrl);

        softAssert.assertTrue(linkedinLabel.isDisplayed());
        softAssert.assertTrue(linkedinLabel.isEnabled());
        softAssert.assertEquals(linkedinLabel.getAttribute("href"), linkedinUrl);

        softAssert.assertTrue(twitterLabel.isDisplayed());
        softAssert.assertTrue(twitterLabel.isEnabled());
        softAssert.assertEquals(twitterLabel.getAttribute("href"), twitterUrl);

        softAssert.assertAll();
    }
}
