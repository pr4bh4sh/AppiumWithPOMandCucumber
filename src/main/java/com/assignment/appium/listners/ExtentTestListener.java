package com.assignment.appium.listners;

import com.assignment.appium.factory.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
  }

  @Override
  public void onFinish(ITestContext context) {
    extent.flush();
  }

  @Override
  public void onTestStart(ITestResult result) {
    parent = extent.createTest(result.getMethod().getMethodName());
    parent.createNode(result.getMethod().getMethodName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    parent.pass("Test passed");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    parent.fail(result.getMethod().getMethodName() + " Failed");
    parent.fail(result.getThrowable());
    try {
      String path = DriverFactory.getScreenShot();
      parent.addScreenCaptureFromPath(path);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
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
