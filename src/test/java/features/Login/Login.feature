Feature: Login Page

  @LoginValidcredentials
  Scenario Outline: User should be able to login with valid credentials
    Given User is on landing page as "<Url>"
    When User clicks on the Sign In link at top menu home page
    And user should be on Login Page
    And User enters email address as "<EmailAddress>" and password as "<Password>"
    When User clicks on Sign In button
    Then User should be presented with a successful validation text message
    And User clicks Sign Out button

    Examples:
      | Url                                              | EmailAddress          | Password     |
      | https://cornerstone-light-demo.mybigcommerce.com | servertools@naver.com | Manchester1  |
#      | https://cornerstone-light-demo.mybigcommerce.com | servertools@naver.com | Manchester11 |
