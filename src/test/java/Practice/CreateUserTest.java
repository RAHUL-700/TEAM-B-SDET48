 package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserTest {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		ExcelUtilities eutils=new ExcelUtilities();
		WebDriverUtilities wutils=new WebDriverUtilities();
		JavaUtilities jLib = new JavaUtilities();
		
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Register']")).click();

		RegisterUserPage rup = new RegisterUserPage(driver);
		
		rup.createUser(eutils.getMultipleData(), driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
	}

}
 