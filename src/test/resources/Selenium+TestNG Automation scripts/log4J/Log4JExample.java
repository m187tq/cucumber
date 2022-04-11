package log4J;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Log4JExample {

	public static Logger logger;
			
	@Test(priority=1)
	public void setup()
	{
		logger=Logger.getLogger("Log4JExample"); // need to pass class name as parameter
		PropertyConfigurator.configure("Log4j.properties");
		
		logger.info("setup method is starting");
		System.out.println(" this is for setup");
		Assert.assertTrue(true);
		logger.info("setup method passed");
		
	}
	
	@Test(priority=2)
	public void login()
	{
		logger.info(" login is started");
		System.out.println("login test");
		Assert.assertTrue(true);
		logger.info(" login is completed");
		logger.info("login is passed");
	}
	
	@Test(priority=3)
	public void logout()
	{
		logger.info("logout is started");
		System.out.println(" logout test");
		Assert.fail();
		logger.info("logout is failed");
	}
	
}
