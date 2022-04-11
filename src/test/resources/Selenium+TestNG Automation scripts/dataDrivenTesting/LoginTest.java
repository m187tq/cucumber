package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		String path="C://SeleniumPractice/Login1.xlsx";
		
		XLUtils.setExcelFile(path, "Sheet1");
		int rows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			String username=XLUtils.getCellData(path,"Sheet1", i, 0);
			String pasword=XLUtils.getCellData(path,"Sheet1", i, 1);
			
			driver.findElement(By.name("userName")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(pasword);
			
			driver.findElement(By.name("login")).click();
			
			Thread.sleep(5000);
			
			if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
			{
				System.out.println("passed");
				XLUtils.setCellData(path, "Sheet1", i, 2, "Passed");
			}
			else
			{
				System.out.println("failed");
				XLUtils.setCellData(path, "Sheet1", i, 2, "Failed");
			}
			
			driver.findElement(By.linkText("Home")).click();
			
		}

		driver.quit();
	}

}
