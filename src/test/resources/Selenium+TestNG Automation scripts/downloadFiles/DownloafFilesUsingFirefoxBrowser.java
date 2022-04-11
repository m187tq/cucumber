package downloadFiles;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloafFilesUsingFirefoxBrowser {

	public static void main(String[] args) throws InterruptedException {

		//download files in required location using chrome
		FirefoxProfile profile=new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf"); // set Mime type according to your file format
		profile.setPreference("browser.download.manager.showWhenStarting", false);
				
		//download files in desired location
		profile.setPreference("browser.download.dir","C:\\Downloadedfiles");
		profile.setPreference("browser.download.folderList", 2); 
		profile.setPreference("pdfjs.disabled", true); // only for pdf file
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		//End of code
		
		System.setProperty("webdriver.gecko.driver","C://Drivers/geckodriver-v0.23.0-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver(option);
		
			
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		driver.manage().window().maximize();
		
		//text file
		
		driver.findElement(By.id("textbox")).sendKeys("testing");//text box
		driver.findElement(By.id("createTxt")).click(); //Generate File
		driver.findElement(By.id("link-to-download")).click(); //download link
		
		Thread.sleep(5000);
		
		if(isFileExist("C://Downloadedfiles/info.txt"))
		{
			System.out.println("File downloaded succesfully");
		}
		else
		{
			System.out.println("File not downloaded");
		}
		
				
		//pdf file
		
		driver.findElement(By.id("pdfbox")).sendKeys("testing");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		
		Thread.sleep(5000);
		
		if(isFileExist("C://Downloadedfiles/info.pdf"))
		{
			System.out.println("File downloaded succesfully");
		}
		else
		{
			System.out.println("File not downloaded");
		}
	}
	
	
	public static boolean isFileExist(String path) // this will check wheather file is eist or not
	{
		File f=new File(path);
		
		if(f.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	

}
