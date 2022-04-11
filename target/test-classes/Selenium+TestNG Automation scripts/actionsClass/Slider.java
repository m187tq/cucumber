package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args)  {
	
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Slider.html");		
			
		WebElement slider=driver.findElement(By.xpath("//*[@id=\'slider\']/a"));
				
	        Actions act=new Actions (driver);
	    
	        act.moveToElement(slider).dragAndDropBy(slider, 50, 0).build().perform();
	    
	}

}
