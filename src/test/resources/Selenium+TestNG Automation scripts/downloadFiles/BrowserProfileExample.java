package downloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BrowserProfileExample {

	@Test
	void loginTest()
	{
		String baseurl = "http://demo.guru99.com/V4/index.php";
		String username = "mngr113560";
		String password = "rUtYvat";
		
		ProfilesIni profile=new ProfilesIni();
		FirefoxProfile myprofile=profile.getProfile("Myprofile");
		
		DesiredCapabilities dc=DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE,myprofile );
		

		System.setProperty("webdriver.gecko.driver","C://Drivers/geckodriver-v0.19.1-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver(dc);
		
		driver.get(baseurl);
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
	}
}
