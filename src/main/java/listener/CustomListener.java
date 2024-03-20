package listener;

import annotations.ReportAnnotation;
import enums.Category;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;

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
        ExtentLogger.pass("Ejecucion exitosa del metodo: " + result.getMethod().getMethodName() + "()", false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("Ejecucion fallida del metodo: " + result.getMethod().getMethodName() + "()", true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip("Se ha salteado el metodo: " + result.getMethod().getMethodName() + "()", false);
    }
}
