Feature: Product Listing
  Scenario: Listing a product by taking its picture
    Given I login using "google" as "Test Acct"
    And I want to sell a product
    When I take a picture of it
    And I select the category as "Everything Else"
    And I set following details for the product
    |name|condition|description|price|
    |Test|Used|rarely used|50.25|
    When I submit and approve my listing
    Then I should be able to view the listing "Test" under "Recent" of category "Everything Else"