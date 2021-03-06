package com.assignment.appium.pages;

import com.assignment.appium.commons.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"BROWSE\")")
  private MobileElement browseSection;
  @AndroidFindBy(id = "action_sell")
  private MobileElement sellButton;
  @AndroidFindBy(id = "pic_camera")
  private MobileElement picCamera;


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
//    scrollToText(category).click();
    scrollWithTouchAction(ScrollDirection.DOWN, 5);
    driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + category + "\")"))
        .click();
    return new ProductCategoryHomePage(driver);
  }

}

