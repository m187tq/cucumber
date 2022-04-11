package webdriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // launch the browser
		
		driver.get("http://newtours.demoaut.com/");
		
		
		WebElement usernametxt=driver.findElement(By.name("userName"));
		WebElement passwordtxt=driver.findElement(By.name("password"));
		
		//isDisplayed(), isEnabled()
		
		if(usernametxt.isDisplayed() && usernametxt.isEnabled())
		{
			usernametxt.sendKeys("mercury");
		}
		else
		{
			System.out.println("User name txt element not displayed or not enabled onthe page");
		}
		
		if(passwordtxt.isDisplayed() && passwordtxt.isEnabled())
		{
			passwordtxt.sendKeys("mercury");
		}
		
		else
		{
			System.out.println("password txt element not displayed or not enabled onthe page");
		}
		
		driver.findElement(By.name("login")).click();
		
		//checking radio buttons selection by using isSelected() method
		
		boolean rad1=driver.findElement(By.cssSelector("input[value=roundtrip]")).isSelected();
		if(rad1==true)
		{
			System.out.println(" RoundTrip is selected");
		}
		else
		{
			System.out.println(" RoundTrip is NOT selected");
		}
		
		
		boolean rad2=driver.findElement(By.cssSelector("input[value=oneway]")).isSelected();
		if(rad2==true)
		{
			System.out.println("Oneways is Selected");
		}
		else
		{
			System.out.println("Oneways is NOT selected");
		}
		

	}

}
