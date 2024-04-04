package listener;

import annotations.ReportAnnotation;
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
        String message = "method=" + result.getMethod().getMethodName() + "() " + "|| browser=" + CLIParams.browser;
        ExtentLogger.pass(message, false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String message = "method=" + result.getMethod().getMethodName() + "() " + "|| browser=" + CLIParams.browser;
        ExtentLogger.fail(message, true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String message = "method=" + result.getMethod().getMethodName() + "() " + "|| browser=" + CLIParams.browser;
        ExtentLogger.skip(message, false);
    }

}
