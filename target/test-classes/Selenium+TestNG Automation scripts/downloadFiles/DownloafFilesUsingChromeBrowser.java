package downloadFiles;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloafFilesUsingChromeBrowser {

	public static void main(String[] args) throws InterruptedException {

		//download files in required location using chrome
		
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.prompt_for_download", "false");
				chromePrefs.put("download.default_directory","C:\\Downloadedfiles"); // set desired download path

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);

				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options); 
		//End of code
		
		
			
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(cap);  // cap object we need pass
		
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
