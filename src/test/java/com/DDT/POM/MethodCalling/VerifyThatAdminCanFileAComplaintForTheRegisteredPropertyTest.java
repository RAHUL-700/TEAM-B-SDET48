package com.DDT.POM.MethodCalling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

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

import com.RE.Twinlite.ObjectRepository.AdminandUserComplaintPage;
import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserDetails_UpdatePage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyThatAdminCanFileAComplaintForTheRegisteredPropertyTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();

		String browser=fus.getPropertyKeyValue("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) { 
			driver=new EdgeDriver();
		}
        wdus.maximizeWindow(driver);
		
		String url=fus.getPropertyKeyValue("url");
		String username=fus.getPropertyKeyValue("username");
		String password=fus.getPropertyKeyValue("password");
		driver.get(url);
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		
		
		//fetching data from excel file for user registration 
				String fullname =eus.getExcelData("LoginAdmin", 1, 1);
				String username1 =eus.getExcelData("LoginAdmin", 2, 1);
				String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
		        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
		        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
		        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
		
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Register']")).click();
		
		//registering the user
		 RegisterUserPage registerUserPage=new RegisterUserPage(driver);
		 //registering the property using generic methods
	        registerUserPage.registerUserInToApp( fullname, username1, mobile, email, password1, password1);
		
		//log in to the application as a user
		HomePage homePage=new HomePage(driver);
		homePage.getLoginbtn().click();
		
		LoginPage loginpage=new LoginPage(driver);
		//login as user using generic methods from pom class
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
		userloginhome.getRegisterBtn().click();
		
		UserRegisterRoomsPage registerRoomsPage=new UserRegisterRoomsPage(driver);
		//registering the room into the application using methods from pom class
		registerRoomsPage.registerRoomsInToApp( fullname,  alternat_mobile,  mobile,  email, plotNo, rooms,country,state,city,rent,deposit ,accommodation, description,landmark,address);

      UserLoginHome userLoginHome = new UserLoginHome(driver);
      //clicking on logout button 
      userLoginHome.getLogoutBtn().click();

		//first log in as admin 
homePage.getLoginbtn().click();
String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
//log in to appm as admin using method from pom classes
loginpage.loginAsUser(adminusn, adminpwd);

		//rising a complaint
//clicking on deatils/Update button
userLoginHome.getDetailsBtn().click();

UserDetails_UpdatePage userDetails_UpdatePage=new UserDetails_UpdatePage(driver);
//clicking on complaint button
userDetails_UpdatePage.getComplaintBtn().click();
		
		String compname =eus.getExcelData("LoginAdmin", 38, 1)+ranNo;
		String complaint =eus.getExcelData("LoginAdmin", 39, 1)+ranNo;

		AdminandUserComplaintPage adminandUserComplaintPage=new AdminandUserComplaintPage(driver);
		//raising a complaint using a method from pom class and verifying the complaint
		adminandUserComplaintPage.risingAComplaint(complaint,compname);

		driver.close();
	}

}
