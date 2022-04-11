package actionsClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;


public class DragAndDrop2 {

    public static void main(String[] args) {
	 
    	System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
    	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://jqueryui.com/droppable/#default");
	    driver.manage().window().maximize();
	 
	    Actions act = new Actions(driver);
	 
	    // Script for dragging an element and dropping it in another place
	    WebElement iFrame = driver.findElement(By.tagName("iframe"));
	    driver.switchTo().frame(iFrame);
	 
	    WebElement s = driver.findElement(By.id("draggable"));
	    System.out.println(s.getLocation());
	 
	    WebElement t = driver.findElement(By.id("droppable"));
	    System.out.println(t.getLocation());
	 
	    act.dragAndDrop(s, t).build().perform();
	 
	    driver.close();
	    }
	} 

