Feature: Verifying e-commerce Search to Order item functionality

  @e2e
  Scenario: user should be able to place an order

    Given user is on landing Page as "https://cornerstone-light-demo.mybigcommerce.com"
    When user clicks on search button
    And user enters product name as "Canvas Laundry Cart" on the search field box
    And user confirms search result items
    And user selects product based on make model location color size, delivery date
    And user adds products to the cart
    And user verifies the product item by item image unit price quantity and grand total in cart
    And user should be able to increase and remove item from cart
    And user clicks on the Check out button
    And user verifies Customer Shipping Address Method Order Summary Coupon and Total
    And user should be able to edit the cart
    And user clicks on continue button
    And user confirms Customer email address
    And user confirms Shipping Address Method Billing and total
    And user should be able to edit the cart, Shipping Method and Billing Address
    And user should be able to use the option to register or login or as a guest
    And user registers or login as a new user
    And user enters payment details
    And user clicks on Place order button
    And user is presented with a purchase confirmation page.
    And user gets an order number and thank message with first name displayed
    And user order confirmation page is populate with print icon, item image total price
    And user continue shipping button
    And user clicks on continue
    And user clicks on logout button
    Then user is back to home page

