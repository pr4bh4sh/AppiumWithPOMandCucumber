package com.assignment.appium.pages;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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
        getElementByTextFromList(gplusAccountNames, gmailUserName).click();
        return new HomePage(driver);
    }


}
