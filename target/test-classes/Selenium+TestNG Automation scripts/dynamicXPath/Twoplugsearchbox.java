package dynamicXPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Twoplugsearchbox {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","C:/Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver(); 
	                
        driver.get("https://qatest.twoplugs.com/login");
        
        driver.findElement(By.xpath("//input[@id='signInEmail']")).sendKeys("joy");
        driver.findElement(By.xpath("//input[@id='signInPassword']")).sendKeys("test2plug");
        driver.findElement(By.xpath("//button[contains(.,'LOG IN')]")).click();
        
        driver.findElement(By.xpath("//*[@id='exampleInputAmount']")).sendKeys("Nitika"); //Search string
        Thread.sleep(3000);
              
       List <WebElement> list=driver.findElements(By.xpath("//nav[@role='navigation']//*[@class='suggestRow']/p/span")); //Find all options based on search string
       System.out.println("no.of suggestions:"+list.size());
    
		for(WebElement e:list)
        {        	
           	if(e.getText().equals("Nitika04"))
	    	  {
          		 //driver.findElement(By.xpath("//nav[@role='navigation']//*[@class='suggestRow']//span[.='Nitika04']")).click();  //Working fine -Method1
          		 driver.findElement(By.xpath("//span[.='Nitika04']")).click(); //Working fine -Method2 		
         	    break;
	    	  }
	      }
       }
	}
