package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomInZoomOutInSelenium {

	WebDriver driver;

	@Test
	public void zoomInZoomOutInSelenium() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		// zoom out by 40%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='40%'");
		
		Thread.sleep(3000);
		// zoom out by 100%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
		
	}
}
