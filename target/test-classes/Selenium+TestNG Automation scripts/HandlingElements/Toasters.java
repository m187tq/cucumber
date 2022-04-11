package HandlingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Toasters {

	@Test
	public void toastTest() {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://codeseven.github.io/toastr/demo.html");
		
		driver.findElement(By.id("title")).sendKeys("Toastmsg");
		driver.findElement(By.id("message")).sendKeys("Toast description");
		
		//Toast Type
		//driver.findElement(By.xpath("//input[@value='success']")).click();//Success
		//driver.findElement(By.xpath("//input[@value='info']")).click();//Info
		//driver.findElement(By.xpath("//input[@value='warning']")).click();//Warning
		driver.findElement(By.xpath("//input[@value='error']")).click(); //Error
		
		driver.findElement(By.id("showtoast")).click();
		
		String title=driver.findElement(By.className("toast-title")).getText();
		String description=driver.findElement(By.className("toast-message")).getText();
				
		System.out.println("Title of the Toast message::"+title);
		System.out.println("Description::"+description);
	
		Assert.assertEquals(title, "Toastmsg");
		Assert.assertEquals(description, "Toast description");
		
	}

}
