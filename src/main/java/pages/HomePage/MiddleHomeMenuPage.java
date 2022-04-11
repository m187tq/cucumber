package pages.HomePage;

import helper.common.action;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MiddleHomeMenuPage extends BPage {
    private final Logger log = LoggerHelper.getLogger(MiddleHomeMenuPage.class);

    public MiddleHomeMenuPage(final WebDriver driver) throws IOException {
        super();
    }

    @FindBy(xpath = "//*[@id=\"menu\"]/nav/ul[1]")
    public List<WebElement> subMenuList;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[1]/a[1]")
    public WebElement gardenDropdownBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[2]/a[1]")
    public WebElement shopAllBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[3]/a[1])")
    public WebElement kitchenBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[4]/a[1])")
    public WebElement publications;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[5]/a[1])")
    public WebElement utilityBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[6]/a[1])")
    public WebElement journalBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[7]/a[1])")
    public WebElement ourStoryBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[8]/a[1])")
    public WebElement contactUsBtn;

    @FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[9]/a[1])")
    public WebElement shippingAndReturnBtn;


    public boolean getSubMenuList() {
        return action.isDisplayed(driver, (WebElement) subMenuList);
    }

    public void clickOnSubMenuListName(String subMenuListName) {
        List<WebElement> subMenuListNames = subMenuList;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(subMenuListName)) {
                log.info("selecting date as: " + subMenuListName);
                c.click();
                break;
            }
        }
    }

    public void clickOnGardenDropdownBtn() {
        action.click(driver, gardenDropdownBtn);
    }

    public void clickOnShopAllBtn() {
        action.click(driver, shopAllBtn);
    }

    public void clickOnKitchenBtn() {
        action.click(driver, kitchenBtn);
    }

    public void clickOnPublications() {
        action.click(driver, publications);
    }

    public void clickOnUtilityBtn() {
        action.click(driver, utilityBtn);
    }

    public void clickOnJournalBtn() {
        action.click(driver, journalBtn);
    }

    public void clickOnOurStoryBtn() {
        action.click(driver, ourStoryBtn);
    }

    public void clickOnContactUsBtn() {
        action.click(driver, contactUsBtn);
    }

    public void clickOnShippingAndReturnBtn() {
        action.click(driver, shippingAndReturnBtn);
    }

}

