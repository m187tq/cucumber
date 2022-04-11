package annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

	@Test(priority=1)
	void openURL()
	{
	 System.out.println("Thisis Open URL");
	// Assert.assertTrue(true);
	 Assert.fail();
	}
		
	@Test(priority=2, dependsOnMethods={"openURL"}, alwaysRun=true)
	void login()
	{
	 System.out.println("This is login");
	 Assert.assertTrue(true);
	 //Assert.fail();
	}
	
	@Test(priority=3, dependsOnMethods={"openURL","login"})
	void search()
	{
	 System.out.println("This is search");
	 Assert.assertTrue(true);
	}
	
	@Test(priority=4)
	void advsearch()
	{
	 System.out.println("This is advsearch");
	 Assert.assertTrue(true);
	}
}
