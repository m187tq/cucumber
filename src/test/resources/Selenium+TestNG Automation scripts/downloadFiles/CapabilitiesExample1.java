package downloadFiles;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesExample1 {

	public static void main(String[] args) {
		
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("63.0");
		capabilities.setJavascriptEnabled(false);
		capabilities.setPlatform(Platform.WIN10);
		
		capabilities.setCapability("screen-resolution","1280x1024");

		System.setProperty("webdriver.chrome.driver","C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(capabilities);
		
		driver.get("https://www.amazon.in/");
	}

}
