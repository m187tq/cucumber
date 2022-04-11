package webdriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // launch the browser
		
		driver.get("https://www.facebook.com/"); //get() opens URL on the browser
		
		String title=driver.getTitle(); //getTitle() returns title of the page
		System.out.println(title);
		
		String url=	driver.getCurrentUrl(); //getCurrentURL() returns URL of the page
		System.out.println(url);
		
		System.out.println(driver.getPageSource()); // return HTML script for the web page
		
		driver.close();
	}

}
