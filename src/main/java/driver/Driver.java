package driver;

import enums.ConfigProperties;
import util.PropertyUtil;

import java.util.Objects;

/**
 * Driver es la clase encargada de invocar y cerrar los navegadores.
 * <p>
 * También es responsable de configurar la variable driver en DriverManager.
 */

public class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.getDriver());

            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtil.get(ConfigProperties.BASE_URL));
        }
    }

    /**
     * Finaliza la instancia del navegador
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
