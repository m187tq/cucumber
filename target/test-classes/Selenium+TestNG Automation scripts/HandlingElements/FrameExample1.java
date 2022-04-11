package HandlingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		driver.switchTo().frame("packageListFrame");// switch to first frame
		driver.findElement(By.linkText("org.openqa.selenium")).click(); //org.openqa.selenium link -1st frame
		
		driver.switchTo().defaultContent(); //switch to main page
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("packageFrame");// switch to second frame
		driver.findElement(By.linkText("WebDriver")).click(); //webDriver link - 2nd frame
	
		driver.switchTo().defaultContent(); //switch to main page
		
		Thread.sleep(3000);
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("/html/body/div[1]/ul/li[5]")).click(); //Deprecated -3rd frame
		
	}

}
