package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class sample {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\satya\\OneDrive\\Desktop\\selenium programs\\com.RE.Twinlite.practice\\src\\test\\resources\\TestDataNew.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("LoginAdmin");
		String data = sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data);
	}

}
