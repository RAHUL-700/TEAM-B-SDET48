package Practice;

import org.testng.annotations.Test;

public class HWDataPro4 {

	
	@Test(dataProviderClass=HWDataPro1.class,dataProvider= "data")
	public void getData1(String src,String dest)
	{
		System.out.println("From "+src+" to "+dest);
	}
	
	@Test(dataProviderClass=HWDataPro2.class,dataProvider= "data")
	public void getData2(String src,String dest)
	{ 
		System.out.println("From "+src+" to "+dest);
	}
	
	@Test(dataProviderClass=HWDataPro3.class,dataProvider= "data")
	public void getData3(String src,String dest,String state,String country, int price)
	{
		System.out.println("From "+src+" to "+dest+"  "+state+" "+country+" "+price);
	}
	
}
