package steps.login;

import actiondriver.Action;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.assertion.AssertionHelper;
import org.testng.Assert;
import utilities.data;
import utils.DriverFactory;

import java.io.IOException;

public class LoginSteps extends DriverFactory {
    Action app = new Action();

    public LoginSteps() throws IOException {
    }

    @Given("^User is on landing page as \"([^\"]*)\"$")
    public void user_is_on_landing_page_as(String arg1) {
        app.launchUrl(driver, arg1);
        Assert.assertTrue(topHomeMenuPage.isLogoImageDisplayed(), "Logo not displayed");
        topHomeMenuPage.isLogoImageEnabled();

    }

    @When("^User clicks on the Sign In link at top menu home page$")
    public void userClicksOnTheSignInLinkAtTopMenuHomePage() throws IOException {
        topHomeMenuPage.clickOnSignLink();
    }

    @And("^user should be on Login Page$")
    public void userShouldBeOnLoginPage() {

        Assert.assertEquals(app.getCurrentURL(driver), data.getExpLoginPageURL());
        Assert.assertEquals(app.getTitle(driver), data.getExpLoginPageTitle());
        Assert.assertTrue(loginPage.isHomeLinkDisplayed());
        Assert.assertTrue(loginPage.isLoginLinkDisplayed());
        Assert.assertTrue(loginPage.isSignInTxtDisplayed());

        //Assert.assertEquals(true, loginPage.homeLink.getText().contains("Home"));

    }


    @And("^User enters email address as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userEntersEmailAddressAsAndPasswordAs(String arg0, String arg1) {
        app.isEnabled(driver, loginPage.emailAddressBox);
        loginPage.enterEmailAddressBox(arg0);
        loginPage.enterPasswordBox(arg1);

    }


    @When("^User clicks on Sign In button$")
    public void user_clicks_on_Sign_In_button() throws IOException, InterruptedException {
        loginPage.clickOnSignInBtn();

    }

    @Then("^User should be presented with a successful validation text message$")
    public void userShouldBePresentedWithASuccessfulValidationTextMessage() throws InterruptedException {

        AssertionHelper.updateTestStatus(orderStatusPage.isAwaitingFulfillmentTxtDisplayed());
        orderStatusPage.isProductDetailDateTxtDisplayed();
        AssertionHelper.updateTestStatus(orderStatusPage.isYourAccountLinkTxtDisplayed());
        orderStatusPage.isYourOrdersLinkTxtDisplayed();
        //orderStatusPage.isHomeLinkTxtDisplayed();
        Assert.assertTrue(orderStatusPage.isHomeLinkTxtDisplayed(), "HomeLink not displayed");

        orderStatusPage.isMessagesMenuLinkTxtDisplayed();
        AssertionHelper.updateTestStatus(orderStatusPage.isOrderTitleTxtDisplayed());
        orderStatusPage.isAddressesMenuLinkTxtDisplayed();
        orderStatusPage.isOrderNoTxtDisplayed();
        AssertionHelper.updateTestStatus(orderStatusPage.isOrderNoTxtDisplayed());
        orderStatusPage.isOrdersMenuLinkTxtDisplayed();
        AssertionHelper.updateTestStatus(orderStatusPage.isReturnsMenuLinkTxtDisplayed());
    }

    @Then("^User clicks Sign Out button$")
    public void user_clicks_Sign_Out_button() throws Exception {
        topHomeMenuPage.clickOnSignOutLinkTxt();


    }


}
