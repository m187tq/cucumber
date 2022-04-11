package dataDrivenTesting;

/*1) Create/establish connection to database
2) create statement/query
3) Execute statement/query
4) store the data and read from resultset
5) close connection
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTTestingDB {

	public static void main(String[] args) throws SQLException, InterruptedException {
			
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		//step1: create connection to the database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborcl","hr","hr");

		//Step2: create statement object
		Statement stmt=con.createStatement();
		
		//Step3 & 4:Execute statement/query and store data in result set
		String s="select uname,passwrd from users";
		ResultSet rs=stmt.executeQuery(s);
		
		while(rs.next())
		{
			String username=rs.getString("uname");
			String password=rs.getString("passwrd");
			
			driver.findElement(By.name("userName")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			
			driver.findElement(By.name("login")).click();
			
			Thread.sleep(5000);
			
			if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
			{
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			
			driver.findElement(By.linkText("Home")).click();
		
		}
		
		
		
		//step5: close resultset, connection
		rs.close();
		con.close();
		
		System.out.println(" program is completed");
		
		
	}

}
