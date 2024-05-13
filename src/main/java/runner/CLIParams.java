package runner;

public final class CLIParams {
    //parámetro browser admite argumentos "chrome" y "firefox". Por defecto, el argumento es "headless".
    public static String browser = System.getProperty("browser", "headless");
    public static final String username = System.getProperty("username", "Admin");
    public static final String password = System.getProperty("password", "admin123");

    private CLIParams() {
    }
}
