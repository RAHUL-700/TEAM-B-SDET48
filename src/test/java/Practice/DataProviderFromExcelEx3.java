package Practice;

import org.testng.annotations.Test;

public class DataProviderFromExcelEx3 {

	
	
	@Test(dataProviderClass= DataProviderFromExcelEx2.class,dataProvider="data2023")
	public void getData(String src,String dest, String price) {
		System.out.println("From -->"+src+" to--->"+dest+"--->"+price);
	}
}
