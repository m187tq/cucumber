package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ToolTip2 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe"))); //iframe
		
		String tooltip=driver.findElement(By.xpath("//*[@id='age']")).getAttribute("title");
		
		System.out.println(tooltip);
		
	}
}
