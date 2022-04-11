package realtimeTestCases;
/*
 *1) URL: https://demo.openmrs.org/openmrs/login.htm
2) Access the url and enter Admin/Admin123 as credentials
3)Select the �Inpatient Ward�.
4) click on login.
5)Navigate to Appointment Scheduling->Manage Service Types.
6) Click on Delete icon to perform deletion of Service Type.
7) Finding an xpath for Yes button results in multiple matching nodes.
Even though we applying indexing to identify the �Yes� Button its not working.
 */

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class OpenMRS2 {
 
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.xpath("//form[@id='login-form']")).submit();
		boolean result = deleteServiceType("Dermatology");
		System.out.println(result);
	}
	public static boolean deleteServiceType(String serviceName) throws InterruptedException
	{
		boolean result = false;
		driver.findElement(By.xpath("//td[text()='"+serviceName+"']/following-sibling::td[3]/descendant::i[@title='Delete']")).click();
		List<WebElement> buttonList = driver.findElements(By.xpath(".//*[@id='delete-appointment-type-dialog']/div[2]/button[@class='confirm right']"));
		System.out.println("Number of Buttons" + buttonList.size());
		for(int i = 0;i<buttonList.size();i++)
		{
			try{
				if(buttonList.get(i).isDisplayed() || buttonList.get(i).isEnabled())
				{
					buttonList.get(i).click();
					result= true;
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Element is not visible|| enabled"+e.getMessage());
			}
		}
		return result;
	}
}
 