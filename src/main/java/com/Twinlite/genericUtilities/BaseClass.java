package com.Twinlite.genericUtilities;
	

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		public DataBaseUtility dLib = new DataBaseUtility();
		public FileUtilities fLib = new FileUtilities();
		public ExcelUtilities eLib = new ExcelUtilities();
		public WebDriverUtilities wLib = new WebDriverUtilities();
		public WebDriver driver;
		
		
		// connect to DB
		@BeforeSuite
		public void Config_BS() throws Throwable
		{
			dLib.connectToDb();
			System.out.println("-- connect to DB");
		}
		
		@BeforeClass
		public void config_BC() throws Throwable
		{
			String BROWSER = fLib.getPropertyKeyValue("browser");
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
			wLib.maximizeWindow(driver);
		}
		
		// login to Appln
		@BeforeMethod
		public void confi_BM() throws Throwable
		{
			String URL = fLib.getPropertyKeyValue("url");
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			
			driver.get(URL);
			
			wLib.waitForATitle(driver,"google");
			
			LoginPage lp = new LoginPage(driver);
			lp.loginAsUser(USERNAME, PASSWORD);
			System.out.println("-- Logged in successfully --");
		}
		
		//logout from Appln
		@AfterMethod
		public void config_AM()
		{
			HomePage hp = new HomePage(driver);
			hp.getLoginbtn().click();
			System.out.println("-- logged out from appl --");
		}
		
		// close the browser
		@AfterClass
		public void config_AC()
		{
			driver.quit();
		}
		
		// disconnect database
		@AfterSuite
		public void config_AS() throws Throwable
		{
			dLib.closeDb();
			
		}

	}


