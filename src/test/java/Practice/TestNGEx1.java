package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGEx1 {

	@Test
	public void create() {
		System.out.println("--create customer--");
	}
	@Test
	public void update() {
		System.out.println("--update customer--");
	}  
	@Test(priority=-1, dependsOnMethods="create")
	public void delete() {
		System.out.println("--delete customer--");
	}
	
	
	
 }
