package com.assignment.appium.pages;

import com.assignment.appium.commons.ScrollDirection;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

    //    @AndroidFindBy(uiAutomator = "Navigate up") //TODO update uiautomation script
    //    MobileElement backButton;
    AppiumDriver<MobileElement> driver;

    public int height, width;

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
            if (element.getText().equals(text)) return element;
        }
        return null;
    }

    public MobileElement scrollInsideElementByText(MobileElement element, String text) {
        String locator = "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(3).scrollIntoView(new UiSelector().text(\"" + text + "\"))";
        return element.findElement(MobileBy.AndroidUIAutomator(locator));
    }

    public MobileElement scrollToText(String text) {
        String locator = "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(8).scrollIntoView(new UiSelector().text(\"" + text + "\"))";
        return driver.findElement(MobileBy.AndroidUIAutomator(locator));
    }

    public void scrollWithTouchAction(String direction, int times) {
        TouchAction touchAction = new TouchAction(driver);
        int startX = width / 2;
        int startY = height / 2 - 100;
        int endX = 0;
        int endY = height - 200;

        for (int i = 0; i < times; i++) {
            if (direction.equals(ScrollDirection.DOWN)) {
                touchAction.press(startX, startY).moveTo(0, -endY).perform();
            } else if (direction.equals(ScrollDirection.UP)) {
                touchAction.press(endX, endY).moveTo(startX, startY).perform();
            }
        }
    }

}
