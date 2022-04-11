package seleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceException1 {

	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.freecrm.com");
		
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("pavanoltraining");
		
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("xyz");
		
		driver.navigate().refresh();
		
		try
		{
		username.sendKeys("pavanoltraining");
		}
		catch(StaleElementReferenceException e)
		{
			username=driver.findElement(By.name("username"));
			username.sendKeys("pavanoltraining");
			
		}
	
		
	}
}
