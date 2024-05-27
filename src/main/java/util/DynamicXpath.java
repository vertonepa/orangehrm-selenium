package util;

public final class DynamicXpath {
    private DynamicXpath() {
    }

    public static String getXpath(String xpath, String inputValue) {
        return String.format(xpath, inputValue); //recordar xpath = //tag[text()='%s']
    }
}
