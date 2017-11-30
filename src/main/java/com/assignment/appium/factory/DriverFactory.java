package com.assignment.appium.factory;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
    static private AppiumDriver appiumDriver;

    public static AppiumDriver getAndroidDriver() {
        if (appiumDriver != null) {
            return appiumDriver;
        } else {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android_device");
//            desiredCapabilities.setCapability(MobileCapabilityType.APP, new File("").getAbsoluteFile() + File.separator + "app" + File.separator + "Carousell-test-engineering-app.apk");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.thecarousell.Carousell.activities.EntryActivity");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.thecarousell.Carousell");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
            desiredCapabilities.setCapability("newCommandTimeout", 99999);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            try {
                appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                System.out.println(appiumDriver);
                return appiumDriver;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void quitDriver(AppiumDriver appiumDriver) {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }


    public static String getScreenshot() {
        try {
            System.out.println("Adding screen shot");
            File screenshot = appiumDriver.getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/report/screenshots/" + UUID
                    .randomUUID() + "" + ".png";
            FileUtils.copyFile(screenshot, new File(path));
            return path;
        } catch (WebDriverException | ClassCastException | IOException e) {
            System.out.println("Screen shot failed");
            System.out.println(e.getMessage());
        }
        return null;
    }
}