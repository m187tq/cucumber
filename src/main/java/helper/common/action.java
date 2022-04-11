package helper.common;

import com.google.common.collect.Ordering;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class action {
    protected JavascriptExecutor js;
    public static WebDriver driver;
    public static WebDriverWait wait;
    private String screenshotName;
    public static Logger log = LoggerHelper.getLogger(action.class);


    public static void click(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();
    }

    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    public static boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();

            flag = true;
        } catch (Exception e) {

            flag = false;
        } finally {
            if (flag) {
                //log.info("Successfully Found element as :" + ele.getText());
            } else {
                log.info("Unable to locate element at");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {

                log.info("The element is Displayed as:  " + "<" + ele.getText() + ">");
            } else {
                log.info("The element is not Displayed");
            }
        } else {
            log.info("Not displayed ");
            log.error("Not displayed: " + ele.getText());
            log.info("Not displayed: " + ele.getText());
        }
        return flag;
    }

    public static boolean isSelected(WebDriver driver, WebElement ele) {

        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                log.info("The element is Selected:  " + "<" + ele + ">");
            } else {
                log.info("The element is not Selected");
            }
        } else {
            log.info("Not selected ");
        }
        return flag;
    }

    public static boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                log.info("The element is Enabled: " + "<" + ele.getText() + ">");
                log.info("The element is " + ele.getText() + " Enabled");
            } else {
                log.info("The element is not Enabled: " + "<" + ele.getText() + ">");
                log.info("The element is not Enabled");
            }
        } else {
            log.info("Not Enabled ");
        }
        return flag;
    }

    public static boolean type(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            log.info("Entered text :" + text);
            log.info("Entered text :" + text);
            flag = true;
        } catch (Exception e) {
            log.info("Location Not found");
            log.info("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                log.info("Successfully entered value");
            } else {
                log.info("Unable to enter value");
            }

        }
        return flag;
    }

    public static boolean selectBySendKeys(String value, WebElement ele) {
        boolean flag = false;
        try {
            ele.sendKeys(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Select value from the DropDown" + value);
            } else {
                log.info("Not Selected value from the DropDown");

            }
        }
    }

    public static boolean selectByIndex(WebElement element, int index) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Option selected by Index: " + "<" + index + ">");
            } else {
                log.info("Option not selected by Index: " + "<" + index + ">");
            }
        }
    }

    public static boolean selectByValue(WebElement element, String value) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Option selected by Value:" + "<" + value + ">");
            } else {
                log.info("Option not selected by Value");
            }
        }
    }

    public static boolean selectByVisibleText(String visibletext, WebElement ele) {

        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Option selected by VisibleText: " + "<" + visibletext + ">");
            } else {
                log.error("Option selected by VisibleText : " + "<" + visibletext + ">");
            }
        }
    }

    public static boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);

            flag = true;

        } catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                log.info("Click Action is performed");
            } else if (!flag) {
                log.info("Click Action is not performed");
            }
        }
        return flag;
    }

    public static boolean switchToFrameByIndex(WebDriver driver, int index) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Frame with index \"" + index + "\" is selected");
            } else {
                log.info("Frame with index \"" + index + "\" is not selected");

            }
        }
    }

    /**
     * This method switch the to frame using frame ID.
     *
     * @param idValue : Frame ID wish to switch
     */

    public static boolean switchToFrameById(WebDriver driver, String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                log.info("Frame with Id \"" + idValue + "\" is selected");

            } else {
                log.info("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame Name.
     *
     * @param nameValue : Frame Name wish to switch
     */

    public static boolean switchToFrameByName(WebDriver driver, String nameValue) {

        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Frame with Name \"" + nameValue + "\" is selected");

            } else if (!flag) {
                log.info("Frame with Name \"" + nameValue + "\" is not selected");

            }
        }
    }

    public static boolean switchToDefaultFrame(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().defaultContent();
            flag = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                log.info("SelectFrame: Frame with Name is selected ");

            } else if (!flag) {

                log.info("SelectFrame: The Frame is not selected ");
            }
        }
    }

    public static void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                log.info(" MouserOver Action is performed on: " + element.getText());

            } else {

                log.info("MouseOver action is not performed on");
            }
        }
    }

    public static boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).build().perform();
            flag = true;

            log.info("MouseOver action is not performed on");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
            return true;

        } catch (Exception e) {
            return false;
        } finally {

            log.info("MouseOver action performed on");

            if (flag) {
                log.info("MouseOver action performed on");
            } else {

            }

        }
    }

    public static boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(source, x, y).build().perform();
            Thread.sleep(5000);
            flag = true;
            return true;

        } catch (Exception e) {

            return false;

        } finally {
            if (flag) {

                log.info("Draggable Action is performed on \"" + source + "\"");
            } else if (!flag) {
                log.info("Draggable action is not performed on \"" + source + "\"");

            }
        }
    }

    public static boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop(source, target).perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("DragAndDrop Action is performed");
            } else if (!flag) {
                log.info("DragAndDrop Action is not performed");
            }
        }
    }

    public static boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
            Thread.sleep(5000);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Slider Action is performed");
            } else {
                log.info("Slider Action is not performed");

            }
        }
    }

    public static boolean rightClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            flag = true;
            return true;
            // driver.findElement(by1).sendKeys(Keys.DOWN);
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("RightClick Action is performed");
            } else {
                log.info("RightClick Action is not performed");
            }
        }
    }

    public static boolean switchToNewWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object popup[] = s.toArray();
            driver.switchTo().window(popup[1].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                log.info("Window is Navigated with title");
            } else {
                log.info("The Window with title: is not Selected");
            }
        }
    }

    public static boolean switchToOldWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object popup[] = s.toArray();
            driver.switchTo().window(popup[0].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                log.info("Focus navigated to the window with title");
            } else {
                log.info("The Window with title: is not Selected");
            }
        }
    }

    /**
     * Verify alert present or not
     *
     * @return: Boolean (True: If alert preset, False: If no alert)
     */

    public static boolean Alert(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            if (!presentFlag) {
                log.info("The Alert is handled successfully");
            } else {
                log.info("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    public static boolean launchUrl(WebDriver driver, String url) {
        boolean flag = false;
        try {
            driver.navigate().to(url);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Successfully launched \"" + url + "\"");
            } else {
                log.info("Failed to launch \"" + url + "\"");
            }
        }
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }   // catch
    }

    public static String getTitle(WebDriver driver) {
        boolean flag = false;

        String text = driver.getTitle();
        if (flag) {
            log.info("Title of the page is: \"" + text + "\"");
        }
        return text;
    }

    public static String getCurrentURL(WebDriver driver) {
        Logger log = LoggerHelper.getLogger(action.class);
        boolean flag = false;

        String text = driver.getCurrentUrl();

        if (flag) {
            log.info("Current URL is: \"" + text + "\"");
            System.out.print("Current URL is: \"" + text + "\"");
        }

        return text;
    }

    public static boolean click1(WebElement locator, String locatorName) {
        boolean flag = false;
        try {
            locator.click();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Able to click on \"" + locatorName + "\"");
            } else {
                log.info("Click Unable to click on \"" + locatorName + "\"");
            }
        }

    }

    public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
        }
    }

    public static void implicitWait(WebDriver driver, int timeOut) {

        Logger log = LoggerHelper.getLogger(action.class);
        log.info("implicitlyWait for 10 timeOut");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
        log.info("page Loading for TimeOut...........");
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
    }

    public static String getCurrentTime() {
        Logger log = LoggerHelper.getLogger(action.class);

        log.info("CurrentTime performed....");
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }

    public static boolean isPresent(WebDriver webdriver, By selector) {
        try {
            webdriver.findElement(selector);
        } catch (NoSuchElementException e) {
            // if element not exist return false
            return false;
        }
        return true;
    }

    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
        return element;
    }

    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
        return element;
    }

    public static void waitForTitle(WebDriver driver, String title, int waitInterval) {
        (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
    }

    /***
     * Sleep for specified number of milliseconds
     * @param msec
     * @param info
     */
    public static void sleep(long msec, String info) {
        if (info != null) {
            log.info("Waiting " + (msec * .001) + " seconds :: " + info);
        }
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * Sleep for specified number of milliseconds
     * @param msec
     */
    public static void sleep(long msec) {
        sleep(msec, null);
    }

    /***
     *
     * @param methodName
     * @param browserName
     * @return
     */
    public static String getScreenshotName(String methodName, String browserName) {
        String localDateTime = getCurrentDateTime();
        StringBuilder name = new StringBuilder().append(browserName)
                .append("_")
                .append(methodName)
                .append("_")
                .append(localDateTime)
                .append(".png");
        return name.toString();
    }

    /***
     * Get Random number within specified range
     * @param min
     * @param max
     * @return a random number
     */
    public static int getRandomNumber(int min, int max) {
        int diff = max - min;
        int randomNum = (int) (min + Math.random() * diff);
        log.info("Random Number :: " + randomNum +
                " within range :: " + min + " and :: " + max);

        return randomNum;
    }
    /***
     * Get Random number within specified range
     * @param number
     * @return a random number
     */
    public static int getRandomNumber(int number) {
        return getRandomNumber(1, number);
    }

    /***
     * Get random unique string with specified length
     * @param length
     * @return a unique string
     */
    public static String getRandomString(int length) {
        StringBuilder sbuilder = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sbuilder.append(chars.charAt(index));
        }
        String randomString = sbuilder.toString();
        log.info("Random string with length :: "
                + length + " is :: " + randomString);

        return randomString;
    }

    /***
     * Get random unique string with 10 characters length
     * @return a unique string
     */
    public static String getRandomString() {
        return getRandomString(10);
    }

    /***
     * Get simple date as string in the specified format
     * @param format MMddyy MMddyyyy
     * @return date as string type
     */
    public static String getSimpleDateFormat(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        String formattedDate = formatter.format(date);
        log.info("Date with format :: "
                + format + " :: " + formattedDate);
        return formattedDate;
    }

    /***
     * Get simple date time as string
     * @return date time as string type
     */
    public static String getCurrentDateTime() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "MM/dd/yyyy HH:mm:ss");
        String date = formatter.format(currentDate.getTime()).replace("/", "_");
        date = date.replace(":", "_");
        log.info("Date and Time :: " + date);
        return date;
    }

    /**
     * Checks whether actual String contains expected string and prints both in log
     *
     * @param actualText - actual Text picked up from application under Test
     * @param expText    - expected Text to be checked with actual text
     * @return boolean result
     */
    public static boolean verifyTextContains(String actualText, String expText) {
        if (actualText.toLowerCase().contains(expText.toLowerCase())) {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Contains Verified !!!");
            return true;
        } else {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification DOES NOT Contains !!!");
            ;

            return false;
        }

    }

    /**
     * Checks whether actual string matches with expected string and prints both in log
     *
     * @param actualText - actual Text picked up from application under Test
     * @param expText    - expected Text to be matched with actual text
     * @return
     */
    public static boolean verifyTextMatch(String actualText, String expText) {
        if (actualText.equals(expText)) {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification MATCHED !!!");
            return true;
        } else {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification DOES NOT MATCH !!!");
            return false;
        }
    }

    /**
     * Verify actual list contains items of the expected list
     *
     * @param actList
     * @param expList
     * @return
     */
    public static Boolean verifyListContains(List<String> actList, List<String> expList) {
        int expListSize = expList.size();
        for (int i = 0; i < expListSize; i++) {
            if (!actList.contains(expList.get(i))) {
                return false;
            }
        }
        log.info("Actual List Contains Expected List !!!");
        return true;
    }

    /***
     * Verify actual list matches expected list
     * @param actList
     * @param expList
     * @return
     */
    public static Boolean verifyListMatch(List<String> actList, List<String> expList) {
        boolean found = false;
        int actListSize = actList.size();
        int expListSize = expList.size();
        if (actListSize != expListSize) {
            return false;
        }

        for (int i = 0; i < actListSize; i++) {
            found = false;
            for (int j = 0; j < expListSize; j++) {
                if (verifyTextMatch(actList.get(i), expList.get(j))) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            log.info("Actual List Matches Expected List !!!");
            return true;
        } else {
            log.info("Actual List DOES NOT Match Expected List !!!");
            return false;
        }
    }

    /**
     * Verifies item is present in the list
     *
     * @param actList
     * @param item
     * @return boolean result
     */
    public static Boolean verifyItemPresentInList(List<String> actList, String item) {
        int actListSize = actList.size();
        for (int i = 0; i < actListSize; i++) {
            if (!actList.contains(item)) {
                log.info("Item is NOT present in List !!!");
                return false;
            }
        }
        log.info("Item is present in List !!!");
        return true;
    }

    /**
     * Verify if list is in ascending order
     *
     * @param list
     * @return boolean result
     */
    public static boolean isListAscendingOrder(List<Long> list) {
        boolean sorted = Ordering.natural().isOrdered(list);
        return sorted;
    }

    public boolean mouseHoverByJavaScript(WebElement ele) {
        boolean flag = false;
        try {
            WebElement mo = ele;
            String javaScript = "var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                    + "arguments[0].dispatchEvent(evObj);";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(javaScript, mo);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("MouseOver Action is performed on:  " + "<" + ele + ">");
            } else {
                log.info("MouseOver Action is not performed on:  " + "<" + ele + ">");
            }
        }
    }

    public static boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        boolean flag = false;
        try {
            Set<String> windowList = driver.getWindowHandles();

            String[] array = windowList.toArray(new String[0]);

            driver.switchTo().window(array[count - 1]);

            if (driver.getTitle().contains(windowTitle)) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        } catch (Exception e) {
            //flag = true;
            return false;
        } finally {
            if (flag) {
                log.info("Navigated to the window with title");
            } else {
                log.info("The Window with title is not Selected");
            }
        }
    }

    public static int getColumnCount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();

        //log.info(columns.size());
        for (WebElement column : columns) {

            System.out.print(column.getText());
            System.out.print("|");
        }
        return a;
    }

    public static int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a = rows.size() - 1;
        return a;
    }

    public static void explicitWait(WebDriver driver, WebElement element, int timeOut) {
        Logger log = LoggerHelper.getLogger(action.class);
        log.info("explicitWait for timeOut");
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}


