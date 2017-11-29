package com.assignment.appium.widgets;

import com.assignment.appium.pages.BasePage;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PictureWidget extends BasePage {
    @AndroidFindBy(id = "button_capture")
    private MobileElement captureButton;

    @AndroidFindBy(id = "pic_camera")
    private MobileElement cameraOption;

    public PictureWidget(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
