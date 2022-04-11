package pages.HomePage;

import helper.common.action;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FooterPage extends BPage {
    /*WebDriver driver;
    WaitHelper waitHelper;
    WebDriverWait wait;*/
    private final Logger log = LoggerHelper.getLogger(FooterPage.class);

    /*public FooterPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(navigate, ObjectReader.reader.getExplicitWait());
        PageFactory.initElements(driver, this);
    }*/


    public FooterPage() throws IOException {
        super();
    }

    @FindBy(css = ".footer-info-heading")
    public List<WebElement> footerTxtHearing;

    @FindBy(xpath = "//h3[contains(text(),'Navigate')]")
    public WebElement navigate;

    @FindBy(xpath = "//h3[contains(text(),'Categories')]")
    public WebElement categories;

    @FindBy(xpath = "//h3[contains(text(),'Popular Brands')]")
    public WebElement popularBrands;

    @FindBy(xpath = "//h3[contains(text(),'Info')]")
    public WebElement info;

    @FindBy(xpath = "//h3[contains(text(),'Subscribe to our newsletter')]")
    public WebElement subscribeNewsletter;

    @FindBy(css = "#nl_email")
    public WebElement subscribeEmailBox;

    @FindBy(xpath = "/html/body/footer/div[1]/section/article[5]/form/fieldset/div/div/input[2]")
    public WebElement subscribeBtn;


    public void  clickOnFooterHearingTextName(String textName) {
       wait.until(ExpectedConditions.invisibilityOfAllElements(footerTxtHearing));
        List<WebElement> textNames = footerTxtHearing;
        Iterator<WebElement> itr = textNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(textName)) {
                log.info("selecting date as: "+textName);
                c.click();
                break;
            }
        }
    }

    public boolean getNavigateTxt() {
        return action.isDisplayed(driver, navigate);
    }

    public Boolean isCategoriesTxtDisplayed() {
        return action.isDisplayed(driver, categories);
    }

    public boolean isPopularBrandsTxtVisible() {
        return action.isDisplayed(driver, popularBrands);

    }

    public boolean isInfoTxtVisible() {
        return action.isDisplayed(driver, info);
    }

    public boolean isSubscribeNewsletterTxtDisplayed() {
        return action.isDisplayed(driver, subscribeNewsletter);
    }

    public void isSubscribeEmailBoxDisplayed(String keyword) {
        action.type(subscribeEmailBox,keyword);
    }

    public void clickOnSubscribeBtn() {
        wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
        action.click(driver, subscribeBtn);
    }


}
