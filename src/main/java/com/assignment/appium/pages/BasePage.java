package com.assignment.appium.pages;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

    @AndroidFindBy(uiAutomator = "Navigate up") //TODO update uiautomation script
            MobileElement backButton;
    AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //TODO initialize utility
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

}
