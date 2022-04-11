package HandlingCookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://flipkart.com/");
		
		driver.manage().window().maximize();
		
		Set <Cookie> cookies=driver.manage().getCookies(); // capture all the cookies from the browser
		
		System.out.println("Size of cookies ---->" +cookies.size()); // print size of cookies
		
		for(Cookie cookie:cookies) // read and print all teh cookies
		{
			System.out.println(cookie.getName()+":"+cookie.getValue()); // prints name and value of cookies
		}
		
		//Adding new cookie to the browser
		
		Cookie cookieobj=new Cookie("MyCookie123","123456789");
		driver.manage().addCookie(cookieobj);  // add new cookie to the browser
		
		cookies=driver.manage().getCookies(); 
		System.out.println("Size of Cookies after adding new one---->" +cookies.size()); 
		
		for(Cookie cookie:cookies) // read and print all teh cookies
		{
			System.out.println(cookie.getName()+":"+cookie.getValue()); // prints name and value of cookies
		}
		
		//deleting cookie
		
		driver.manage().deleteCookie(cookieobj);
		cookies=driver.manage().getCookies(); 
		System.out.println("Size of Cookies after deleting one cookie---->" +cookies.size()); 
		
		driver.manage().deleteAllCookies(); //deletes all the cookies
		
		cookies=driver.manage().getCookies(); 
		Thread.sleep(3000);
		System.out.println("Size of Cookies after deleting All cookies---->" +cookies.size());  // 0
		
		
		driver.quit();
		
		
		
		
		
	}

}
