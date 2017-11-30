package com.assignment.appium.listners;

import com.assignment.appium.factory.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * http://extentreports.com/docs/versions/3/java/#testng-itestlistener
 */
public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance("report/extent.html");
    private static ExtentTest parent;

    public static void logStep(String log) {
        parent.info(log);
    }

    @Override
    public void onStart(ITestContext context) {
        parent = extent.createTest(getClass().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        parent.createNode(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        parent.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        parent.fail(result.getThrowable());
        try {
            parent.addScreenCaptureFromPath(DriverFactory.getScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        parent.skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}
