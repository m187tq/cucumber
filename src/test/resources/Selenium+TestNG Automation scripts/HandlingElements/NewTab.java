package HandlingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class NewTab {

	public static void main(String[] args) throws InterruptedException {

		// Chrome Browser
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		 
		// Firefox Browser
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		// IE Browser
		 //System.setProperty("webdriver.ie.driver","C://Drivers/IEDriverServer_Win32_3.7.0/IEDriverServer.exe");
		 //WebDriver driver=new InternetExplorerDriver();

		//driver.manage().window().maximize();
		
		
		//Opening link in next tab
		//---------------------------
		/*driver.get("http://newtours.demoaut.com/");
		String newTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("REGISTER")).sendKeys(newTab);*/
	
		
		// Opening URL in next tab
		//---------------------------

	 	driver.get("http://newtours.demoaut.com/");
		System.out.println(driver.getTitle());

		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL,"t"));
				
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		//driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "\t");


	}
}
