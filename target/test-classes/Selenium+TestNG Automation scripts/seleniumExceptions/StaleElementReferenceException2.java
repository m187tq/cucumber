package seleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StaleElementReferenceException2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://www.pavantestingtools.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	
		WebElement link=driver.findElement(By.xpath("//*[@id=\"site-navigationpbt\"]/div/ul/li[11]/a"));
		
		link.click();  //Navigated to the next page
		
		driver.navigate().back();
		
		try
		{
		link.click();  
		}
		catch(StaleElementReferenceException e)
		{
		link=driver.findElement(By.xpath("//*[@id=\"site-navigationpbt\"]/div/ul/li[11]/a"));
		link.click(); 
		}
		
	
		
	}

}
