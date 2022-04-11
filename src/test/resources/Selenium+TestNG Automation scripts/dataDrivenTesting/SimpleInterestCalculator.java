package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleInterestCalculator {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.easycalculation.com/simple-interest.php");
		
		driver.manage().window().maximize();
		
		String path="C://SeleniumPractice//SIdata.xlsx";
	
		int rowcount=XLUtils.getRowCount(path, "Sheet1");//NUMBER OF ROWS PRESENT IN A EXCEL SHEET
		
		for(int i=1;i<=rowcount;i++)
		{
			String princ=XLUtils.getCellData(path, "Sheet1",i,0);
			String rateofinterest=XLUtils.getCellData(path, "Sheet1",i,1); 
			String time=XLUtils.getCellData(path, "Sheet1",i,2); 
			Double exp_si=Double.parseDouble(XLUtils.getCellData(path, "Sheet1",i,3));
			
			
			driver.findElement(By.name("res1")).sendKeys(princ);
			driver.findElement(By.name("res2")).sendKeys(rateofinterest);
			driver.findElement(By.name("res3")).sendKeys(time);
			
								
			Select timedrp=new Select(driver.findElement(By.name("time")));
			timedrp.selectByVisibleText("Years");
					
			Thread.sleep(5000);
			
			String act_si=driver.findElement(By.name("res4")).getAttribute("value"); //capture Simple Interest value
			
			if(exp_si==Double.parseDouble(act_si))
			{
				System.out.println("Test Passed");
				XLUtils.setCellData(path, "Sheet1", i, 4, "Passed");
							
			}
			else
			{
				System.out.println("Test Failed");
				XLUtils.setCellData(path, "Sheet1", i, 4, "Failed");
			}
				
			driver.findElement(By.xpath("//*[@id='dispCalcConts']/input[2]")).click(); //reset button
					
			Thread.sleep(3000);
			
		}
		
	}

}
