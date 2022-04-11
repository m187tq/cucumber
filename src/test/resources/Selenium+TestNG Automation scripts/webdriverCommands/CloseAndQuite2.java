package webdriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuite2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // launch the browser
		
		driver.get("http://www.popuptest.com/popuptest2.html");
				
		//driver.close(); // closes only current browser ( single)
		
		driver.quit(); // closes all the browsers.
		

	}

}
