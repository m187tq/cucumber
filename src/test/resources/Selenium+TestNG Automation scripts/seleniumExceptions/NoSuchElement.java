package seleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // launch the browser
		
		driver.get("http://newtours.demoaut.com/");
				
		WebElement usernametxt=driver.findElement(By.name("username"));//NoSuchElementException
		usernametxt.sendKeys("mercury");

	}

}
