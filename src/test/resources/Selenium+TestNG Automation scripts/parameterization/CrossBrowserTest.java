package parameterization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver=null;
	
	@Parameters("browser")
	@Test
	public void launchBrowser(String br)
	{
		if(br.equals("FF"))
		{
			//Firefox Browser
			System.setProperty("webdriver.gecko.driver","C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(br.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C://Drivers/IEDriverServer_Win32_3.7.0/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else if(br.equals("CH"))
		{
			System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver(); // opens the browser
		}
		
		driver.get("http://newtours.demoaut.com/");
		
	}
	
	@Test
	public void verifyTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}
	
	/*@Test
	public void registration()
	{
		//selenium code for registration
	}*/
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
