package testnglisteners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter
{
	public void onTestStart(ITestResult tr)
	{
		System.out.println(" test is started");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println(" test is passed");
	}
	
	public void onTestFailure(ITestResult tr)
	{
		System.out.println("test is failed");
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("test is skipped");
	}

}
