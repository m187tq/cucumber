package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitRealTime {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		WebDriverWait mywait=new WebDriverWait(driver,10000);
		
		driver.get("http://www.expedia.com");
		
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("SFO");
		Thread.sleep(2000);
		driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("NYC");
		driver.findElement(By.id("flight-departing-hp-flight")).sendKeys("10/10/2018");
		
		WebElement returnDate = driver.findElement(By.id("flight-returning-hp-flight"));
		returnDate.clear();
		returnDate.sendKeys("10/15/2018");
		
		driver.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[7]/label/button")).click();

		WebElement element=mywait.until(ExpectedConditions.elementToBeClickable(By.id("stopFilter_stops-0")));
		element.click();
		
		driver.quit();

	}

}
