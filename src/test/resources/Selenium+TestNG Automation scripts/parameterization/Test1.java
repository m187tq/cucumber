package parameterization;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	
	@Parameters("a")
	@Test
	public void m1(String s)
	{
		System.out.println("the value from xml file is:" +s);
	}
}




