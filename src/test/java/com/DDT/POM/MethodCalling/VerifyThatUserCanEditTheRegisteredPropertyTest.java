package com.DDT.POM.MethodCalling;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyThatUserCanEditTheRegisteredPropertyTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

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
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		
		//fetching data from excel file for user registration 
		driver.get(url);
		wdus.maximizeWindow(driver);

		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
        
        HomePage homePage = new HomePage(driver);
		homePage.getRegisteruserbtn().click();
		
				//registering the user using the methods from pom classes
        RegisterUserPage registerUserPage=new RegisterUserPage(driver);
        registerUserPage.registerUserInToApp( fullname, username1, mobile, email, password1, password1);
		
		//log in to the application as a user
        
        //click on the login button 
    		homePage.getLoginbtn().click();
    		LoginPage loginpage=new LoginPage(driver);
    		loginpage.loginAsUser(username, password);
		
		//fetching data for registering property using excel file
		String alternat_mobile =	eus.getExcelData("LoginAdmin", 19, 1)+ranNo;
		String plotNo =	eus.getExcelData("LoginAdmin", 21, 1);
		String rooms =	eus.getExcelData("LoginAdmin", 22, 1);
		String country =	eus.getExcelData("LoginAdmin", 23, 1);
		String state =	eus.getExcelData("LoginAdmin", 24, 1);
		String city =	eus.getExcelData("LoginAdmin", 25, 1);
		String rent =	eus.getExcelData("LoginAdmin", 26, 1);
		String deposit =	eus.getExcelData("LoginAdmin", 27, 1);
		String accommodation =	eus.getExcelData("LoginAdmin", 28, 1);
		String description =	eus.getExcelData("LoginAdmin", 29, 1);
		String landmark =	eus.getExcelData("LoginAdmin", 30, 1);
		String address =	eus.getExcelData("LoginAdmin", 31, 1);
				
				//registering a property into the application
		UserLoginHome userloginhome=new UserLoginHome(driver);
		//click on register button
		userloginhome.getRegisterBtn().click();
		
		UserRegisterRoomsPage registerRoomsPage=new UserRegisterRoomsPage(driver);
		//registering a property using generic methods from pom classes
		registerRoomsPage.registerRoomsInToApp( fullname,  alternat_mobile,  mobile,  email, plotNo, rooms,country,state,city,rent,deposit ,accommodation, description,landmark,address);
		
		//logout as user
		UserLoginHome userLoginHome=new UserLoginHome(driver);
		//clcik omn logout button
		userLoginHome.getLogoutBtn().click();
		
		//first log in as user again
		homePage.getLoginbtn().click();
		loginpage.loginAsUser(username, password);
		
		//edit the property
		
		//click on Details/Update button 
		userloginhome.getDetailsBtn().click();
		//click on the edit button for specific room 
		driver.findElement(By.xpath("//p[contains(.,'"+mobile+"')]/../../..//a")).click();
		Thread.sleep(2000);
		WebElement options2 = driver.findElement(By.xpath("//select[@id='vacant']"));
		Select s1=new Select(options2);
		s1.selectByValue("1");
		String otherdetails = eus.getExcelData("LoginAdmin", 34, 1);
		
		UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
		//edit the alternative number of specific room
		userRegisterRoomsPage.editAltNumber(alternat_mobile,otherdetails, driver);

		driver.quit();
		
	}
}
