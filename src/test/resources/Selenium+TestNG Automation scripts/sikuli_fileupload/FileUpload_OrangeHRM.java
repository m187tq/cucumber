package sikuli_fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUpload_OrangeHRM {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		//Chrome
				System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
					
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(3000);
		

		driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b")).click();//PIM
		driver.findElement(By.xpath("//*[@id=\'menu_pim_addEmployee\']")).click(); //AddEmployee
		
		driver.findElement(By.id("photofile")).click();
		
		Screen s=new Screen();
		
		String path="C:\\SeleniumPractice\\sikulifiles\\";
		
		Pattern fileInputTextBox=new Pattern(path+"filetxtbox.png");
		Pattern openButton=new Pattern(path+"openbtn.png");
		
		s.wait(fileInputTextBox,20);
		s.type(fileInputTextBox,path+"profilepic.jpg");
		s.click(openButton);
		
	}

}





