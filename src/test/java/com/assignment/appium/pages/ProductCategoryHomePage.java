package com.assignment.appium.pages;

import com.assignment.appium.commons.Filters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.List;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryHomePage extends BasePage {

  //There will be only one element possible, but Proxy will throw error if not present
  // hence making it list to check presence
  @AndroidFindBy(id = "feature_button")
  private List<MobileElement> okGotIt;

  @AndroidFindBy(id = "bar_filter_title")
  private MobileElement productFilter;

  @AndroidFindBy(id = "text_sort_recent")
  private MobileElement byRecent;

  @AndroidFindBy(id = "button_apply_filter")
  private MobileElement applyFilter;

  public ProductCategoryHomePage(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public ProductCategoryHomePage selectFilter(Filters type) {
    //if okGotIt exist click otherwise don't
    if (okGotIt.size() > 0) {
      okGotIt.get(0).click();
    }

    //call find element with the category text
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
    return this;
  }

  public List<MobileElement> getProductByText(String text) {
    return driver
        .findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text + "\")"));
  }
}
