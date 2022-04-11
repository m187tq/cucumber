package downloadFiles;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DownloadFilesUsingIE {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.ie.driver","C://Drivers/IEDriverServer_Win32_3.7.0/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		driver.findElement(By.id("textbox")).sendKeys("testing text file download");
		driver.findElement(By.id("createTxt")).click(); //generate txt file
		//driver.findElement(By.id("link-to-download")).click(); // display download and click - Not working even manually
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div[1]/a")).click();
		Runtime.getRuntime().exec("C://SeleniumPractice/filedownload-IE.exe");
				
		Thread.sleep(5000);
		
		/*driver.findElement(By.id("pdfbox")).sendKeys("testing pdf download");
		driver.findElement(By.id("createPdf")).click(); //generate pdf file 
		driver.findElement(By.id("pdf-link-to-download")).click(); // download pdf file
		Runtime.getRuntime().exec("C://SeleniumPractice/filedownload.exe");*/
		
		

	}

}
