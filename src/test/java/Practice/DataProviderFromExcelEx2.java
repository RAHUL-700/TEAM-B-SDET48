package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFromExcelEx2 {

	@DataProvider
	public Object[][] data2023() throws EncryptedDocumentException, IOException{
	ExcelUtilities eUtil=new ExcelUtilities();
	Object[][] obj = eUtil.data20("DataProvider");
	return obj;
	}

	@Test(dataProvider="data2023")
	public void getData(String src,String dest, String price) {
		System.out.println("From -->"+src+" to--->"+dest+"--->"+price);
	}
}
