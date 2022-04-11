package imageComparison;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
 
public class ImageComparisonPositive 
{
    WebDriver driver;
     
    @Test
    public void imageComaparision() throws IOException
    {
    	System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
        driver.get("https://opensource-demo.orangehrmlive.com/");
         
        WebElement logoImage = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
         
        BufferedImage expectedImage = ImageIO.read(new File("C://SeleniumPractice//OrangeHRMlogo.png"));
        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
        BufferedImage actualImage = logoImageScreenshot.getImage();
                 
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        Assert.assertFalse(diff.hasDiff(),"Images are Same");
                 
        driver.quit();
    }
}