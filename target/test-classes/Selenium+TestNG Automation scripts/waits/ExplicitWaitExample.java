package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		WebDriverWait mywait=new WebDriverWait(driver,10000);
		
		driver.get("http://newtours.demoaut.com/");
		
		
		WebElement uname=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
		uname.sendKeys("mercury");
		
		WebElement password=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("mercury");
		
		

	}

}
