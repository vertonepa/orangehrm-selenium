package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import enums.Category;
import util.ConstantsUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private static ExtentReports extent;

    private ExtentReport() {
    }

    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(ConstantsUtil.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("OrangeHRM Automation Reports");
        }
    }

    public static void closeReport() {
        if (Objects.nonNull(extent)) extent.flush();
        ExtentManager.unload();

        try {
            Desktop.getDesktop().browse(new File(ConstantsUtil.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void createTest(String tcName) {
        ExtentTest testName = extent.createTest(tcName);
        ExtentManager.setExtentTest(testName);
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors)
            ExtentManager.getExtentTest().assignAuthor(author);
    }

    public static void addCategories(Category[] categories) {
        for (Category category : categories)
            ExtentManager.getExtentTest().assignCategory(category.toString());
    }
}
