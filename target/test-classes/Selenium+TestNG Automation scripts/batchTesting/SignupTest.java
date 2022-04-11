package batchTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest {

	
	@Test(priority=1)
	void signupbyemail()
	{
		System.out.println(" this is signup by email test");
		Assert.assertTrue(true);
		
	}
	
	@Test(priority=2)
	void signupbyfacebook()
	{
		System.out.println(" this is signup by facebook test");
		Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	void signupbytwitter()
	{
		System.out.println(" this is sign up by twitter");
		Assert.assertTrue(true);
	}
}
