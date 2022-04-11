package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Allwaits {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://newtours.demoaut.com/");

		//only for browser page loading
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		
		//for all the elements -- global wait -- implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//explicit wait:
		//used for the specific element
		WebElement username = driver.findElement(By.name("userName"));
		sendKeys(driver, username, 5, "mercury");
		
		WebElement pwd = driver.findElement(By.name("password"));
		sendKeys(driver, pwd, 5, "mercury");
		
		WebElement signin = driver.findElement(By.name("login"));
		clickOn(driver, signin, 3);
		
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static String getElementText(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	
}
