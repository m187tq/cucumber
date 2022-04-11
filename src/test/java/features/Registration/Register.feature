Feature: Verification of Registration functionality

  @RegistrationValidcredentials
  Scenario: user should be able to Register with valid credentials
    Given user is on landing page
    When user clicks the Register link
    And user verifies create account page
    And user enters all the requested personal Address and company details
    And user clicks on create account button
    Then user gets confirmation message
    And user clicks on Continue Shipping button
    And user successfully created and login into new account
    And user clicks on SignOut button at the top-right edge
    And user is back to login page and successfully logout
