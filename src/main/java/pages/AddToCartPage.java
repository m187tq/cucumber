package pages;

import helper.common.action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.OrderPage.OrderConfirmationPage;

import java.io.IOException;

public class AddToCartPage extends BPage {

    public AddToCartPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div/section/ul/li[2]")
    public WebElement addToCartByIndex;

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(name="group_1")
    private WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
    private WebElement addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public void enterQuantity(String quantity1) throws Throwable {
        action.type(quantity, quantity1);
    }
    public void selectSize(String size1) throws Throwable {
        action.selectByVisibleText(size1, size);
    }
    public void clickOnAddToCart() throws Throwable {
        action.click(getDriver(), addToCartBtn);
    }
    public boolean validateAddToCart() throws Throwable {
        action.fluentWait(getDriver(), addToCartMessage, 10);
        return action.isDisplayed(getDriver(), addToCartMessage);
    }
    public OrderConfirmationPage clickOnCheckOut() throws Throwable {
        action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
        action.JSClick(getDriver(), proceedToCheckOutBtn);
        return new OrderConfirmationPage();
    }
    public void ClickOnAddToCartByIndex() {
        action.moveToElement(driver,addToCartByIndex);
        action.JSClick(driver,addToCartByIndex);
    }
    public void setAddToCartByIndex(WebElement addToCartByIndex) {
        this.addToCartByIndex = addToCartByIndex;
    }

}
