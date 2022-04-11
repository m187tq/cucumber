package autoIT_fileupload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadMultipleFilesUsingAutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver","C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement button=driver.findElement(By.xpath("//*[@id='imagesrc']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
				
		Thread.sleep(3000);
		
		//round1- first file
		executor.executeScript("arguments[0].click();", button);
		Runtime.getRuntime().exec("C://SeleniumPractice/MultipleFilesUpload.exe"+" "+ "C:\\SeleniumPractice\\Fruites\\apple.jpg");
		
		Thread.sleep(5000);
		
		//round2-  second file
		executor.executeScript("arguments[0].click();", button);
		Runtime.getRuntime().exec("C://SeleniumPractice/MultipleFilesUpload.exe"+" "+ "C:\\SeleniumPractice\\Fruites\\Mangoes.jpg");
						
		Thread.sleep(5000);
		
		//round3-  third file file
		executor.executeScript("arguments[0].click();", button);
		Runtime.getRuntime().exec("C://SeleniumPractice/MultipleFilesUpload.exe"+" "+ "C:\\SeleniumPractice\\Fruites\\PineApple.jpg");
		Thread.sleep(5000);			
		
		driver.quit();
	}

}
