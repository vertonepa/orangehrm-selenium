package reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {
    private static ThreadLocal<ExtentTest> extentTestTL = new ThreadLocal<>();

    private ExtentManager() {
    }

    static ExtentTest getExtentTest() {
        return extentTestTL.get();
    }

    static void setExtentTest(ExtentTest test) {
        if (Objects.nonNull(test)) extentTestTL.set(test);
    }

    static void unload() {
        extentTestTL.remove();
    }
}
