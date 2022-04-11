package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage.AccountCreatedPage;
import pages.AccountPage.CreateAccountPage;
import pages.*;
import pages.CheckoutPage.*;
import pages.HomePage.FooterPage;
import pages.HomePage.MiddleHomeMenuPage;
import pages.HomePage.TopHomeMenuPage;
import pages.OrderPage.OrderConfirmationPage;
import pages.OrderPage.OrderStatusPage;
import pages.SearchPage.SearchPage;
import pages.SearchPage.SearchResultPage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static AccountCreatedPage account;
	public static CheckoutPage checkoutPage;
	public static CreateAccountPage register;
	public static FooterPage footerPage;
	public static LoginPage loginPage;
	public static MiddleHomeMenuPage middleHomeMenuPage;
	public static NavigationMenu navigationMenu;
	public static OrderConfirmationPage orderConfirmationPage;
	public static OrderStatusPage orderStatusPage;
	public static CheckoutPaymentPage checkoutPaymentPage;
	public static ProductCategoryPage productCategoryPage;
	public static SearchPage searchPage;
	public static SearchResultPage searchResultPage;
	public static ShippingReturnsPage shippingReturnsPage;
	public static CartPage cartPage;
	public static TopHomeMenuPage topHomeMenuPage;
	public static AddToCartPage addToCartPage;
	public static CheckoutBillingPage checkoutBillingPage;
	public static CheckoutCustomerPage checkoutCustomerPage;
	public static CheckoutShippingPage checkoutShippingPage;

	public WebDriver getDriver() {
		try {
			// Read Config
			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");

			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();

				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 30);
			topHomeMenuPage = PageFactory.initElements(driver, TopHomeMenuPage.class);
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			register = PageFactory.initElements(driver, CreateAccountPage.class);
			account = PageFactory.initElements(driver, AccountCreatedPage.class);
			checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
			footerPage = PageFactory.initElements(driver, FooterPage.class);
			middleHomeMenuPage = PageFactory.initElements(driver, MiddleHomeMenuPage.class);
			navigationMenu = PageFactory.initElements(driver, NavigationMenu.class);
			orderConfirmationPage = PageFactory.initElements(driver, OrderConfirmationPage.class);
			orderStatusPage = PageFactory.initElements(driver, OrderStatusPage.class);
			checkoutPaymentPage = PageFactory.initElements(driver, CheckoutPaymentPage.class);
			productCategoryPage = PageFactory.initElements(driver, ProductCategoryPage.class);
			searchPage = PageFactory.initElements(driver, SearchPage.class);
			searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
			shippingReturnsPage = PageFactory.initElements(driver, ShippingReturnsPage.class);
			cartPage = PageFactory.initElements(driver, CartPage.class);
			addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);
			checkoutBillingPage = PageFactory.initElements(driver, CheckoutBillingPage.class);
			checkoutCustomerPage = PageFactory.initElements(driver, CheckoutCustomerPage.class);
			checkoutShippingPage = PageFactory.initElements(driver, CheckoutShippingPage.class);
		}
		return driver;
	}
}
