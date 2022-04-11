package pages;

import actiondriver.Action;
import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage.CreateAccountPage;

import java.io.IOException;

public class LoginPage extends BPage {

    @FindBy(css = "#login_email")
    public WebElement emailAddressBox;
    Action app = new Action();
    WebDriverWait wait;


    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/nav/ol/li[1]/a/span")
    @CacheLookup
    WebElement homeLink;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/nav/ol/li[2]/a/span")
    @CacheLookup
    WebElement loginLink;

    @FindBy(css = ".page-heading")
    @CacheLookup
    WebElement signInTxt;

    // login Elements //
    @FindBy(css = "#login_pass")
    @CacheLookup
    WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div/form/div[3]/input")
    @CacheLookup
    WebElement signInBtn;

    @FindBy(css = ".forgot-password")
    @CacheLookup
    WebElement forgotPassword;

    @FindBy(xpath = "//h2[contains(text(),'New Customer?')]")
    @CacheLookup
    WebElement newCustomerTxt;


    // Create Account Elements //
    @FindBy(css = ".new-customer-intro")
    @CacheLookup
    WebElement CreateAccountWithUsAndYouBeAbleTo;

    @FindBy(css = "new-customer-fact-list")
    @CacheLookup
    WebElement newCustomerFactList;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div/div/div/div[2]/a/button")
    @CacheLookup
    WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id=\"alertBox-message-text\"]")
    @CacheLookup
    public WebElement youBeenLoggedOutOfYourAccountSuccessfully;


    public LoginPage(WebDriver driver) throws IOException {
        super();

        this.wait = new WebDriverWait(driver, 30);

    }

    public boolean isHomeLinkDisplayed() {
        return app.isDisplayed(driver, this.homeLink);
    }

    public boolean isLoginLinkDisplayed() {
        return app.isDisplayed(driver, this.loginLink);
    }

    public boolean isSignInTxtDisplayed() {
        return app.isDisplayed(driver, this.signInTxt);
    }

    public void enterEmailAddressBox(String EmailAddress) {
        app.type(this.emailAddressBox, EmailAddress);
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
        javaScriptHelper.scrollDownVertically(passwordBox);

    }

    public void enterPasswordBox(String Password) {
        app.type(this.passwordBox, Password);
    }

    public void clickOnForgotPassword() {
        app.click(driver, this.forgotPassword);
    }

    public boolean isForgotPasswordTxtLinkDisplayed() {
        return app.isDisplayed(driver, this.forgotPassword);
    }

    public LoginPage clickOnSignInBtn() throws IOException, InterruptedException {
        System.out.println("clicking on sign In button...");
        app.click(driver, signInBtn);
        app.WaitUntilWebElementIsVisible(orderStatusPage.OrderNoTxt);
        return new LoginPage(driver);
    }

    public CreateAccountPage clickOnCreateAccountBtn() throws IOException {
        app.click(driver, this.createAccountBtn);
        return new CreateAccountPage();
    }

    public LoginPage login(String EmailAddress, String Password) throws IOException {
        topHomeMenuPage.clickOnSignLink();
        enterEmailAddressBox(EmailAddress);
        enterPasswordBox(Password);
        return new LoginPage(driver);
    }

    public boolean isCreateAccountWithUsAndYouBeAbleToDisplayed() {
        return app.isDisplayed(driver, CreateAccountWithUsAndYouBeAbleTo);
    }

    public boolean isNewCustomerFactListDisplayed() {
        return app.isDisplayed(driver, newCustomerFactList);
    }

    public String getLogOutAccountSuccessfullyTxt() throws InterruptedException {
        String result = youBeenLoggedOutOfYourAccountSuccessfully.getText();
        return result;
    }

}
