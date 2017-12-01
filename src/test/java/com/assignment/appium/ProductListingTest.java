package com.assignment.appium;

import com.assignment.appium.commons.Filters;
import com.assignment.appium.commons.ProductCondition;
import com.assignment.appium.factory.DriverFactory;
import com.assignment.appium.listners.ExtentTestListener;
import com.assignment.appium.pages.AddProductToSellPage;
import com.assignment.appium.pages.HomePage;
import com.assignment.appium.pages.LoginPage;
import com.assignment.appium.pages.ProductCategoryHomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@Listeners(ExtentTestListener.class)
public class ProductListingTest {

    private AppiumDriver<MobileElement> appiumDriver;

    @BeforeClass
    public void setUp() {
        appiumDriver = DriverFactory.getAndroidDriver();
    }

    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }

    @Test
    public void verifyProductListing() {
        HomePage homePage = new LoginPage(appiumDriver).loginWithGoogle("Test Acct");
        AddProductToSellPage productToSellPage = homePage.navigateToSellItem().takePhotoFromCamera().captureImage().acceptImage();
        productToSellPage.selectCategory("Everything Else");
        productToSellPage.addProductDetails("Test", ProductCondition.Used, "test");
        productToSellPage.setPrice(50.25);
        productToSellPage.publishProduct();
        ProductCategoryHomePage productCategoryHomePage = homePage.openBrowseSection().openProductCategory("Everything Else");
        productCategoryHomePage.selectFilter(Filters.RECENT);
        Assert.assertNotNull(productCategoryHomePage.getProductByText("Test"));
    }
}
