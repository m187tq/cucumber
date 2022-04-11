package HandlingElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VolenteerSignup {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://goo.gl/RVdKM9");
		//driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize(); // Maximize the browser
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//driver.switchTo().frame(0);
				
		driver.findElement(By.name("RESULT_TextField-1")).sendKeys("John");
		driver.findElement(By.name("RESULT_TextField-2")).sendKeys("brill");
		driver.findElement(By.name("RESULT_TextField-3")).sendKeys("123456789");
		driver.findElement(By.name("RESULT_TextField-4")).sendKeys("Canada");
		driver.findElement(By.name("RESULT_TextField-5")).sendKeys("Toronto");
		driver.findElement(By.name("RESULT_TextField-6")).sendKeys("abcd@gmail.com");
		
			
		//WebElement dropdown=driver.findElement(By.name("RESULT_RadioButton-6"));
		Select drp=new Select(driver.findElement(By.name("RESULT_RadioButton-7")));
		
		//Counting number of options present in dropdown
		System.out.println("Number of options present in dropdown:"+ drp.getOptions().size());
		
		//How to capture all the options from dropdown
		List <WebElement> options=drp.getOptions();
		
		for(WebElement e:options)
		{
			System.out.println(e.getText());
			
		}
		
		//Select option from drop down 
		//drp.selectByIndex(3);   // here 3 is the index
		//drp.selectByValue("Radio-1"); //Afternoon
		drp.selectByVisibleText("Morning");  // Visible text
		
		//Selecting radio button
		
		boolean status=driver.findElement(By.id("RESULT_RadioButton-8_0")).isSelected(); //False
		
		System.out.println("Status of radio button before selecting:"+status);
		
		driver.findElement(By.id("RESULT_RadioButton-8_0")).click(); //selected radio button
		
		status=driver.findElement(By.id("RESULT_RadioButton-8_0")).isSelected(); //True
		
		System.out.println("Status of radio button After selecting:"+status);
		
		//check boxes
		
		driver.findElement(By.id("RESULT_CheckBox-9_0")).click(); // Sunday
		driver.findElement(By.id("RESULT_CheckBox-9_6")).click(); //saturday
		
		status=driver.findElement(By.id("RESULT_CheckBox-9_0")).isSelected(); //true
		System.out.println("status of sunday check box:" + status);
		
		
		status=driver.findElement(By.id("RESULT_CheckBox-9_6")).isSelected(); //true
		System.out.println("status of saturday check box:" + status);
	
		
		//text area
		
		driver.findElement(By.name("RESULT_TextArea-12")).sendKeys("testing");
		
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.partialLinkText("Tools Training")).click();
		
		driver.navigate().back();
				
	}

}
