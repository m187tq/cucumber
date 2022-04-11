package dynamicXPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class SearchDemo {
	 public static void main(String[] args) throws Exception {
		 
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
    			
		driver.get("https://www.google.com"); 
		 driver.manage().window().maximize();
         
         driver.findElement(By.id("lst-ib")).sendKeys("Selenium"); //Search box
         driver.findElement(By.name("btnK")).click(); //search button
         
         Thread.sleep(3000);
         
        List<WebElement> NoOfLinks = driver.findElements(By.xpath("//*[@id=\"rso\"]//h3")); //Capture links
         System.out.println("Number of search links present in search page --->"+NoOfLinks.size());

         Actions action=new Actions(driver);
         
         for(int i=0;i<NoOfLinks.size();i++)
           {
        	WebElement link=NoOfLinks.get(i); //Capture every link as web element
        	action.moveToElement(link).		// Move and place the cursor on link
        	keyDown(Keys.CONTROL).   //Press control key down
        	click(link).   // click on link, here link opens in new tab
        	keyUp(Keys.CONTROL).perform(); //Release control key up
        	
           
           
           }
         
        // driver.quit();
       }
}