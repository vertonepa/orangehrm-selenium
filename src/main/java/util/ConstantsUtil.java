package util;

import enums.ConfigProperties;


public final class ConstantsUtil {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String RESOURCES_PATH = PROJECT_PATH + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/config.properties";
    private static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/extent-test-output/";
    private static String extentReportFilePath = "";

    private static final int EXPLICIT_WAIT = 10;

    private ConstantsUtil() {
    }

    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty())
            extentReportFilePath = createReportPath();

        return extentReportFilePath;
    }

    private static String createReportPath() {
        if(PropertyUtil.get(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("no")) {
            return EXTENT_REPORT_FOLDER_PATH + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENT_REPORT_FOLDER_PATH + "index.html";
        }
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
}
