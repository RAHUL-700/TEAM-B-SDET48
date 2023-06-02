package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFromExcel1 {
	
	@DataProvider
	public Object[][] data2023() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream(IPATHConstants.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int lastRow = sh.getLastRowNum()+1;
		int lastCol = sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastCol];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCol;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

	@Test(dataProvider="data2023")
	public void getData(String src,String dest, String price) {
		System.out.println("From -->"+src+" to--->"+dest+"--->"+price);
	}
	
}
