package testcases;

import driver.Driver;
import enums.ConfigProperties;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import util.PropertyUtil;


public abstract class BaseTest {
    SoftAssertions soft = new SoftAssertions();

    /**
     * Este método se ejecutará antes de ejecutar cualquier método de prueba.
     * <p>Su función es invocar una instancia del navegador y cargar la url base.</>
     */
    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
        LoginPage in = new LoginPage();
        in.login(PropertyUtil.get(ConfigProperties.USERNAME), PropertyUtil.get(ConfigProperties.PASSWORD));
    }

    /**
     * Este método finaliza la instancia del navegador
     */
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
