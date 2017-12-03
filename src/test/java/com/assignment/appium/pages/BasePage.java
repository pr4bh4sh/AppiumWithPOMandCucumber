package com.assignment.appium.pages;

import com.assignment.appium.commons.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  public int height, width;
  AppiumDriver<MobileElement> driver;

  public BasePage(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    //TODO initialize utility
    height = (height == 0) ? driver.manage().window().getSize().height : height;
    width = (width == 0) ? driver.manage().window().getSize().width : width;
  }

  /**
   * Accepts list of element and text and returns the first element which has the text.
   */
  public MobileElement getElementByTextFromList(List<MobileElement> elements, String text) {
    for (MobileElement element : elements) {
      if (element.getText().equals(text)) {
        return element;
      }
    }
    return null;
  }

  /**
   * Scroll to text with UiAutomator inside an element bounds
   *
   * @param text - exact text
   */
  public MobileElement scrollInsideElementByText(MobileElement element, String text) {
    String locator =
        "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(3).scrollIntoView(new UiSelector().text(\""
            + text + "\"))";
    return element.findElement(MobileBy.AndroidUIAutomator(locator));
  }

  /**
   * Scroll to text with UiAutomator
   *
   * @param text - exact text
   */
  public MobileElement scrollToText(String text) {
    String locator =
        "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(8).scrollIntoView(new UiSelector().text(\""
            + text + "\"))";
    return driver.findElement(MobileBy.AndroidUIAutomator(locator));
  }

  /**
   * Scroll to a direction
   */
  public void scrollWithTouchAction(String direction, int time) {
    TouchAction touchAction = new TouchAction(driver);
    int startX = width / 2;
    int startY = height - height / 3;
    int endX = 0; // of which the startX will deviate not the actual co-ordinates
    int endY = height - 300;

    for (int i = 0; i < time; i++) {
      if (direction.equals(ScrollDirection.DOWN)) {
        touchAction.press(startX, startY).moveTo(0, -endY).perform();
      } else if (direction.equals(ScrollDirection.UP)) {
        touchAction.press(endX, endY).moveTo(startX, startY).perform();
      }
      try {
        Thread.sleep(200); //sleep between scroll
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  /**
   * Wait for element visibility
   */
  public MobileElement waitForElement(By by, int timeInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
    return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

}
