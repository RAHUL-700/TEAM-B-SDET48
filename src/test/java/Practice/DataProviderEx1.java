package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@DataProvider
	public Object[][] data(){
		
		Object[][] arr=new Object[2][3];
		arr[0][0]="Bangalore";
		arr[0][1]="Mysore";
		arr[0][2]=100;
		
		arr[1][0]="QSpiders";
		arr[1][1]="Testyantra";
		arr[1][2]=300;
		
		return arr;
	}
		
		@Test(dataProvider= "data")
		public void getData(String src,String dest, int price)
		{
			System.out.println("From "+src+" to "+dest+"--"+price);
		}
		
	
}
