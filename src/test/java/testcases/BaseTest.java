package testcases;

import driver.Driver;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import runner.CLIParams;


public abstract class BaseTest {
    protected SoftAssertions soft = new SoftAssertions();

    /**
     * Este método se ejecutará antes de ejecutar cualquier método de prueba.
     * <p>Su función es invocar una instancia del navegador y cargar la url base.</>
     */
    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.login(CLIParams.username, CLIParams.password);
    }

    /**
     * Este método finaliza la instancia del navegador
     */
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
