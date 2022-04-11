package HandlingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		driver.manage().window().maximize(); // maximize the browser window
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)","");   //1. Scroll down page by pixel
		Long value = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println(value); //Scroll location 500
		
		/*WebElement indflag=driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/table[1]/tbody/tr[85]/td[1]/img"));
		js.executeScript("arguments[0].scrollIntoView();",indflag);   //Scroll down page till the element is visible
		value = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println(value); //Scroll location 4896 */
		
				
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //scroll down page till end of the page
		value = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println(value); //Scroll location 5939
		
		
		 //This will scroll the page Horizontally till the element is found		
        //js.executeScript("arguments[0].scrollIntoView();", Element);
	}

}
