package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import runner.CLIParams;

public final class DriverFactory {

    private DriverFactory() {
    }

    /**
     * Este método se encargará de tomar las decisiones correspondientes de configuración
     * de driver a partir de los valores que se le pasen mediante CLI,
     * los cuales están establecidos en {@link CLIParams}
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        WebDriver driver = null;
        String browser = CLIParams.browser;

        if (browser.equalsIgnoreCase("headless")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--headless=new");
            driver = new ChromeDriver(opt);
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        }

        return driver;
    }
}
