package annotations;

import org.testng.annotations.*;

public class AnnotationsExample1 {
	
	@BeforeMethod
	void login()
	{
		System.out.println("login test");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("logout test");
	}
	
	@Test(priority=1)
	void search()
	{
		System.out.println("search functionality");
	}
	
	@Test(priority=2)
	void advancedSearch()
	{
		System.out.println("Advanced search");
			
	}
	
	@Test(priority=3)
	void prepaidrecharge()
	{
		System.out.println("prepaid recharge test");
	}
	
	@Test(priority=4)
	void postpaidrecharge()
	{
		System.out.println(" post paid recharge test");
	}
	

}
