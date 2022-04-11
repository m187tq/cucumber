package steps.E2E;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

import java.io.IOException;

public class e2eSteps extends DriverFactory {

    @Given("^user is on landing Page as \"([^\"]*)\"$")
    public void user_is_on_landing_Page_as(String arg1) throws IOException {
        topHomeMenuPage.goToUrl(arg1);
    }

    @When("^user clicks on search button$")
    public void user_clicks_on_search_button() {

    }

    @When("^user enters product name as \"([^\"]*)\" on the search field box$")
    public void user_enters_product_name_as_on_the_search_field_box(String arg1) {
        searchPage.clickOnSearchLinkAndEnterProductNameOnSearchBox(arg1);
    }

    @When("^user confirms search result items$")
    public void user_confirms_search_result_items() {
        searchResultPage.isQuickSearchResultDisplayed();
        searchResultPage.isQuickSearchResultCloseBarEnabled();
        searchResultPage.verifyListOfProductItemSearchResultAndClickOnProducts("Canvas Laundry Cart");
    }

    @When("^user selects product based on make model location color size, delivery date$")
    public void user_selects_product_based_on_make_model_location_color_size_delivery_date() {

    }

    @When("^user adds products to the cart$")
    public void user_adds_products_to_the_cart() {

    }

    @When("^user verifies the product item by item image unit price quantity and grand total in cart$")
    public void user_verifies_the_product_item_by_item_image_unit_price_quantity_and_grand_total_in_cart() {

    }

    @When("^user should be able to increase and remove item from cart$")
    public void user_should_be_able_to_increase_and_remove_item_from_cart() {

    }

    @When("^user clicks on the Check out button$")
    public void user_clicks_on_the_Check_out_button() {

    }

    @When("^user verifies Customer Shipping Address Method Order Summary Coupon and Total$")
    public void user_verifies_Customer_Shipping_Address_Method_Order_Summary_Coupon_and_Total() {

    }

    @When("^user should be able to edit the cart$")
    public void user_should_be_able_to_edit_the_cart() {

    }

    @When("^user clicks on continue button$")
    public void user_clicks_on_continue_button() {

    }

    @When("^user confirms Customer email address$")
    public void user_confirms_Customer_email_address() {

    }

    @When("^user confirms Shipping Address Method Billing and total$")
    public void user_confirms_Shipping_Address_Method_Billing_and_total() {

    }

    @When("^user should be able to edit the cart, Shipping Method and Billing Address$")
    public void user_should_be_able_to_edit_the_cart_Shipping_Method_and_Billing_Address() {

    }

    @When("^user should be able to use the option to register or login or as a guest$")
    public void user_should_be_able_to_use_the_option_to_register_or_login_or_as_a_guest() {

    }

    @When("^user registers or login as a new user$")
    public void user_registers_or_login_as_a_new_user() {

    }

    @When("^user enters payment details$")
    public void user_enters_payment_details() {

    }

    @When("^user clicks on Place order button$")
    public void user_clicks_on_Place_order_button() {

    }

    @When("^user is presented with a purchase confirmation page\\.$")
    public void user_is_presented_with_a_purchase_confirmation_page() {

    }

    @When("^user gets an order number and thank message with first name displayed$")
    public void user_gets_an_order_number_and_thank_message_with_first_name_displayed() {

    }

    @When("^user order confirmation page is populate with print icon, item image total price$")
    public void user_order_confirmation_page_is_populate_with_print_icon_item_image_total_price() {

    }

    @When("^user continue shipping button$")
    public void user_continue_shipping_button() {

    }

    @When("^user clicks on continue$")
    public void user_clicks_on_continue() {

    }

    @When("^user clicks on logout button$")
    public void user_clicks_on_logout_button() {

    }

    @Then("^user is back to home page$")
    public void user_is_back_to_home_page() {

    }




}
