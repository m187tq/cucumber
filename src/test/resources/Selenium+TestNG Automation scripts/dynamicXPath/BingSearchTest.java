package dynamicXPath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BingSearchTest {

public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	//System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
	//WebDriver driver=new FirefoxDriver();

	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
   driver.get("https://www.bing.com/");
 
   // driver.manage().window().maximize();
   driver.findElement(By.id("sb_form_q")).sendKeys("java");
   
   //List<WebElement> list= driver.findElements(By.xpath("/html/body/table/tbody/tr/td/div/div[2]/div[2]/form/div[1]/div/div/ul/li/div")); //working using full xpath
   List<WebElement> list= driver.findElements(By.xpath("//ul[@id='sa_ul']/li/div")); //working - using partial xpath
   
   System.out.println("size of elements"+ list.size());

   for (int i=0;i<list.size();i++)
   {
    System.out.println(list.get(i).getText());
    if(list.get(i).getText().contains("java update"))
    {
     list.get(i).click();
     break;
    }
   }
}
}