package com.assignment.appium.pages;

import com.assignment.appium.commons.Filters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryHomePage extends BasePage {


  @AndroidFindBy(id = "feature_button")
  MobileElement okGotIt;

  @AndroidFindBy(id = "bar_filter_title")
  MobileElement productFilter;

  @AndroidFindBy(id = "text_sort_recent")
  MobileElement byRecent;

  @AndroidFindBy(id = "button_apply_filter")
  MobileElement applyFilter;

  public ProductCategoryHomePage(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public void selectFilter(Filters type) {
    if (okGotIt != null) {
      okGotIt.click();
    }
    productFilter.click();
    switch (type) {
      case POPULAR:
        break;
      case RECENT:
        byRecent.click();
        break;
      case NEAREST:
        break;
      case LOWEST_PRICE:
        break;
      case HIGHEST_PRICE:
        break;
    }
    applyFilter.click();
  }

  public MobileElement getProductByText(String text) {
    return driver
        .findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text + "\")"));
  }
}
