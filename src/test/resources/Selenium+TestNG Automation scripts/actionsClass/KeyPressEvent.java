package actionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class KeyPressEvent {

	
	public static void main(String args[]){
		
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		//option1:
		//driver.findElement(By.id("content")).sendKeys(Keys.SPACE);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();//Keys.ESCAPE, Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.BACK_SPACE
						
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		
		if(text.contains("You entered: ENTER"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
			
	}

}