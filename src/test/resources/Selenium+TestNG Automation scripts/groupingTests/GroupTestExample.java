/* 
LoginByemail - sanity
loginByfacebook - sanity
loginBytwitter - sanity

signupByemail - sanity, regression
signupByfacebook - sanity , regression
signupBytwitter - sanity, regression

paymentReturnbybank - regression
payementindollar - regression
payementinrupees - regression  */




package groupingTests;

import org.testng.annotations.*;

public class GroupTestExample {

	@Test(groups={"sanity"})
	public void loginByemail()
	{
		System.out.println(" this is login by email");
	}

	@Test(groups={"sanity"})
	public void loginByfacebook()
	{
		System.out.println(" this is login by facebook");
	}

	@Test(groups={"sanity"})
	public void loginBytwitter()
	{
		System.out.println(" this is login by twitter");
	}

	@Test(groups={"sanity","regression"})
	public void signupbyemail()
	{
		System.out.println("signup by email");
	}

	@Test(groups={"sanity","regression"})
	public void signupbyfacebook()
	{
		System.out.println("signup by facebbok");
	}

	@Test(groups={"sanity","regression"})
	public void signupbytwitter()
	{
		System.out.println("signup by twitter");
	}

	@Test(groups={"regression"})
	public void paymentReturnbybank()
	{
		System.out.println("payment return by bank");
	}

	@Test(groups={"regression"})
	public void payementindollar()
	{
		System.out.println("this is payement by dollar method");
	}

	@Test(groups={"regression"})
	public void payementinrupees()
	{
		System.out.println("this is payement by rupees method");
	}



}
