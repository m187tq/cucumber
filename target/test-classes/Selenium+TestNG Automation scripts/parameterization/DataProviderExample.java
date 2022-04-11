package parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="users")
	void loginTest(String uname,String pwd)
	{
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	}
	
	@DataProvider(name="users")
	String [][] logindata()
	{
		String data[][]={{"mercury","mercury"},{"asasa","mercury1"},{"mercury2","mercury2"} };
		return data;
	}
	
	@AfterClass
	void closebrowser()
	{
	driver.quit();	
	}
	
}
