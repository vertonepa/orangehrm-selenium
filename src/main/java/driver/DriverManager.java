package driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * DriverManager ayuda a lograr la thread safety para cualquier instancia de {@link org.openqa.selenium.WebDriver}
 * <p>
 */
public final class DriverManager {
    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    /**
     * Retorna una instancia thread safe de WebDriver traída de la variable ThreadLocal.
     *
     * @return {@link org.openqa.selenium.WebDriver}<p>
     */
    public static WebDriver getDriver() {
        return tDriver.get();
    }

    /**
     * Establece el valor de una instancia de WebDriver a una variable ThreadLocal
     *
     * @param driverRef instancia de WebDriver que debe salvarse de los problemas de seguridad del Thread.<p>
     */
    static void setDriver(WebDriver driverRef) {
        if (Objects.nonNull(driverRef)) tDriver.set(driverRef);
    }

    /**
     * LLamar al método remove() en una variable ThreadLocal asegura establecer el valor por defecto en
     * esta variable. <p>
     */
    static void unload() {
        tDriver.remove();
    }
}
