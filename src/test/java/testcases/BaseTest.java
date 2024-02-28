package testcases;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {

    /**
     * Este método se ejecutará antes de ejecutar cualquier método de prueba.
     * <p>Su función es invocar una instancia del navegador y cargar la url base.</>
     */
    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }

    /**
     * Este método finaliza la instancia del navegador
     */
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
