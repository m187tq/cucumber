package downloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadZIPFile {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		
		// Create FireFox Profile object
		FirefoxProfile profile = new FirefoxProfile();
		
		// Set Preference to not show file download confirmation dialogue using
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip"); // set MIME types Of different file extension types.
		profile.setPreference("browser.download.manager.showWhenStarting", false);
	
			
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		// Initialize Firefox driver
		WebDriver driver = new FirefoxDriver(option);
		
		driver.get("http://testingmasters.com/student-corner/downloads/");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/table/tbody/tr[1]/td[2]/a")).click(); //downlaod link
		
	}

}
