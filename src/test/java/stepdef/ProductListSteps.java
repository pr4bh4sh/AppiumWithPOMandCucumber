package stepdef;

import com.assignment.appium.commons.Filters;
import com.assignment.appium.commons.ProductCondition;
import com.assignment.appium.factory.DriverFactory;
import com.assignment.appium.logger.Log;
import com.assignment.appium.pages.AddProductToSellPage;
import com.assignment.appium.pages.HomePage;
import com.assignment.appium.pages.LoginPage;
import com.assignment.appium.pages.ProductCategoryHomePage;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.Map;
import org.testng.Assert;


public class ProductListSteps implements En {

  private AppiumDriver<MobileElement> appiumDriver;
  private HomePage homePage;
  private AddProductToSellPage addProductToSellPage;

  public ProductListSteps() {
    AppiumDriver appiumDriver = DriverFactory.getAndroidDriver();
    Given("^I login using \"([^\"]*)\" as \"([^\"]*)\"$", (String with, String userName) -> {
      Log.INFO("Trying to login with " + with);
      switch (with) {
        case "google":
          homePage = new LoginPage(appiumDriver).loginWithGoogle(userName);
          break;
        default:
          System.out.println("test");
          break;
      }
    });

    Given("^I want to sell a product$", () -> {
      homePage = new HomePage(appiumDriver).navigateToSellItem();
    });

    When("^I take a picture of it$", () -> {
      homePage.takePhotoFromCamera();
      addProductToSellPage = new AddProductToSellPage(appiumDriver).captureImage().acceptImage();
    });

    When("^I select the category as \"([^\"]*)\"$", (String category) -> {
      addProductToSellPage.selectCategory(category);
    });

    When("^I set following details for the product$", (DataTable table) -> {
      Map details = table.asMaps(String.class, String.class).get(0);
      addProductToSellPage.addProductDetails(details.get("name").toString(),
          ProductCondition.valueOf(details.get("condition").toString().toUpperCase()),
          details.get("description").toString());
      addProductToSellPage.setPrice(details.get("price").toString());
    });

    When("^I submit and approve my listing$", () -> {
      addProductToSellPage.publishProduct();
    });

    Then(
        "^I should be able to view the listing \"([^\"]*)\" under \"([^\"]*)\" of category \"([^\"]*)\"$",
        (String productName, String filter, String category) -> {
          ProductCategoryHomePage productCategoryHomePage = homePage.openBrowseSection()
              .openProductCategory(category);
          productCategoryHomePage.selectFilter(Filters.RECENT);
          Assert.assertNotNull(productCategoryHomePage.getProductByText(productName));
        });


  }
}
