package com.assignment.appium.pages;

import com.assignment.appium.commons.ProductCondition;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddProductToSellPage extends BasePage {

  @AndroidFindBy(id = "button_capture")
  private MobileElement captureButton;

  @AndroidFindBy(id = "button_filter_forward")
  private MobileElement acceptImage;


  @AndroidFindBy(className = "android.widget.ListView")
  private MobileElement categoryContainer;

  @AndroidFindBy(id = "spinner_category")
  private MobileElement categorySpinner;

  @AndroidFindBy(id = "text_item_details")
  private MobileElement textItemDetails;

  @AndroidFindBy(id = "text_title")
  private MobileElement textTitleInput;

  @AndroidFindBy(id = "text_product_condition")
  private MobileElement productConditionButton;

  @AndroidFindBy(id = "text_description")
  private MobileElement descriptionTextInput;

  @AndroidFindBy(id = "text_sell_price")
  private MobileElement priceInput;

  @AndroidFindBy(id = "action_submit")
  private MobileElement submitButton;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"New\")")
  private MobileElement newRadio;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Used\")")
  private MobileElement usedRadio;
  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"List it!\")")
  private MobileElement listIt;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Make Changes\")")
  private MobileElement makeChanges;

  public AddProductToSellPage(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

  }

  public AddProductToSellPage captureImage() {
    captureButton.click();
    return this;
  }

  public AddProductToSellPage acceptImage() {
    acceptImage.click();
    return this;
  }

  public void selectCategory(String category) {
    categorySpinner.click();
    scrollInsideElementByText(categoryContainer, "Everything Else").click();
  }

  public void addProductDetails(String name, ProductCondition condition, String details) {
    textItemDetails.click();
    textTitleInput.sendKeys(name);
    switch (condition) {
      case New:
        productConditionButton.click();
        newRadio.click();
        break;
      case Used:
        productConditionButton.click();
        newRadio.click();
        break;
      case NONE:
        break;
    }
    if (details.length() > 0) {
      descriptionTextInput.click();
      descriptionTextInput.sendKeys(details);
    }
    submitButton.click();
  }

  public void setPrice(double priceInSDG) {
    priceInput.sendKeys(String.valueOf(priceInSDG));
  }

  public HomePage publishProduct() {
    submitButton.click();
    listIt.click();
    return new HomePage(driver);
  }

}

