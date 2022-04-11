package sikuli_fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUploadSikuliDemo {

	public static void main(String[] args) throws FindFailed {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("RESULT_FileUpload-11")).click();
		
		//sikuli
		
		Screen s=new Screen();
		
		String path="C:\\SeleniumPractice\\sikulifiles\\";
		
		Pattern fileInputTextBox=new Pattern(path+"filetxtbox.png");
		Pattern openButton=new Pattern(path+"openbtn.png");
		
		s.wait(fileInputTextBox,20);
		s.type(fileInputTextBox,path+"profilepic.jpg");
		s.click(openButton);
		
	}

}
