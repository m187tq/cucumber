package pages.OrderPage;

import actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;
import java.util.List;

public class OrderStatusPage  extends BPage {

    Action app = new Action();

    public OrderStatusPage() throws IOException {
        super();
    }

    @FindBy(xpath="//span[contains(text(),'Home')]")
    public WebElement homeLinkTxt;

    @FindBy(xpath="//span[contains(text(),'Your Account')]")
    public WebElement yourAccountLinkTxt;

    @FindBy(xpath="//span[contains(text(),'Your Orders')]")
    public WebElement yourOrdersLinkTxt;

    @FindBy(xpath="//a[contains(text(),'Order #')]")
    public WebElement OrderNoTxt;

    @FindBy(xpath="//p[contains(text(),' products totaling $')]")
    public WebElement productsTotalingPriceTxt;

    @FindBy(css=".account-product-detail")
    public WebElement productDetailDateTxt;

    @FindBy(xpath="//h6[contains(text(),'Awaiting Fulfillment')]")
    public WebElement awaitingFulfillmentTxt;

    @FindBy(css=".breadcrumbs")
    public List<WebElement> allMenuLinksText;

    @FindBy(linkText="Orders")
    public WebElement ordersMenuLinkTxt;

    @FindBy(linkText="Returns")
    public WebElement returnsMenuLinkTxt;

    @FindBy(linkText="Messages")
    public WebElement messagesMenuLinkTxt;

    @FindBy(linkText="Addresses")
    public WebElement addressesMenuLinkTxt;

    @FindBy(linkText="Wish Lists")
    public WebElement wishListsMenuLinkTxt;

    @FindBy(linkText="Recently Viewed")
    public WebElement recentlyViewedLinkTxt;

    @FindBy(css=".page-heading")
    public WebElement orderTitleTxt;

    @FindBy(css=".navBar-section")
    public List<WebElement> navBarSection;

    @FindBy(css=".alertBox-column.alertBox-message")
    public WebElement anyOrdersAlertBoxMessage;


    public boolean isHomeLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.homeLinkTxt);
    }

    public boolean isYourAccountLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.yourAccountLinkTxt);
    }

    public boolean isYourOrdersLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.yourOrdersLinkTxt);
    }

    public  List<WebElement> areAllMenuLinksTextDisplayed() {

        return allMenuLinksText;
    }

    public boolean isOrdersMenuLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.ordersMenuLinkTxt);
    }

    public boolean isReturnsMenuLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.returnsMenuLinkTxt);

    }

    public boolean isMessagesMenuLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.messagesMenuLinkTxt);

    }

    public boolean isAddressesMenuLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.addressesMenuLinkTxt);

    }

    public boolean isWishListsMenuLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.wishListsMenuLinkTxt);

    }

    public boolean isRecentlyViewedLinkTxtDisplayed() {
        return app.isDisplayed(driver, this.recentlyViewedLinkTxt);

    }

    public boolean isOrderTitleTxtDisplayed() {
        return app.isDisplayed(driver, this.orderTitleTxt);
    }

    public List<WebElement> getNavBarSection() {
        return navBarSection;
    }

    public boolean isAnyOrdersAlertBoxMessageDisplayed() {
        return app.isDisplayed(driver, this.anyOrdersAlertBoxMessage);
    }


    public boolean isOrderNoTxtDisplayed() {
        return app.isDisplayed(driver, this.OrderNoTxt);
    }

    public boolean isProductsTotalingPriceTxtDisplayed() {
        return app.isDisplayed(driver, this.productsTotalingPriceTxt);
    }

    public boolean isProductDetailDateTxtDisplayed() {
        return app.isDisplayed(driver, this.productDetailDateTxt);
    }

    public boolean isAwaitingFulfillmentTxtDisplayed() {
        return app.isDisplayed(driver, this.awaitingFulfillmentTxt);
    }

}
