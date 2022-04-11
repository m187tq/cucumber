package pages.CheckoutPage;


import helper.common.action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class CheckoutPage extends BPage {


public CheckoutPage() throws IOException {
    super();
}

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement customerHeadingTxt;

    @FindBy(css=".product-column.product-figure")
    public WebElement itemImage;

    @FindBy(xpath="//button[contains(text(),'Sign Out')]")
    public WebElement signOutBtn;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/div/ol/li[3]/div/a/div[3]/button")
    public WebElement billingAddrEditBtn;

    @FindBy(xpath="//body/div[@id='checkout-app']/div[1]/div[1]/div[1]/div[1]/ol[1]/li[2]/div[1]/a[1]/div[3]/button[1]")
    public WebElement ShippingAddressEditBtn;

    @FindBy(css=".checkout-step.optimizedCheckout-checkoutStep.checkout-step--customer")
    public WebElement fullCustomerHeadingTxt;

    @FindBy(id="addressToggle")
    public WebElement shippingAddressTxt;

    @FindBy(xpath="//label[contains(text(),'My billing address is the same as my shipping addr')]")
    public WebElement MyBillingAddressSameShippingAddressTxt;

    @FindBy(css="//h2[contains(text(),'Customer')]")
    public WebElement shippingMethodTxt;

    @FindBy(css="#checkout-shipping-continue")
    public WebElement customerContinueBtn;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(css="#cart-edit-link")
    public WebElement editCartLinkTxt;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/aside/article/section[3]/div/div")
    public WebElement totalPrice;

    public boolean isCustomerHeadingTxtDisplayed() {
        return action.isDisplayed(driver, customerHeadingTxt);
    }

    public boolean isItemImageDisplayed() {
        return action.isDisplayed(driver, itemImage);
    }

    public void clickOnSignOutBtn() {
        action.click(driver, signOutBtn);

    }

    public boolean isSignOutBtnEnabled() {
        return action.isEnabled(driver, signOutBtn);

    }

    public void clickOnBillingAddrEditBtn() {
        action.click(driver, billingAddrEditBtn);

    }

    public void isBillingAddrEditBtnEnabled() {
        action.isEnabled(driver, billingAddrEditBtn);
    }

    public void isBillingAddrEditBtnDisplayed() {
        action.isDisplayed(driver, billingAddrEditBtn);
    }

    public boolean isShippingAddrEditBtnDisplayed() {
        return action.isDisplayed(driver, ShippingAddressEditBtn);
    }

    public boolean isFullCustomerHeadingTxtDisplayed() {
        return action.isDisplayed(driver, fullCustomerHeadingTxt);

    }
    public boolean isShippingAddressTxtDisplayed() {
        return action.isDisplayed(driver, shippingAddressTxt);
    }
    public boolean isMyBillingAddressSameShippingAddressTxtDisplayed() {
        return action.isDisplayed(driver, MyBillingAddressSameShippingAddressTxt);
    }
    public boolean isShippingMethodTxtDisplayed() {
        return action.isDisplayed(driver, shippingMethodTxt);
    }

    public void clickOnCustomerContinueBtn() {
        action.click(driver,customerContinueBtn);
    }
    public boolean isOrderSummaryTxtDisplayed() {
        return action.isDisplayed(driver, orderSummaryTxt);

    }
    public void clickOnEditCartLinkTxt() {
        action.click(driver, editCartLinkTxt);
    }

    public boolean isEditCartLinkTxtDisplayed() {
       return action.isDisplayed(driver, editCartLinkTxt);
    }

    public boolean isTotalPriceDisplay() {
       return action.isDisplayed(driver,totalPrice);
    }


}
