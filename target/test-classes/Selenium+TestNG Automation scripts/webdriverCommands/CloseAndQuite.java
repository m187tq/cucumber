package webdriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuite {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // launch the browser
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();// clcik on button
		
		
		Thread.sleep(5000);
		
		//driver.close(); // closes only current browser ( single)
		
		driver.quit(); // closes all the browsers.
		

	}

}
