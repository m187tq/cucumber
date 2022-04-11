package annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SkippingTestMethods {

	@Test(priority=1)
	void openURL()
	{
	 System.out.println("Thisis Open URL");
	 Assert.assertTrue(true);
	}
		
	@Test(priority=2)
	void login()
	{
	 System.out.println("This is login");
	 Assert.assertTrue(true);
	}
	
	@Test(priority=3, enabled=false)
	void search()
	{
	 System.out.println("This is search");
	 Assert.assertTrue(true);
	}
	
	@Test(priority=4, enabled=false)
	void advsearch()
	{
	 System.out.println("This is advsearch");
	 Assert.assertTrue(true);
	}
}
