Feature: parallel two scenario


    @parallel
  Scenario Outline: User checks if different laptops can be added to cart <differentLaptops>
    Then User adds some "<differentLaptops>" from "Laptops"
    Examples:
      |differentLaptops|
      | Sony vaio i5        |
      | Sony vaio i7        |
      | MacBook air         |