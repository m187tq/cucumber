package pages;

import helper.assertion.VerificationHelper;
import helper.common.action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CartPage extends BPage {

	@FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
	WebElement yourShoppingCart;

	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/button[1]")
	public WebElement quantityDeleteIcon;

	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/button[2]")
	public WebElement quantityAddIcon;

	@FindBy(css=".cart-remove.icon")
	public WebElement deleteAnItemFromCartIcon;

	@FindBy(css="#swal2-content")
	public WebElement confirmDeleteAnItemFromCartText;

	@FindBy(css=".swal2-confirm.button")
	public WebElement okToConfirmDeleteAnItemFromCartBtn;

	@FindBy(xpath="//body/div[6]/div[1]/div[3]/button[2]")
	public WebElement cancelConfirmDeleteAnItemFromCartBtn;

	@FindBy(xpath="//h3[contains(text(),'Your cart is empty')]")
	public WebElement emptyShoppingCartMsg;

	public CartPage() throws IOException {
		super();
	}


	public boolean verifyProduct(String prod) throws IOException {
		WebElement product = driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));
		return new VerificationHelper(driver).isDisplayed(product);
	}

	public void deleteProductFromShoppingCart() throws InterruptedException {
		// Delete all items from cart
		List<WebElement> deletes = (List<WebElement>) deleteAnItemFromCartIcon;
		Iterator<WebElement> itr = deletes.iterator();
		while (itr.hasNext()) {
			itr.next().click();
			Thread.sleep(2000);
		}
	}

	public void addProductFromShoppingCart() throws InterruptedException {
		// Add to all items from cart
		System.out.println("Deleting all products from cart..");
		List<WebElement> add = (List<WebElement>) quantityAddIcon;
		Iterator<WebElement> itr = add.iterator();
		while (itr.hasNext()) {
			itr.next().click();
			Thread.sleep(2000);
		}
	}

	public WebElement getYourShoppingCart() {
		return yourShoppingCart;
	}

	public void clickOnQuantityDeleteIcon() {
		action.click(driver, quantityDeleteIcon);
	}

	public void ClickOnQuantityAddIcon() {
		action.click(driver, quantityAddIcon);
	}

	public void clickOnDeleteAnItemFromCartIcon() {
		action.click(driver, deleteAnItemFromCartIcon);
	}

	public boolean isConfirmDeleteAnItemFromCartTextDisplayed() {
		return action.isDisplayed(driver, confirmDeleteAnItemFromCartText);
	}

	public void clickOnOkToConfirmDeleteAnItemFromCartBtn() {
		action.click(driver, okToConfirmDeleteAnItemFromCartBtn);
	}

	public void clickOnCancelConfirmDeleteAnItemFromCartBtn() {
		action.click(driver, cancelConfirmDeleteAnItemFromCartBtn);

	}

	public boolean isEmptyShoppingCartMsgDisplayed() {
		return action.isDisplayed(driver, emptyShoppingCartMsg);
	}

	public boolean verifyEmptyShoppingCartMessage() throws IOException {
		return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);
	}
}