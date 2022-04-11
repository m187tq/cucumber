package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardAndMouseEventUsingActionClassInSelenium2 {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void keyboardAndMouseEventUsingActionClassInSelenium() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
    	
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement firstname = driver.findElement(By.name("firstname"));
		WebElement lastname = driver.findElement(By.name("lastname"));
		WebElement email = driver.findElement(By.name("reg_email__"));
		WebElement pass = driver.findElement(By.name("reg_passwd__"));
		
		Actions action = new Actions(driver);
		action.keyDown(firstname, Keys.SHIFT).sendKeys("Pavan Kumar").keyUp(firstname,Keys.SHIFT).build().perform();
		action.keyDown(lastname, Keys.SHIFT).sendKeys("Bhimavarapu").keyUp(lastname,Keys.SHIFT).build().perform();
		action.keyDown(email, Keys.SHIFT).sendKeys("pavan@gmail.com").keyUp(email,Keys.SHIFT).build().perform();
		action.keyDown(pass, Keys.SHIFT).sendKeys("234567").keyUp(pass,Keys.SHIFT).build().perform();

	}
}
