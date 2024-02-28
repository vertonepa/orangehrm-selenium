package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {

    protected BasePage() {
    }

    protected void click(By element, WaitStrategy wait) {
        ExplicitWaitFactory.performExplicitWait(element, wait).click();
    }

    protected void click(By noWaitButton) {
        DriverManager.getDriver().findElement(noWaitButton).click();
    }

    protected String getText(By element, WaitStrategy wait) {
        return ExplicitWaitFactory.performExplicitWait(element, wait).getText();
    }

    protected void type(By element, String text, WaitStrategy wait) {
        ExplicitWaitFactory.performExplicitWait(element, wait).sendKeys(text);
    }

}
