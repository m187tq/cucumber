package HandlingElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyOpenAndCollapse {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void verifyOpenAndCollapse() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
    	
		//Launch the first URL
		driver.get("https://www.hdfcbank.com/personal/ways-to-bank/bank-online/netbanking");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// click on What’s NetBanking all about?
		driver.findElement(By.xpath("//*[@id='accordian1']/h3")).click();
		// when we click class name will have active appended
		String className = driver.findElement(By.xpath("//*[@id='accordian1']/h3")).getAttribute("class");
        System.out.println(className);
        
        if(className.contains("clearfix open active")){
        	   Assert.assertTrue(true, "Test verifyRadioButton is PASS");
        }
        else{
        	 Assert.assertTrue(false, "Test verifyRadioButton is PASS");
        }
	}
}
