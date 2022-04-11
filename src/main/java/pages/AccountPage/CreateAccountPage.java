package pages.AccountPage;

import actiondriver.Action;
import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class CreateAccountPage extends BPage {
    Action app = new Action();

    public CreateAccountPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    @CacheLookup
    public WebElement homeTxtLink;

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    @CacheLookup
    public WebElement createAccountTxtLink;

    @FindBy(xpath = "//h1[contains(text(),'New Account')]")
    @CacheLookup
    public WebElement formTitleTxt;

    @FindBy(css = "#FormField_1_input")
    @CacheLookup
    public WebElement emailAddressBox;

    @FindBy(css = "#FormField_2_input")
    @CacheLookup
    public WebElement passwordBox;

    @FindBy(css = "#FormField_3_input")
    @CacheLookup
    public WebElement comPasswordBox;

    @FindBy(xpath = "//*[@id=\"FormField_11_select\"]")
    @CacheLookup
    public WebElement countryDropdown;

    @FindBy(css = "#FormField_4_input")
    @CacheLookup
    public WebElement firstNameBox;

    @FindBy(css = "#FormField_5_input")
    @CacheLookup
    public WebElement lastNameBox;

    @FindBy(css = "#FormField_8_input")
    public WebElement addressLine1Box;

    @FindBy(css = "#FormField_9_input")
    @CacheLookup
    public WebElement addressLine2Box;

    @FindBy(css = "#FormField_6_input")
    public WebElement companyNameBox;

    @FindBy(css = "#FormField_10_input")
    @CacheLookup
    public WebElement SuburbOrCityBox;

    @FindBy(css = "#FormField_12_select")
    @CacheLookup
    public WebElement stateOrProvinceBox;

    @FindBy(css = "#FormField_13_input")
    @CacheLookup
    public WebElement zipPostcode;

    @FindBy(css = "#FormField_7_input")
    @CacheLookup
    public WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div/form/div[2]/input")
    @CacheLookup
    public WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id=\"FormField_1\"]/label/small")
    @CacheLookup
    public WebElement requiredFieldTxt;


    public boolean isHomeTxtLinkDisplayed() {
        return app.isDisplayed(driver, this.homeTxtLink);
    }

    public boolean isCreateAccountTxtLinkDisplayed() {
        return app.isDisplayed(driver, this.createAccountTxtLink);
    }

    public boolean isNewAccountTxtDisplayed() {
        return app.isDisplayed(driver, this.formTitleTxt);
    }


    public void enterEmailAddressBox() throws Exception {
        String email = System.currentTimeMillis() + "@gmail.com";
        sendKeysToWebElement(this.emailAddressBox, email);
    }

    public void enterPasswordBox(String password) throws Exception {
        sendKeysToWebElement(this.passwordBox, password);
        //app.type(this.passwordBox, password);
    }

    public void enterConfirmPasswordBox(String confirmPassword) throws Exception {
        sendKeysToWebElement(this.comPasswordBox, confirmPassword);
        //app.type(this.comPasswordBox, confirmPassword);
    }


    public void selectCountryDropdown(String chooseCountryDrop) throws Exception {
        app.moveToElement(driver, countryDropdown);
        app.selectByVisibleText(chooseCountryDrop, countryDropdown);
    }

    public void enterFirstNameBox(String firstName) {
        app.type(this.firstNameBox, firstName);
    }

    public void enterLastNameBox(String lastName) {
        app.type(this.lastNameBox, lastName);

    }

    public void enterAddressLine1Box(String addressLine1) {
        app.type(this.addressLine1Box, addressLine1);
    }

    public void enterAddressLine2Box(String addressLine2) {
        app.type(this.addressLine2Box, addressLine2);
    }

    public void enterCompanyNameBox(String companyName) {
        app.type(this.companyNameBox, companyName);
    }

    public void enterSuburbOrCityBox(String suburbOrCityName) {
        app.type(this.SuburbOrCityBox, suburbOrCityName);
    }

    public void enterStateOrProvinceBox(String StateOrProvince) {
        app.type(this.stateOrProvinceBox, StateOrProvince);
    }

    public void enterZipPostcodeBox(String postCode) {
        app.type(this.zipPostcode, postCode);
    }

    public void enterPhoneNumberBox(String phoneNum) {
        app.type(this.phoneNumber, phoneNum);
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
        javaScriptHelper.scrollDownVertically(this.createAccountBtn);
    }

    public boolean isRequiredFieldDisplayed() {
        return app.isDisplayed(driver, this.requiredFieldTxt);
    }

    public void clickOnCreateAccountBtn() throws IOException, InterruptedException {
        waitAndClickElement(this.createAccountBtn);
        app.WaitUntilWebElementIsVisible(account.continueShoppingBtn);

    }

    public void enterAllMandatoryDetailsToCreateAnAccount(
            String password,
            String comPassword,
            String chooseCountryDrop,
            String firstName,
            String lastName,
            String addressLine1,
            String addressLine2,
            String companyName,
            String suburbOrCityName,
            String StateOrProvince,
            String postCode,
            String phoneNum

    ) throws Exception {

        enterEmailAddressBox();
        enterPasswordBox(password);
        enterConfirmPasswordBox(comPassword);
        selectCountryDropdown(chooseCountryDrop);
        enterFirstNameBox(firstName);
        enterLastNameBox(lastName);
        enterAddressLine1Box(addressLine1);
        enterAddressLine2Box(addressLine2);
        enterCompanyNameBox(companyName);
        enterSuburbOrCityBox(suburbOrCityName);
        enterStateOrProvinceBox(StateOrProvince);
        enterZipPostcodeBox(postCode);
        enterPhoneNumberBox(phoneNum);
    }

}
