/*
Open Web Browser.
Open URL  http://opensource.demo.orangehrmlive.com
Enter username  (Admin).
Enter password  (admin).   
Click on login.
Capture title of the home page.
Verify title of the page: OrangeHRM 
*/
package basicWebdriverTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		//Chrome Browser
		//System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		//WebDriver driver=new ChromeDriver(); //ChromeDriver driver=new ChromeDriver(); // Invokes the chrome browser
	
		//Microsoft Edge	//OS Build no:17134.345  App: Microsoft Edge 42.17134.1.0
		System.setProperty("webdriver.edge.driver", "C://Drivers/MicrosoftEdgeDriver/MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://newtours.demoaut.com/"); //Open URL  http://opensource.demo.orangehrmlive.com
		
		driver.findElement(By.name("userName")).sendKeys("mercury"); //Enter username  (Admin).
		
		driver.findElement(By.name("password")).sendKeys("mercury"); //Enter password  (admin).
		
		driver.findElement(By.name("login")).click();   //Click on Submit.
		
		Thread.sleep(5000);
		
		String actTitle="Find a Flight: Mercury Tours:";
		String expTitle=driver.getTitle();
		
		//Verify title of the page
				if(expTitle.equals(actTitle))
				{
					System.out.println("login test passed");
				}
				else
				{
				System.out.println(" login Test failed");
				}
				
		driver.close(); // closes the browser
	}

}
