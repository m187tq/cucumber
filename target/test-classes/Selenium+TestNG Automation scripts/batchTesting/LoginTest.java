package batchTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(priority=1)
	void loginByemail()
	{
		System.out.println(" this is login by email test");
		Assert.assertTrue(true); // make this method pass
	}
	
	@Test(priority=2, enabled=true)
	void loginbyfacebook()
	{
		System.out.println(" this is login by facebook test");
		//Assert.fail(); // make this method fail
		Assert.assertTrue(true); // make this method pass
	}
	
	
	@Test(priority=3)
	void loginbytwitter()
	{
		System.out.println(" thisi slogin by twitter");
		Assert.assertTrue(true);
	}

}
