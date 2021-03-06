package com.assignment.appium.listners;

import com.assignment.appium.logger.Log;
import io.appium.java_client.events.api.general.ElementEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * For logging the events on the driver
 */
public class ElementListener implements ElementEventListener {

  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    Log.INFO("Clicking on " + element);
  }

  @Override
  public void afterClickOn(WebElement element, WebDriver driver) {
    Log.INFO("Clicked on " + element);

  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver) {

  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver) {

  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

  }
}
