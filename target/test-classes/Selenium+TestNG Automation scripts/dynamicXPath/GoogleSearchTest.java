package dynamicXPath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {

public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	//System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
	//WebDriver driver=new FirefoxDriver();

	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
   driver.get("http://www.google.com");
 
   // driver.manage().window().maximize();
   driver.findElement(By.id("lst-ib")).sendKeys("java");
  
   List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));//working-partial xpath
       
   System.out.println("size of elements"+ list.size());

   for (int i=0;i<list.size();i++)
   {
    System.out.println(list.get(i).getText());
    if(list.get(i).getText().contains("java tutorial"))
    {
     list.get(i).click();
     break;
    }
   }
}
}