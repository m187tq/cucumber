package webdriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/"); // FR
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.navigate().to("https://www.facebook.com/"); //FB
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.navigate().back(); //FR
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.navigate().forward(); // FB
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.navigate().refresh(); // refresing the page
	}

}
