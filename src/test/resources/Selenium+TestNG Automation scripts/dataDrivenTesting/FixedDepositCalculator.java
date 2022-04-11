package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class FixedDepositCalculator {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		driver.manage().window().maximize();
		
		String path="C://SeleniumPractice/caldata.xlsx";
		
		XLUtils.setExcelFile(path, "Sheet1");
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rowcount;i++)
		{
			String pric=XLUtils.getCellData(path,"Sheet1",i, 0);
			String rateofinterest=XLUtils.getCellData(path,"Sheet1",i, 1);
			String per= XLUtils.getCellData(path,"Sheet1",i, 2);
			String fre=XLUtils.getCellData(path, "Sheet1", i,3);
			double exp_mvalue=Double.parseDouble(XLUtils.getCellData(path,"Sheet1",i,4));
			
			
			driver.findElement(By.id("principal")).sendKeys(pric);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(per);
			
			Select perioddrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perioddrp.selectByVisibleText("year(s)");
		
			Select frequencydrp=new Select(driver.findElement(By.id("frequency")));
			frequencydrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img")).click();
			
			String act_mvalue=driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			
			if(exp_mvalue==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test is passed");
			}
			else
			{
				System.out.println("Test failed");
			}
			
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
			Thread.sleep(3000);
			
		}
	}
}
