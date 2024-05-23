package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import enums.ConfigProperties;
import util.PropertyUtil;
import util.ScreenshotsUtil;

public class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    /**
     *
     * @param message
     * @param isScreenshotNeeded
     */
    public static void pass(String message, boolean isScreenshotNeeded) {
        if (PropertyUtil.get(ConfigProperties.PASSED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtil.getBase64Image()).build());
        else pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if (PropertyUtil.get(ConfigProperties.FAILED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtil.getBase64Image()).build());
        else fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        if (PropertyUtil.get(ConfigProperties.SKIPPED_STEPS_SCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtil.getBase64Image()).build());
        else skip(message);
    }

}
