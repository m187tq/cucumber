package headlessbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessFirefox {

	public static void main(String[] args) {

		//set the driver server exe path
		System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver-v0.23.0-win64/geckodriver.exe");
		
		// set Firefox as Headless
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		
		WebDriver driver=new FirefoxDriver(options);		//Instantiate Firefox Driver
		
		
		driver.get("http://demo.nopcommerce.com/");
						
		System.out.println("Title of the page:" + driver.getTitle());
		System.out.println("URL of the page:" + driver.getCurrentUrl());
	
		
	}

}
