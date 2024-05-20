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

    static void setDriver(WebDriver driverRef) {
        if (Objects.nonNull(driverRef)) tDriver.set(driverRef);
    }

    static void unload() {
        tDriver.remove();
    }
}
