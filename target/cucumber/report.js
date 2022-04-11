$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Registration/Register.feature");
formatter.feature({
  "line": 1,
  "name": "Verification of Registration functionality",
  "description": "",
  "id": "verification-of-registration-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 20312531699,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "user should be able to Register with valid credentials",
  "description": "",
  "id": "verification-of-registration-functionality;user-should-be-able-to-register-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@RegistrationValidcredentials"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is on landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks the Register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user verifies create account page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user enters all the requested personal Address and company details",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks on create account button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user gets confirmation message",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user clicks on Continue Shipping button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user successfully created and login into new account",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "user clicks on SignOut button at the top-right edge",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "user is back to login page and successfully logout",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrationSteps.user_is_on_landing_page()"
});
formatter.result({
  "duration": 5476523800,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_clicks_the_Register_link()"
});
formatter.result({
  "duration": 1962623200,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_verifies_create_account_page()"
});
formatter.result({
  "duration": 983267299,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_enters_all_the_requested_personal_Address_and_company_details()"
});
formatter.result({
  "duration": 3235901000,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_clicks_on_create_account_button()"
});
formatter.result({
  "duration": 2563692800,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_gets_confirmation_message()"
});
formatter.result({
  "duration": 547578400,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_clicks_on_Continue_Shipping_button()"
});
formatter.result({
  "duration": 385216599,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.user_successfully_created_and_login_into_new_account()"
});
formatter.result({
  "duration": 2338273801,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.userClicksOnSignOutButtonAtThTopRightEdge()"
});
formatter.result({
  "duration": 4403619400,
  "status": "passed"
});
formatter.match({
  "location": "RegistrationSteps.userIsBackToLoginPageAndSuccessfullyLogout()"
});
formatter.result({
  "duration": 143224099,
  "status": "passed"
});
formatter.after({
  "duration": 3217453100,
  "status": "passed"
});
});