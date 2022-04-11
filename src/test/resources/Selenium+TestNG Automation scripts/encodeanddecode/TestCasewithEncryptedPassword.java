package encodeanddecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasewithEncryptedPassword {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.nopcommerce.com/login");
		
		driver.findElement(By.linkText("Log in")).click();
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pavanoltraining@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(decodeString("dGVzdDEyMw=="));
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	
	static String decodeString(String password)
	{
		byte[] decodedString=Base64.decodeBase64(password);
		return(new String(decodedString));
	}
	
	
	
}
