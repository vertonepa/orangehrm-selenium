package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage{
    private final By header = By.cssSelector(".oxd-topbar-header-breadcrumb-module");

    public String getHeaderText() {
        return getText(header, WaitStrategy.PRESENCE);
    }
}
