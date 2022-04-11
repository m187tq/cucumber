package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserRegistration {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver","C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver(); /// opens the browser
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		String path="C://SeleniumPractice/registration.xlsx";
		
		XLUtils.setExcelFile(path,"Sheet1");
		
		int noofrows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int row=1;row<=noofrows;row++)
		{
			String First_name=XLUtils.getCellData(path, "Sheet1", row, 0);
			String Last_name= XLUtils.getCellData(path, "Sheet1", row, 1);
			String phone=XLUtils.getCellData(path, "Sheet1", row, 2);
			String email=XLUtils.getCellData(path, "Sheet1", row, 3);
			String address=XLUtils.getCellData(path, "Sheet1", row, 4);
			String city=XLUtils.getCellData(path, "Sheet1", row, 5);
			String state=XLUtils.getCellData(path, "Sheet1", row, 6);
			String pincode=XLUtils.getCellData(path, "Sheet1", row, 7);
			String country=XLUtils.getCellData(path, "Sheet1", row, 8);
			String username=XLUtils.getCellData(path, "Sheet1", row, 9);
			String password=XLUtils.getCellData(path, "Sheet1", row, 10);
						
			driver.findElement(By.linkText("REGISTER")).click();
					
			//registration process start
			driver.findElement(By.linkText("REGISTER")).click();
			
			//contact information
			driver.findElement(By.name("firstName")).sendKeys(First_name);
			driver.findElement(By.name("lastName")).sendKeys(Last_name);
			driver.findElement(By.name("phone")).sendKeys(phone);
			driver.findElement(By.name("userName")).sendKeys(email);
						
			//mailing information
			driver.findElement(By.name("address1")).sendKeys(address);
			driver.findElement(By.name("address2")).sendKeys(address);
			driver.findElement(By.name("city")).sendKeys(city);
			driver.findElement(By.name("state")).sendKeys(state);
			driver.findElement(By.name("postalCode")).sendKeys(pincode);
			Select dropcountry=new Select(driver.findElement(By.name("country")));
			dropcountry.selectByVisibleText(country);
			
			//user information
			driver.findElement(By.name("email")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("confirmPassword")).sendKeys(password);
			
			driver.findElement(By.name("RegistrationSteps")).click(); //submit
			
			Thread.sleep(2000);
			
			//validation
			
			if (driver.getPageSource().contains("Thank you for registering")) {
				System.out.println(" registration Completed for  " + row + " record");

			}

			else
			{
				System.out.println(" registration Failed for " + row + " record");

			}
			
			
		}
		
	
	
	
	}

}
