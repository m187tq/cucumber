package allElements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationTestingPracticeForm {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    
		driver.get("https://testautomationpractice.blogspot.com/");
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.switchTo().frame(0);//Switch to frame
	   
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//*[@id='RESULT_TextField-1']")).sendKeys("Oliver");//Enter FirstName
	    driver.findElement(By.xpath("//*[@id='RESULT_TextField-2']")).sendKeys("Twist");//Enter LName
	    driver.findElement(By.id("RESULT_TextField-3")).sendKeys("12345678");//Enter Phone Number
	    driver.findElement(By.id("RESULT_TextField-4")).sendKeys("Canada");//Enter Country
	    driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Toronto");//Enter City
	    driver.findElement(By.id("RESULT_TextField-6")).sendKeys("Oliver@gmail.com");//Enter Email
	    
	    Select Options = new Select(driver.findElement(By.id("RESULT_RadioButton-7")));//Select dropdown
	   
	    List <WebElement> list = Options.getOptions();//Print all options
	    	for(WebElement e:list) {
	    		System.out.println(e.getText());
		   
	    	}
	    System.out.println(Options.getOptions().size());// Get the number of options of dropdown
	    Options.selectByVisibleText("Morning"); // Select an option 
	    
   	    driver.findElement(By.id("RESULT_RadioButton-8_1")).click();//Select Gender Radio button 
	        	    
	    driver.findElement(By.xpath("//*[@id='RESULT_CheckBox-9_2']")).click();//Select Check box
	    driver.findElement(By.xpath("//*[@id='RESULT_CheckBox-9_4']")).click();// Select another Check box
	   
	    driver.switchTo().defaultContent(); //Here You have to come out of first frame to continue rest of the elements
	    
	  	
		//Tool Tip Capture
		
		String tooltip1=driver.findElement(By.xpath("//*[@id=\"HTML8\"]/div[1]/p[1]/a")).getAttribute("title");
		System.out.println(tooltip1);
		
		String tooltip2=driver.findElement(By.xpath("//*[@id=\"HTML8\"]/div[1]/p[2]/a")).getAttribute("title");
		System.out.println(tooltip2);
		
		//Alert
		
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click();
		driver.switchTo().alert().accept(); //close alert by using OK button
		//driver.switchTo().alert().dismiss(); //close alert by using cancel button
		
		
		//Date Picker - Current Date
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.linkText("19")).click();
		
				
		//Select menu
			
			Select speed=new Select(driver.findElement(By.id("speed")));
			speed.selectByVisibleText("Fast");
		
		//Select class does not work here	
			Select files=new Select(driver.findElement(By.id("files")));
			files.selectByVisibleText("TXT file");
			
		//Select a number
			Select number=new Select(driver.findElement(By.id("number")));
			number.selectByVisibleText("5");
		
		
		//HTML Table
		
		int rows=driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr")).size();
		
		System.out.println("BookName"+"       "+"Author"+"       "+"Subject"+"      "+"Price"); //Header
		System.out.println("-------------------------------------------"); //Header
		
		for(int r=2;r<=rows;r++)
		{
			String bookname=driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+r+"]/td[1]")).getText(); //Book Name
			String author=driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+r+"]/td[2]")).getText(); //Book Name
			String subject=driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+r+"]/td[3]")).getText(); //Book Name
			String price=driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+r+"]/td[4]")).getText(); //Book Price
			System.out.println(bookname+"     "+author+"        "+subject+"      "+price);
		}
		
	 //Drag and Drop	
		
		WebElement source=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement target=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).build().perform();;
	
	//Resizable
	
		WebElement resize=driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		act.dragAndDropBy(resize, 300, 300).build().perform();
	
	//Slider
		WebElement slider=driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		act.dragAndDropBy(slider, 400, 0).build().perform();
		
	}
	
}
