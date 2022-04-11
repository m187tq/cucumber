package pages.SearchPage;

import helper.common.action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class SearchPage extends BPage {

    @FindBy(xpath = "//*[@id=\"quick-search-expand\"]")
    public WebElement searchTxtLink;

    @FindBy(xpath = "//*[@id='nav-quick-search']")
    public WebElement searchBox;


    public SearchPage() throws IOException {
        super();
    }

    public void clickOnSearchLinkAndEnterProductNameOnSearchBox(String productName) {
        action.click(driver, this.searchTxtLink);
        action.fluentWait(driver,this.searchBox, 10);
        action.type(this.searchBox, productName);
    }

    public void clickOnSearchBox() {
        action.fluentWait(driver,this.searchTxtLink, 10);
        action.click(driver, this.searchBox);
        action.fluentWait(driver,this.searchBox, 10);
    }


}
