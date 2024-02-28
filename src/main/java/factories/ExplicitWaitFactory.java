package factories;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConstantsUtil;

import java.time.Duration;

public class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(By locator, WaitStrategy wait) {
        WebElement element = null;
        if(wait == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager
                    .getDriver(), Duration.ofSeconds(ConstantsUtil.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if(wait == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager
                    .getDriver(), Duration.ofSeconds(ConstantsUtil.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if(wait == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager
                    .getDriver(), Duration.ofSeconds(ConstantsUtil.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if(wait == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(locator);
        }

        return element;
    }
}
