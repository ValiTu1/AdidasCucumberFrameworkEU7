Feature: Adidas Order Placement Functionalities

  @parallel
  Scenario: Placing a successful order
    When User adds some "Sony vaio i5" from "Laptops"
    Then User adds some "Dell i7 8gb" from "Laptops"
    And user navigates to cart and removes "Dell i7 8gb"
    And use clicks on place order
    And User fills the form for order and clicks on pruchase button
    Then Order Id and order amount should be as expected


