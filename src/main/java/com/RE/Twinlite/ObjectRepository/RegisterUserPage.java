package com.RE.Twinlite.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Twinlite.genericUtilities.JavaUtilities;
/**
 * 
 * @author satya
 *
 */
public class RegisterUserPage{

	
	//declaration 
	@FindBy(xpath="//input[@id='fullname']")private WebElement fullname;
	@FindBy(xpath="//input[@id='username']")private WebElement username1;
	@FindBy(xpath="//input[@id='mobile']")private WebElement mobile;
	@FindBy(xpath="//input[@id='email']")private WebElement email;
	@FindBy(xpath="//input[@id='password']")private WebElement password1;
	@FindBy(xpath="//input[@id='c_password']")private WebElement c_password1;
	@FindBy(xpath="//button[.='Submit']")private WebElement submitUserReg;
	
	
	
	//initialization using constructors
	public RegisterUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getFullname() {
		return fullname;
	}



	public WebElement getUsername1() {
		return username1;
	}



	public WebElement getMobile() {
		return mobile;
	}



	public WebElement getEmail() {
		return email;
	}



	public WebElement getPassword1() {
		return password1;
	}



	public WebElement getC_password1() {
		return c_password1;
	}

	public WebElement getSubmitUserReg() {
		return submitUserReg;
	}
	 
      public void registerUserInToApp( String fullname,String Username2,String mobile,String email,String password1,String password2) throws InterruptedException
      {
      getFullname().sendKeys(fullname);
     // getUsername1.sendKeys(Username2);
      username1.sendKeys(Username2);
	getMobile().sendKeys(mobile);
	getEmail().sendKeys(email);
	getPassword1().sendKeys(password1);
	getC_password1().sendKeys(password1);
	Thread.sleep(1000);
	getSubmitUserReg().click();
	}
      
      Random ra=new Random();
      int ranNo=ra.nextInt(1000);
      
    //bussiness library
  	public void createUser(HashMap<String, String> map,WebDriver driver) {
  		for(Entry<String, String> set:map.entrySet()) {
  			String al=set.getValue(); 
  				driver.findElement(By.id(set.getKey())).sendKeys(al);
  	}     

  	}  	
}
