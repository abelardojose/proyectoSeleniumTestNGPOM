package utilities;

import org.openqa.selenium.chrome.ChromeDriver;

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
        Logs.debug("Inicializar driver");
        final var driver = new ChromeDriver();
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
}
