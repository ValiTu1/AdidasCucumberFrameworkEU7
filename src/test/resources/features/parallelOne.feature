Feature: parallel one functionality



    @parallel
  Scenario: Verify all the products exist in the products pages
    Then under "Phones" category user should be able to see the list of following products
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |
      | Nexus 6           |
      | Samsung galaxy s7 |
      | Iphone 6 32gb     |
      | Sony xperia z5    |
      | HTC One M9        |

    Then under "Laptops" category user should be able to see the list of following products
      | Sony vaio i5        |
      | Sony vaio i7        |
      | MacBook air         |
      | Dell i7 8gb         |
      | 2017 Dell 15.6 Inch |
      | MacBook Pro         |
    Then under "Monitors" category user should be able to see the list of following products
      | Apple monitor 24 |
      | ASUS Full HD     |