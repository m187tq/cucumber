package batchTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest {

	@Test(priority=2)
	void paymentindollor()
	{
		System.out.println(" Payment in dollor test");
		Assert.assertTrue(true);
	}
	
	
	@Test(priority=1)
	void paymentinrupees()
	{
		System.out.println("paymenet in rupees test");
		Assert.assertTrue(true);
	}
}
