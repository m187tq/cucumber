package steps.registration;

import actiondriver.Action;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.assertion.AssertionHelper;
import org.testng.Assert;
import pages.BPage;
import pages.HomePage.TopHomeMenuPage;
import utilities.data;
import utils.Constant;

import java.io.IOException;

public class RegistrationSteps extends BPage {
    Action app = new Action();

    public RegistrationSteps() throws IOException {
        super();
    }

    @Given("^user is on landing page$")
    public void user_is_on_landing_page() throws IOException, InterruptedException {
        topHomeMenuPage.launchUrl(Constant.HOME_URL);
        Assert.assertEquals(app.getCurrentURL(driver), data.expectedURL);
        Assert.assertEquals(app.getTitle(driver), data.expectedTitle);
        verifyTextContains(app.getCurrentURL(driver), data.expectedURL);
        verifyTextContains(app.getTitle(driver), data.expectedTitle);

        Assert.assertTrue(topHomeMenuPage.isLogoImageDisplayed());
        Assert.assertTrue(topHomeMenuPage.isLogoImageEnabled());
        Assert.assertTrue(topHomeMenuPage.isGiftCertificatesBtnDisplayed());
        AssertionHelper.updateTestStatus(topHomeMenuPage.isGiftCertificatesBtnDisplayed());

    }

    @When("^user clicks the Register link$")
    public TopHomeMenuPage user_clicks_the_Register_link() throws Exception {
        AssertionHelper.updateTestStatus(topHomeMenuPage.isOnSignLinkEnabled());
        topHomeMenuPage.moveAndClickOnRegisterLink();
        return new TopHomeMenuPage(driver);
    }

    @When("^user verifies create account page$")
    public void user_verifies_create_account_page() throws InterruptedException {
        Assert.assertEquals(app.getCurrentURL(driver), data.expCreateAccPageURL);
        Assert.assertEquals(app.getTitle(driver), data.expCreateAccPageTitle);
        register.isHomeTxtLinkDisplayed();
        register.isCreateAccountTxtLinkDisplayed();
        Assert.assertTrue(register.isNewAccountTxtDisplayed());
        Assert.assertTrue(register.isRequiredFieldDisplayed());
        AssertionHelper.updateTestStatus(register.isRequiredFieldDisplayed());
    }


    @When("^user enters all the requested personal Address and company details$")
    public void user_enters_all_the_requested_personal_Address_and_company_details() throws Exception {
        register.enterEmailAddressBox();
        register.enterPasswordBox(data.password);
        register.enterConfirmPasswordBox(data.confirmPassword);
        register.selectCountryDropdown(data.country);
        register.enterFirstNameBox(data.firstName);
        register.enterLastNameBox(data.lastName);
        register.enterAddressLine1Box(data.addressLine1);
        register.enterAddressLine2Box(data.addressLine2);
        register.enterCompanyNameBox(data.companyName);
        register.enterSuburbOrCityBox(data.suburbOrCityName);
        register.enterStateOrProvinceBox(data.StateOrProvince);
        register.enterZipPostcodeBox(data.postCode);
        register.enterPhoneNumberBox(data.phoneNum);
    }

    @When("^user clicks on create account button$")
    public void user_clicks_on_create_account_button() throws IOException, InterruptedException {
        register.clickOnCreateAccountBtn();
    }

    @Then("^user gets confirmation message$")
    public void user_gets_confirmation_message() throws InterruptedException {
        Assert.assertTrue(account.isYourAccountDetailsEmailedTxtDisplayed());
        Assert.assertTrue(account.isYourAccountHasBeenCreatedTxtDisplayed());
        AssertionHelper.updateTestStatus(account.isYourAccountHasBeenCreatedTxtDisplayed());

    }

    @Then("^user clicks on Continue Shipping button$")
    public void user_clicks_on_Continue_Shipping_button() throws Exception {
        Assert.assertTrue(account.isContinueShoppingBtnDisplayed());
        Assert.assertTrue(account.isContinueShoppingBtnEnabled());
        AssertionHelper.updateTestStatus(account.isContinueShoppingBtnEnabled());
        account.clickOnContinueShoppingBtn();
    }

    @Then("^user successfully created and login into new account$")
    public void user_successfully_created_and_login_into_new_account() throws InterruptedException {
        account.isYourAccountHasBeenCreatedTxtDisplayed();
        account.isYourAccountDetailsEmailedTxtDisplayed();
        Thread.sleep(2000);
    }

    @And("^user clicks on SignOut button at the top-right edge$")
    public void userClicksOnSignOutButtonAtThTopRightEdge() throws Exception {
        topHomeMenuPage.isSignOutLinkTxtEnabled();
        account.clickSignOutLinkTxt();
        Thread.sleep(2000);
    }

    @And("^user is back to login page and successfully logout$")
    public void userIsBackToLoginPageAndSuccessfullyLogout() throws InterruptedException {
        String result = loginPage.getLogOutAccountSuccessfullyTxt();
        Assert.assertEquals(result, "You've been logged out of your account successfully.");
        Assert.assertEquals(loginPage.getLogOutAccountSuccessfullyTxt(), "You've been logged out of your account successfully.");
        Assert.assertTrue(result.contains("logged out of your account successfully"));
        Assert.assertTrue(app.getCurrentURL(driver).contains(".mybigcommerce.com/login.php"));
        Assert.assertEquals(app.getTitle(driver), ("Cornerstone Demo - Sign in"));
    }

}
