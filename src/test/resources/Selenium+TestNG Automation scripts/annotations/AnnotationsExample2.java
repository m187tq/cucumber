package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsExample2 {

	@BeforeClass
	void login()
	{
		System.out.println("login test");
	}
	
	@AfterClass
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
	void posrpaidrecharge()
	{
		System.out.println(" post paid recharge test");
	}
	
}
