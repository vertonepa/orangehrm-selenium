package listener;

import annotations.ReportAnnotation;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import enums.Category;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;
import runner.CLIParams;

public class CustomListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.closeReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ReportAnnotation.class).author();
        Category[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ReportAnnotation.class).category();

        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(authors);
        ExtentReport.addCategories(categories);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String message = "This test method " + result.getMethod().getMethodName() + "() has passed successfully on "
                 + CLIParams.browser + " browser";
        ExtentLogger.pass(message, false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String message = "This test method " + result.getMethod().getMethodName() + "()" +
                " has failure on " + CLIParams.browser + " browser";
        ExtentLogger.fail(message, true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String message = "This test method " + result.getMethod().getMethodName() + "()" +
                " has skipped when it tried to run on " + CLIParams.browser + " browser";
        ExtentLogger.skip(message, false);
    }

}
