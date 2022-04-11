package annotations;

import org.testng.annotations.Test;

public class FirstTestCase {
	
	@Test(priority=2)
	void login()
	{
		//web driver code
	 System.out.println(" This is LOGIN");
	}
	
	@Test(priority=3)
	void logout()
	{
		//web driver code
		 System.out.println(" This is LOGOUT");
	}
	
	@Test(priority=1)
	void openURL()
	{
		//web driver code
		System.out.println(" This is open URL");
	}
}
