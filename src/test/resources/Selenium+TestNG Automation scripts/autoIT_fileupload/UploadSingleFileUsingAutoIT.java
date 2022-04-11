package autoIT_fileupload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadSingleFileUsingAutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"imagesrc\"]"));
		
		button.click();
		
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);*/
	
		Runtime.getRuntime().exec("C://SeleniumPractice//autoITFiles//SingleFileUpload.exe"); // execute .exe file
	
		//driver.quit();
	}

}
