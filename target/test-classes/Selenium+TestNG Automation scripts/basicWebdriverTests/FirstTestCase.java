package basicWebdriverTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*1) Open Web Browser(Chrome/IE/firefox).
2) Open URL  https://opensource-demo.orangehrmlive.com/
3) Enter username  (Admin).
4) Enter password  (admin123).   
5) Click on login.
6) Capture title of the home page.
7) Verify title of the page: OrangeHRM 
  */

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		
		//Chrome browser
			//System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
			//WebDriver driver=new ChromeDriver(); //ChromeDriver driver=new ChromeDriver(); //1) Open Web Browser
		
		//Firefox
			//System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver-v0.23.0-win64/geckodriver.exe");
			//WebDriver driver=new FirefoxDriver(); //ChromeDriver driver=new ChromeDriver(); //1) Open Web Browser	
			
		//IE Browser
		 //System.setProperty("webdriver.ie.driver", "C://Drivers/IEDriverServer_Win32_3.14.0/IEDriverServer.exe");
		 //WebDriver driver=new InternetExplorerDriver(); //ChromeDriver driver=new ChromeDriver(); //1) Open Web Browser	
		
		//Microsoft Edge	//OS Build no:17134.345  App: Microsoft Edge 42.17134.1.0
			System.setProperty("webdriver.edge.driver", "C://Drivers/MicrosoftEdgeDriver/MicrosoftWebDriver.exe");
			WebDriver driver = new EdgeDriver();
				
		//2) Open URL  https://opensource-demo.orangehrmlive.com/
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			driver.manage().window().maximize(); // Maximize th browser
			
		//3) Enter username  (Admin).
			
			//WebElement username=driver.findElement(By.id("txtUsername"));
			//username.sendKeys("Admin");
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		//4) Enter password  (admin123).   
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			
		//5) Click on login.
			
			driver.findElement(By.id("btnLogin")).click();
			
			Thread.sleep(5000);
			
		//6) Capture title of the home page.
			String acttitle=driver.getTitle(); // Actual title
			
			String exptitle="OrangeHRM";
			
		//7) Verify title of the page: OrangeHRM 
			
			if(acttitle.equals(exptitle))
			{
				System.out.println("Test is passed");
			}
			else
			{
				System.out.println("Test is failed");
			}
		
		//close browser
			
			driver.quit();
			
		
	}

}
