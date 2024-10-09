Feature: Login and verifying products

  Scenario: Login and verifying products
    Given I navigate to "login" page
    When I log in with username "standard_user" and password "secret_sauce"
      And "Products" page is open
      And I add "Sauce Labs Backpack" item to cart
      And I add "Sauce Labs Bike Light" item to cart
      And I verify that "2" items are added to cart
      And I remove "Sauce Labs Backpack" item from cart
      And I remove "Sauce Labs Bike Light" item from cart
      And I verify that there are no items in cart
      And I add "Sauce Labs Bolt T-Shirt" item to cart
      And I add "Sauce Labs Fleece Jacket" item to cart
      And I verify that "2" items are added to cart
      And I navigate to "cart" page
      And "Your Cart" page is open
      And I verify "Sauce Labs Bolt T-Shirt" item is displayed
      And I verify "Sauce Labs Fleece Jacket" item is displayed
      And I click on "Checkout" button
      And "Checkout: Your Information" page is open
      And I click on "Continue" button
      And I check if 3 errors are displayed
      And I check if "Error: First Name is required" error message is shown
      And I clear form from errors
      And I fill "John" in "First Name" field
      And I fill "Doe" in "Last Name" field
      And I fill "1000" in "Zip/Postal Code" field
      And I click on "Continue" button
      And "Checkout: Overview" page is open
      And I verify "Sauce Labs Bolt T-Shirt" item is displayed
      And I verify "Sauce Labs Fleece Jacket" item is displayed
      And I verify "finish" button is displayed
      And I verify "cancel" button is displayed
      And I verify if total price is "Total: $71.26"
      And I click on "Finish" button
      And "Checkout: Complete!" page is open
      And I verify "Thank you for your order!" success message is shown
    Then I Logout




