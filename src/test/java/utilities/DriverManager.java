package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {
        if (runServer) {
            builRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    private void buildLocalDriver() {
        var browserProperty = System.getProperty("browser");

        if (browserProperty == null) {
            Logs.debug("Defaul driver CHROME");
            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());
        Logs.debug("Init Driver: %s", browser);

        final var driver = switch (browser) {
            case CHROME -> new ChromeDriver();
            case SAFARI -> new SafariDriver();
            case EDGE -> new EdgeDriver();
            case FIREFOX -> new FirefoxDriver();
        };

        Logs.debug("Maximizar pantalla");
        driver.manage().window().maximize();
        Logs.debug("Borrar cookies");
        driver.manage().deleteAllCookies();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new WebDriverProvider().set(driver);
    }

    private void builRemoteDriver() {
        //Cuando tengamos una configuracion para Jenkins
    }

    public void killDriver() {
        Logs.debug("Finalizar driver");
        new WebDriverProvider().get().quit();
    }

    private enum Browser {
        CHROME,
        FIREFOX,
        SAFARI,
        EDGE
    }
}
