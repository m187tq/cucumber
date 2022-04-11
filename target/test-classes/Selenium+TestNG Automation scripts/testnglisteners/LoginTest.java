package testnglisteners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	void setup()
	{
		Assert.fail();
	}
	
	@Test
	void loginByEmail()
	{
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods={"setup"})
	void loginByFacebook()
	{
		Assert.assertTrue(true);
	}
}
