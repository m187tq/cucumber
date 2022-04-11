package pages.OrderPage;

import helper.common.action;
import helper.wait.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class OrderConfirmationPage extends BPage {
    private WebDriver driver;
    WaitHelper waitHelper;

    public OrderConfirmationPage() throws IOException {
        super();
    }

    //private final Logger log = LoggerHelper.getLogger(CreateAccountPage.class);
    //TopHomeMenuPage topHomeMenuPage;

   /* public OrderConfirmationPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(thankYouTxt, ObjectReader.reader.getExplicitWait());
        new BPage().getNavigationScreen(driver);
        //log.info("Order Status Page initiated....");
    }*/



    @FindBy(id="cart-print-link")
    public WebElement printIcon;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement summaryOrder;

    @FindBy(xpath="//h1[contains(text(),'Thank you')]")
    public WebElement thankYouTxt;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/section/p[1]")
    public WebElement yourOrderNumberTxt;

    @FindBy(xpath="//span[contains(text(),'Your Orders')]")
    public WebElement yourOrdersLinkTxt;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(css=".cart-priceItem.optimizedCheckout-contentPrimary.cart-priceItem--total")
    public WebElement totalAmountTxt;

    @FindBy(xpath="//h3[contains(text(),'Items')]")
    public WebElement totalItems;

    @FindBy(xpath="//span[contains(text(),'Shipping')]")
    public WebElement shippingPrice;

    @FindBy(xpath="//button[contains(text(),'Continue Shopping »')]")
    public WebElement continueShoppingBtn;

    public boolean isThankYouTxtDisplayed() {
        return action.isDisplayed(driver,thankYouTxt);
    }

    public boolean getYourOrderNumberTxt() {
        return action.isDisplayed(driver,yourOrderNumberTxt);
    }

    public boolean getYourOrdersLinkTxt() {
        return action.isDisplayed(driver,yourOrdersLinkTxt);
    }

    public boolean isOrderSummaryTxtDisplayedABoolean() {
        return action.isDisplayed(driver,orderSummaryTxt);
    }

    public boolean isTotalAmountTxtDisplayed() {
        return action.isDisplayed(driver,totalAmountTxt);
    }

    public boolean isTotalItemsDisplayed() {
        return action.isDisplayed(driver,totalItems);
    }

    public boolean isShippingPriceDisplayed() {
        return action.isDisplayed(driver,shippingPrice);
    }

    public OrderConfirmationPage clickOnContinueShoppingBtn() throws IOException {
        action.click(driver, continueShoppingBtn);
        return new OrderConfirmationPage();
    }


    public boolean isPrintIconEnabled() {
        return action.isEnabled(driver, printIcon);
    }

    public boolean isPrintIconDisplayed() {
        return action.isDisplayed(driver, printIcon);
    }

    public boolean isSummaryOrderDisplayed() {
        return action.isDisplayed(driver, summaryOrder);
    }

}
