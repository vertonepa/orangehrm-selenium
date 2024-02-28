package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private final By nameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.tagName("button");

    public DashboardPage login(String nameText, String passwordText) {
        type(nameField, nameText, WaitStrategy.VISIBLE);
        type(passwordField, passwordText, WaitStrategy.PRESENCE);
        click(loginButton);
        return new DashboardPage();
    }

}
