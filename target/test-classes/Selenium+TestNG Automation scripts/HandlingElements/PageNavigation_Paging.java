package HandlingElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageNavigation_Paging {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dice.com/");
		driver.findElement(By.xpath("//input[@id='search-field-keyword']")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id='search-field-location']")).clear();
		//driver.findElement(By.xpath("//*[@id='search-field-location']")).sendKeys("USAF Academy, CO");
				
		driver.findElement(By.xpath("//button[@id='findTechJobs']")).click();
	
		Thread.sleep(5000);
		
		WebElement Paging_Element = driver.findElement(By.xpath("//*[@id='dice_paging_top']")); 
		
		
		List<WebElement> sub_links = Paging_Element.findElements(By.tagName("a")); 
		System.out.println("Total Paging Elements Are -- > " + sub_links.size());

		if (sub_links.size() > 0) {
			System.out.println("Link Is Present");

			for (int i = 1; i < sub_links.size(); i++) {
					WebElement link=driver.findElement(By.xpath("//*[@id='dice_paging_top']/ul/li[" + i + "]/a"));
					System.out.println(link.getText());
					link.click();
					Thread.sleep(5000);
				}
		} else {
			System.out.println("Links not presents");
		}
	}
}