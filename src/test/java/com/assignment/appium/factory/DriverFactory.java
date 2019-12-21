package com.assignment.appium.factory;


import com.assignment.appium.listners.ElementListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

  static private AppiumDriver appiumDriver;

  /**
   * @return - Returns driver instance
   */
  public static AppiumDriver getAndroidDriver() throws UnsupportedEncodingException {
    if (appiumDriver != null) {
      return appiumDriver;
    } else {
      // package name is obfusecated to stop displaying it in github search
      byte[] asBytes = Base64.getDecoder().decode("Y29tLnRoZWNhcm91c2VsbC5DYXJvdXNlbGw=");
      String package_name = new String(asBytes, "utf-8");
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
      desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android_device");
      desiredCapabilities.setCapability(MobileCapabilityType.APP,
          new File("").getAbsoluteFile() + File.separator + "app" + File.separator
              + "test-app.apk");
      desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
          package_name + ".activities.EntryActivity");
      desiredCapabilities
          .setCapability(AndroidMobileCapabilityType.APP_PACKAGE, package_name);
      desiredCapabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
      desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
      desiredCapabilities.setCapability("newCommandTimeout", 7200);
      desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
      desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
      desiredCapabilities
          .setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
      try {
        appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
            desiredCapabilities);
        appiumDriver = EventFiringWebDriverFactory
            .getEventFiringWebDriver(appiumDriver, new ElementListener());
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.out.println(appiumDriver);

        return appiumDriver;
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * @return - Returns relative path with result dir
   */
  public static String getScreenShot() {
    try {
      System.out.println("Adding screen shot");
      File screenshot = appiumDriver.getScreenshotAs(OutputType.FILE);
      String path = "screenshots/" + UUID.randomUUID() + "" + ".png";
      System.out.println(path);
      FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/reports/" + path));
      return path;
    } catch (Exception e) {
      System.out.println("Screen shot failed");
      System.out.println(e.getMessage());
    }
    return null;
  }

  /**
   * Kills driver session
   */
  public static void quitDriver() {
    if (appiumDriver != null) {
      appiumDriver.quit();
    }
  }
}
