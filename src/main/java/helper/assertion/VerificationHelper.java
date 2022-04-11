package helper.assertion;


import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BPage;

import java.io.IOException;


public class VerificationHelper extends BPage {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver) throws IOException {
        super();

    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed.." + element.getText());

            return true;
        } catch (Exception e) {
            log.error("element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present.." + element.getText());


            return false;
        } catch (Exception e) {
            log.error("element is not present..");

            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");

            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());

            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());

            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        log.info("page title is: " + driver.getTitle());
        return driver.getTitle();
    }


}
