  package com.DDT.POM.MethodCalling;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class VerifyThatAdminEditTheDetailsOfTheRegisteredProperty {

	public static void main(String[] args) throws InterruptedException, IOException {

 		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
 		JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();

		String browser=fus.getPropertyKeyValue("browser");
		
		//selecting browser according to the property file data
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		String url=fus.getPropertyKeyValue("url");
		String username=fus.getPropertyKeyValue("username");
		String password=fus.getPropertyKeyValue("password");
		
		driver.get(url);
		wdus.maximizeWindow(driver);
		
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		//fetching data from excel file for user registration 
		 String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
			String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
		
		//log in to the application as a admin
			HomePage homePage=new HomePage(driver);
			//click on login button
			homePage.getLoginbtn().click();

			LoginPage loginpage=new LoginPage(driver);
			//log in as user using method from pom classes
			loginpage.loginAsUser(username, password);
		
		//goto details and edit the details of a property registered by the user
			UserLoginHome userloginhome=new UserLoginHome(driver);
			//click on Details/Update button
			userloginhome.getDetailsBtn().click();
			//click on edit button of the room whose number is 8884771323
		driver.findElement(By.xpath("//p[contains(.,'8884771323')]/../../..//a")).click();

		String alternat_mobile =eus.getExcelData("LoginAdmin", 19, 1)+ranNo;
		Thread.sleep(1000);
		UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
		//Editing the alternative number of a property using a method from pom class
		userRegisterRoomsPage.editAltNumber(alternat_mobile,"hello", driver);
		
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}
