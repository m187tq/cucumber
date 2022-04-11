package actionsClass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizing {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32//chromedriver.exe");
	WebDriver driver=new ChromeDriver();
		
    driver.get("http://demo.automationtesting.in/Resizable.html");
   
    WebElement resize=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
    
    Actions act=new Actions(driver);
    
    act.moveToElement(resize).dragAndDropBy(resize,100,150).build().perform();
    

	}  

}