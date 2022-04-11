package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		//login
		
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();

		//Admin-->User managerment-->Users
		
		Actions act=new Actions(driver);
			
		WebElement admin=driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
		WebElement usermgnt= driver.findElement(By.xpath("//*[@id='menu_admin_UserManagement']"));
		WebElement users=driver.findElement(By.xpath("//*[@id='menu_admin_viewSystemUsers']"));	
		
		act.moveToElement(admin).build().perform();
		act.moveToElement(usermgnt).build().perform();
		act.moveToElement(users).click().build().perform();
			
		//act.moveToElement(admin).moveToElement(usermgnt).moveToElement(users).click().build().perform();
		
		
		
	}

}
