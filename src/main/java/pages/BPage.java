package pages;

import com.cucumber.listener.Reporter;
import com.google.common.collect.Ordering;
import helper.browserConfiguration.config.ObjectReader;
import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BPage extends DriverFactory {
	protected static WebDriverWait wait;
	protected static JavascriptExecutor jsExecutor;
	protected static JavaScriptHelper javaScriptHelper;
	private static String screenshotName;

	public BPage() throws IOException {
		this.wait = new WebDriverWait(driver, 15);
		jsExecutor = ((JavascriptExecutor) driver);
		javaScriptHelper = new JavaScriptHelper(driver);
		//waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(topHomeMenuPage.logoImage, ObjectReader.reader.getExplicitWait());
	}

	/**********************************************************************************
	 **CLICK METHODS
	 * @throws IOException 
	 **********************************************************************************/
	public void waitAndClickElement(WebElement element) throws InterruptedException, IOException {
		Logger log = LoggerHelper.getLogger(BPage.class);
		boolean clicked = false;
		int attempts = 0;
		while (!clicked && attempts < 10) {
			try {
				this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				log.info("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
				clicked = true;
			} catch (Exception e) {
				log.info("Unable to wait and click on WebElement, Exception: " + e.getMessage());
				Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
			}
			attempts++;
		}
	}

	public void waitAndClickElementsUsingByLocator(By by) throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;
		while (!clicked && attempts < 10) {
			try {
				this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
				log.info("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
				clicked = true;
			} catch (Exception e) {
				log.info("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
				Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<"+ by.toString() + ">");
			}
			attempts++;
		}
	}

	public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) {
		Wait<WebDriver> tempWait = new WebDriverWait(driver, 30);
		try {
			tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
			list.sendKeys(textToSearchFor);
			list.sendKeys(Keys.ENTER);
			log.info("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
		} catch (Exception e) {
			log.info("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
			Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
		}
	}

	public void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver driver, int timeout) {
		try {
			final WebDriverWait customWait = new WebDriverWait(driver, timeout);
			customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
			locator.click();
			log.info("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">"+ ", using a custom Timeout of: " + timeout);
		} catch (Exception e) {
			log.info("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
			Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
		}
	}

	 /**********************************************************************************
	 **ACTION METHODS
	 **********************************************************************************/

	public void actionMoveAndClick(WebElement element) throws Exception {
		Actions ob = new Actions(driver);
		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			ob.moveToElement(element).click().build().perform();
			log.info("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement elementToClick = element;
			Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
			if (elementPresent == true) {
				ob.moveToElement(elementToClick).click().build().perform();
				log.info("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
			}
		} catch (Exception e) {
			log.info("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
			Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
		}
	}

	public void actionMoveAndClickByLocator(By element) throws Exception {
		Actions ob = new Actions(driver);
		try {
			Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			if (elementPresent == true) {
				WebElement elementToClick = driver.findElement(element);
				ob.moveToElement(elementToClick).click().build().perform();
				log.info("Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
			}
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement elementToClick = driver.findElement(element);
			ob.moveToElement(elementToClick).click().build().perform();
			log.info("(Stale Exception) - Action moved and clicked on the following element, using By locator: "+ "<" + element.toString() + ">");
		} catch (Exception e) {
			log.info("Unable to Action Move and Click on the WebElement using by locator: " + "<" + element.toString() + ">");
			Assert.fail("Unable to Action Move and Click on the WebElement using by locator, Exception: " + e.getMessage());
		}
	}

	/**********************************************************************************
	 **SEND KEYS METHODS /
	 **********************************************************************************/
	public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
		try {
			this.WaitUntilWebElementIsVisible(element);
			element.clear();
			element.sendKeys(textToSend);
			log.info("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
		} catch (Exception e) {
			log.info("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
			Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
		}
	}

	/**********************************************************************************
	 **JS METHODS & JS SCROLL
	 **********************************************************************************/
	public void scrollToElementByWebElementLocator(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -400)");
			log.info("Succesfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
		} catch (Exception e) {
			log.info("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
			Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
		}
	}

	public void jsPageScroll(int numb1, int numb2) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
			log.info("Succesfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
		} catch (Exception e) {
			log.info("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
			Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
		}
	}

	public void waitAndClickElementUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			js.executeScript("arguments[0].click();", element);
			log.info("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement staleElement = element;
			Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
			if (elementPresent == true) {
				js.executeScript("arguments[0].click();", elementPresent);
				log.info("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
			}
		} catch (NoSuchElementException e) {
			log.info("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
			Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
		}
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	/**********************************************************************************
	 **WAIT METHODS
	 **********************************************************************************/
	public boolean WaitUntilWebElementIsVisible(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOf(element));
			log.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			log.info("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			log.info("Element is visible using By locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			log.info("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean isElementClickable(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("WebElement is clickable using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			log.info("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
			return false;
		}
	}

	public boolean waitUntilPreLoadElementDisappears(By element) {
		return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	/**********************************************************************************
	 **PAGE METHODS
	 **********************************************************************************/
	Logger log = LoggerHelper.getLogger(BPage.class);
	public BPage loadUrl(String url) throws Exception {
		driver.get(url);
		return new BPage();
	}

	public String getCurrentUrl() {
		Logger log = LoggerHelper.getLogger(BPage.class);
		try {
			String url = driver.getCurrentUrl();
			log.info("Found(Got) the following URL: " + url);
			return url;
		} catch (Exception e) {
			log.info("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
			return e.getMessage();
		}
	}

	public String waitForSpecificPage(String urlToWaitFor) {
		Logger log = LoggerHelper.getLogger(BPage.class);
		try {
			String url = driver.getCurrentUrl();
			this.wait.until(ExpectedConditions.urlMatches(urlToWaitFor));
			log.info("The current URL was: " + url + ", " + "navigated and waited for the following URL: "+ urlToWaitFor);
			return urlToWaitFor;
		} catch (Exception e) {
			log.info("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
			return e.getMessage();
		}
	}

	/**********************************************************************************
	 **ALERT & POPUPS METHODS
	 **********************************************************************************/

	public void closePopups(By locator) throws InterruptedException {
		Logger log = LoggerHelper.getLogger(BPage.class);
		try {
			List<WebElement> elements = this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			for (WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					this.wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
					log.info("The popup has been closed Successfully!");
				}
			}
		} catch (Exception e) {
			log.info("Exception! - could not close the popup!, Exception: " + e.toString());
			throw (e);
		}
	}

	public boolean checkPopupIsVisible() {
		Logger log = LoggerHelper.getLogger(BPage.class);
		try {
			@SuppressWarnings("unused")
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			log.info("A popup has been found!");
			return true;
		} catch (Exception e) {
			System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
		}
		return false;
	}

	public boolean isAlertPresent() {
		Logger log = LoggerHelper.getLogger(BPage.class);
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void closeAlertPopupBox() throws AWTException, InterruptedException {
		Logger log = LoggerHelper.getLogger(BPage.class);
		try {
			Alert alert = this.wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (UnhandledAlertException f) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			log.info("Unable to close the popup");
			Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
		}
	}
	
	/********************EXTENT REPORT***********************************************/

	public static String returnDateStamp(String fileExtension) {
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
		return date;
	}
	
	public static void captureScreenshot() throws IOException, InterruptedException {
		Logger log = LoggerHelper.getLogger(BPage.class);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		screenshotName = returnDateStamp(".jpg");
	
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName));
		
		Reporter.addStepLog("Taking a screenshot!");
		Reporter.addStepLog("<br>");
		Reporter.addStepLog("<a target=\"_blank\", href="+ returnScreenshotName() + "><img src="+ returnScreenshotName()+ " height=200 width=300></img></a>");
	}
	
	public static String returnScreenshotName() {
		return (System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName).toString();
	}
	
	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			
			while((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			
		} finally {
			is.close();
			os.close();
		}
	}
	
	public static void copyLatestExtentReport() throws IOException {
		Logger log = LoggerHelper.getLogger(BPage.class);
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_");
		File source = new File(System.getProperty("user.dir") + "\\output\\report.html");
		File dest = new File(System.getProperty("user.dir") + "\\output\\" + date.toString() + ".html");
		copyFileUsingStream(source, dest);
	}

	public static void sleep(long msec, String info) {
		Logger log = LoggerHelper.getLogger(BPage.class);
		if (info != null) {
			log.info("Waiting " + (msec * .001) + " seconds :: " + info);
		}
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleep(long msec) {
		sleep(msec, null);
	}

	public static String getScreenshotName(String methodName, String browserName) {
		Logger log = LoggerHelper.getLogger(BPage.class);
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
		Logger log = LoggerHelper.getLogger(BPage.class);
		int diff = max - min;
		int randomNum = (int)(min + Math.random() * diff);
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
		Logger log = LoggerHelper.getLogger(BPage.class);
		StringBuilder sbuilder = new StringBuilder();
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i<length; i++) {
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
	public static String getSimpleDateFormat(String format){
		Logger log = LoggerHelper.getLogger(BPage.class);
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
	public static String getCurrentDateTime(){
		Logger log = LoggerHelper.getLogger(BPage.class);
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
	 * @param actualText - actual Text picked up from application under Test
	 * @param expText - expected Text to be checked with actual text
	 * @return boolean result
	 */
	public static boolean verifyTextContains(String actualText, String expText) {
		Logger log = LoggerHelper.getLogger(BPage.class);
		if (actualText.toLowerCase().contains(expText.toLowerCase())){
			log.info("Actual Text From Web Application UI   --> : "+ actualText);
			log.info("Expected Text From Web Application UI --> : "+ expText);
			log.info("### Verification Contains !!!");
			return true;
		}
		else{
			log.info("Actual Text From Web Application UI   --> : "+ actualText);
			log.info("Expected Text From Web Application UI --> : "+ expText);
			log.info("### Verification DOES NOT Contains !!!");
			return false;
		}

	}

	/**
	 * Checks whether actual string matches with expected string and prints both in log
	 * @param actualText - actual Text picked up from application under Test
	 * @param expText - expected Text to be matched with actual text
	 * @return
	 */
	public static boolean verifyTextMatch(String actualText, String expText) {
		Logger log = LoggerHelper.getLogger(BPage.class);
		if (actualText.equals(expText)){
			log.info("Actual Text From Web Application UI   --> : "+ actualText);
			log.info("Expected Text From Web Application UI --> : "+ expText);
			log.info("### Verification MATCHED !!!");
			return true;
		}else{
			log.info("Actual Text From Web Application UI   --> : "+ actualText);
			log.info("Expected Text From Web Application UI --> : "+ expText);
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
		Logger log = LoggerHelper.getLogger(BPage.class);
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
		Logger log = LoggerHelper.getLogger(BPage.class);
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
		}
		else {
			log.info("Actual List DOES NOT Match Expected List !!!");
			return false;
		}
	}

	/**
	 * Verifies item is present in the list
	 * @param actList
	 * @param item
	 * @return boolean result
	 */
	public static Boolean verifyItemPresentInList(List<String> actList, String item){
		Logger log = LoggerHelper.getLogger(BPage.class);
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
	 * @param list
	 * @return boolean result
	 */
	public static boolean isListAscendingOrder(List<Long> list){
		Logger log = LoggerHelper.getLogger(BPage.class);
		boolean sorted = Ordering.natural().isOrdered(list);
		return sorted;
	}

}
