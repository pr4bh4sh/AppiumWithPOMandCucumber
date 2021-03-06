package com.assignment.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.List;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

  @AndroidFindBy(id = "gplus_signin_button")
  private MobileElement gplusSigninButton;

  @AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
  private List<MobileElement> gplusAccountNames;


  public LoginPage(AppiumDriver<MobileElement> driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public HomePage loginWithGoogle(String gmailUserName) {
    gplusSigninButton.click();
    try {
      //Timeout should be used
      Thread.sleep(2000); //wait for google Sign in popup
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    getElementByTextFromList(gplusAccountNames, gmailUserName).click();
    return new HomePage(driver);
  }


}
