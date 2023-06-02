package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HWDataPro1 {

	@DataProvider
	public Object[][] data(){
		
		Object[][] arr=new Object[2][2];
		arr[0][0]="Davanagere";
		arr[0][1]="haveri";
		
		arr[1][0]="QSpiders";
		arr[1][1]="banashankari";
		
		return arr;
	}
		
		@Test(dataProvider= "data")
		public void getData(String src,String dest)
		{
			System.out.println("From "+src+" to "+dest);
		}
}
