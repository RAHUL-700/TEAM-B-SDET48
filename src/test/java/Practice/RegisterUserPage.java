package Practice;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Twinlite.genericUtilities.JavaUtilities;

public class RegisterUserPage {

	
	//INITIALIZATION
	
	
	//declaration
	public RegisterUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//bussiness library
	public void createUser(HashMap<String, String> map,WebDriver driver) {
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());//getting the element by using locator(key) and sending the values 
		}
	}
	
}
