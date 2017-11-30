package com.assignment.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {
    @AndroidFindBy(id = "action_sell")
    private MobileElement sellButton;
    @AndroidFindBy(id = "pic_camera")
    private MobileElement picCamera;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"BROWSE\")")
    MobileElement browseSection;


    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomePage navigateToSellItem() {
        sellButton.click();
        return this;
    }

    public AddProductToSellPage takePhotoFromCamera() {
        picCamera.click();
        return new AddProductToSellPage(driver);
    }

    public HomePage openBrowseSection() {
        browseSection.click();
        return this;
    }

    public ProductCategoryHomePage openProductCategory(String category) {
        scrollToText(category).click();
        return new ProductCategoryHomePage(driver);
    }

}

