package realtimeTestCases;

/*
 * 1) Open URL:https://demo.openmrs.org/openmrs/login.htm
2) Access the url and enter Admin/Admin123 as credentials
3) Select the �Inpatient Ward�.
4) click on login.
5) Navigate to Appointment Scheduling->Manage Service Types.
6) verify the Service Type �Urology� available in the html table.
 * 
 */

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class OpenMRS1 {
 
	static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://demo.openmrs.org/openmrs/");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		
		driver.findElement(By.xpath("//form[@id='login-form']")).submit();
			
		List<WebElement> pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		List<WebElement> tdList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
 
		for(int i = 1 ; i< pageList.size();i++)
		{
			for(int j=0;j<tdList.size();j++)
			{
				System.out.println(tdList.get(j).getText());
				/*if(tdList.get(j).getText().contains(sName))
				{
					System.out.println("Service Type Found!!!");
					result = true;
					break outerloop;
				}*/
			}
			pageList =driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a")); 
			pageList.get(i).click();
			tdList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		}
		
 
	}
	
}