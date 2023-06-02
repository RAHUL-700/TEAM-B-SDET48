package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HWDataPro3 {


	@DataProvider
	public Object[][] data(){
		
		Object[][] arr=new Object[4][5];
		arr[0][0]="Davanagere";
		arr[0][1]="haveri";
		arr[0][2]="karnataka";
		arr[0][3]="India";
		arr[0][4]=300;
		
		arr[1][0]="chitradurga";
		arr[1][1]="hassan";
		arr[1][2]="karnataka";
		arr[1][3]="India";
		arr[1][4]=250;
		
		arr[2][0]="bidar";
		arr[2][1]="gulbarga";
		arr[2][2]="karnataka";
		arr[2][3]="India";
		arr[2][4]=500;
		
		arr[3][0]="haveri";
		arr[3][1]="hubli";
		arr[3][2]="karnataka";
		arr[3][3]="India";
		arr[3][4]=410;
		
		return arr;
	}
		
		@Test(dataProvider= "data")
		public void getData(String src,String dest,String state,String country, int price)
		{
			System.out.println("From "+src+" to "+dest+"  "+state+" "+country+" "+price);
		}
}
