package pages.CheckoutPage;


import helper.common.action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;
import pages.OrderPage.OrderConfirmationPage;

import java.io.IOException;

public class CheckoutPaymentPage extends BPage {

    public CheckoutPaymentPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//h2[contains(text(),'Payment')]")
    private WebElement paymentHeadingTxt;

    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;

    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;

    @FindBy(css = "#ccName")
    private WebElement ccNameBox;

    @FindBy(css = "#ccExpiry")
    private WebElement ccExpiryBox;

    @FindBy(css = "#ccCvv")
    private WebElement ccCvvBox;

    @FindBy(css = "#checkout-payment-continue")
    private WebElement placeOrderBtn;


    public boolean isPaymentHeadingTxtDisplayed() {
        return action.isDisplayed(driver, paymentHeadingTxt);
    }

    public boolean getTestGatewayTxt() {
        return action.isDisplayed(driver, testGatewayTxt);
    }
    public void getCcNumberBox(String ccNumber) {
        action.type(ccNumberBox, ccNumber);
    }

    public void getCcNameBox(String ccName) {
        action.type(ccNameBox, ccName);
    }

    public void getCcExpiryBox(String ccExpDate) {
        action.type(ccExpiryBox, ccExpDate);
    }

    public void getCcCvvBox(String cvv) {
        action.type(ccCvvBox, cvv);
    }

    public OrderConfirmationPage clickOnPlaceOrderBtn() throws IOException {
        action.click(driver, placeOrderBtn);
        return new OrderConfirmationPage();
    }


}
