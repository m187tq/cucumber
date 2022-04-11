package basicTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*Test Case
-------------
1) Open Web Browser(Chrome/IE/firefox).
2) Open URL  https://opensource-demo.orangehrmlive.com/
3) Enter username  (Admin).
4) Enter password  (admin123).   
5) Click on login.
6) Capture title of the home page.
7) Verify title of the page: OrangeHRM 
8) Close browser
 */
public class nopCommerceLogin {

	public static void main(String[] args) {
		
		//Chrome Browser
			
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();  //1) Open Web Browser //ChromeDriver driver=new ChromeDriver();
	
		
		//2) Open URL  https://opensource-demo.orangehrmlive.com/
		
		driver.get("http://demo.nopcommerce.com/login");
		driver.manage().window().maximize(); //maximize page
		
		//3) Enter username 
		
			driver.findElement(By.name("Email")).sendKeys("pavanoltraining@gmail.com");
		
		//4) Enter password  
			
			driver.findElement(By.name("Password")).sendKeys("test123");
		
		//5) Click on login.
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
		//6) Capture title of the home page.
			
			String act_title=driver.getTitle();
			String exp_title="nopCommerce demo store";
			
		//7) Verify title of the page: OrangeHRM 
			
			if(act_title.equals(exp_title))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test failed");
			}
		//8) Close browser
			driver.close(); //driver.quite();
			
	}

}
