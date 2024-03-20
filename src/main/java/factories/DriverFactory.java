package factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import runner.CLIParams;

public final class DriverFactory {

    private DriverFactory() {
    }

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
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = WebDriverManager.edgedriver().create();
        }

        return driver;
    }
}
