package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ShippingReturnsPage  extends BPage {

    /*private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(ShippingReturnsPage.class);
    WaitHelper waitHelper*/;

    /*public ShippingReturnsPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(shippingReturnsHeadingTxt, ObjectReader.reader.getExplicitWait());
        log.info("ShippingReturnsPage object created");
        new BPage().getNavigationScreen(driver);
    }*/

    @FindBy(xpath = "//h1[contains(text(),'Shipping & Returns')]")
    private WebElement shippingReturnsHeadingTxt;


    public ShippingReturnsPage() throws IOException {
        super();
    }
}
