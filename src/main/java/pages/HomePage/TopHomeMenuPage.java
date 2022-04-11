package pages.HomePage;

import actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountPage.CreateAccountPage;
import pages.BPage;
import pages.LoginPage;
import utils.Constant;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TopHomeMenuPage extends BPage {
    Action app = new Action();

    public TopHomeMenuPage(WebDriver driver) throws IOException {
        super();


    }

    public final String Url = Constant.HOME_URL;
    @FindBy(css = ".header-logo-text")
    WebElement logoImage;

    @FindBy(css = ".navUser-action")
    @CacheLookup
    List<WebElement> topMenuList;

    @FindBy(xpath = "/html/body/header/nav/ul/li[3]/a")
    @CacheLookup
    WebElement giftCertificatesLinkTxt;

    @FindBy(xpath = "//header/nav[1]/ul[1]/li[4]/a[1]")
    @CacheLookup
    WebElement signInLinkTxt;

    @FindBy(xpath = "//header/nav[1]/ul[1]/li[4]/a[2]")
    @CacheLookup
    WebElement registerLinkTxt;

    @FindBy(xpath = "//header/nav[1]/ul[1]/li[4]/a[2]")
    @CacheLookup
    public WebElement signOutLinkTxt;

    @FindBy(css = ".navUser-item-cartLabel")
    @CacheLookup
    WebElement cartLinkTxt;

    @FindBy(css = ".button")
    @CacheLookup
    WebElement alertMiddlePageBtn;

    public String goToUrl(String arg1) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return Url;
    }

    public LoginPage launchUrl(String arg1) throws IOException {
        app.launchUrl(driver, arg1);
        return new LoginPage(driver);

    }

    public boolean isSignOutLinkTxtEnabled() throws InterruptedException {
        Thread.sleep(2000);
        return app.isEnabled(driver, this.signOutLinkTxt);
    }

    public void clickOnSignOutLinkTxt() throws Exception {
        app.explicitWait(driver, signOutLinkTxt,15);
        app.JSClick(driver, this.signOutLinkTxt);
        Thread.sleep(2000);
    }

    public boolean isLogoImageDisplayed() {
        return app.isDisplayed(driver, this.logoImage);
    }

    public boolean isLogoImageEnabled() {
        return wait.until((d) -> this.logoImage.isEnabled());
    }

    public Boolean topMenuList() {
        wait.until(ExpectedConditions.invisibilityOfAllElements(topMenuList));
        return wait.until((d) -> this.topMenuList.size() >= 4);
    }

    public Boolean isGiftCertificatesBtnDisplayed() {
        return wait.until((d) -> this.giftCertificatesLinkTxt.isDisplayed());

    }

    public void clickOnSignLink() throws IOException {
        app.click(driver, this.signInLinkTxt);
        app.WaitUntilWebElementIsVisible(register.homeTxtLink);
        new CreateAccountPage();
    }

    public boolean isOnSignLinkEnabled() throws IOException {
        return app.isEnabled(driver, this.signInLinkTxt);

    }

    public void moveAndClickOnRegisterLink() throws Exception {
        app.actionMoveAndClick(this.registerLinkTxt);
        app.WaitUntilWebElementIsVisible(register.homeTxtLink);
        new CreateAccountPage();
    }

    public void clickOnCartBtn(){
         app.click(driver, this.cartLinkTxt);
    }

}
