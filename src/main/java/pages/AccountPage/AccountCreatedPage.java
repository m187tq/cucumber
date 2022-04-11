package pages.AccountPage;

import actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class AccountCreatedPage extends BPage {
    @FindBy(css = ".page-heading")
    @CacheLookup
    public WebElement yourAccountHasBeenCreatedTxt;
    @FindBy(xpath = "//body/main[@id='main-content']/div[1]/section[1]/div[1]/p[1]")
    @CacheLookup
    public WebElement yourAccountDetailsEmailedTxt;
    @FindBy(linkText = "Continue Shopping")
    @CacheLookup
    public WebElement continueShoppingBtn;
    @FindBy(xpath = "//header/nav[1]/ul[1]/li[4]/a[2]")
    @CacheLookup
    public WebElement signOutLinkTxt;
    Action app = new Action();

    public AccountCreatedPage(WebDriver driver) throws IOException {
        super();
    }

    public boolean isYourAccountHasBeenCreatedTxtDisplayed() {
        return app.isDisplayed(driver, yourAccountHasBeenCreatedTxt);
    }


    public boolean isYourAccountDetailsEmailedTxtDisplayed() {
        return app.isDisplayed(driver, yourAccountDetailsEmailedTxt);
    }

    public boolean isContinueShoppingBtnEnabled() {
        return app.isDisplayed(driver, continueShoppingBtn);
    }

    public boolean isContinueShoppingBtnDisplayed() {
        return app.isDisplayed(driver, continueShoppingBtn);
    }

    public AccountCreatedPage clickOnContinueShoppingBtn() throws Exception {
        app.JSClick(driver, continueShoppingBtn);
        //Thread.sleep(1000);
        return new AccountCreatedPage(driver);
    }

    public void clickSignOutLinkTxt() throws Exception {
        app.actionMoveAndClick(this.signOutLinkTxt);
        //Thread.sleep(1000);
        new CreateAccountPage();

    }

}
